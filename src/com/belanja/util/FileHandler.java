package com.belanja.util;

import com.belanja.model.Barang;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_NAME = "data/belanja.csv";
    private static final String CSV_HEADER = "ID,Nama,Jumlah,Satuan,Harga,Prioritas,Toko,Tanggal,SudahDibeli";

    public FileHandler() {
        buatFolderJikaTidakAda();
    }

    private void buatFolderJikaTidakAda() {
        try {
            Path folder = Paths.get("data");
            if (!Files.exists(folder)) {
                Files.createDirectories(folder);
                System.out.println("Folder data dibuat");
            }
        } catch (IOException e) {
            System.err.println("Gagal membuat folder data: " + e.getMessage());
        }
    }

    public List<Barang> loadData() {
        List<Barang> daftarBarang = new ArrayList<>();
        Path filePath = Paths.get(FILE_NAME);

        if (!Files.exists(filePath)) {
            System.out.println("File belum ada, membuat file baru...");
            buatFileBaru();
            return daftarBarang;
        }

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            boolean firstLine = true;
            int lineCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                try {
                    Barang barang = Barang.fromCSV(line);
                    if (barang != null) {
                        daftarBarang.add(barang);
                    }
                } catch (Exception e) {
                    System.err.println("Error di baris " + lineCount + ": " + e.getMessage());
                }
            }

            System.out.println("Data berhasil dimuat: " + daftarBarang.size() + " item");

        } catch (IOException e) {
            System.err.println("Error membaca file: " + e.getMessage());
            throw new RuntimeException("Gagal membaca file: " + e.getMessage(), e);
        }

        return daftarBarang;
    }

    public void saveData(List<Barang> daftarBarang) {
        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(FILE_NAME),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {

            writer.write(CSV_HEADER);
            writer.newLine();

            for (Barang barang : daftarBarang) {
                writer.write(barang.toCSV());
                writer.newLine();
            }

            System.out.println("Data berhasil disimpan: " + daftarBarang.size() + " item");

        } catch (IOException e) {
            System.err.println("Error menyimpan file: " + e.getMessage());
            throw new RuntimeException("Gagal menyimpan data: " + e.getMessage(), e);
        }
    }

    private void buatFileBaru() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_NAME))) {
            writer.write(CSV_HEADER);
            writer.newLine();
            System.out.println("File baru dibuat: " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Gagal membuat file baru: " + e.getMessage());
        }
    }

    public void buatBackup() {
        try {
            Path source = Paths.get(FILE_NAME);
            if (!Files.exists(source)) return;

            String timestamp = java.time.LocalDateTime.now()
                    .format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path backup = Paths.get("data/backup_" + timestamp + ".csv");

            Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Backup berhasil: " + backup.getFileName());

        } catch (IOException e) {
            System.err.println("Gagal membuat backup: " + e.getMessage());
        }
    }
}