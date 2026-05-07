package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:database/asrama.db";
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL);
            initDatabase(connection);
        }
        return connection;
    }

    private static void initDatabase(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS penghuni (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "nama TEXT NOT NULL," +
                     "nik TEXT UNIQUE NOT NULL," +
                     "tanggal_masuk TEXT NOT NULL," +
                     "tanggal_keluar TEXT," +
                     "kamar_id INTEGER," +
                     "jenis_kelamin TEXT" +
                     ")";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}