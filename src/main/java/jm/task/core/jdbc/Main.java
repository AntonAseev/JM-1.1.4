package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl table = new UserDaoJDBCImpl();
        table.createUsersTable();

        table.saveUser("Anton", "Aseev", (byte) 27);
        table.saveUser("Ivan", "Ivanov", (byte) 51);
        table.saveUser("Petr", "Petrov", (byte) 33);
        table.saveUser("Pavel", "Pavlov", (byte) 102);

        table.getAllUsers();

        table.cleanUsersTable();

        table.dropUsersTable();

    }
}
