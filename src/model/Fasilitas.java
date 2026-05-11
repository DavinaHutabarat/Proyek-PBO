package model;

public class Fasilitas extends Entity {
    private String nama;
    private String lokasi;
    private String kondisi;

    public Fasilitas(int id, String nama, String lokasi, String kondisi) {
        super(id);
        this.nama = nama;
        this.lokasi = lokasi;
        this.kondisi = kondisi;
    }

    public Fasilitas(String nama, String lokasi, String kondisi) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.kondisi = kondisi;
    }

    @Override
    public String getInfo() {
        return "[ID: " + getId() + "] [FASILITAS] " + nama + 
               " | Lokasi: " + lokasi + " | Kondisi: " + kondisi;
    }

    public String getNama() { return nama; }
    public String getLokasi() { return lokasi; }
    public String getKondisi() { return kondisi; }
}