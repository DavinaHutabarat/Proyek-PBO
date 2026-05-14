//Amelia Renata Lumbanbatu - 12S24031

package mapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.DatabaseConnection;
import model.Fasilitas;

public class FasilitasMapper {
    private Connection conn;

    public FasilitasMapper() throws SQLException {

        this.conn = DatabaseConnection.getConnection();
    }

    public void insert(Fasilitas f) throws SQLException {

        String sql = "INSERT INTO fasilitas (nama, lokasi, kondisi) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, f.getNama());
            ps.setString(2, f.getLokasi());
            ps.setString(3, f.getKondisi());
            ps.executeUpdate();
        }
    }

    public List<Fasilitas> findAll() throws SQLException {
        List<Fasilitas> list = new ArrayList<>();
        String sql = "SELECT * FROM fasilitas";
        
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {

                Fasilitas f = new Fasilitas(
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("lokasi"),
                    rs.getString("kondisi")
                );
                list.add(f);
            }
        }
        return list;
    }
}