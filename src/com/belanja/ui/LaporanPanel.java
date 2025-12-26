package com.belanja.ui;

import com.belanja.service.BelanjaService;
import com.belanja.util.Validator;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Map;

public class LaporanPanel extends JPanel {

    private static final Color COKLAT_MUDA = new Color(245, 222, 179);
    private static final Color COKLAT_TUA  = new Color(101, 67, 33);
    private static final Font FONT_LABEL  = new Font("Arial", Font.BOLD, 14);
    private static final Font FONT_VALUE  = new Font("Arial", Font.BOLD, 15);

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
        setLayout(new BorderLayout(15, 15));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(COKLAT_MUDA);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(COKLAT_MUDA);

        JLabel title = new JLabel("LAPORAN BELANJA");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.BLACK);
        header.add(title, BorderLayout.WEST);

        JPanel headerBtn = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        headerBtn.setBackground(COKLAT_MUDA);

        JButton btnRefresh = createButton("🔄 Refresh");
        btnRefresh.addActionListener(e -> refreshLaporan());

        JButton btnBackup = createButton("💾 Backup");
        btnBackup.addActionListener(e -> {
            belanjaService.buatBackup();
            parent.showMessage("Backup berhasil dibuat!", "Info",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        headerBtn.add(btnRefresh);
        headerBtn.add(btnBackup);
        header.add(headerBtn, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);

        JPanel center = new JPanel(new GridLayout(1, 2, 20, 0));
        center.setBackground(COKLAT_MUDA);

        JPanel statsPanel = createCardPanel("📊 Statistik Utama");
        JPanel statsContent = new JPanel(new GridLayout(5, 1, 10, 10));
        statsContent.setBackground(COKLAT_TUA);

        statsContent.add(createStatItem("Anggaran Bulanan:", lblAnggaran = new JLabel()));
        statsContent.add(createStatItem("Total Belanja:", lblTotal = new JLabel()));
        statsContent.add(createStatItem("Sisa Anggaran:", lblSisa = new JLabel()));
        statsContent.add(createStatItem("Jumlah Barang:", lblJumlahBarang = new JLabel()));

        JButton btnSetAnggaran = createButton("💰 Set Anggaran");
        btnSetAnggaran.addActionListener(e -> setAnggaran());
        statsContent.add(btnSetAnggaran);

        statsPanel.add(statsContent, BorderLayout.CENTER);
        center.add(statsPanel);

        JPanel tokoPanel = createCardPanel("🏪 Distribusi per Toko");
        JPanel tokoContent = new JPanel(new GridLayout(5, 1, 10, 10));
        tokoContent.setBackground(COKLAT_TUA);

        tokoContent.add(createSimpleLabel("PASAR"));
        tokoContent.add(createSimpleLabel("SWALAYAN"));
        tokoContent.add(createSimpleLabel("ONLINE"));
        tokoContent.add(createSimpleLabel("TOKO KELONTONG"));

        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        tokoContent.add(progressBar);

        tokoPanel.add(tokoContent, BorderLayout.CENTER);
        center.add(tokoPanel);

        add(center, BorderLayout.CENTER);

        JPanel bottom = createCardPanel("📝 Ringkasan Laporan");

        txtLaporan = new JTextArea(8, 50);
        txtLaporan.setEditable(false);
        txtLaporan.setFont(new Font("Monospaced", Font.BOLD, 13));
        txtLaporan.setForeground(Color.BLACK);
        txtLaporan.setBackground(Color.WHITE);

        bottom.add(new JScrollPane(txtLaporan), BorderLayout.CENTER);

        JButton btnKembali = createButton("← Kembali ke Dashboard");
        btnKembali.addActionListener(e -> parent.showDashboard());
        bottom.add(btnKembali, BorderLayout.SOUTH);

        add(bottom, BorderLayout.SOUTH);
    }

    private JPanel createCardPanel(String title) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(COKLAT_TUA);

        TitledBorder border = BorderFactory.createTitledBorder(title);
        border.setTitleColor(Color.BLACK);
        border.setTitleFont(new Font("Arial", Font.BOLD, 14));
        panel.setBorder(border);

        return panel;
    }

    private JPanel createStatItem(String text, JLabel value) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(COKLAT_TUA);

        JLabel label = new JLabel(text);
        label.setFont(FONT_LABEL);
        label.setForeground(Color.BLACK);

        value.setFont(FONT_VALUE);
        value.setForeground(Color.BLACK);

        panel.add(label, BorderLayout.WEST);
        panel.add(value, BorderLayout.EAST);
        return panel;
    }

    private JLabel createSimpleLabel(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(FONT_LABEL);
        lbl.setForeground(Color.BLACK);
        return lbl;
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(FONT_LABEL);
        btn.setForeground(Color.BLACK);
        btn.setBackground(new Color(222, 184, 135));
        return btn;
    }

    public void refreshLaporan() {
        double anggaran = belanjaService.getAnggaran();
        double total = belanjaService.hitungTotalBelanja();
        double sisa = belanjaService.hitungSisaAnggaran();
        int jumlah = belanjaService.getJumlahBarang();
        int belum = belanjaService.getJumlahBelumDibeli();

        lblAnggaran.setText(Validator.formatRupiah(anggaran));
        lblTotal.setText(Validator.formatRupiah(total));
        lblSisa.setText(Validator.formatRupiah(sisa));
        lblJumlahBarang.setText(jumlah + " item (" + belum + " belum)");

        generateLaporanText(anggaran, total, sisa, jumlah, belum);
    }

    private void generateLaporanText(double anggaran, double total,
                                     double sisa, int jumlah, int belum) {

        Map<String, Double> perToko = belanjaService.hitungPerToko();
        StringBuilder sb = new StringBuilder();

        sb.append("LAPORAN BELANJA BULANAN\n");
        sb.append("=".repeat(40)).append("\n\n");

        sb.append("Anggaran : ").append(Validator.formatRupiah(anggaran)).append("\n");
        sb.append("Total    : ").append(Validator.formatRupiah(total)).append("\n");
        sb.append("Sisa     : ").append(Validator.formatRupiah(sisa)).append("\n");
        sb.append("Barang   : ").append(jumlah).append(" item\n\n");

        sb.append("Distribusi Toko:\n");
        for (var e : perToko.entrySet()) {
            sb.append("- ").append(e.getKey())
                    .append(" : ").append(Validator.formatRupiah(e.getValue()))
                    .append("\n");
        }

        txtLaporan.setText(sb.toString());
    }

    private void setAnggaran() {
        String input = JOptionPane.showInputDialog(this,
                "Masukkan anggaran baru (Rp):");

        if (input != null && !input.isEmpty()) {
            try {
                belanjaService.setAnggaran(Double.parseDouble(input));
                refreshLaporan();
            } catch (Exception e) {
                parent.showMessage("Input tidak valid!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
