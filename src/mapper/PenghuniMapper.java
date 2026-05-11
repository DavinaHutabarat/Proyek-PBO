package mapper;

import db.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Penghuni;

public class PenghuniMapper {
    private Connection conn;

    public PenghuniMapper() throws SQLException {
        this.conn = DatabaseConnection.getConnection();
    }

    public void insert(Penghuni p) throws SQLException {
        String sql = "INSERT INTO penghuni (nim, nama, no_kamar) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNim());
            ps.setString(2, p.getNama());
            ps.setString(3, p.getNoKamar());
            ps.executeUpdate();
        }
    }

    public List<Penghuni> findAll() throws SQLException {
        List<Penghuni> listPenghuni = new ArrayList<>();
        String sql = "SELECT * FROM penghuni";
        
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Penghuni p = new Penghuni(
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getString("no_kamar")
                );
                p.setId(rs.getInt("id"));
                listPenghuni.add(p);
            }
        }
        return listPenghuni;
    }
}