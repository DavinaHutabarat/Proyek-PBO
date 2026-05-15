//  12S24024 - Yesika Nadia Saragih 

import db.DatabaseConnection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import mapper.FasilitasMapper;
import mapper.PenghuniMapper;
import mapper.RutinMapper; 
import model.Fasilitas;
import model.Penghuni;
import model.Rutinitas; 

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            PenghuniMapper pm = new PenghuniMapper();
            FasilitasMapper fm = new FasilitasMapper();
            RutinMapper rm = new RutinMapper(); 
            
            while (true) {

                System.out.println("\n======= SISTEM ASRAMA IT DEL =======");

                System.out.println("\n[ PENGHUNI ]");
                System.out.println(" 1. Tambah Data Penghuni");
                System.out.println(" 2. Lihat Semua Penghuni");
                System.out.println(" 3. Urutkan Penghuni (Nama)");
                System.out.println(" 4. Cari Penghuni (NIM)");

                System.out.println("\n[ FASILITAS ]");
                System.out.println(" 5. Tambah Data Fasilitas");
                System.out.println(" 6. Lihat Semua Fasilitas");

                System.out.println("\n[ RUTINITAS ]");
                System.out.println(" 7. Tambah Jadwal Kurve (Kebersihan)");
                System.out.println(" 8. Tambah Jadwal Ibadah");
                System.out.println(" 9. Lihat Semua Riwayat Rutinitas");

                System.out.println("\n[ SISTEM ]");
                System.out.println(" 0. Keluar");
                System.out.print("\nPilih: ");

                if (!input.hasNextInt()) {
                    System.out.println("Error: Input harus berupa angka!");
                    input.next();
                    continue;
                }
                
                int pil = input.nextInt(); 
                input.nextLine();

                if (pil == 1) {
                    System.out.println("\n--- Input Data Penghuni ---");
                    System.out.print("NIM   : "); String nim = input.nextLine();
                    System.out.print("Nama  : "); String nama = input.nextLine();
                    System.out.print("Kamar : "); String kmr = input.nextLine();
                    pm.insert(new Penghuni(nim, nama, kmr));
                    System.out.println("Berhasil: Data penghuni disimpan ke Database.");

                } else if (pil == 2) {
                    List<Penghuni> list = pm.findAll();
                    System.out.println("\n--- DAFTAR PENGHUNI ---");
                    if (list.isEmpty()) {
                        System.out.println("Data masih kosong.");
                    } else {
                        list.forEach(p -> System.out.println(p.getInfo()));
                    }

                } else if (pil == 3) {
                    List<Penghuni> list = pm.findAll();
                    Collections.sort(list, Comparator.comparing(p -> p.getNama().toLowerCase()));
                    System.out.println("\n--- DAFTAR PENGHUNI (Urut Nama) ---");
                    list.forEach(p -> System.out.println(p.getInfo()));

                } else if (pil == 4) {
                    System.out.print("Masukkan NIM yang dicari: ");
                    String cariNim = input.nextLine();
                    List<Penghuni> list = pm.findAll();
                    Optional<Penghuni> hasil = list.stream()
                        .filter(p -> p.getNim().equals(cariNim))
                        .findFirst();

                    if (hasil.isPresent()) {
                        System.out.println("Ditemukan: " + hasil.get().getInfo());
                    } else {
                        System.out.println("Info: NIM " + cariNim + " tidak ditemukan.");
                    }

                } else if (pil == 5) {
                    System.out.println("\n--- Input Data Fasilitas ---");
                    System.out.print("Nama Fasilitas : "); String namaF = input.nextLine();
                    System.out.print("Lokasi         : "); String lokasi = input.nextLine();
                    System.out.print("Kondisi        : "); String kondisi = input.nextLine();
                    fm.insert(new Fasilitas(namaF, lokasi, kondisi));
                    System.out.println("Berhasil: Data fasilitas disimpan ke Database.");

                } else if (pil == 6) {
                    List<Fasilitas> listF = fm.findAll();
                    System.out.println("\n--- DAFTAR FASILITAS ASRAMA ---");
                    if (listF.isEmpty()) {
                        System.out.println("Data fasilitas kosong.");
                    } else {
                        listF.forEach(f -> System.out.println(f.getInfo()));
                    }

                } else if (pil == 7) {
                    System.out.println("\n--- Input Jadwal Kurve ---");
                    System.out.print("Hari         : "); String hari = input.nextLine();
                    System.out.print("Jadwal Kurve : "); String kelompok = input.nextLine();
                    
                    String bukti = "Sudah Melaksanakan Kurve";
                    String kegiatan = "Jadwal Kurve: " + kelompok;
                    
                    rm.insert(new Rutinitas(kegiatan, hari, bukti));
                    System.out.println("Berhasil: Jadwal Kurve disimpan.");

                    System.out.println("\nRUTINITAS:");
                    System.out.println("Hari: " + hari);
                    System.out.println(kegiatan);
                    System.out.println("Bukti: " + bukti);
                    System.out.println("Laporan Sudah Dikonfirmasi.");
                    System.out.println("----------------------------");

                } else if (pil == 8) {
                    System.out.println("\n--- Input Jadwal Ibadah ---");
                    System.out.print("Jenis Ibadah : "); String jenis = input.nextLine();
                    System.out.print("Hari/Waktu   : "); String waktu = input.nextLine();
                    
                    String bukti = "Sudah Melaksanakan Ibadah";
                    String kegiatan = "Ibadah " + jenis;
                    
                    rm.insert(new Rutinitas(kegiatan, waktu, bukti));
                    System.out.println("Berhasil: Jadwal Ibadah disimpan.");

                    System.out.println("\nRUTINITAS:");
                    System.out.println("Hari: " + waktu);
                    System.out.println(kegiatan);
                    System.out.println("Bukti: " + bukti);
                    System.out.println("Laporan Sudah Dikonfirmasi.");
                    System.out.println("----------------------------");

                } else if (pil == 9) {
                    List<Rutinitas> listR = rm.findAll();
                    System.out.println("\n--- DAFTAR RIWAYAT RUTINITAS ASRAMA ---");
                    if (listR.isEmpty()) {
                        System.out.println("Belum ada riwayat rutinitas.");
                    } else {
                        for (Rutinitas r : listR) {
                            System.out.println("RUTINITAS:");
                            System.out.println("Hari: " + r.getWaktu());
                            System.out.println(r.getNamaKegiatan());
                            System.out.println("Bukti: " + r.getPenanggungJawab());
                            System.out.println("Laporan Sudah Dikonfirmasi.");
                            System.out.println("----------------------------");
                        }
                    }

                } else if (pil == 0) {
                    System.out.println("Menutup koneksi dan keluar sistem...");
                    DatabaseConnection.closeConnection();
                    break;
                } else {
                    System.out.println("Pilihan tidak valid!");
                }
            }
        } catch (Exception e) {
            System.err.println("Sistem Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            input.close();
        }
    }
}