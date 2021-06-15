package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import static org.hibernate.cfg.AvailableSettings.URL;

public class Util {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.setProperty("hibernate.current_session_context_class", "thread");
                configuration.setProperty(URL, "jdbc:mysql://localhost:3306/mydb_jm_1.1.3?autoReconnect=true&useSSL=false");
                configuration.setProperty(Environment.USER, "root");
                configuration.setProperty(Environment.PASS, "Fhvtqwscytds178");
                configuration.setProperty("hibernate.connection.release_mode", "auto");
                configuration.setProperty("hibernate.show_sql", "true");
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }


//    private static final String URL = "jdbc:mysql://localhost:3306/mydb_jm_1.1.3";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "Fhvtqwscytds178";
//
//    public static Connection connection() {
//        try {
//            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }
}
