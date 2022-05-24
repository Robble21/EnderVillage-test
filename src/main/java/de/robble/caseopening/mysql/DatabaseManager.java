package de.robble.caseopening.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private String HOST;
    private int PORT;
    private String DATABASE;
    private String USERNAME;
    private String PASSWORD;

    private Connection connection;
    public void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false",
                USERNAME,
                PASSWORD);
        connection.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS case-opening(UUID VARCHAR(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL, PLAYERNAME VARCHAR(255) NOT NULL, CASE1 FLOAT DEFAULT 0, CASE2 FLOAT DEFAULT 0, CASE3 FLOAT DEFAULT 0 );");

    }
    public boolean isConnected(){
        return connection != null;
    }
    public Connection getConnection(){
        return connection;
    }
    public void Disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
