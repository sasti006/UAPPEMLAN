package com.belanja.ui;

import com.belanja.model.Barang;
import com.belanja.service.BelanjaService;
import com.belanja.util.Validator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DaftarBarangPanel extends JPanel {
    private MainFrame parent;
    private BelanjaService belanjaService;
    private JTable table;
    private JTextField txtSearch;

    public DaftarBarangPanel(MainFrame parent, BelanjaService belanjaService) {
        this.parent = parent;
        this.belanjaService = belanjaService;
        initUI();
        refreshTable();
    }

    private void initUI() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("📋 DAFTAR BARANG BELANJA");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchPanel.add(new JLabel("🔍 Cari:"));
        txtSearch = new JTextField(20);
        txtSearch.addActionListener(e -> searchBarang());
        searchPanel.add(txtSearch);

        JComboBox<String> comboSort = new JComboBox<>(new String[]{"Nama A-Z", "Harga Terendah", "Harga Tertinggi", "Prioritas"});
        comboSort.addActionListener(e -> sortBarang((String) comboSort.getSelectedItem()));
        searchPanel.add(new JLabel("Urutkan:"));
        searchPanel.add(comboSort);

        JButton btnRefresh = new JButton("🔄 Refresh");
        btnRefresh.addActionListener(e -> refreshTable());
        searchPanel.add(btnRefresh);
        headerPanel.add(searchPanel, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        String[] columns = {"ID", "Nama", "Jumlah", "Satuan", "Harga", "Total", "Prioritas", "Toko", "Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };

        table = new JTable(model);
        table.setRowHeight(30);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Daftar Belanja"));
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnEdit = new JButton("✏️ Edit Barang");
        btnEdit.addActionListener(e -> editBarang());

        JButton btnDelete = new JButton("🗑️ Hapus Barang");
        btnDelete.addActionListener(e -> deleteBarang());

        JButton btnMarkBought = new JButton("✅ Tandai Sudah Dibeli");
        btnMarkBought.addActionListener(e -> markAsBought());

        JButton btnBack = new JButton("← Kembali ke Dashboard");
        btnBack.addActionListener(e -> parent.showDashboard());

        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnMarkBought);
        buttonPanel.add(btnBack);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<Barang> barangList = belanjaService.getSemuaBarang();
        for (Barang barang : barangList) {
            String status = barang.isSudahDibeli() ? "✅ Sudah Dibeli" : "⏳ Belum Dibeli";
            model.addRow(new Object[]{
                    barang.getId(),
                    barang.getNama(),
                    barang.getJumlah(),
                    barang.getSatuan(),
                    Validator.formatRupiah(barang.getHarga()),
                    Validator.formatRupiah(barang.getTotalHarga()),
                    barang.getPrioritas(),
                    barang.getToko(),
                    status
            });
        }
    }

    private void searchBarang() {
        String keyword = txtSearch.getText().trim();
        if (!keyword.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            List<Barang> results = belanjaService.cariBarang(keyword);
            for (Barang barang : results) {
                String status = barang.isSudahDibeli() ? "✅ Sudah Dibeli" : "⏳ Belum Dibeli";
                model.addRow(new Object[]{
                        barang.getId(),
                        barang.getNama(),
                        barang.getJumlah(),
                        barang.getSatuan(),
                        Validator.formatRupiah(barang.getHarga()),
                        Validator.formatRupiah(barang.getTotalHarga()),
                        barang.getPrioritas(),
                        barang.getToko(),
                        status
                });
            }
        } else {
            refreshTable();
        }
    }

    private void sortBarang(String selected) {
        String sortBy = "";
        switch (selected) {
            case "Nama A-Z": sortBy = "nama"; break;
            case "Harga Terendah": sortBy = "harga"; break;
            case "Harga Tertinggi": sortBy = "harga_desc"; break;
            case "Prioritas": sortBy = "prioritas"; break;
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        List<Barang> sorted = belanjaService.sortBy(sortBy);
        for (Barang barang : sorted) {
            String status = barang.isSudahDibeli() ? "✅ Sudah Dibeli" : "⏳ Belum Dibeli";
            model.addRow(new Object[]{
                    barang.getId(),
                    barang.getNama(),
                    barang.getJumlah(),
                    barang.getSatuan(),
                    Validator.formatRupiah(barang.getHarga()),
                    Validator.formatRupiah(barang.getTotalHarga()),
                    barang.getPrioritas(),
                    barang.getToko(),
                    status
            });
        }
    }

    private void editBarang() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            parent.showMessage("Pilih barang yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = (String) table.getValueAt(selectedRow, 0);
        parent.showFormForEdit(id);
    }

    private void deleteBarang() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            parent.showMessage("Pilih barang yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = (String) table.getValueAt(selectedRow, 0);
        String nama = (String) table.getValueAt(selectedRow, 1);

        boolean confirm = parent.showConfirm("Hapus barang: " + nama + "?", "Konfirmasi Hapus");
        if (confirm) {
            String result = belanjaService.hapusBarang(id);
            parent.showMessage(result, "Info", JOptionPane.INFORMATION_MESSAGE);
            refreshTable();
        }
    }

    private void markAsBought() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            parent.showMessage("Pilih barang yang sudah dibeli!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String id = (String) table.getValueAt(selectedRow, 0);
        String result = belanjaService.tandaiSudahDibeli(id);
        parent.showMessage(result, "Info", JOptionPane.INFORMATION_MESSAGE);
        refreshTable();
    }
}