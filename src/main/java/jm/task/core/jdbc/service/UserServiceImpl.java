package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJDBCImpl uDJDBC = new UserDaoJDBCImpl();

    public UserServiceImpl() {
    }
    @Override
    public void createUsersTable() {
        uDJDBC.createUsersTable();
    }
    @Override
    public void dropUsersTable() {
        uDJDBC.dropUsersTable();
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        uDJDBC.saveUser(name, lastName, age);
    }
    @Override
    public void removeUserById(long id) {
        uDJDBC.removeUserById(id);
    }
    @Override
    public List<User> getAllUsers() {
        return uDJDBC.getAllUsers();
    }
    @Override
    public void cleanUsersTable() {
        uDJDBC.cleanUsersTable();
    }
}
