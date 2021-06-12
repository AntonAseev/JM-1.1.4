package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb_jm_1.1.3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Fhvtqwscytds178";

    public static Connection connection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
