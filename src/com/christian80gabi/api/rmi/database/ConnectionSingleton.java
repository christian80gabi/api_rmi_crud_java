// by Christian80gabi
package com.christian80gabi.api.rmi.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSingleton {
    private static Connection connection;

    static String url = "jdbc:mysql://localhost:3306/api_products";
    static String user = "chris";
    static String password = "ChristianSQL8.0"; // replace '???' by your database user password

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
