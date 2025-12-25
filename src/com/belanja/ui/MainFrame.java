package com.belanja.ui;

import com.belanja.service.BelanjaService;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private DashboardPanel dashboardPanel;
    private DaftarBarangPanel daftarBarangPanel;
    private FormBarangPanel formBarangPanel;
    private LaporanPanel laporanPanel;
    private BelanjaService belanjaService;

    public MainFrame() {
        belanjaService = new BelanjaService();

        setTitle("📝 Catatan Belanja Bulanan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        dashboardPanel = new DashboardPanel(this, belanjaService);
        daftarBarangPanel = new DaftarBarangPanel(this, belanjaService);
        formBarangPanel = new FormBarangPanel(this, belanjaService);
        laporanPanel = new LaporanPanel(this, belanjaService);

        mainPanel.add(dashboardPanel, "DASHBOARD");
        mainPanel.add(daftarBarangPanel, "DAFTAR");
        mainPanel.add(formBarangPanel, "FORM");
        mainPanel.add(laporanPanel, "LAPORAN");

        add(mainPanel);
        setupMenuBar();
        showDashboard();
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem backupItem = new JMenuItem("Buat Backup");
        backupItem.addActionListener(e -> {
            belanjaService.buatBackup();
            JOptionPane.showMessageDialog(this, "Backup berhasil dibuat!");
        });

        JMenuItem exitItem = new JMenuItem("Keluar");
        exitItem.addActionListener(e -> confirmExit());

        fileMenu.add(backupItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu navMenu = new JMenu("Navigasi");
        JMenuItem dashboardItem = new JMenuItem("Dashboard");
        dashboardItem.addActionListener(e -> showDashboard());

        JMenuItem daftarItem = new JMenuItem("Daftar Barang");
        daftarItem.addActionListener(e -> showDaftarBarang());

        JMenuItem tambahItem = new JMenuItem("Tambah Barang");
        tambahItem.addActionListener(e -> showFormBarang());

        JMenuItem laporanItem = new JMenuItem("Laporan");
        laporanItem.addActionListener(e -> showLaporan());

        navMenu.add(dashboardItem);
        navMenu.add(daftarItem);
        navMenu.add(tambahItem);
        navMenu.add(laporanItem);

        JMenu helpMenu = new JMenu("Bantuan");
        JMenuItem aboutItem = new JMenuItem("Tentang");
        aboutItem.addActionListener(e -> showAbout());
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(navMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
    }

    public void showDashboard() {
        cardLayout.show(mainPanel, "DASHBOARD");
        dashboardPanel.refreshData();
        setTitle("Catatan Belanja - Dashboard");
    }

    public void showDaftarBarang() {
        cardLayout.show(mainPanel, "DAFTAR");
        daftarBarangPanel.refreshTable();
        setTitle("Catatan Belanja - Daftar Barang");
    }

    public void showFormBarang() {
        cardLayout.show(mainPanel, "FORM");
        formBarangPanel.resetForm();
        setTitle("Catatan Belanja - Tambah/Edit Barang");
    }

    public void showLaporan() {
        cardLayout.show(mainPanel, "LAPORAN");
        laporanPanel.refreshLaporan();
        setTitle("Catatan Belanja - Laporan");
    }

    public void showFormForEdit(String id) {
        cardLayout.show(mainPanel, "FORM");
        formBarangPanel.loadDataForEdit(id);
        setTitle("Catatan Belanja - Edit Barang");
    }

    private void confirmExit() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah Anda yakin ingin keluar?",
                "Konfirmasi Keluar",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void showAbout() {
        JOptionPane.showMessageDialog(this,
                "Catatan Belanja Bulanan v1.0\n\n" +
                        "Aplikasi sederhana untuk mencatat rencana belanja bulanan\n" +
                        "Dibuat untuk tugas Pemrograman Lanjut\n" +
                        "© 2025",
                "Tentang Aplikasi",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    public boolean showConfirm(String message, String title) {
        int result = JOptionPane.showConfirmDialog(this, message, title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
}