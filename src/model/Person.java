package model;

public abstract class Person extends Entity {
    protected String nama;
    protected String jenisKelamin;

    public Person() {}

    public Person(int id, String nama, String jenisKelamin) {
        super(id);
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
    }

    public abstract String getInfo();

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getJenisKelamin() { return jenisKelamin; }
    public void setJenisKelamin(String jenisKelamin) { this.jenisKelamin = jenisKelamin; }
}