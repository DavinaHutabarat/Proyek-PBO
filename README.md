# Sistem Manajemen Asrama

Sistem Manajemen Asrama merupakan sebuah aplikasi berbasis desktop yang dikembangkan menggunakan bahasa pemrograman Java untuk mengoptimalkan pengelolaan lingkungan asrama secara digital. Proyek ini dirancang sebagai pemenuhan tugas kelompok dalam mata kuliah Pemrograman Berorientasi Objek (PBO) dengan fokus pada implementasi konsep OOP tingkat lanjut.

Tujuan utama dari pengembangan sistem ini adalah untuk menyediakan platform yang terstruktur guna mengelola penambahan data mahasiswa penghuni asrama, menginventarisasi fasilitas yang tersedia, serta mengatur jadwal agenda kegiatan rutin mahasiswa secara terintegrasi.

------------------------------------------------------------------------

## Anggota Kelompok
* **Davina Olivia** - (12S24047)
* **Amelia Renata** - (12S24031)
* **Yesika Nadia** - (12S24024)
* **Jody Alfonso** - (12S24039)

------------------------------------------------------------------------

## Fitur & Implementasi
Aplikasi ini menerapkan beberapa poin utama sesuai ketentuan tugas:
* **JDBC (Java Database Connectivity):** Untuk koneksi ke database MySQL/phpMyAdmin.
* **JCF (Java Collection Framework):** Pemanfaatan antarmuka List, Map, atau Set guna mengelola dan memanipulasi data mahasiswa, fasilitas, serta rutinitas di dalam memori secara efisien.
* **Inheritance & Polymorphism:** Penerapan struktur kelas yang terorganisir melalui pewarisan untuk mendukung modularitas dan fleksibilitas kode.
* **ORM dengan Data Mapper Pattern:** Melakukan pemetaan objek Java ke dalam tabel basis data secara manual atau menggunakan pola Data Mapper guna menjaga integritas data.

------------------------------------------------------------------------

## 🗄️ Skema Database (MySQL)
Aplikasi menggunakan basis data asrama_db dengan skema Relasional (RDBMS) sebagai berikut:

1. Table: fasilitas
   - id (INT, PK, AI)      : ID unik fasilitas.
   - nama (VARCHAR)        : Nama fasilitas (contoh: Dispencer, Kulkas).
   - lokasi (VARCHAR)      : Letak fasilitas (contoh: Lantai 1).
   - kondisi (VARCHAR)     : Status keadaan (contoh: Bagus, Rusak).

2. Table: penghuni
   - id (INT, PK, AI)      : ID unik penghuni.
   - nim (VARCHAR)         : Nomor Induk Mahasiswa.
   - nama (VARCHAR)        : Nama lengkap mahasiswa.
   - no_kamar (INT)        : Nomor kamar mahasiswa.

3. Table: rutinitas
   - id (INT, PK, AI)      : ID unik jadwal kegiatan.
   - nama_kegiatan (TEXT)  : Nama agenda (contoh: Jadwal Kurve).
   - waktu (VARCHAR)       : Hari/jam pelaksanaan (contoh: Senin).
   - penanggung_jawab (TEXT): Pihak bertanggung jawab/status.

------------------------------------------------------------------------

##  Link Presentasi YouTube
[Klik di sini untuk menonton video presentasi kami](Link_YouTube_Kalian_Disini)
*(Durasi: minimal 15 menit)*

------------------------------------------------------------------------

## Cara Menjalankan Proyek
1. Clone repositori ini.
2. Import database (file `.sql` terlampir).
3. Konfigurasi `database.properties` atau file koneksi JDBC kalian.
4. Jalankan `Main.java`.

------------------------------------------------------------------------

📂 Struktur Proyek Sistem Manajemen Asrama
```plaintext
PROYEK-PBO/
├── src/
│   ├── db/
│   │   └── DatabaseConnection.java    (Koneksi Database JDBC)
│   ├── mapper/
│   │   ├── FasilitasMapper.java       (Data Access Logic: Fasilitas)
│   │   ├── PenghuniMapper.java        (Data Access Logic: Penghuni)
│   │   └── RutinMapper.java           (Data Access Logic: Rutinitas)
│   ├── model/
│   │   ├── Entity.java               (Base/Parent Class)
│   │   ├── Fasilitas.java            (Entity Class: Fasilitas)
│   │   ├── Penghuni.java             (Entity Class: Penghuni)
│   │   └── Rutinitas.java            (Entity Class: Rutinitas)
│   └── Main.java                     (Entry Point/Main Class)
├── Makefile                          (Build Automation)
└── README.md                         (Dokumentasi Proyek)