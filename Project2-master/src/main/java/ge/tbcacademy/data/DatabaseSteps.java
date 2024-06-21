package ge.tbcacademy.data;

import java.sql.*;

public class DatabaseSteps {

    public ResultSet selectUserByUsername(String username) throws SQLException {
        Connection connection = DatabaseConnection.connect();
        String query = "SELECT * FROM Users WHERE username = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        return statement.executeQuery();
    }
}