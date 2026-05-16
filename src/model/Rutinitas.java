// 12S24039 - Jody Alfonso Siahaan

package model;

public class Rutinitas extends Entity {
    private String namaKegiatan;
    private String waktu;
    private String penanggungJawab;

    public Rutinitas(int id, String nama, String waktu, String pj) {
        super(id);
        this.namaKegiatan = nama;
        this.waktu = waktu;
        this.penanggungJawab = pj;
    }

    public Rutinitas(String nama, String waktu, String pj) {
        this.namaKegiatan = nama;
        this.waktu = waktu;
        this.penanggungJawab = pj;
    }

    @Override
    public String getInfo() {
        return "[ID: " + getId() + "] [RUTINITAS] " + namaKegiatan + 
               " | Jam: " + waktu + " | PJ: " + penanggungJawab;
    }

    public String getNamaKegiatan() { return namaKegiatan; }
    public String getWaktu() { return waktu; }
    public String getPenanggungJawab() { return penanggungJawab; }
}