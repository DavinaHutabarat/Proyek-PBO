import model.Penghuni;
import service.PenghuniService;
import db.DatabaseConnection;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PenghuniService service = new PenghuniService();

        try {
            // === TAMBAH PENGHUNI ===
            Penghuni p1 = new Penghuni(0, "Budi Santoso", "Laki-laki",
                                       "3201010101010001", LocalDate.of(2024, 1, 15), 1);
            Penghuni p2 = new Penghuni(0, "Siti Aminah", "Perempuan",
                                       "3201010101010002", LocalDate.of(2024, 2, 1), 2);
            service.tambahPenghuni(p1);
            service.tambahPenghuni(p2);

            // === TAMPILKAN SEMUA ===
            System.out.println("\n=== DAFTAR PENGHUNI ===");
            List<Penghuni> list = service.getAllPenghuni();
            for (Penghuni penghuni : list) {
                System.out.println(penghuni.getInfo());
            }

            // === PENGHUNI PER KAMAR (JCF Map) ===
            System.out.println("\n=== PENGHUNI PER KAMAR ===");
            Map<Integer, List<Penghuni>> perKamar = service.getPenghuniPerKamar();
            perKamar.forEach((kamarId, penghuniList) -> {
                System.out.println("Kamar " + kamarId + ": " + penghuniList.size() + " orang");
                penghuniList.forEach(p -> System.out.println("  - " + p.getNama()));
            });

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection();
        }
    }
}