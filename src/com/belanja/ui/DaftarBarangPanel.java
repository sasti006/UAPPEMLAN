package com.belanja.ui;

import com.belanja.model.Barang;
import com.belanja.service.BelanjaService;
import com.belanja.util.Validator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DaftarBarangPanel extends JPanel {

    private static final Color COKLAT_MUDA = new Color(245, 222, 179);
    private static final Color COKLAT_TUA  = new Color(101, 67, 33);

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
        setBackground(COKLAT_MUDA);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(COKLAT_MUDA);

        JLabel titleLabel = new JLabel("DAFTAR BARANG BELANJA");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK);
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchPanel.setBackground(COKLAT_MUDA);

        JLabel lblCari = new JLabel("🔍 Cari:");
        lblCari.setForeground(Color.BLACK);
        searchPanel.add(lblCari);

        txtSearch = new JTextField(20);
        txtSearch.setForeground(Color.BLACK);
        txtSearch.addActionListener(e -> searchBarang());
        searchPanel.add(txtSearch);

        JLabel lblSort = new JLabel("Urutkan:");
        lblSort.setForeground(Color.BLACK);
        searchPanel.add(lblSort);

        JComboBox<String> comboSort = new JComboBox<>(
                new String[]{"Nama A-Z", "Harga Terendah", "Harga Tertinggi", "Prioritas"}
        );
        comboSort.setForeground(Color.BLACK);
        comboSort.addActionListener(e -> sortBarang((String) comboSort.getSelectedItem()));
        searchPanel.add(comboSort);

        JButton btnRefresh = new JButton("🔄 Refresh");
        btnRefresh.setForeground(Color.BLACK);
        btnRefresh.addActionListener(e -> refreshTable());
        searchPanel.add(btnRefresh);

        headerPanel.add(searchPanel, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        String[] columns = {
                "ID", "Nama", "Jumlah", "Satuan",
                "Harga", "Total", "Prioritas", "Toko", "Status"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.setRowHeight(30);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.setBackground(COKLAT_TUA);
        table.setForeground(Color.WHITE);
        table.setGridColor(new Color(160, 120, 80));
        table.setSelectionBackground(new Color(160, 120, 80));
        table.setSelectionForeground(Color.WHITE);

        table.getTableHeader().setBackground(new Color(120, 80, 40));
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(COKLAT_TUA);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                "Daftar Belanja"
        ));

        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(COKLAT_MUDA);

        JButton btnEdit = new JButton("✏️ Edit Barang");
        btnEdit.setForeground(Color.BLACK);
        btnEdit.addActionListener(e -> editBarang());

        JButton btnDelete = new JButton("🗑️ Hapus Barang");
        btnDelete.setForeground(Color.BLACK);
        btnDelete.addActionListener(e -> deleteBarang());

        JButton btnMarkBought = new JButton("✅ Tandai Sudah Dibeli");
        btnMarkBought.setForeground(Color.BLACK);
        btnMarkBought.addActionListener(e -> markAsBought());

        JButton btnBack = new JButton("← Kembali ke Dashboard");
        btnBack.setForeground(Color.BLACK);
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
        if (keyword.isEmpty()) {
            refreshTable();
            return;
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Barang barang : belanjaService.cariBarang(keyword)) {
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

    private void sortBarang(String selected) {
        String sortBy = switch (selected) {
            case "Nama A-Z" -> "nama";
            case "Harga Terendah" -> "harga";
            case "Harga Tertinggi" -> "harga_desc";
            case "Prioritas" -> "prioritas";
            default -> "";
        };

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Barang barang : belanjaService.sortBy(sortBy)) {
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
        int row = table.getSelectedRow();
        if (row == -1) {
            parent.showMessage("Pilih barang yang ingin diedit!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        parent.showFormForEdit((String) table.getValueAt(row, 0));
    }

    private void deleteBarang() {
        int row = table.getSelectedRow();
        if (row == -1) {
            parent.showMessage("Pilih barang yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = (String) table.getValueAt(row, 0);
        String nama = (String) table.getValueAt(row, 1);

        if (parent.showConfirm("Hapus barang: " + nama + "?", "Konfirmasi")) {
            parent.showMessage(
                    belanjaService.hapusBarang(id),
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE
            );
            refreshTable();
        }
    }

    private void markAsBought() {
        int row = table.getSelectedRow();
        if (row == -1) {
            parent.showMessage("Pilih barang yang sudah dibeli!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        parent.showMessage(
                belanjaService.tandaiSudahDibeli((String) table.getValueAt(row, 0)),
                "Info",
                JOptionPane.INFORMATION_MESSAGE
        );
        refreshTable();
    }
}
