package service;

import mapper.PenghuniMapper;
import model.Penghuni;

import java.util.*;

public class PenghuniService {
    private final PenghuniMapper mapper = new PenghuniMapper();

    public List<Penghuni> getAllPenghuni() throws Exception {
        return mapper.findAll();
    }

    public Penghuni getPenghuniById(int id) throws Exception {
        return mapper.findById(id);
    }

    // JCF Map: kelompokkan penghuni berdasarkan kamar
    public Map<Integer, List<Penghuni>> getPenghuniPerKamar() throws Exception {
        Map<Integer, List<Penghuni>> map = new HashMap<>();
        for (Penghuni p : mapper.findAll()) {
            map.computeIfAbsent(p.getKamarId(), k -> new ArrayList<>()).add(p);
        }
        return map;
    }

    // JCF Set: cek NIK duplikat
    public boolean isNikDuplikat(String nik) throws Exception {
        Set<String> nikSet = new HashSet<>();
        for (Penghuni p : mapper.findAll()) {
            nikSet.add(p.getNik());
        }
        return nikSet.contains(nik);
    }

    public void tambahPenghuni(Penghuni p) throws Exception {
        if (isNikDuplikat(p.getNik())) {
            throw new Exception("NIK " + p.getNik() + " sudah terdaftar!");
        }
        mapper.insert(p);
        System.out.println("Penghuni berhasil ditambahkan: " + p.getNama());
    }

    public void updatePenghuni(Penghuni p) throws Exception {
        mapper.update(p);
        System.out.println("Data penghuni berhasil diupdate.");
    }

    public void hapusPenghuni(int id) throws Exception {
        mapper.delete(id);
        System.out.println("Penghuni ID " + id + " berhasil dihapus.");
    }
}