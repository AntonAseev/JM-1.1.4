package jm.task

        .core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    private static final String NEW_CREATE = "CREATE TABLE IF NOT EXISTS `Users` (\n" +
            "  `Id` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `Name` VARCHAR(45) NOT NULL,\n" +
            "  `LastName` VARCHAR(45) NOT NULL,\n" +
            "  `Age` INT(3) NOT NULL,\n" +
            "  PRIMARY KEY (`Id`));";

    public void createUsersTable() {
        try (Statement statement = Util.connection().createStatement();) {
            statement.execute(NEW_CREATE);
        } catch (SQLException ignore) {}
    }

    private static final String DROP_TABLE = "DROP TABLE Users";

    public void dropUsersTable() {
        try (PreparedStatement preparedStatement = Util.connection().prepareStatement(DROP_TABLE)) {
            preparedStatement.executeUpdate();
        } catch (SQLException ignore) {}
    }

    private static final String NEW_INSERT = "insert into Users (Name, LastName, Age) values (?, ?, ?)";

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = Util.connection().prepareStatement(NEW_INSERT)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static final String DELETE = "DELETE FROM Users WHERE Id = ?";

    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = Util.connection().prepareStatement(DELETE)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private static final String SELECT = "SELECT * FROM Users";

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Statement statement = Util.connection().createStatement();) {
            ResultSet resultSet = statement.executeQuery(SELECT);
            while (resultSet.next()) {
                User user = new User(resultSet.getString(2),
                                     resultSet.getString(3),
                                     resultSet.getByte(4));
                users.add(user);
                System.out.println(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(users);
        return users;
    }

    private static final String DELETE_ALL = "DELETE FROM Users";

    public void cleanUsersTable() {
        try (PreparedStatement preparedStatement = Util.connection().prepareStatement(DELETE_ALL)) {
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
