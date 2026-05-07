package model;

import java.time.LocalDate;

public class Penghuni extends Person {
    private String nik;
    private LocalDate tanggalMasuk;
    private LocalDate tanggalKeluar;
    private int kamarId;

    public Penghuni() {}

    public Penghuni(int id, String nama, String jenisKelamin,
                    String nik, LocalDate tanggalMasuk, int kamarId) {
        super(id, nama, jenisKelamin);
        this.nik = nik;
        this.tanggalMasuk = tanggalMasuk;
        this.kamarId = kamarId;
    }

    @Override
    public String getInfo() {
        return "ID: " + id + " | Nama: " + nama +
               " | NIK: " + nik +
               " | Kamar: " + kamarId +
               " | Masuk: " + tanggalMasuk;
    }

    public String getNik() { return nik; }
    public void setNik(String nik) { this.nik = nik; }
    public LocalDate getTanggalMasuk() { return tanggalMasuk; }
    public void setTanggalMasuk(LocalDate tanggalMasuk) { this.tanggalMasuk = tanggalMasuk; }
    public LocalDate getTanggalKeluar() { return tanggalKeluar; }
    public void setTanggalKeluar(LocalDate tanggalKeluar) { this.tanggalKeluar = tanggalKeluar; }
    public int getKamarId() { return kamarId; }
    public void setKamarId(int kamarId) { this.kamarId = kamarId; }
}