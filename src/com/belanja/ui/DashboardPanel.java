package com.belanja.ui;

import com.belanja.service.BelanjaService;
import com.belanja.util.Validator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DashboardPanel extends JPanel {
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

        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("📊 DASHBOARD BELANJA BULANAN");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        JButton btnTambah = new JButton("➕ Tambah Barang");
        btnTambah.addActionListener(e -> parent.showFormBarang());

        JButton btnLihatSemua = new JButton("📋 Lihat Semua Barang");
        btnLihatSemua.addActionListener(e -> parent.showDaftarBarang());

        buttonPanel.add(btnTambah);
        buttonPanel.add(btnLihatSemua);
        headerPanel.add(buttonPanel, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        JPanel mainContent = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel statsPanel = new JPanel(new GridLayout(1, 4, 15, 15));

        JPanel card1 = createStatCard("📦 Total Barang", "0", "item dalam daftar", new Color(52, 152, 219));
        lblTotalBarang = (JLabel) ((JPanel) card1.getComponent(1)).getComponent(0);

        JPanel card2 = createStatCard("💰 Total Biaya", "Rp 0", "belum dibeli", new Color(46, 204, 113));
        lblTotalBiaya = (JLabel) ((JPanel) card2.getComponent(1)).getComponent(0);

        JPanel card3 = createStatCard("💵 Sisa Dana", "Rp 0", "dari anggaran", new Color(241, 196, 15));
        lblSisaDana = (JLabel) ((JPanel) card3.getComponent(1)).getComponent(0);

        JPanel card4 = createStatCard("📋 Anggaran", "Rp 0", "bulanan", new Color(155, 89, 182));
        lblAnggaran = (JLabel) ((JPanel) card4.getComponent(1)).getComponent(0);

        statsPanel.add(card1);
        statsPanel.add(card2);
        statsPanel.add(card3);
        statsPanel.add(card4);
        mainContent.add(statsPanel);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("📋 Barang Berdasarkan Prioritas"));
        String[] columns = {"Nama", "Jumlah", "Harga", "Prioritas", "Toko"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        tblPrioritas = new JTable(model);
        tblPrioritas.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(tblPrioritas);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        mainContent.add(tablePanel);
        add(mainContent, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel infoLabel = new JLabel("💡 Tips: Prioritaskan barang 'WAJIB' terlebih dahulu!");
        infoLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        bottomPanel.add(infoLabel);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private JPanel createStatCard(String title, String value, String subtitle, Color color) {
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color, 2),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        card.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        titleLabel.setForeground(color);
        card.add(titleLabel, BorderLayout.NORTH);

        JPanel valuePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 24));
        valuePanel.add(valueLabel);
        card.add(valuePanel, BorderLayout.CENTER);

        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        subtitleLabel.setForeground(Color.GRAY);
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
                .sorted((b1, b2) -> {
                    int p1 = b1.getPrioritas().equals("WAJIB") ? 1 :
                            b1.getPrioritas().equals("PENTING") ? 2 : 3;
                    int p2 = b2.getPrioritas().equals("WAJIB") ? 1 :
                            b2.getPrioritas().equals("PENTING") ? 2 : 3;
                    return Integer.compare(p1, p2);
                })
                .limit(10)
                .forEach(b -> {
                    model.addRow(new Object[]{
                            b.getNama(),
                            b.getJumlah() + " " + b.getSatuan(),
                            Validator.formatRupiah(b.getHarga()),
                            b.getPrioritas(),
                            b.getToko()
                    });
                });
    }
}