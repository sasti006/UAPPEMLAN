package com.belanja.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Barang {
    private String id;
    private String nama;
    private double jumlah;
    private String satuan;
    private double harga;
    private String prioritas;
    private String toko;
    private LocalDate tanggal;
    private boolean sudahDibeli;

    public Barang(String id, String nama, double jumlah, String satuan,
                  double harga, String prioritas, String toko) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID tidak boleh kosong");
        }
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong");
        }
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah harus lebih dari 0");
        }
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif");
        }

        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
        this.satuan = satuan;
        this.harga = harga;
        this.prioritas = prioritas;
        this.toko = toko;
        this.tanggal = LocalDate.now();
        this.sudahDibeli = false;
    }

    // Getter dan Setter
    public String getId() { return id; }

    public String getNama() { return nama; }
    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.nama = nama;
    }

    public double getJumlah() { return jumlah; }
    public void setJumlah(double jumlah) {
        if (jumlah <= 0) throw new IllegalArgumentException("Jumlah harus > 0");
        this.jumlah = jumlah;
    }

    public String getSatuan() { return satuan; }
    public void setSatuan(String satuan) { this.satuan = satuan; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) {
        if (harga < 0) throw new IllegalArgumentException("Harga tidak boleh negatif");
        this.harga = harga;
    }

    public double getTotalHarga() { return jumlah * harga; }

    public String getPrioritas() { return prioritas; }
    public void setPrioritas(String prioritas) { this.prioritas = prioritas; }

    public String getToko() { return toko; }
    public void setToko(String toko) { this.toko = toko; }

    public LocalDate getTanggal() { return tanggal; }

    public boolean isSudahDibeli() { return sudahDibeli; }
    public void setSudahDibeli(boolean sudahDibeli) { this.sudahDibeli = sudahDibeli; }

    public String toCSV() {
        return String.join(",",
                id,
                nama.replace(",", ";"),
                String.valueOf(jumlah),
                satuan,
                String.valueOf(harga),
                prioritas,
                toko,
                tanggal.toString(),
                String.valueOf(sudahDibeli)
        );
    }

    public static Barang fromCSV(String csvLine) {
        try {
            String[] data = csvLine.split(",");
            if (data.length >= 9) {
                Barang barang = new Barang(
                        data[0],
                        data[1].replace(";", ","),
                        Double.parseDouble(data[2]),
                        data[3],
                        Double.parseDouble(data[4]),
                        data[5],
                        data[6]
                );
                barang.tanggal = LocalDate.parse(data[7]);
                barang.sudahDibeli = Boolean.parseBoolean(data[8]);
                return barang;
            }
        } catch (Exception e) {
            System.err.println("Error parsing CSV: " + e.getMessage());
        }
        return null;
    }

    public static Comparator<Barang> sortByNama() {
        return Comparator.comparing(Barang::getNama, String.CASE_INSENSITIVE_ORDER);
    }

    public static Comparator<Barang> sortByHarga() {
        return Comparator.comparingDouble(Barang::getTotalHarga);
    }

    public static Comparator<Barang> sortByPrioritas() {
        Map<String, Integer> priorityOrder = new HashMap<>();
        priorityOrder.put("WAJIB", 1);
        priorityOrder.put("PENTING", 2);
        priorityOrder.put("BISA NANTI", 3);

        return Comparator.comparingInt(b -> priorityOrder.get(b.getPrioritas()));
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%.1f %s) = Rp %,.0f",
                id, nama, jumlah, satuan, getTotalHarga());
    }
}