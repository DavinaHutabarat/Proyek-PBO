package mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.DatabaseConnection;
import model.Rutinitas;

public class RutinMapper {
    private Connection conn;

    public RutinMapper() throws SQLException {
        this.conn = DatabaseConnection.getConnection();
    }

    public void insert(Rutinitas r) throws SQLException {
        String sql = "INSERT INTO rutinitas (nama_kegiatan, waktu, penanggung_jawab) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, r.getNamaKegiatan());
            ps.setString(2, r.getWaktu());
            ps.setString(3, r.getPenanggungJawab());
            ps.executeUpdate();
        }
    }

    public List<Rutinitas> findAll() throws SQLException {
        List<Rutinitas> list = new ArrayList<>();
        String sql = "SELECT * FROM rutinitas";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Rutinitas(
                    rs.getInt("id"),
                    rs.getString("nama_kegiatan"),
                    rs.getString("waktu"),
                    rs.getString("penanggung_jawab")
                ));
            }
        }
        return list;
    }
}