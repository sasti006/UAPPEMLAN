package com.belanja.util;

public class Validator {
    private static final int MAX_NAMA_LENGTH = 100;
    private static final double MIN_JUMLAH = 0.01;
    private static final double MAX_JUMLAH = 1000.0;
    private static final double MIN_HARGA = 0.0;
    private static final double MAX_HARGA = 10000000.0;

    private static final String[] PRIORITAS_VALID = {"WAJIB", "PENTING", "BISA NANTI"};
    private static final String[] TOKO_VALID = {"PASAR", "SWALAYAN", "ONLINE", "TOKO KELONTONG"};
    private static final String[] SATUAN_VALID = {"kg", "liter", "buah", "bungkus", "pack", "dus"};

    public static void validasiNama(String nama) throws IllegalArgumentException {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong");
        }

        if (nama.trim().length() > MAX_NAMA_LENGTH) {
            throw new IllegalArgumentException("Nama barang maksimal " + MAX_NAMA_LENGTH + " karakter");
        }

        if (nama.contains(",") || nama.contains(";")) {
            throw new IllegalArgumentException("Nama tidak boleh mengandung koma (,) atau titik koma (;)");
        }
    }

    public static void validasiJumlah(double jumlah) throws IllegalArgumentException {
        if (jumlah < MIN_JUMLAH) {
            throw new IllegalArgumentException("Jumlah minimal " + MIN_JUMLAH);
        }

        if (jumlah > MAX_JUMLAH) {
            throw new IllegalArgumentException("Jumlah maksimal " + MAX_JUMLAH);
        }
    }

    public static void validasiHarga(double harga) throws IllegalArgumentException {
        if (harga < MIN_HARGA) {
            throw new IllegalArgumentException("Harga tidak boleh negatif");
        }

        if (harga > MAX_HARGA) {
            throw new IllegalArgumentException("Harga maksimal Rp " + formatAngka(MAX_HARGA));
        }
    }

    public static void validasiSatuan(String satuan) throws IllegalArgumentException {
        if (!isValidValue(satuan, SATUAN_VALID)) {
            throw new IllegalArgumentException("Satuan tidak valid. Pilih: " + String.join(", ", SATUAN_VALID));
        }
    }

    public static void validasiPrioritas(String prioritas) throws IllegalArgumentException {
        if (!isValidValue(prioritas, PRIORITAS_VALID)) {
            throw new IllegalArgumentException("Prioritas tidak valid. Pilih: " + String.join(", ", PRIORITAS_VALID));
        }
    }

    public static void validasiToko(String toko) throws IllegalArgumentException {
        if (!isValidValue(toko, TOKO_VALID)) {
            throw new IllegalArgumentException("Toko tidak valid. Pilih: " + String.join(", ", TOKO_VALID));
        }
    }

    public static void validasiAnggaran(double anggaran) throws IllegalArgumentException {
        if (anggaran < 0) {
            throw new IllegalArgumentException("Anggaran tidak boleh negatif");
        }

        if (anggaran > 100000000) {
            throw new IllegalArgumentException("Anggaran maksimal Rp 100.000.000");
        }
    }

    private static boolean isValidValue(String value, String[] validValues) {
        if (value == null) return false;
        for (String valid : validValues) {
            if (valid.equals(value)) return true;
        }
        return false;
    }

    public static String formatRupiah(double amount) {
        return String.format("Rp %,.0f", amount);
    }

    public static String formatAngka(double number) {
        return String.format("%,.0f", number);
    }

    public static String formatPersentase(double value, double total) {
        if (total == 0) return "0%";
        return String.format("%.1f%%", (value / total) * 100);
    }
}