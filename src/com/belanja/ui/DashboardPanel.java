package com.belanja.ui;

import com.belanja.service.BelanjaService;
import com.belanja.util.Validator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DashboardPanel extends JPanel {

    // ===== WARNA TEMA =====
    private static final Color COKLAT_MUDA = new Color(245, 222, 179); // background
    private static final Color COKLAT_TUA  = new Color(101, 67, 33);   // tabel

    private MainFrame parent;
    private BelanjaService belanjaService;

    private JLabel lblTotalBarang, lblTotalBiaya, lblSisaDana, lblAnggaran;
    private JTable tblPrioritas;

    public DashboardPanel(MainFrame parent, BelanjaService belanjaService) {
        this.parent = parent;
        this.belanjaService = belanjaService;
        initUI();
        refreshData();
    }

    private void initUI() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(COKLAT_MUDA);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(COKLAT_MUDA);

        JLabel titleLabel = new JLabel("DASHBOARD BELANJA BULANAN");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK);
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setBackground(COKLAT_MUDA);

        JButton btnTambah = new JButton("➕ Tambah Barang");
        btnTambah.setForeground(Color.BLACK);
        btnTambah.addActionListener(e -> parent.showFormBarang());

        JButton btnLihatSemua = new JButton("📋 Lihat Semua Barang");
        btnLihatSemua.setForeground(Color.BLACK);
        btnLihatSemua.addActionListener(e -> parent.showDaftarBarang());

        buttonPanel.add(btnTambah);
        buttonPanel.add(btnLihatSemua);
        headerPanel.add(buttonPanel, BorderLayout.EAST);

        add(headerPanel, BorderLayout.NORTH);

        JPanel mainContent = new JPanel(new GridLayout(2, 1, 10, 10));
        mainContent.setBackground(COKLAT_MUDA);

        JPanel statsPanel = new JPanel(new GridLayout(1, 4, 15, 15));
        statsPanel.setBackground(COKLAT_MUDA);

        JPanel card1 = createStatCard("Total Barang", "0", "item dalam daftar");
        lblTotalBarang = (JLabel) ((JPanel) card1.getComponent(1)).getComponent(0);

        JPanel card2 = createStatCard("Total Biaya", "Rp 0", "belum dibeli");
        lblTotalBiaya = (JLabel) ((JPanel) card2.getComponent(1)).getComponent(0);

        JPanel card3 = createStatCard("Sisa Dana", "Rp 0", "dari anggaran");
        lblSisaDana = (JLabel) ((JPanel) card3.getComponent(1)).getComponent(0);

        JPanel card4 = createStatCard("Anggaran", "Rp 0", "bulanan");
        lblAnggaran = (JLabel) ((JPanel) card4.getComponent(1)).getComponent(0);

        statsPanel.add(card1);
        statsPanel.add(card2);
        statsPanel.add(card3);
        statsPanel.add(card4);

        mainContent.add(statsPanel);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(COKLAT_MUDA);
        tablePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                "📋Barang Berdasarkan Prioritas"
        ));

        String[] columns = {"Nama", "Jumlah", "Harga", "Prioritas", "Toko"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblPrioritas = new JTable(model);
        tblPrioritas.setRowHeight(30);

        tblPrioritas.setBackground(COKLAT_TUA);
        tblPrioritas.setForeground(Color.WHITE); // isi tabel tetap putih biar kebaca
        tblPrioritas.setGridColor(new Color(160, 120, 80));
        tblPrioritas.setSelectionBackground(new Color(160, 120, 80));
        tblPrioritas.setSelectionForeground(Color.WHITE);

        tblPrioritas.getTableHeader().setBackground(new Color(120, 80, 40));
        tblPrioritas.getTableHeader().setForeground(Color.BLACK); // font hitam
        tblPrioritas.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));

        JScrollPane scrollPane = new JScrollPane(tblPrioritas);
        scrollPane.getViewport().setBackground(COKLAT_TUA);

        tablePanel.add(scrollPane, BorderLayout.CENTER);
        mainContent.add(tablePanel);

        add(mainContent, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(COKLAT_MUDA);

        JLabel infoLabel = new JLabel("💡 Tips: Prioritaskan barang 'WAJIB' terlebih dahulu!");
        infoLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        infoLabel.setForeground(Color.BLACK);

        bottomPanel.add(infoLabel);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createStatCard(String title, String value, String subtitle) {
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        card.setBackground(new Color(255, 248, 220)); // creamy coklat

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(Color.BLACK);
        card.add(titleLabel, BorderLayout.NORTH);

        JPanel valuePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        valuePanel.setOpaque(false);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 24));
        valueLabel.setForeground(Color.BLACK);
        valuePanel.add(valueLabel);

        card.add(valuePanel, BorderLayout.CENTER);

        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        subtitleLabel.setForeground(Color.BLACK);
        card.add(subtitleLabel, BorderLayout.SOUTH);

        return card;
    }

    public void refreshData() {
        int totalBarang = belanjaService.getJumlahBarang();
        double totalBiaya = belanjaService.hitungTotalBelanja();
        double sisaDana = belanjaService.hitungSisaAnggaran();
        double anggaran = belanjaService.getAnggaran();

        lblTotalBarang.setText(String.valueOf(totalBarang));
        lblTotalBiaya.setText(Validator.formatRupiah(totalBiaya));
        lblSisaDana.setText(Validator.formatRupiah(sisaDana));
        lblAnggaran.setText(Validator.formatRupiah(anggaran));

        DefaultTableModel model = (DefaultTableModel) tblPrioritas.getModel();
        model.setRowCount(0);

        belanjaService.getSemuaBarang().stream()
                .filter(b -> !b.isSudahDibeli())
                .limit(10)
                .forEach(b -> model.addRow(new Object[]{
                        b.getNama(),
                        b.getJumlah() + " " + b.getSatuan(),
                        Validator.formatRupiah(b.getHarga()),
                        b.getPrioritas(),
                        b.getToko()
                }));
    }
}
