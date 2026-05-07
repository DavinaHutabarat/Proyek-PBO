package mapper;

import db.DatabaseConnection;
import model.Penghuni;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PenghuniMapper implements IMapper<Penghuni> {

    @Override
    public void insert(Penghuni p) throws Exception {
        String sql = "INSERT INTO penghuni (nama, nik, tanggal_masuk, kamar_id, jenis_kelamin) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNama());
            ps.setString(2, p.getNik());
            ps.setString(3, p.getTanggalMasuk().toString());
            ps.setInt(4, p.getKamarId());
            ps.setString(5, p.getJenisKelamin());
            ps.executeUpdate();
        }
    }

    @Override
    public Penghuni findById(int id) throws Exception {
        String sql = "SELECT * FROM penghuni WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        }
        return null;
    }

    @Override
    public List<Penghuni> findAll() throws Exception {
        List<Penghuni> list = new ArrayList<>();
        String sql = "SELECT * FROM penghuni";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        }
        return list;
    }

    @Override
    public void update(Penghuni p) throws Exception {
        String sql = "UPDATE penghuni SET nama=?, nik=?, tanggal_masuk=?, kamar_id=?, jenis_kelamin=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNama());
            ps.setString(2, p.getNik());
            ps.setString(3, p.getTanggalMasuk().toString());
            ps.setInt(4, p.getKamarId());
            ps.setString(5, p.getJenisKelamin());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM penghuni WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private Penghuni mapRow(ResultSet rs) throws SQLException {
        Penghuni p = new Penghuni(
            rs.getInt("id"),
            rs.getString("nama"),
            rs.getString("jenis_kelamin"),
            rs.getString("nik"),
            LocalDate.parse(rs.getString("tanggal_masuk")),
            rs.getInt("kamar_id")
        );
        String keluar = rs.getString("tanggal_keluar");
        if (keluar != null) {
            p.setTanggalKeluar(LocalDate.parse(keluar));
        }
        return p;
    }
}