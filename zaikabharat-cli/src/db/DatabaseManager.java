// Jagriti Shukla
// Jay Gupta

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/zaikabharat"; // Adjust your DB name
    private static final String USER = "root"; // Your MySQL username
    private static final String PASSWORD = "kaya0726"; // Your MySQL password

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("Database connection failed!");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
