package ge.tbcacademy.data;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
            String jdbcUrl = DBConfiguration.getURL();
            String password = DBConfiguration.getPassword();
            String username = DBConfiguration.getUsername();
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
