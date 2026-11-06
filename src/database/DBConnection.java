package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        try {
            String url = System.getenv("DB_URL");
            String username = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            if (url == null || username == null || password == null) {
                throw new RuntimeException(
                    "Database environment variables are missing!"
                );
            }

            Connection connection = DriverManager.getConnection(
                url, username, password
            );

            System.out.println("Database Connected Successfully!");
            return connection;

        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}