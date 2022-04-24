package sources;

import java.sql.*;

import static java.lang.System.*;

public class Database {
    private static final String URL =  "jdbc:postgresql://localhost:5432/cities";
    private static final String USER = "postgres";
    private static final String PASSWORD = "raul";
    private static Connection connection =  null;

    public Database(){
        createConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    private void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            err.println(e);
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
