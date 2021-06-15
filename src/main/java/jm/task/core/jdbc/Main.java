package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Anton", "Aseev", (byte) 27);
        userService.saveUser("Ivan", "Ivanov", (byte) 5);
        userService.saveUser("Petr", "Petrov", (byte) 13);
        userService.saveUser("Pavel", "Pavlov", (byte) 102);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();


//        UserDaoJDBCImpl table = new UserDaoJDBCImpl();
//        table.createUsersTable();
//
//        table.saveUser("Anton", "Aseev", (byte) 27);
//        table.saveUser("Ivan", "Ivanov", (byte) 51);
//        table.saveUser("Petr", "Petrov", (byte) 33);
//        table.saveUser("Pavel", "Pavlov", (byte) 102);
//
//        table.getAllUsers();
//
//        table.cleanUsersTable();
//
//        table.dropUsersTable();

    }
}
