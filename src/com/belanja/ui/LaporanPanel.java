package com.belanja.ui;

import com.belanja.service.BelanjaService;
import com.belanja.util.Validator;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class LaporanPanel extends JPanel {
    private MainFrame parent;
    private BelanjaService belanjaService;
    private JLabel lblAnggaran, lblTotal, lblSisa, lblJumlahBarang;
    private JTextArea txtLaporan;

    public LaporanPanel(MainFrame parent, BelanjaService belanjaService) {
        this.parent = parent;
        this.belanjaService = belanjaService;
        initUI();
        refreshLaporan();
    }

    private void initUI() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("📈 LAPORAN BELANJA");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnRefresh = new JButton("🔄 Refresh");
        btnRefresh.addActionListener(e -> refreshLaporan());

        JButton btnBackup = new JButton("💾 Buat Backup");
        btnBackup.addActionListener(e -> {
            belanjaService.buatBackup();
            parent.showMessage("Backup berhasil dibuat!", "Info", JOptionPane.INFORMATION_MESSAGE);
        });

        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnBackup);
        headerPanel.add(buttonPanel, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        JPanel mainContent = new JPanel(new GridLayout(1, 2, 20, 0));
        JPanel statsPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        statsPanel.setBorder(BorderFactory.createTitledBorder("📊 Statistik Utama"));

        statsPanel.add(createStatItem("Anggaran Bulanan:", "Rp 0"));
        lblAnggaran = (JLabel) ((JPanel) statsPanel.getComponent(0)).getComponent(1);

        statsPanel.add(createStatItem("Total Belanja:", "Rp 0"));
        lblTotal = (JLabel) ((JPanel) statsPanel.getComponent(1)).getComponent(1);

        statsPanel.add(createStatItem("Sisa Anggaran:", "Rp 0"));
        lblSisa = (JLabel) ((JPanel) statsPanel.getComponent(2)).getComponent(1);

        statsPanel.add(createStatItem("Jumlah Barang:", "0 item"));
        lblJumlahBarang = (JLabel) ((JPanel) statsPanel.getComponent(3)).getComponent(1);

        JButton btnSetAnggaran = new JButton("💰 Set Anggaran");
        btnSetAnggaran.addActionListener(e -> setAnggaran());
        statsPanel.add(btnSetAnggaran);
        mainContent.add(statsPanel);

        JPanel tokoPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        tokoPanel.setBorder(BorderFactory.createTitledBorder("🏪 Distribusi per Toko"));

        tokoPanel.add(createTokoItem("PASAR:", "Rp 0"));
        tokoPanel.add(createTokoItem("SWALAYAN:", "Rp 0"));
        tokoPanel.add(createTokoItem("ONLINE:", "Rp 0"));
        tokoPanel.add(createTokoItem("TOKO KELONTONG:", "Rp 0"));

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        tokoPanel.add(progressBar);

        mainContent.add(tokoPanel);
        add(mainContent, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createTitledBorder("📝 Ringkasan Laporan"));
        txtLaporan = new JTextArea(8, 50);
        txtLaporan.setEditable(false);
        txtLaporan.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtLaporan);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        JButton btnKembali = new JButton("← Kembali ke Dashboard");
        btnKembali.addActionListener(e -> parent.showDashboard());
        bottomPanel.add(btnKembali, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createStatItem(String label, String value) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(label), BorderLayout.WEST);
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(valueLabel, BorderLayout.EAST);
        return panel;
    }

    private JPanel createTokoItem(String label, String value) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(label), BorderLayout.WEST);
        panel.add(new JLabel(value), BorderLayout.EAST);
        return panel;
    }

    public void refreshLaporan() {
        double anggaran = belanjaService.getAnggaran();
        double total = belanjaService.hitungTotalBelanja();
        double sisa = belanjaService.hitungSisaAnggaran();
        int jumlah = belanjaService.getJumlahBarang();
        int belumDibeli = belanjaService.getJumlahBelumDibeli();

        lblAnggaran.setText(Validator.formatRupiah(anggaran));
        lblTotal.setText(Validator.formatRupiah(total));
        lblSisa.setText(Validator.formatRupiah(sisa));
        lblJumlahBarang.setText(jumlah + " item (" + belumDibeli + " belum dibeli)");

        generateLaporanText(anggaran, total, sisa, jumlah, belumDibeli);
    }

    private void generateLaporanText(double anggaran, double total, double sisa,
                                     int jumlah, int belumDibeli) {
        Map<String, Double> perToko = belanjaService.hitungPerToko();

        StringBuilder sb = new StringBuilder();
        sb.append("LAPORAN BELANJA BULANAN\n");
        sb.append("=".repeat(40) + "\n\n");

        sb.append("📊 STATISTIK UTAMA:\n");
        sb.append(String.format("  • Anggaran         : %s\n", Validator.formatRupiah(anggaran)));
        sb.append(String.format("  • Total Belanja    : %s\n", Validator.formatRupiah(total)));
        sb.append(String.format("  • Sisa Anggaran    : %s\n", Validator.formatRupiah(sisa)));
        sb.append(String.format("  • Jumlah Barang    : %d item\n", jumlah));
        sb.append(String.format("  • Belum Dibeli     : %d item\n\n", belumDibeli));

        sb.append("🏪 DISTRIBUSI PER TOKO:\n");
        for (Map.Entry<String, Double> entry : perToko.entrySet()) {
            double persentase = total > 0 ? (entry.getValue() / total) * 100 : 0;
            sb.append(String.format("  • %-15s : %s (%s)\n",
                    entry.getKey(),
                    Validator.formatRupiah(entry.getValue()),
                    Validator.formatPersentase(entry.getValue(), total)
            ));
        }

        sb.append("\n💡 REKOMENDASI:\n");
        if (sisa < 0) {
            sb.append("  ⚠️  Anggaran terlampaui! Kurangi belanja.\n");
        } else if (sisa < anggaran * 0.1) {
            sb.append("  ⚠️  Anggaran hampir habis. Batasi belanja baru.\n");
        } else if (sisa > anggaran * 0.5) {
            sb.append("  ✅  Anggaran masih aman. Bisa tambah belanja.\n");
        } else {
            sb.append("  ⚖️  Anggaran dalam kondisi normal.\n");
        }

        if (belumDibeli > 10) {
            sb.append("  ⚠️  Terlalu banyak barang belum dibeli. Prioritaskan!\n");
        }

        txtLaporan.setText(sb.toString());
    }

    private void setAnggaran() {
        String input = JOptionPane.showInputDialog(this,
                "Masukkan anggaran bulanan baru (Rp):",
                "Set Anggaran",
                JOptionPane.QUESTION_MESSAGE);

        if (input != null && !input.trim().isEmpty()) {
            try {
                double newAnggaran = Double.parseDouble(input);
                belanjaService.setAnggaran(newAnggaran);
                refreshLaporan();
                parent.showMessage("Anggaran berhasil diupdate!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                parent.showMessage("Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}