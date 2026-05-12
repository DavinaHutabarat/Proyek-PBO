// 12S24039 - Jody Alfonso Siahaan

package model;

public class Penghuni extends Entity {
    private String nim;
    private String nama;
    private String noKamar;

    public Penghuni(String nim, String nama, String noKamar) {
        this.nim = nim;
        this.nama = nama;
        this.noKamar = noKamar;
    }

    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public String getNoKamar() { return noKamar; }

    @Override
    public String getInfo() {
        return "NIM: " + nim + " | Nama: " + nama + " | Kamar: " + noKamar;
    }
}