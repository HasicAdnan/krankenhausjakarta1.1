package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection connection;

    public DBConnection() {
    }

    public static DBConnection getInstance() {
        if (connection == null) {
            connection = new DBConnection();
        }
        return connection;
    }

    public static Connection getConnect() {
        Connection connect = null;
        try {
            String url = "jdbc:mysql://localhost:3307/krankenhausjakarta";
            String username = "root";
            String password = "Root2";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
            System.out.println(connect.toString());
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connect;
    }
}
