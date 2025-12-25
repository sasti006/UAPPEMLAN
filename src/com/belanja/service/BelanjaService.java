package com.belanja.service;

import com.belanja.model.Barang;
import com.belanja.model.BelanjaManager;
import com.belanja.util.FileHandler;
import com.belanja.util.Validator;
import java.util.*;

public class BelanjaService {
    private BelanjaManager belanjaManager;
    private FileHandler fileHandler;

    public BelanjaService() {
        this.belanjaManager = new BelanjaManager();
        this.fileHandler = new FileHandler();
        muatDataDariFile();
    }

    private void muatDataDariFile() {
        try {
            List<Barang> data = fileHandler.loadData();
            belanjaManager.setDaftarBarang(data);
        } catch (Exception e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    private void simpanDataKeFile() {
        try {
            fileHandler.saveData(belanjaManager.getSemuaBarang());
        } catch (Exception e) {
            System.err.println("Error saving data: " + e.getMessage());
            throw e;
        }
    }

    public String tambahBarang(String nama, double jumlah, String satuan,
                               double harga, String prioritas, String toko) {
        try {
            Validator.validasiNama(nama);
            Validator.validasiJumlah(jumlah);
            Validator.validasiHarga(harga);
            Validator.validasiSatuan(satuan);
            Validator.validasiPrioritas(prioritas);
            Validator.validasiToko(toko);

            String id = "BRG" + System.currentTimeMillis();
            Barang barang = new Barang(id, nama, jumlah, satuan, harga, prioritas, toko);

            belanjaManager.tambahBarang(barang);
            simpanDataKeFile();

            return "✅ Barang berhasil ditambahkan: " + nama;

        } catch (IllegalArgumentException e) {
            return "❌ " + e.getMessage();
        } catch (Exception e) {
            return "❌ Error: " + e.getMessage();
        }
    }

    public List<Barang> getSemuaBarang() {
        return belanjaManager.getSemuaBarang();
    }

    public List<Barang> cariBarang(String keyword) {
        return belanjaManager.cariBarang(keyword);
    }

    public List<Barang> sortBy(String sortBy) {
        return belanjaManager.sortBy(sortBy);
    }

    public String updateBarang(String id, String nama, double jumlah, String satuan,
                               double harga, String prioritas, String toko) {
        try {
            Validator.validasiNama(nama);
            Validator.validasiJumlah(jumlah);
            Validator.validasiHarga(harga);
            Validator.validasiSatuan(satuan);
            Validator.validasiPrioritas(prioritas);
            Validator.validasiToko(toko);

            Barang barangLama = belanjaManager.getBarangById(id);
            if (barangLama == null) {
                return "❌ Barang tidak ditemukan";
            }

            Barang barangBaru = new Barang(id, nama, jumlah, satuan, harga, prioritas, toko);
            barangBaru.setSudahDibeli(barangLama.isSudahDibeli());

            belanjaManager.updateBarang(id, barangBaru);
            simpanDataKeFile();

            return "✅ Barang berhasil diupdate: " + nama;

        } catch (IllegalArgumentException e) {
            return "❌ " + e.getMessage();
        } catch (Exception e) {
            return "❌ Error: " + e.getMessage();
        }
    }

    public String hapusBarang(String id) {
        boolean berhasil = belanjaManager.hapusBarang(id);
        if (berhasil) {
            simpanDataKeFile();
            return "✅ Barang berhasil dihapus";
        }
        return "❌ Barang tidak ditemukan";
    }

    public String tandaiSudahDibeli(String id) {
        Barang barang = belanjaManager.getBarangById(id);
        if (barang != null) {
            barang.setSudahDibeli(true);
            simpanDataKeFile();
            return "✅ " + barang.getNama() + " ditandai sudah dibeli";
        }
        return "❌ Barang tidak ditemukan";
    }

    public double hitungTotalBelanja() {
        return belanjaManager.hitungTotalBelanja();
    }

    public double hitungSisaAnggaran() {
        return belanjaManager.hitungSisaAnggaran();
    }

    public double getAnggaran() {
        return belanjaManager.getAnggaran();
    }

    public void setAnggaran(double anggaran) {
        Validator.validasiAnggaran(anggaran);
        belanjaManager.setAnggaran(anggaran);
    }

    public int getJumlahBarang() {
        return belanjaManager.getSemuaBarang().size();
    }

    public int getJumlahBelumDibeli() {
        int count = 0;
        for (Barang barang : belanjaManager.getSemuaBarang()) {
            if (!barang.isSudahDibeli()) {
                count++;
            }
        }
        return count;
    }

    public void buatBackup() {
        fileHandler.buatBackup();
    }

    public Map<String, Double> hitungPerToko() {
        Map<String, Double> result = new HashMap<>();
        String[] tokoList = {"PASAR", "SWALAYAN", "ONLINE", "TOKO KELONTONG"};

        for (String toko : tokoList) {
            result.put(toko, 0.0);
        }

        for (Barang barang : belanjaManager.getSemuaBarang()) {
            if (!barang.isSudahDibeli()) {
                String toko = barang.getToko();
                double total = barang.getTotalHarga();
                result.put(toko, result.get(toko) + total);
            }
        }
        return result;
    }

    public Barang getBarangById(String id) {
        return belanjaManager.getBarangById(id);
    }
}