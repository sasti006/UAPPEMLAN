package com.belanja.ui;

import com.belanja.model.Barang;
import com.belanja.service.BelanjaService;
import javax.swing.*;
import java.awt.*;

public class FormBarangPanel extends JPanel {
    private MainFrame parent;
    private BelanjaService belanjaService;
    private JTextField txtNama, txtJumlah, txtHarga;
    private JComboBox<String> comboPrioritas, comboToko, comboSatuan;
    private String currentId = null;

    public FormBarangPanel(MainFrame parent, BelanjaService belanjaService) {
        this.parent = parent;
        this.belanjaService = belanjaService;
        initUI();
        resetForm();
    }

    private void initUI() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("➕ TAMBAH BARANG BARU");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 15, 15));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        formPanel.add(new JLabel("Nama Barang*:"));
        txtNama = new JTextField();
        formPanel.add(txtNama);

        formPanel.add(new JLabel("Jumlah*:"));
        JPanel jumlahPanel = new JPanel(new BorderLayout());
        txtJumlah = new JTextField("1");
        jumlahPanel.add(txtJumlah, BorderLayout.CENTER);
        comboSatuan = new JComboBox<>(new String[]{"kg", "liter", "buah", "bungkus", "pack", "dus"});
        jumlahPanel.add(comboSatuan, BorderLayout.EAST);
        formPanel.add(jumlahPanel);

        formPanel.add(new JLabel("Harga per Satuan (Rp)*:"));
        txtHarga = new JTextField();
        formPanel.add(txtHarga);

        formPanel.add(new JLabel("Prioritas*:"));
        comboPrioritas = new JComboBox<>(new String[]{"WAJIB", "PENTING", "BISA NANTI"});
        formPanel.add(comboPrioritas);

        formPanel.add(new JLabel("Toko*:"));
        comboToko = new JComboBox<>(new String[]{"PASAR", "SWALAYAN", "ONLINE", "TOKO KELONTONG"});
        formPanel.add(comboToko);

        formPanel.add(new JLabel("* wajib diisi"));
        formPanel.add(new JLabel("ID akan dibuat otomatis"));
        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnSimpan = new JButton("💾 Simpan Barang");
        btnSimpan.addActionListener(e -> simpanBarang());

        JButton btnReset = new JButton("🔄 Reset Form");
        btnReset.addActionListener(e -> resetForm());

        JButton btnKembali = new JButton("← Kembali ke Dashboard");
        btnKembali.addActionListener(e -> parent.showDashboard());

        buttonPanel.add(btnSimpan);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnKembali);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void resetForm() {
        currentId = null;
        txtNama.setText("");
        txtJumlah.setText("1");
        txtHarga.setText("");
        comboPrioritas.setSelectedIndex(0);
        comboToko.setSelectedIndex(0);
        comboSatuan.setSelectedIndex(0);
    }

    public void loadDataForEdit(String id) {
        Barang barang = belanjaService.getBarangById(id);
        if (barang != null) {
            currentId = id;
            txtNama.setText(barang.getNama());
            txtJumlah.setText(String.valueOf(barang.getJumlah()));
            txtHarga.setText(String.valueOf(barang.getHarga()));
            comboPrioritas.setSelectedItem(barang.getPrioritas());
            comboToko.setSelectedItem(barang.getToko());
            comboSatuan.setSelectedItem(barang.getSatuan());
        }
    }

    private void simpanBarang() {
        try {
            String nama = txtNama.getText().trim();
            double jumlah = Double.parseDouble(txtJumlah.getText());
            double harga = Double.parseDouble(txtHarga.getText());
            String prioritas = (String) comboPrioritas.getSelectedItem();
            String toko = (String) comboToko.getSelectedItem();
            String satuan = (String) comboSatuan.getSelectedItem();

            String result;
            if (currentId == null) {
                result = belanjaService.tambahBarang(nama, jumlah, satuan, harga, prioritas, toko);
            } else {
                result = belanjaService.updateBarang(currentId, nama, jumlah, satuan, harga, prioritas, toko);
            }

            if (result.startsWith("✅")) {
                parent.showMessage(result, "Sukses", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
                parent.showDaftarBarang();
            } else {
                parent.showMessage(result, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            parent.showMessage("Jumlah dan harga harus angka!", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            parent.showMessage("Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}