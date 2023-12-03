package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Util {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pp1";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

//      JDBC
//    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
//            connection.setAutoCommit(false);
//            System.out.println("Подключение к БД прошло успешно.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("Ошибка подключения к БД.");
//        }
//        return connection;
//    }

//      Hibernate
    public static SessionFactory getSessionFactory() {
        SessionFactory factory = null;

        try {
            Configuration config = new Configuration();
            Properties properties = new Properties();

            properties.put(Environment.URL, DB_URL);
            properties.put(Environment.USER, DB_USERNAME);
            properties.put(Environment.PASS, DB_PASSWORD);
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            properties.put(Environment.SHOW_SQL, true);
            properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            config.setProperties(properties);
            config.addAnnotatedClass(User.class);

            StandardServiceRegistry registry =
                    new StandardServiceRegistryBuilder()
                            .applySettings(config.getProperties()).build();

            factory = config.buildSessionFactory(registry);

        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return factory;
    }

}
