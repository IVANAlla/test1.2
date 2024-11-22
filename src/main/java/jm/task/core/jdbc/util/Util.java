package jdbc.util;

import jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public  class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/newtest?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws ClassNotFoundException {

        Connection connection = null;
        try {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
    private static SessionFactory sessionFactory;

    public static void init() {
        sessionFactory = new Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.driver_class", "com.mysql.cj.jdbc.Driver")
                .setProperty("hibernate.url", "jdbc:mysql://localhost:3306/newtest")
                .setProperty("hibernate.username", "root")
                .setProperty("hibernate.password", "root")
                .setProperty("hibernate.hbm2ddl.auto", "update") // or validate for no automatic schema modification
                .addAnnotatedClass(User.class) // добавляем модель
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}


