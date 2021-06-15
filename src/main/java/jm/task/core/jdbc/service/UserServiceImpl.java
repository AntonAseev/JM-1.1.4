package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoHibernateImpl uDH = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        uDH.createUsersTable();
    }
    @Override
    public void dropUsersTable() {
        uDH.dropUsersTable();
    }
    @Override
    public void saveUser(String name, String lastName, byte age) {
        uDH.saveUser(name, lastName, age);
    }
    @Override
    public void removeUserById(long id) {
        uDH.removeUserById(id);
    }
    @Override
    public List<User> getAllUsers() {
        return uDH.getAllUsers();
    }
    @Override
    public void cleanUsersTable() {
        uDH.cleanUsersTable();
    }
}
