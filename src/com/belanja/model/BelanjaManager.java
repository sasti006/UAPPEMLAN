package com.belanja.model;

import java.util.*;

public class BelanjaManager {
    private List<Barang> daftarBarang;
    private double anggaran;

    public BelanjaManager() {
        this.daftarBarang = new ArrayList<>();
        this.anggaran = 1000000.0;
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    public List<Barang> getSemuaBarang() {
        return new ArrayList<>(daftarBarang);
    }

    public Barang getBarangById(String id) {
        for (Barang barang : daftarBarang) {
            if (barang.getId().equals(id)) {
                return barang;
            }
        }
        return null;
    }

    public boolean updateBarang(String id, Barang barangBaru) {
        for (int i = 0; i < daftarBarang.size(); i++) {
            if (daftarBarang.get(i).getId().equals(id)) {
                daftarBarang.set(i, barangBaru);
                return true;
            }
        }
        return false;
    }

    public boolean hapusBarang(String id) {
        return daftarBarang.removeIf(barang -> barang.getId().equals(id));
    }

    public List<Barang> cariBarang(String keyword) {
        List<Barang> hasil = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Barang barang : daftarBarang) {
            if (barang.getNama().toLowerCase().contains(lowerKeyword) ||
                    barang.getToko().toLowerCase().contains(lowerKeyword)) {
                hasil.add(barang);
            }
        }
        return hasil;
    }

    public List<Barang> sortBy(String sortBy) {
        List<Barang> sorted = new ArrayList<>(daftarBarang);

        switch (sortBy) {
            case "nama":
                sorted.sort(Barang.sortByNama());
                break;
            case "harga":
                sorted.sort(Barang.sortByHarga());
                break;
            case "prioritas":
                sorted.sort(Barang.sortByPrioritas());
                break;
            case "harga_desc":
                sorted.sort(Barang.sortByHarga().reversed());
                break;
        }
        return sorted;
    }

    public double hitungTotalBelanja() {
        double total = 0;
        for (Barang barang : daftarBarang) {
            if (!barang.isSudahDibeli()) {
                total += barang.getTotalHarga();
            }
        }
        return total;
    }

    public double hitungSisaAnggaran() {
        return anggaran - hitungTotalBelanja();
    }

    public double getAnggaran() { return anggaran; }
    public void setAnggaran(double anggaran) {
        if (anggaran < 0) throw new IllegalArgumentException("Anggaran tidak boleh negatif");
        this.anggaran = anggaran;
    }

    public void setDaftarBarang(List<Barang> daftarBarang) {
        this.daftarBarang = new ArrayList<>(daftarBarang);
    }
}