package com.belanja.ui;

import com.belanja.model.Barang;
import com.belanja.service.BelanjaService;

import javax.swing.*;
import java.awt.*;

public class FormBarangPanel extends JPanel {

    private static final Color COKLAT_MUDA = new Color(245, 222, 179);

    private static final Font FONT_LABEL = new Font("Arial", Font.BOLD, 14);
    private static final Font FONT_INPUT = new Font("Arial", Font.BOLD, 14);
    private static final Font FONT_BUTTON = new Font("Arial", Font.BOLD, 14);
    private static final Font FONT_TITLE = new Font("Arial", Font.BOLD, 22);

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
        setBackground(COKLAT_MUDA);

        JLabel titleLabel = new JLabel("TAMBAH BARANG BARU");
        titleLabel.setFont(FONT_TITLE);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 15, 15));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        formPanel.setBackground(COKLAT_MUDA);

        formPanel.add(createLabel("Nama Barang:"));
        txtNama = createTextField();
        formPanel.add(txtNama);

        formPanel.add(createLabel("Jumlah:"));
        JPanel jumlahPanel = new JPanel(new BorderLayout());
        jumlahPanel.setBackground(COKLAT_MUDA);

        txtJumlah = createTextField();
        txtJumlah.setText("1");
        jumlahPanel.add(txtJumlah, BorderLayout.CENTER);

        comboSatuan = createComboBox(new String[]{
                "kg", "liter", "buah", "bungkus", "pack", "dus"
        });
        jumlahPanel.add(comboSatuan, BorderLayout.EAST);
        formPanel.add(jumlahPanel);

        formPanel.add(createLabel("Harga per Satuan (Rp):"));
        txtHarga = createTextField();
        formPanel.add(txtHarga);

        formPanel.add(createLabel("Prioritas:"));
        comboPrioritas = createComboBox(new String[]{
                "WAJIB", "PENTING", "BISA NANTI"
        });
        formPanel.add(comboPrioritas);

        formPanel.add(createLabel("Toko:"));
        comboToko = createComboBox(new String[]{
                "PASAR", "SWALAYAN", "ONLINE", "TOKO KELONTONG"
        });
        formPanel.add(comboToko);

        formPanel.add(createLabel("* wajib diisi"));
        formPanel.add(createLabel("ID akan dibuat otomatis"));

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(COKLAT_MUDA);

        JButton btnSimpan = createButton("💾 Simpan Barang");
        btnSimpan.addActionListener(e -> simpanBarang());

        JButton btnReset = createButton("🔄 Reset Form");
        btnReset.addActionListener(e -> resetForm());

        JButton btnKembali = createButton("← Kembali ke Dashboard");
        btnKembali.addActionListener(e -> parent.showDashboard());

        buttonPanel.add(btnSimpan);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnKembali);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(FONT_LABEL);
        label.setForeground(Color.BLACK);
        return label;
    }

    private JTextField createTextField() {
        JTextField tf = new JTextField();
        tf.setFont(FONT_INPUT);
        tf.setForeground(Color.BLACK);
        tf.setBackground(Color.WHITE);
        return tf;
    }

    private JComboBox<String> createComboBox(String[] data) {
        JComboBox<String> cb = new JComboBox<>(data);
        cb.setFont(FONT_INPUT);
        cb.setForeground(Color.BLACK);
        cb.setBackground(Color.WHITE);
        return cb;
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(FONT_BUTTON);
        btn.setForeground(Color.BLACK);
        btn.setBackground(new Color(222, 184, 135));
        return btn;
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
                result = belanjaService.tambahBarang(
                        nama, jumlah, satuan, harga, prioritas, toko
                );
            } else {
                result = belanjaService.updateBarang(
                        currentId, nama, jumlah, satuan, harga, prioritas, toko
                );
            }

            if (result.startsWith("✅")) {
                parent.showMessage(result, "Sukses", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
                parent.showDaftarBarang();
            } else {
                parent.showMessage(result, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            parent.showMessage("Jumlah dan harga harus angka!",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            parent.showMessage("Error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
