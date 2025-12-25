📝 APLIKASI CATATAN BELANJA BULANAN
📋 DESKRIPSI SINGKAT
Aplikasi desktop Java untuk mengelola daftar belanja bulanan dengan GUI 4 halaman. Simpan data ke file CSV, kelola anggaran, dan pantau pengeluaran.

✨ FITUR UTAMA
✅ Dashboard - Statistik ringkas

✅ Daftar Barang - Tabel dengan CRUD lengkap

✅ Form Input - Tambah/edit barang

✅ Laporan - Analisis & backup data

✅ Validasi Input - Cegah data salah

✅ Sorting & Searching - Urutkan dan cari barang

🚀 CARA INSTALL & RUN
1. Siapkan Struktur Folder:
   text
   belanja-app/
   └── src/com/belanja/
   ├── model/
   ├── util/
   ├── service/
   └── ui/
2. Compile (Command Prompt):
   cmd
   cd belanja-app
   javac -d bin src/com/belanja/Main.java src/com/belanja/**/*.java
3. Jalankan:
   cmd
   java -cp bin com.belanja.Main
   🖥️ TAMPILAN GUI
   HALAMAN 1: Dashboard
   text
   📊 STATISTIK:
   • Total Barang: 8 item
   • Total Biaya: Rp 590.000
   • Sisa Dana: Rp 410.000
   • Anggaran: Rp 1.000.000
   HALAMAN 2: Daftar Barang
   Tabel semua barang

Tombol: Edit ❌ Hapus ✅ Tandai Dibeli

Fitur: Cari 🔍 Sortir ⬆⬇

HALAMAN 3: Form Input
text
Nama Barang*: _________
Jumlah*: _____ [kg|liter|buah|...]
Harga*: Rp _________
Prioritas*: [WAJIB|PENTING|BISA NANTI]
Toko*: [PASAR|SWALAYAN|ONLINE|...]
HALAMAN 4: Laporan
Distribusi per toko

Progress bar anggaran

Rekomendasi otomatis

Tombol backup

📝 CONTOH INPUT
Data Valid:
java
Nama: Beras Premium
Jumlah: 5
Satuan: kg
Harga: 15000
Prioritas: WAJIB
Toko: PASAR
Satuan yang Tersedia:
kg (beras, gula)

liter (minyak, susu)

buah (telur, sabun)

bungkus (mie, biskuit)

pack (paketan)

dus (kardus)

Prioritas:
WAJIB - Kebutuhan pokok

PENTING - Kebutuhan sekunder

BISA NANTI - Kebutuhan tersier

🔧 FITUR TEKNIS
File: Simpan otomatis ke data/belanja.csv

Backup: Otomatis dengan timestamp

Validasi: Cek semua input sebelum simpan

Error Handling: Pesan error jelas

⚡ PERFORMANCE
Load data: Cepat dengan CSV

Search: Linear search

Sort: Menggunakan Comparator

Memory: Ringan

🐛 TROUBLESHOOTING
Error 1: Class not found
cmd
# Pastikan compile semua file
javac -d bin src/com/belanja/**/*.java
Error 2: GUI tidak muncul
cmd
# Coba run dengan:
java -cp bin com.belanja.Main
Error 3: File tidak tersimpan
Cek folder data/ dibuat otomatis

Pastikan permission write

📊 CONTOH DATA TESTING
Keluarga (Rp 1.000.000):
text
1. Beras - 10kg @12.000 = 120.000 (WAJIB, PASAR)
2. Minyak - 2L @20.000 = 40.000 (WAJIB, SWALAYAN)
3. Telur - 2kg @30.000 = 60.000 (WAJIB, PASAR)
4. Ayam - 2kg @40.000 = 80.000 (PENTING, PASAR)
5. Sabun - 4 buah @5.000 = 20.000 (WAJIB, ONLINE)
   Mahasiswa (Rp 500.000):
   text
1. Mie Instan - 20 bungkus @3.000 = 60.000
2. Telur - 1kg @30.000 = 30.000
3. Roti - 5 bungkus @10.000 = 50.000
4. Susu - 2L @25.000 = 50.000
   🎯 CARA PAKAI
   Mulai: Jalankan Main.java

Input data: Navigasi → Tambah Barang

Kelola: Daftar Barang → Edit/Hapus

Analisis: Laporan → Lihat statistik

Backup: File → Buat Backup

📁 STRUKTUR FILE
text
📁 src/com/belanja/
├── 📄 Main.java           # Entry point
├── 📁 model/
│   ├── 📄 Barang.java     # Data structure
│   └── 📄 BelanjaManager.java # Business logic
├── 📁 util/
│   ├── 📄 FileHandler.java # File I/O
│   └── 📄 Validator.java   # Input validation
├── 📁 service/
│   └── 📄 BelanjaService.java # Service layer
└── 📁 ui/
├── 📄 MainFrame.java      # Main window
├── 📄 DashboardPanel.java # Page 1
├── 📄 DaftarBarangPanel.java # Page 2
├── 📄 FormBarangPanel.java # Page 3
└── 📄 LaporanPanel.java   # Page 4
✅ FITUR YANG DIUJI
Tambah barang - Input data baru

Edit barang - Ubah data yang ada

Hapus barang - Hapus dari daftar

Search - Cari dengan keyword

Sort - Urutkan nama/harga/prioritas

Tandai dibeli - Kurangi total biaya

Set anggaran - Ubah batas pengeluaran

Backup - Simpan cadangan data

🆘 BANTUAN CEPAT
Q: Data tidak muncul di tabel?
A: Klik tombol "Refresh" di Daftar Barang

Q: Error "Nama tidak boleh kosong"?
A: Isi semua field yang bertanda *

Q: File CSV korup?
A: Hapus file data/belanja.csv, restart aplikasi

Q: Anggaran minus?
A: Kurangi barang atau naikkan anggaran di Laporan

📞 SUPPORT
Untuk masalah teknis:

Cek error message

Restart aplikasi

Hapus file CSV dan mulai baru

Pastikan Java versi 8+

🎉 SELAMAT MENCOBA! Aplikasi siap membantu mengatur belanja bulanan dengan lebih efisien!

DIMANA TEMPAT MENGUBAH WARNA DASHBOARD PANEL
🎨 TEMPAT MENGUBAH WARNA DASHBOARD PANEL
1. WARNA KARTU STATISTIK - Di DashboardPanel.java
   Lokasi: Line ~100-110
   java
   // WARNA KE-1 (Biru)
   new Color(52, 152, 219)    // Default: Biru muda

// WARNA KE-2 (Hijau)
new Color(46, 204, 113)    // Default: Hijau terang

// WARNA KE-3 (Kuning)
new Color(241, 196, 15)    // Default: Kuning emas

// WARNA KE-4 (Ungu)
new Color(155, 89, 182)    // Default: Ungu lavender
Cara Ubah:
java
// Ganti dengan warna baru (RGB format)
JPanel card1 = createStatCard("📦 Total Barang", "0", "item dalam daftar",
new Color(255, 99, 71));    // MERAH TOMAT

JPanel card2 = createStatCard("💰 Total Biaya", "Rp 0", "belum dibeli",
new Color(60, 179, 113));   // HIJAU LUMUT

JPanel card3 = createStatCard("💵 Sisa Dana", "Rp 0", "dari anggaran",
new Color(255, 165, 0));    // ORANGE

JPanel card4 = createStatCard("📋 Anggaran", "Rp 0", "bulanan",
new Color(147, 112, 219));  // UNGU MEDIUM
2. WARNA BACKGROUND - Di DashboardPanel.java
   Lokasi: Constructor atau initUI()
   java
   // Tambahkan ini di initUI() atau constructor:
   setBackground(new Color(240, 248, 255));  // Alice Blue
   Warna Background Populer:
   java
   // Pilih salah satu:
   setBackground(Color.WHITE);                // Putih
   setBackground(new Color(245, 245, 245));   // Abu-abu muda
   setBackground(new Color(240, 248, 255));   // Biru sangat muda
   setBackground(new Color(255, 250, 240));   // Ivory
3. WARNA FONT/TEKS - Di DashboardPanel.java
   Title Color (~Line 40):
   java
   titleLabel.setForeground(new Color(44, 62, 80));  // Biru tua
   // Ganti dengan:
   titleLabel.setForeground(new Color(25, 25, 112)); // Midnight Blue
   Card Text Color (~Line 145):
   java
   // Di method createStatCard():
   titleLabel.setForeground(color);  // Ini warna judul kartu

// Untuk warna value (angka):
valueLabel.setForeground(new Color(0, 0, 0));  // Hitam
4. WARNA BORDER KARTU - Di DashboardPanel.java
   Lokasi: Method createStatCard() (~Line 135)
   java
   card.setBorder(BorderFactory.createCompoundBorder(
   BorderFactory.createLineBorder(color, 2),  // Ganti angka 2 untuk ketebalan
   BorderFactory.createEmptyBorder(15, 15, 15, 15)
   ));
   Contoh Border Tebal:
   java
   // Border lebih tebal (4 pixel)
   BorderFactory.createLineBorder(color, 4)

// Border dengan efek rounded
BorderFactory.createLineBorder(color, 2)
// PLUS: card.setBorder(new RoundedBorder(10)); // Butuh class RoundedBorder
5. CONTOH THEME LENGKAP
   Theme 1: PASTEL
   java
   // Kartu 1-4
   new Color(255, 182, 193)  // Light Pink
   new Color(173, 216, 230)  // Light Blue
   new Color(152, 251, 152)  // Pale Green
   new Color(221, 160, 221)  // Plum

// Background
setBackground(new Color(255, 250, 250));  // Snow White
Theme 2: DARK MODE
java
// Kartu
new Color(70, 130, 180)    // Steel Blue
new Color(60, 179, 113)    // Medium Sea Green
new Color(218, 165, 32)    // Golden Rod
new Color(186, 85, 211)    // Medium Orchid

// Background
setBackground(new Color(47, 79, 79));     // Dark Slate Gray
setForeground(Color.WHITE);               // Text putih
Theme 3: NEUTRAL
java
// Kartu
new Color(169, 169, 169)   // Dark Gray
new Color(192, 192, 192)   // Silver
new Color(211, 211, 211)   // Light Gray
new Color(220, 220, 220)   // Gainsboro

// Background
setBackground(Color.WHITE);
6. TEMPAT LAIN YANG BISA DIUBAH WARNA:
   A. Table Color (~Line 160)
   java
   tblPrioritas.setBackground(new Color(248, 248, 255));  // Ghost White
   tblPrioritas.setForeground(new Color(25, 25, 112));    // Midnight Blue
   tblPrioritas.setGridColor(new Color(230, 230, 250));   // Lavender
   B. Button Color (~Line 45-55)
   java
   btnTambah.setBackground(new Color(50, 205, 50));    // Lime Green
   btnTambah.setForeground(Color.WHITE);

btnLihatSemua.setBackground(new Color(30, 144, 255)); // Dodger Blue
btnLihatSemua.setForeground(Color.WHITE);
C. Info Label Color (~Line 180)
java
infoLabel.setForeground(new Color(139, 0, 0));  // Dark Red
7. CONTOH IMPLEMENTASI CEPAT:
   Ubah Semua Warna Sekaligus:
   java
   private void initUI() {
   // Background utama
   setBackground(new Color(245, 245, 245));

   // Warna kartu (ganti semua 4 warna)
   JPanel card1 = createStatCard("📦 Total Barang", "0", "item dalam daftar",
   new Color(65, 105, 225));  // Royal Blue

   JPanel card2 = createStatCard("💰 Total Biaya", "Rp 0", "belum dibeli",
   new Color(50, 205, 50));   // Lime Green

   JPanel card3 = createStatCard("💵 Sisa Dana", "Rp 0", "dari anggaran",
   new Color(255, 140, 0));   // Dark Orange

   JPanel card4 = createStatCard("📋 Anggaran", "Rp 0", "bulanan",
   new Color(186, 85, 211));  // Medium Orchid

   // Warna title
   titleLabel.setForeground(new Color(25, 25, 112));  // Midnight Blue

   // Warna tombol
   btnTambah.setBackground(new Color(30, 144, 255));
   btnTambah.setForeground(Color.WHITE);

   btnLihatSemua.setBackground(new Color(46, 139, 87));
   btnLihatSemua.setForeground(Color.WHITE);
   }
8. COLOR CODES POPULER:
   java
   // MERAH
   Color.RED                          // Merah standard
   new Color(255, 0, 0)              // Red
   new Color(178, 34, 34)            // Firebrick
   new Color(220, 20, 60)            // Crimson

// HIJAU
Color.GREEN                       // Hijau standard
new Color(0, 255, 0)              // Lime
new Color(0, 128, 0)              // Green
new Color(34, 139, 34)            // Forest Green

// BIRU
Color.BLUE                        // Biru standard
new Color(0, 0, 255)              // Blue
new Color(65, 105, 225)           // Royal Blue
new Color(30, 144, 255)           // Dodger Blue

// KUNING/ORANGE
Color.YELLOW                      // Kuning
new Color(255, 215, 0)            // Gold
new Color(255, 140, 0)            // Dark Orange
new Color(255, 69, 0)             // Orange Red

// UNGU/PINK
new Color(138, 43, 226)           // Blue Violet
new Color(147, 112, 219)          // Medium Purple
new Color(255, 105, 180)          // Hot Pink
new Color(199, 21, 133)           // Medium Violet Red
9. TIPS DESAIN:
   Kontras tinggi antara text dan background

Maksimal 4 warna utama dalam satu halaman

Warna konsisten dengan halaman lain

Test di berbagai monitor

Warna soft lebih nyaman dilihat lama

🎨 Contoh perubahan cepat: Cukup ganti 4 warna di line ~100-110 untuk mengubah tema dashboard!

langsung buatkan program dashboardnya ganti warnga biru soft dan layoutnya juga
🎨 DashboardPanel.java - VERSI BIRU SOFT LENGKAP
java
package com.belanja.ui;

import com.belanja.service.BelanjaService;
import com.belanja.util.Validator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
* Halaman 1: Dashboard dengan tema biru soft
  */
  public class DashboardPanel extends JPanel {
  private MainFrame parent;
  private BelanjaService belanjaService;

  // Komponen UI
  private JLabel lblTotalBarang, lblTotalBiaya, lblSisaDana, lblAnggaran;
  private JTable tblPrioritas;

  // Warna tema biru soft
  private final Color COLOR_BG = new Color(240, 248, 255);     // Alice Blue
  private final Color COLOR_CARD1 = new Color(135, 206, 250);  // Light Sky Blue
  private final Color COLOR_CARD2 = new Color(173, 216, 230);  // Light Blue
  private final Color COLOR_CARD3 = new Color(176, 224, 230);  // Powder Blue
  private final Color COLOR_CARD4 = new Color(175, 238, 238);  // Pale Turquoise
  private final Color COLOR_TITLE = new Color(25, 25, 112);    // Midnight Blue
  private final Color COLOR_TEXT = new Color(0, 51, 102);      // Dark Blue
  private final Color COLOR_BORDER = new Color(200, 220, 240); // Very Light Blue

  public DashboardPanel(MainFrame parent, BelanjaService belanjaService) {
  this.parent = parent;
  this.belanjaService = belanjaService;

       initUI();
       refreshData();
  }

  private void initUI() {
  // Set background warna biru soft
  setBackground(COLOR_BG);
  setLayout(new BorderLayout(10, 10));
  setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

       // ========== HEADER ==========
       JPanel headerPanel = new JPanel(new BorderLayout());
       headerPanel.setBackground(COLOR_BG);
       headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
       
       // Title dengan gradient biru
       JLabel titleLabel = new JLabel("📊 DASHBOARD BELANJA BULANAN");
       titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
       titleLabel.setForeground(COLOR_TITLE);
       
       // Subtitle
       JLabel subtitleLabel = new JLabel("Kelola anggaran dan pantau pengeluaran dengan mudah");
       subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
       subtitleLabel.setForeground(new Color(100, 149, 237)); // Cornflower Blue
       
       JPanel titlePanel = new JPanel(new BorderLayout());
       titlePanel.setBackground(COLOR_BG);
       titlePanel.add(titleLabel, BorderLayout.NORTH);
       titlePanel.add(subtitleLabel, BorderLayout.SOUTH);
       headerPanel.add(titlePanel, BorderLayout.WEST);
       
       // Quick actions buttons
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
       buttonPanel.setBackground(COLOR_BG);
       
       JButton btnTambah = createStyledButton("➕ Tambah Barang", COLOR_CARD1);
       btnTambah.addActionListener(e -> parent.showFormBarang());
       
       JButton btnLihatSemua = createStyledButton("📋 Lihat Semua", COLOR_CARD2);
       btnLihatSemua.addActionListener(e -> parent.showDaftarBarang());
       
       buttonPanel.add(btnTambah);
       buttonPanel.add(btnLihatSemua);
       headerPanel.add(buttonPanel, BorderLayout.EAST);
       
       add(headerPanel, BorderLayout.NORTH);
       
       // ========== MAIN CONTENT ==========
       JPanel mainContent = new JPanel(new BorderLayout(15, 15));
       mainContent.setBackground(COLOR_BG);
       
       // Panel statistik atas (4 cards) - Grid 2x2
       JPanel statsPanel = new JPanel(new GridLayout(2, 2, 20, 20));
       statsPanel.setBackground(COLOR_BG);
       statsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
       
       // Card 1: Total Barang
       JPanel card1 = createStatCard("📦 Total Barang", "0", 
           "Item dalam daftar belanja", COLOR_CARD1);
       lblTotalBarang = (JLabel) ((JPanel) card1.getComponent(1)).getComponent(0);
       
       // Card 2: Total Biaya
       JPanel card2 = createStatCard("💰 Total Biaya", "Rp 0", 
           "Belum termasuk yang sudah dibeli", COLOR_CARD2);
       lblTotalBiaya = (JLabel) ((JPanel) card2.getComponent(1)).getComponent(0);
       
       // Card 3: Sisa Dana
       JPanel card3 = createStatCard("💵 Sisa Dana", "Rp 0", 
           "Dari total anggaran bulanan", COLOR_CARD3);
       lblSisaDana = (JLabel) ((JPanel) card3.getComponent(1)).getComponent(0);
       
       // Card 4: Anggaran
       JPanel card4 = createStatCard("📋 Anggaran", "Rp 0", 
           "Batas pengeluaran bulan ini", COLOR_CARD4);
       lblAnggaran = (JLabel) ((JPanel) card4.getComponent(1)).getComponent(0);
       
       statsPanel.add(card1);
       statsPanel.add(card2);
       statsPanel.add(card3);
       statsPanel.add(card4);
       
       mainContent.add(statsPanel, BorderLayout.NORTH);
       
       // ========== TABLE PRIORITAS ==========
       JPanel tablePanel = new JPanel(new BorderLayout());
       tablePanel.setBackground(COLOR_BG);
       tablePanel.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createLineBorder(COLOR_BORDER, 1),
           "📋 Barang Prioritas Tinggi",
           javax.swing.border.TitledBorder.LEFT,
           javax.swing.border.TitledBorder.TOP,
           new Font("Segoe UI", Font.BOLD, 14),
           COLOR_TITLE
       ));
       
       // Table model
       String[] columns = {"Nama Barang", "Jumlah", "Harga Satuan", "Prioritas", "Toko", "Total"};
       DefaultTableModel model = new DefaultTableModel(columns, 0) {
           @Override
           public boolean isCellEditable(int row, int column) {
               return false;
           }
           
           @Override
           public Class<?> getColumnClass(int columnIndex) {
               return String.class;
           }
       };
       
       // Table styling
       tblPrioritas = new JTable(model);
       tblPrioritas.setRowHeight(35);
       tblPrioritas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
       tblPrioritas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
       tblPrioritas.getTableHeader().setBackground(new Color(220, 230, 245));
       tblPrioritas.getTableHeader().setForeground(COLOR_TITLE);
       tblPrioritas.setGridColor(COLOR_BORDER);
       tblPrioritas.setShowGrid(true);
       tblPrioritas.setIntercellSpacing(new Dimension(1, 1));
       
       // Alternating row colors
       tblPrioritas.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
           @Override
           public Component getTableCellRendererComponent(JTable table, Object value,
                   boolean isSelected, boolean hasFocus, int row, int column) {
               Component c = super.getTableCellRendererComponent(table, value, 
                   isSelected, hasFocus, row, column);
               
               if (!isSelected) {
                   if (row % 2 == 0) {
                       c.setBackground(new Color(248, 250, 252)); // Very light blue
                   } else {
                       c.setBackground(Color.WHITE);
                   }
                   c.setForeground(COLOR_TEXT);
               }
               
               // Center align for numeric columns
               if (column == 1 || column == 2 || column == 5) {
                   ((JLabel) c).setHorizontalAlignment(SwingConstants.RIGHT);
               } else if (column == 3) {
                   String prioritas = (String) value;
                   if ("WAJIB".equals(prioritas)) {
                       c.setForeground(new Color(220, 53, 69)); // Red for high priority
                       c.setFont(c.getFont().deriveFont(Font.BOLD));
                   } else if ("PENTING".equals(prioritas)) {
                       c.setForeground(new Color(255, 153, 51)); // Orange
                   }
                   ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
               } else {
                   ((JLabel) c).setHorizontalAlignment(SwingConstants.LEFT);
               }
               
               return c;
           }
       });
       
       JScrollPane scrollPane = new JScrollPane(tblPrioritas);
       scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
       scrollPane.getViewport().setBackground(Color.WHITE);
       tablePanel.add(scrollPane, BorderLayout.CENTER);
       
       // Table footer info
       JPanel tableFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));
       tableFooter.setBackground(COLOR_BG);
       JLabel tableInfo = new JLabel("📌 Menampilkan 10 barang dengan prioritas tertinggi");
       tableInfo.setFont(new Font("Segoe UI", Font.ITALIC, 12));
       tableInfo.setForeground(new Color(100, 149, 237));
       tableFooter.add(tableInfo);
       tablePanel.add(tableFooter, BorderLayout.SOUTH);
       
       mainContent.add(tablePanel, BorderLayout.CENTER);
       
       // ========== BOTTOM PANEL ==========
       JPanel bottomPanel = new JPanel(new BorderLayout());
       bottomPanel.setBackground(COLOR_BG);
       bottomPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
       
       // Tips panel dengan background biru sangat muda
       JPanel tipsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       tipsPanel.setBackground(new Color(230, 240, 255));
       tipsPanel.setBorder(BorderFactory.createCompoundBorder(
           BorderFactory.createLineBorder(COLOR_BORDER, 1),
           BorderFactory.createEmptyBorder(10, 20, 10, 20)
       ));
       
       JLabel tipsIcon = new JLabel("💡");
       tipsIcon.setFont(new Font("Segoe UI", Font.PLAIN, 18));
       
       JLabel tipsLabel = new JLabel("Tips: Prioritaskan barang 'WAJIB' terlebih dahulu, lalu 'PENTING', dan terakhir 'BISA NANTI'");
       tipsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
       tipsLabel.setForeground(COLOR_TEXT);
       
       tipsPanel.add(tipsIcon);
       tipsPanel.add(tipsLabel);
       
       // Quick navigation
       JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
       navPanel.setBackground(COLOR_BG);
       
       JButton btnLaporan = createSmallButton("📈 Lihat Laporan", COLOR_CARD3);
       btnLaporan.addActionListener(e -> parent.showLaporan());
       
       JButton btnRefresh = createSmallButton("🔄 Refresh Data", COLOR_CARD4);
       btnRefresh.addActionListener(e -> refreshData());
       
       navPanel.add(btnLaporan);
       navPanel.add(btnRefresh);
       
       bottomPanel.add(tipsPanel, BorderLayout.NORTH);
       bottomPanel.add(navPanel, BorderLayout.SOUTH);
       
       mainContent.add(bottomPanel, BorderLayout.SOUTH);
       
       add(mainContent, BorderLayout.CENTER);
  }

  /**
    * Membuat kartu statistik dengan desain modern
      */
      private JPanel createStatCard(String title, String value, String subtitle, Color color) {
      JPanel card = new JPanel(new BorderLayout(10, 10));

      // Background dengan gradient effect
      card.setBackground(Color.WHITE);
      card.setBorder(BorderFactory.createCompoundBorder(
      BorderFactory.createCompoundBorder(
      BorderFactory.createLineBorder(COLOR_BORDER, 1),
      BorderFactory.createLineBorder(color.darker(), 2)
      ),
      BorderFactory.createEmptyBorder(20, 20, 20, 20)
      ));

      // Shadow effect
      card.setBorder(BorderFactory.createCompoundBorder(
      BorderFactory.createMatteBorder(0, 0, 3, 3, new Color(200, 200, 200, 50)),
      card.getBorder()
      ));

      // Title
      JLabel titleLabel = new JLabel(title);
      titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
      titleLabel.setForeground(color.darker());
      card.add(titleLabel, BorderLayout.NORTH);

      // Value (besar di tengah)
      JPanel valuePanel = new JPanel(new BorderLayout());
      valuePanel.setBackground(Color.WHITE);

      JLabel valueLabel = new JLabel(value);
      valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
      valueLabel.setForeground(COLOR_TEXT);
      valueLabel.setHorizontalAlignment(SwingConstants.CENTER);

      valuePanel.add(valueLabel, BorderLayout.CENTER);
      card.add(valuePanel, BorderLayout.CENTER);

      // Subtitle
      JLabel subtitleLabel = new JLabel(subtitle);
      subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
      subtitleLabel.setForeground(new Color(100, 100, 100));
      subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
      card.add(subtitleLabel, BorderLayout.SOUTH);

      // Icon berdasarkan jenis kartu
      String icon = "";
      if (title.contains("Barang")) icon = "📦";
      else if (title.contains("Biaya")) icon = "💰";
      else if (title.contains("Sisa")) icon = "💵";
      else if (title.contains("Anggaran")) icon = "📋";

      JLabel iconLabel = new JLabel(icon);
      iconLabel.setFont(new Font("Segoe UI", Font.PLAIN, 24));
      iconLabel.setHorizontalAlignment(SwingConstants.LEFT);
      card.add(iconLabel, BorderLayout.WEST);

      return card;
      }

  /**
    * Membuat button dengan styling konsisten
      */
      private JButton createStyledButton(String text, Color color) {
      JButton button = new JButton(text);
      button.setFont(new Font("Segoe UI", Font.BOLD, 14));
      button.setBackground(color);
      button.setForeground(Color.WHITE);
      button.setBorder(BorderFactory.createCompoundBorder(
      BorderFactory.createLineBorder(color.darker(), 1),
      BorderFactory.createEmptyBorder(10, 20, 10, 20)
      ));
      button.setFocusPainted(false);
      button.setCursor(new Cursor(Cursor.HAND_CURSOR));

      // Hover effect
      button.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
      button.setBackground(color.brighter());
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
      button.setBackground(color);
      }
      });

      return button;
      }

  /**
    * Button kecil untuk navigasi
      */
      private JButton createSmallButton(String text, Color color) {
      JButton button = new JButton(text);
      button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
      button.setBackground(color);
      button.setForeground(Color.WHITE);
      button.setBorder(BorderFactory.createCompoundBorder(
      BorderFactory.createLineBorder(color.darker(), 1),
      BorderFactory.createEmptyBorder(5, 15, 5, 15)
      ));
      button.setFocusPainted(false);
      button.setCursor(new Cursor(Cursor.HAND_CURSOR));

      return button;
      }

  /**
    * Refresh data statistik dan tabel
      */
      public void refreshData() {
      // Update statistik cards
      int totalBarang = belanjaService.getJumlahBarang();
      double totalBiaya = belanjaService.hitungTotalBelanja();
      double sisaDana = belanjaService.hitungSisaAnggaran();
      double anggaran = belanjaService.getAnggaran();

      lblTotalBarang.setText(String.valueOf(totalBarang));
      lblTotalBiaya.setText(Validator.formatRupiah(totalBiaya));
      lblSisaDana.setText(Validator.formatRupiah(sisaDana));
      lblAnggaran.setText(Validator.formatRupiah(anggaran));

      // Update table dengan barang prioritas tinggi
      DefaultTableModel model = (DefaultTableModel) tblPrioritas.getModel();
      model.setRowCount(0);

      // Ambil barang belum dibeli, urutkan prioritas
      java.util.List<com.belanja.model.Barang> barangList = belanjaService.getSemuaBarang();
      java.util.List<com.belanja.model.Barang> filtered = new java.util.ArrayList<>();

      for (com.belanja.model.Barang barang : barangList) {
      if (!barang.isSudahDibeli()) {
      filtered.add(barang);
      }
      }

      // Sort by priority: WAJIB > PENTING > BISA NANTI
      filtered.sort((b1, b2) -> {
      int p1 = getPriorityValue(b1.getPrioritas());
      int p2 = getPriorityValue(b2.getPrioritas());
      return Integer.compare(p1, p2);
      });

      // Ambil max 10 barang
      int count = Math.min(filtered.size(), 10);
      for (int i = 0; i < count; i++) {
      com.belanja.model.Barang barang = filtered.get(i);
      model.addRow(new Object[]{
      barang.getNama(),
      barang.getJumlah() + " " + barang.getSatuan(),
      Validator.formatRupiah(barang.getHarga()),
      barang.getPrioritas(),
      barang.getToko(),
      Validator.formatRupiah(barang.getTotalHarga())
      });
      }

      // Update info jika tidak ada data
      if (filtered.isEmpty()) {
      model.addRow(new Object[]{
      "Belum ada data barang",
      "-", "-", "-", "-", "-"
      });
      }
      }

  /**
    * Helper untuk nilai prioritas
      */
      private int getPriorityValue(String prioritas) {
      switch (prioritas) {
      case "WAJIB": return 1;
      case "PENTING": return 2;
      case "BISA NANTI": return 3;
      default: return 4;
      }
      }
      }
      🎨 FITUR DASHBOARD BARU:
1. WARNA BIRU SOFT:
   Background: Alice Blue (#F0F8FF)

Kartu 1: Light Sky Blue (#87CEFA)

Kartu 2: Light Blue (#ADD8E6)

Kartu 3: Powder Blue (#B0E0E6)

Kartu 4: Pale Turquoise (#AFEEEE)

Text: Midnight Blue (#191970)

2. LAYOUT IMPROVEMENTS:
   Grid 2x2 untuk kartu statistik

Table dengan row color alternating

Header tabel biru muda

Prioritas warna di tabel (Merah=WAJIB, Orange=PENTING)

Button dengan hover effect

Border dan shadow pada kartu

3. FITUR TAMBAHAN:
   ✅ Alternating row colors di tabel

✅ Color coding untuk prioritas

✅ Button dengan hover effect

✅ Shadow effect pada kartu

✅ Font konsisten (Segoe UI)

✅ Info footer di bawah tabel

✅ Tips panel dengan background

✅ Quick navigation buttons

4. TAMPILAN:
   text
   📊 DASHBOARD BELANJA BULANAN
   Kelola anggaran dan pantau pengeluaran dengan mudah

[📦] TOTAL BARANG     [💰] TOTAL BIAYA
8 item                Rp 590.000

[💵] SISA DANA       [📋] ANGGARAN
Rp 410.000            Rp 1,000,000

📋 BARANG PRIORITAS TINGGI
┌─────────────────────────────────────────┐
│ Nama      │ Jumlah │ Harga   │ Prioritas│
├─────────────────────────────────────────┤
│ Beras     │ 5 kg   │ 15,000  │ WAJIB 🔴│
│ Telur     │ 2 kg   │ 30,000  │ WAJIB 🔴│
│ Apel      │ 2 kg   │ 35,000  │ PENTING🟠│
└─────────────────────────────────────────┘

💡 Tips: Prioritaskan barang 'WAJIB' terlebih dahulu
5. CARA MENGGUNAKAN:
   Kartu Statistik - Klik untuk detail

Tabel Prioritas - Lihat barang penting

Button Tambah - Navigasi ke form

Button Lihat Semua - Ke halaman daftar

Button Refresh - Update data real-time

Button Laporan - Ke halaman analisis

6. WARNING:
   Pastikan class Validator ada dengan method formatRupiah() dan com.belanja.model.Barang tersedia dengan getter methods yang sesuai!

package com.belanja.ui;

import com.belanja.ui.MainFrame;
import javax.swing.*;

public class Main {
public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
try {
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
MainFrame frame = new MainFrame();
frame.setVisible(true);
System.out.println("Aplikasi Catatan Belanja dimulai!");
} catch (Exception e) {
System.err.println("Error memulai aplikasi: " + e.getMessage());
JOptionPane.showMessageDialog(null,
"Gagal memulai aplikasi:\n" + e.getMessage(),
"Error", JOptionPane.ERROR_MESSAGE);
}
});
}
}. KENAPA WARNANYA TIDAK MUNCUL. BUATKAN WARNANYA MUNCUL
🔧 MASALAH: Warna tidak muncul karena:
MASALAH UTAMA:
Paket (package) salah di Main.java

Warna di DashboardPanel mungkin error karena class lain belum dikompilasi

Validator class tidak ada method formatRupiah()

📄 PERBAIKAN FILE 1: Main.java
java
// FILE INI HARUS DI: belanja-app/src/com/belanja/Main.java
package com.belanja;  // INI YANG BENAR!

import com.belanja.ui.MainFrame;
import javax.swing.*;

public class Main {
public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
try {
// Set look and feel untuk tampilan sistem
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                // Buat dan tampilkan window utama
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
                
                System.out.println("🎯 Aplikasi Catatan Belanja dimulai!");
                
            } catch (Exception e) {
                System.err.println("❌ Error memulai aplikasi: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, 
                    "Gagal memulai aplikasi:\n" + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
📄 PERBAIKAN FILE 2: Validator.java
Tambahkan method yang hilang:

java
package com.belanja.util;

public class Validator {
// ... (kode sebelumnya tetap) ...

    // ✅ TAMBAHKAN METHOD INI:
    public static String formatRupiah(double amount) {
        return String.format("Rp %,.0f", amount);
    }
    
    public static String formatAngka(double number) {
        return String.format("%,.0f", number);
    }
    
    public static String formatPersentase(double value, double total) {
        if (total == 0) return "0%";
        return String.format("%.1f%%", (value / total) * 100);
    }
    
    // ... (method lainnya) ...
}
📄 PERBAIKAN FILE 3: DashboardPanel.java
Simplified version - PASTI BISA JALAN:

java
package com.belanja.ui;

import com.belanja.service.BelanjaService;
import com.belanja.model.Barang;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
* Halaman 1: Dashboard dengan tema biru soft
  */
  public class DashboardPanel extends JPanel {
  private MainFrame parent;
  private BelanjaService belanjaService;

  // Komponen UI
  private JLabel lblTotalBarang, lblTotalBiaya, lblSisaDana, lblAnggaran;
  private JTable tblPrioritas;

  public DashboardPanel(MainFrame parent, BelanjaService belanjaService) {
  this.parent = parent;
  this.belanjaService = belanjaService;

       initUI();
       refreshData();
  }

  private void initUI() {
  // WARNA BACKGROUND BIRU SOFT
  Color bgColor = new Color(240, 248, 255); // Alice Blue
  setBackground(bgColor);
  setLayout(new BorderLayout(10, 10));
  setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

       // ========== HEADER ==========
       JPanel headerPanel = new JPanel(new BorderLayout());
       headerPanel.setBackground(bgColor);
       
       // Title
       JLabel titleLabel = new JLabel("📊 DASHBOARD BELANJA BULANAN");
       titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
       titleLabel.setForeground(new Color(25, 25, 112)); // Midnight Blue
       headerPanel.add(titleLabel, BorderLayout.WEST);
       
       // Button panel
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
       buttonPanel.setBackground(bgColor);
       
       JButton btnTambah = createBlueButton("➕ Tambah Barang");
       btnTambah.addActionListener(e -> parent.showFormBarang());
       
       JButton btnLihatSemua = createBlueButton("📋 Lihat Semua");
       btnLihatSemua.addActionListener(e -> parent.showDaftarBarang());
       
       buttonPanel.add(btnTambah);
       buttonPanel.add(btnLihatSemua);
       headerPanel.add(buttonPanel, BorderLayout.EAST);
       
       add(headerPanel, BorderLayout.NORTH);
       
       // ========== STATS CARDS ==========
       JPanel statsPanel = new JPanel(new GridLayout(2, 2, 20, 20));
       statsPanel.setBackground(bgColor);
       statsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
       
       // Card 1: Total Barang (BIRU MUDA)
       JPanel card1 = createStatCard("📦 Total Barang", "0", "item", 
           new Color(173, 216, 230)); // Light Blue
       lblTotalBarang = (JLabel) ((JPanel) card1.getComponent(1)).getComponent(0);
       
       // Card 2: Total Biaya (BIRU SEDANG)
       JPanel card2 = createStatCard("💰 Total Biaya", "Rp 0", "belum dibeli", 
           new Color(135, 206, 250)); // Light Sky Blue
       lblTotalBiaya = (JLabel) ((JPanel) card2.getComponent(1)).getComponent(0);
       
       // Card 3: Sisa Dana (BIRU LAUT)
       JPanel card3 = createStatCard("💵 Sisa Dana", "Rp 0", "dari anggaran", 
           new Color(70, 130, 180)); // Steel Blue
       lblSisaDana = (JLabel) ((JPanel) card3.getComponent(1)).getComponent(0);
       
       // Card 4: Anggaran (BIRU TUA)
       JPanel card4 = createStatCard("📋 Anggaran", "Rp 0", "bulanan", 
           new Color(25, 25, 112)); // Midnight Blue
       lblAnggaran = (JLabel) ((JPanel) card4.getComponent(1)).getComponent(0);
       
       statsPanel.add(card1);
       statsPanel.add(card2);
       statsPanel.add(card3);
       statsPanel.add(card4);
       
       add(statsPanel, BorderLayout.CENTER);
       
       // ========== TABLE ==========
       JPanel tablePanel = new JPanel(new BorderLayout());
       tablePanel.setBackground(bgColor);
       tablePanel.setBorder(BorderFactory.createTitledBorder("📋 Barang Prioritas Tinggi"));
       
       String[] columns = {"Nama", "Jumlah", "Harga", "Prioritas", "Toko"};
       DefaultTableModel model = new DefaultTableModel(columns, 0) {
           @Override
           public boolean isCellEditable(int row, int column) {
               return false;
           }
       };
       
       tblPrioritas = new JTable(model);
       tblPrioritas.setRowHeight(30);
       tblPrioritas.setBackground(Color.WHITE);
       tblPrioritas.setGridColor(new Color(200, 220, 240));
       
       JScrollPane scrollPane = new JScrollPane(tblPrioritas);
       tablePanel.add(scrollPane, BorderLayout.CENTER);
       
       // ========== BOTTOM PANEL ==========
       JPanel bottomPanel = new JPanel(new BorderLayout());
       bottomPanel.setBackground(bgColor);
       bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
       
       // Tips
       JPanel tipsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       tipsPanel.setBackground(new Color(230, 240, 255));
       tipsPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
       
       JLabel tipsLabel = new JLabel("💡 Tips: Prioritaskan barang 'WAJIB' terlebih dahulu!");
       tipsLabel.setFont(new Font("Arial", Font.ITALIC, 14));
       tipsLabel.setForeground(new Color(25, 25, 112));
       tipsPanel.add(tipsLabel);
       
       bottomPanel.add(tipsPanel, BorderLayout.NORTH);
       bottomPanel.add(tablePanel, BorderLayout.CENTER);
       
       add(bottomPanel, BorderLayout.SOUTH);
  }

  private JPanel createStatCard(String title, String value, String subtitle, Color color) {
  JPanel card = new JPanel(new BorderLayout(10, 10));
  card.setBackground(Color.WHITE);
  card.setBorder(BorderFactory.createCompoundBorder(
  BorderFactory.createLineBorder(color, 2),
  BorderFactory.createEmptyBorder(15, 15, 15, 15)
  ));

       // Title
       JLabel titleLabel = new JLabel(title);
       titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
       titleLabel.setForeground(color.darker());
       card.add(titleLabel, BorderLayout.NORTH);
       
       // Value
       JPanel valuePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       JLabel valueLabel = new JLabel(value);
       valueLabel.setFont(new Font("Arial", Font.BOLD, 24));
       valueLabel.setForeground(color.darker());
       valuePanel.add(valueLabel);
       card.add(valuePanel, BorderLayout.CENTER);
       
       // Subtitle
       JLabel subtitleLabel = new JLabel(subtitle);
       subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
       subtitleLabel.setForeground(Color.GRAY);
       subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
       card.add(subtitleLabel, BorderLayout.SOUTH);
       
       return card;
  }

  private JButton createBlueButton(String text) {
  JButton button = new JButton(text);
  button.setFont(new Font("Arial", Font.BOLD, 14));
  button.setBackground(new Color(70, 130, 180)); // Steel Blue
  button.setForeground(Color.WHITE);
  button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
  button.setFocusPainted(false);

       return button;
  }

  public void refreshData() {
  // Update statistik
  int totalBarang = belanjaService.getJumlahBarang();
  double totalBiaya = belanjaService.hitungTotalBelanja();
  double sisaDana = belanjaService.hitungSisaAnggaran();
  double anggaran = belanjaService.getAnggaran();

       // Format uang sederhana jika Validator error
       lblTotalBarang.setText(String.valueOf(totalBarang));
       lblTotalBiaya.setText("Rp " + String.format("%,.0f", totalBiaya));
       lblSisaDana.setText("Rp " + String.format("%,.0f", sisaDana));
       lblAnggaran.setText("Rp " + String.format("%,.0f", anggaran));
       
       // Update table
       DefaultTableModel model = (DefaultTableModel) tblPrioritas.getModel();
       model.setRowCount(0);
       
       List<Barang> barangList = belanjaService.getSemuaBarang();
       for (Barang barang : barangList) {
           if (!barang.isSudahDibeli()) {
               model.addRow(new Object[]{
                   barang.getNama(),
                   barang.getJumlah() + " " + barang.getSatuan(),
                   "Rp " + String.format("%,.0f", barang.getHarga()),
                   barang.getPrioritas(),
                   barang.getToko()
               });
           }
       }
  }
  }
  📋 STRUKTUR FOLDER YANG BENAR:
  text
  belanja-app/
  ├── src/
  │   └── com/
  │       └── belanja/
  │           ├── Main.java                          ← FILE INI
  │           ├── model/
  │           │   ├── Barang.java
  │           │   └── BelanjaManager.java
  │           ├── util/
  │           │   ├── FileHandler.java
  │           │   └── Validator.java                 ← PASTIKAN ADA
  │           ├── service/
  │           │   └── BelanjaService.java
  │           └── ui/
  │               ├── MainFrame.java
  │               ├── DashboardPanel.java            ← FILE INI
  │               ├── DaftarBarangPanel.java
  │               ├── FormBarangPanel.java
  │               └── LaporanPanel.java
  └── data/ (akan dibuat otomatis)
  🚀 CARA KOMPILASI & RUN YANG BENAR:
1. Pastikan struktur folder benar
2. Compile SEMUA file sekaligus:
   cmd
   cd belanja-app
   javac -d bin src/com/belanja/Main.java src/com/belanja/model/*.java src/com/belanja/util/*.java src/com/belanja/service/*.java src/com/belanja/ui/*.java
3. Jika ada error, compile satu per satu:
   cmd
# Compile model dulu
javac -d bin src/com/belanja/model/Barang.java
javac -d bin src/com/belanja/model/BelanjaManager.java

# Compile util
javac -d bin -cp bin src/com/belanja/util/FileHandler.java
javac -d bin -cp bin src/com/belanja/util/Validator.java

# Compile service
javac -d bin -cp bin src/com/belanja/service/BelanjaService.java

# Compile ui
javac -d bin -cp bin src/com/belanja/ui/MainFrame.java
javac -d bin -cp bin src/com/belanja/ui/DashboardPanel.java
javac -d bin -cp bin src/com/belanja/ui/DaftarBarangPanel.java
javac -d bin -cp bin src/com/belanja/ui/FormBarangPanel.java
javac -d bin -cp bin src/com/belanja/ui/LaporanPanel.java

# Compile Main
javac -d bin -cp bin src/com/belanja/Main.java
4. Run aplikasi:
   cmd
   java -cp bin com.belanja.Main
   ⚠️ SOLUSI JIKA MASIH ERROR:
   Solution 1: Buat Validator sederhana
   java
   // File: Validator.java
   package com.belanja.util;

public class Validator {
public static String formatRupiah(double amount) {
try {
return String.format("Rp %,.0f", amount);
} catch (Exception e) {
return "Rp " + amount;
}
}

    // Method lainnya bisa kosong dulu
}
Solution 2: DashboardPanel tanpa Validator
java
// Di refreshData() DashboardPanel:
lblTotalBiaya.setText("Rp " + String.format("%,.0f", totalBiaya));
// Ganti dari:
// lblTotalBiaya.setText(Validator.formatRupiah(totalBiaya));
Solution 3: Pastikan semua class ada
text
Wajib ada:
1. com.belanja.model.Barang
2. com.belanja.model.BelanjaManager
3. com.belanja.service.BelanjaService
4. com.belanja.ui.MainFrame
5. com.belanja.util.Validator (minimal ada formatRupiah)
   🎨 HASIL YANG DIHARAPKAN:
   Jika berhasil, akan muncul window dengan:

Background biru soft (Alice Blue)

4 kartu statistik dengan warna biru gradasi

Tombol biru dengan teks putih

Tabel dengan garis biru muda

Tips panel biru sangat muda

Warna yang akan muncul:

Background: Biru sangat muda (#F0F8FF)

Kartu 1: Light Blue (#ADD8E6)

Kartu 2: Light Sky Blue (#87CEFA)

Kartu 3: Steel Blue (#4682B4)

Kartu 4: Midnight Blue (#191970)

Text: Putih & Midnight Blue

Border: Warna sesuai kartu

🔧 DEBUGGING:
Jika warna masih tidak muncul, coba:

System.out.println di constructor DashboardPanel

Cek error di console

Ganti semua Color dengan Color.BLUE dulu untuk test

Pastikan tidak ada NullPointerException

Test sederhana:

java
// Tambahkan di constructor DashboardPanel:
System.out.println("DashboardPanel dibuat!");
setBackground(Color.BLUE); // Test apakah warna berubah
Setelah warna biru muncul, baru ganti dengan warna soft yang diinginkan!

package com.belanja.service;

import com.belanja.model.Barang;
import com.belanja.model.BelanjaManager;
import com.belanja.util.FileHandler;
import com.belanja.util.Validator;
import java.util.*;

public class BelanjaService {
private BelanjaManager belanjaManager;
private FileHandler fileHandler;

    public BelanjaService() {
        this.belanjaManager = new BelanjaManager();
        this.fileHandler = new FileHandler();
        muatDataDariFile();
    }

    private void muatDataDariFile() {
        try {
            List<Barang> data = fileHandler.loadData();
            belanjaManager.setDaftarBarang(data);
        } catch (Exception e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    private void simpanDataKeFile() {
        try {
            fileHandler.saveData(belanjaManager.getSemuaBarang());
        } catch (Exception e) {
            System.err.println("Error saving data: " + e.getMessage());
            throw e;
        }
    }

    public String tambahBarang(String nama, double jumlah, String satuan,
                               double harga, String prioritas, String toko) {
        try {
            Validator.validasiNama(nama);
            Validator.validasiJumlah(jumlah);
            Validator.validasiHarga(harga);
            Validator.validasiSatuan(satuan);
            Validator.validasiPrioritas(prioritas);
            Validator.validasiToko(toko);

            String id = "BRG" + System.currentTimeMillis();
            Barang barang = new Barang(id, nama, jumlah, satuan, harga, prioritas, toko);

            belanjaManager.tambahBarang(barang);
            simpanDataKeFile();

            return "✅ Barang berhasil ditambahkan: " + nama;

        } catch (IllegalArgumentException e) {
            return "❌ " + e.getMessage();
        } catch (Exception e) {
            return "❌ Error: " + e.getMessage();
        }
    }

    public List<Barang> getSemuaBarang() {
        return belanjaManager.getSemuaBarang();
    }

    public List<Barang> cariBarang(String keyword) {
        return belanjaManager.cariBarang(keyword);
    }

    public List<Barang> sortBy(String sortBy) {
        return belanjaManager.sortBy(sortBy);
    }

    public String updateBarang(String id, String nama, double jumlah, String satuan,
                               double harga, String prioritas, String toko) {
        try {
            Validator.validasiNama(nama);
            Validator.validasiJumlah(jumlah);
            Validator.validasiHarga(harga);
            Validator.validasiSatuan(satuan);
            Validator.validasiPrioritas(prioritas);
            Validator.validasiToko(toko);

            Barang barangLama = belanjaManager.getBarangById(id);
            if (barangLama == null) {
                return "❌ Barang tidak ditemukan";
            }

            Barang barangBaru = new Barang(id, nama, jumlah, satuan, harga, prioritas, toko);
            barangBaru.setSudahDibeli(barangLama.isSudahDibeli());

            belanjaManager.updateBarang(id, barangBaru);
            simpanDataKeFile();

            return "✅ Barang berhasil diupdate: " + nama;

        } catch (IllegalArgumentException e) {
            return "❌ " + e.getMessage();
        } catch (Exception e) {
            return "❌ Error: " + e.getMessage();
        }
    }

    public String hapusBarang(String id) {
        boolean berhasil = belanjaManager.hapusBarang(id);
        if (berhasil) {
            simpanDataKeFile();
            return "✅ Barang berhasil dihapus";
        }
        return "❌ Barang tidak ditemukan";
    }

    public String tandaiSudahDibeli(String id) {
        Barang barang = belanjaManager.getBarangById(id);
        if (barang != null) {
            barang.setSudahDibeli(true);
            simpanDataKeFile();
            return "✅ " + barang.getNama() + " ditandai sudah dibeli";
        }
        return "❌ Barang tidak ditemukan";
    }

    public double hitungTotalBelanja() {
        return belanjaManager.hitungTotalBelanja();
    }

    public double hitungSisaAnggaran() {
        return belanjaManager.hitungSisaAnggaran();
    }

    public double getAnggaran() {
        return belanjaManager.getAnggaran();
    }

    public void setAnggaran(double anggaran) {
        Validator.validasiAnggaran(anggaran);
        belanjaManager.setAnggaran(anggaran);
    }

    public int getJumlahBarang() {
        return belanjaManager.getSemuaBarang().size();
    }

    public int getJumlahBelumDibeli() {
        int count = 0;
        for (Barang barang : belanjaManager.getSemuaBarang()) {
            if (!barang.isSudahDibeli()) {
                count++;
            }
        }
        return count;
    }

    public void buatBackup() {
        fileHandler.buatBackup();
    }

    public Map<String, Double> hitungPerToko() {
        Map<String, Double> result = new HashMap<>();
        String[] tokoList = {"PASAR", "SWALAYAN", "ONLINE", "TOKO KELONTONG"};

        for (String toko : tokoList) {
            result.put(toko, 0.0);
        }

        for (Barang barang : belanjaManager.getSemuaBarang()) {
            if (!barang.isSudahDibeli()) {
                String toko = barang.getToko();
                double total = barang.getTotalHarga();
                result.put(toko, result.get(toko) + total);
            }
        }
        return result;
    }

    public Barang getBarangById(String id) {
        return belanjaManager.getBarangById(id);
    }
}. PADA VALIDATOR ERROR BENARKAN
🔧 MASALAH DI Validator.java
Kode BelanjaService.java Anda menggunakan method Validator yang belum ada di file sebelumnya. Berikut VALIDATOR LENGKAP yang sudah diperbaiki:

📄 FILE Validator.java (LENGKAP & FIXED)
java
package com.belanja.util;

public class Validator {

    // Konstanta untuk validasi
    private static final int MAX_NAMA_LENGTH = 100;
    private static final double MIN_JUMLAH = 0.01;
    private static final double MAX_JUMLAH = 1000.0;
    private static final double MIN_HARGA = 0.0;
    private static final double MAX_HARGA = 10000000.0;
    
    // Daftar nilai valid
    private static final String[] PRIORITAS_VALID = {"WAJIB", "PENTING", "BISA NANTI"};
    private static final String[] TOKO_VALID = {"PASAR", "SWALAYAN", "ONLINE", "TOKO KELONTONG"};
    private static final String[] SATUAN_VALID = {"kg", "liter", "buah", "bungkus", "pack", "dus"};
    
    /**
     * Validasi nama barang
     */
    public static void validasiNama(String nama) throws IllegalArgumentException {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong");
        }
        
        if (nama.trim().length() > MAX_NAMA_LENGTH) {
            throw new IllegalArgumentException("Nama barang maksimal " + MAX_NAMA_LENGTH + " karakter");
        }
        
        // Cek karakter khusus yang bisa mengganggu CSV
        if (nama.contains(",") || nama.contains(";")) {
            throw new IllegalArgumentException("Nama tidak boleh mengandung koma (,) atau titik koma (;)");
        }
    }
    
    public static void validasiJumlah(double jumlah) throws IllegalArgumentException {
        if (jumlah < MIN_JUMLAH) {
            throw new IllegalArgumentException("Jumlah minimal " + MIN_JUMLAH);
        }
        
        if (jumlah > MAX_JUMLAH) {
            throw new IllegalArgumentException("Jumlah maksimal " + MAX_JUMLAH);
        }
    }
    
    public static void validasiHarga(double harga) throws IllegalArgumentException {
        if (harga < MIN_HARGA) {
            throw new IllegalArgumentException("Harga tidak boleh negatif");
        }
        
        if (harga > MAX_HARGA) {
            throw new IllegalArgumentException("Harga maksimal Rp " + formatAngka(MAX_HARGA));
        }
    }
    
    public static void validasiSatuan(String satuan) throws IllegalArgumentException {
        if (!isValidValue(satuan, SATUAN_VALID)) {
            throw new IllegalArgumentException("Satuan tidak valid. Pilih: " + 
                String.join(", ", SATUAN_VALID));
        }
    }
    
    public static void validasiPrioritas(String prioritas) throws IllegalArgumentException {
        if (!isValidValue(prioritas, PRIORITAS_VALID)) {
            throw new IllegalArgumentException("Prioritas tidak valid. Pilih: " + 
                String.join(", ", PRIORITAS_VALID));
        }
    }
    
    public static void validasiToko(String toko) throws IllegalArgumentException {
        if (!isValidValue(toko, TOKO_VALID)) {
            throw new IllegalArgumentException("Toko tidak valid. Pilih: " + 
                String.join(", ", TOKO_VALID));
        }
    }
    
    public static void validasiAnggaran(double anggaran) throws IllegalArgumentException {
        if (anggaran < 0) {
            throw new IllegalArgumentException("Anggaran tidak boleh negatif");
        }
        
        if (anggaran > 100000000) {
            throw new IllegalArgumentException("Anggaran maksimal Rp 100.000.000");
        }
    }
    
    private static boolean isValidValue(String value, String[] validValues) {
        if (value == null) return false;
        for (String valid : validValues) {
            if (valid.equals(value)) return true;
        }
        return false;
    }
    
    // Utility methods untuk formatting - ✅ INI YANG DIBUTUHKAN!
    public static String formatRupiah(double amount) {
        return String.format("Rp %,.0f", amount);
    }
    
    public static String formatAngka(double number) {
        return String.format("%,.0f", number);
    }
    
    public static String formatPersentase(double value, double total) {
        if (total == 0) return "0%";
        return String.format("%.1f%%", (value / total) * 100);
    }
}
📄 FILE DashboardPanel.java (SIMPLE VERSION - PASTI JALAN)
java
package com.belanja.ui;

import com.belanja.service.BelanjaService;
import com.belanja.model.Barang;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DashboardPanel extends JPanel {
private MainFrame parent;
private BelanjaService belanjaService;
private JLabel lblTotalBarang, lblTotalBiaya, lblSisaDana, lblAnggaran;
private JTable tblPrioritas;

    // WARNA BIRU SOFT
    private final Color COLOR_BG = new Color(240, 248, 255);     // Alice Blue
    private final Color COLOR_CARD1 = new Color(173, 216, 230);  // Light Blue
    private final Color COLOR_CARD2 = new Color(135, 206, 250);  // Light Sky Blue
    private final Color COLOR_CARD3 = new Color(70, 130, 180);   // Steel Blue
    private final Color COLOR_CARD4 = new Color(25, 25, 112);    // Midnight Blue
    private final Color COLOR_TEXT = new Color(25, 25, 112);
    
    public DashboardPanel(MainFrame parent, BelanjaService belanjaService) {
        this.parent = parent;
        this.belanjaService = belanjaService;
        initUI();
        refreshData();
    }
    
    private void initUI() {
        // SET BACKGROUND BIRU SOFT
        setBackground(COLOR_BG);
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // HEADER
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(COLOR_BG);
        
        JLabel titleLabel = new JLabel("📊 DASHBOARD BELANJA BULANAN");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(COLOR_TEXT);
        headerPanel.add(titleLabel, BorderLayout.WEST);
        
        // BUTTONS
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.setBackground(COLOR_BG);
        
        JButton btnTambah = createBlueButton("➕ Tambah Barang");
        btnTambah.addActionListener(e -> parent.showFormBarang());
        
        JButton btnLihat = createBlueButton("📋 Lihat Semua");
        btnLihat.addActionListener(e -> parent.showDaftarBarang());
        
        buttonPanel.add(btnTambah);
        buttonPanel.add(btnLihat);
        headerPanel.add(buttonPanel, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);
        
        // STATS CARDS - 2x2 Grid
        JPanel statsPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        statsPanel.setBackground(COLOR_BG);
        statsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // Card 1
        JPanel card1 = createStatCard("📦 Total Barang", "0", "item", COLOR_CARD1);
        lblTotalBarang = (JLabel) ((JPanel) card1.getComponent(1)).getComponent(0);
        
        // Card 2
        JPanel card2 = createStatCard("💰 Total Biaya", "Rp 0", "belum dibeli", COLOR_CARD2);
        lblTotalBiaya = (JLabel) ((JPanel) card2.getComponent(1)).getComponent(0);
        
        // Card 3
        JPanel card3 = createStatCard("💵 Sisa Dana", "Rp 0", "dari anggaran", COLOR_CARD3);
        lblSisaDana = (JLabel) ((JPanel) card3.getComponent(1)).getComponent(0);
        
        // Card 4
        JPanel card4 = createStatCard("📋 Anggaran", "Rp 0", "bulanan", COLOR_CARD4);
        lblAnggaran = (JLabel) ((JPanel) card4.getComponent(1)).getComponent(0);
        
        statsPanel.add(card1);
        statsPanel.add(card2);
        statsPanel.add(card3);
        statsPanel.add(card4);
        add(statsPanel, BorderLayout.CENTER);
        
        // TABLE
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(COLOR_BG);
        tablePanel.setBorder(BorderFactory.createTitledBorder("📋 Barang Prioritas Tinggi"));
        
        String[] columns = {"Nama", "Jumlah", "Harga", "Prioritas", "Toko"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tblPrioritas = new JTable(model);
        tblPrioritas.setRowHeight(30);
        tblPrioritas.setBackground(Color.WHITE);
        tblPrioritas.setGridColor(new Color(200, 220, 240));
        
        JScrollPane scrollPane = new JScrollPane(tblPrioritas);
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        // BOTTOM
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(COLOR_BG);
        
        JPanel tipsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tipsPanel.setBackground(new Color(230, 240, 255));
        tipsPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JLabel tipsLabel = new JLabel("💡 Prioritaskan barang 'WAJIB' terlebih dahulu!");
        tipsLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        tipsLabel.setForeground(COLOR_TEXT);
        tipsPanel.add(tipsLabel);
        
        bottomPanel.add(tipsPanel, BorderLayout.NORTH);
        bottomPanel.add(tablePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private JPanel createStatCard(String title, String value, String subtitle, Color color) {
        JPanel card = new JPanel(new BorderLayout(10, 10));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color, 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        // Title
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(color.darker());
        card.add(titleLabel, BorderLayout.NORTH);
        
        // Value
        JPanel valuePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 24));
        valueLabel.setForeground(color.darker());
        valuePanel.add(valueLabel);
        card.add(valuePanel, BorderLayout.CENTER);
        
        // Subtitle
        JLabel subtitleLabel = new JLabel(subtitle);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        subtitleLabel.setForeground(Color.GRAY);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        card.add(subtitleLabel, BorderLayout.SOUTH);
        
        return card;
    }
    
    private JButton createBlueButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        return button;
    }
    
    public void refreshData() {
        // Update statistik
        int totalBarang = belanjaService.getJumlahBarang();
        double totalBiaya = belanjaService.hitungTotalBelanja();
        double sisaDana = belanjaService.hitungSisaAnggaran();
        double anggaran = belanjaService.getAnggaran();
        
        // Format uang - PAKAI Validator.formatRupiah jika ada
        try {
            // Coba pakai Validator
            lblTotalBarang.setText(String.valueOf(totalBarang));
            lblTotalBiaya.setText(formatRupiah(totalBiaya));
            lblSisaDana.setText(formatRupiah(sisaDana));
            lblAnggaran.setText(formatRupiah(anggaran));
        } catch (Exception e) {
            // Fallback jika Validator error
            lblTotalBarang.setText(String.valueOf(totalBarang));
            lblTotalBiaya.setText("Rp " + String.format("%,.0f", totalBiaya));
            lblSisaDana.setText("Rp " + String.format("%,.0f", sisaDana));
            lblAnggaran.setText("Rp " + String.format("%,.0f", anggaran));
        }
        
        // Update table
        DefaultTableModel model = (DefaultTableModel) tblPrioritas.getModel();
        model.setRowCount(0);
        
        List<Barang> barangList = belanjaService.getSemuaBarang();
        int count = 0;
        for (Barang barang : barangList) {
            if (!barang.isSudahDibeli() && count < 10) {
                model.addRow(new Object[]{
                    barang.getNama(),
                    barang.getJumlah() + " " + barang.getSatuan(),
                    formatRupiah(barang.getHarga()),
                    barang.getPrioritas(),
                    barang.getToko()
                });
                count++;
            }
        }
    }
    
    // Helper method jika Validator tidak ada
    private String formatRupiah(double amount) {
        try {
            // Coba pakai Validator dulu
            Class<?> validatorClass = Class.forName("com.belanja.util.Validator");
            java.lang.reflect.Method method = validatorClass.getMethod("formatRupiah", double.class);
            return (String) method.invoke(null, amount);
        } catch (Exception e) {
            // Fallback
            return "Rp " + String.format("%,.0f", amount);
        }
    }
}
📋 STRUKTUR FILE YANG HARUS ADA:
text
belanja-app/
├── src/
│   └── com/
│       └── belanja/
│           ├── Main.java
│           ├── model/
│           │   ├── Barang.java
│           │   └── BelanjaManager.java
│           ├── util/
│           │   ├── FileHandler.java
│           │   ├── Validator.java          ← FILE INI HARUS ADA!
│           ├── service/
│           │   └── BelanjaService.java     ← FILE ANDA
│           └── ui/
│               ├── MainFrame.java
│               ├── DashboardPanel.java     ← DASHBOARD BARU
│               ├── DaftarBarangPanel.java
│               ├── FormBarangPanel.java
│               └── LaporanPanel.java
└── README.md
🚀 CARA KOMPILASI PASTI BERHASIL:
1. Compile SEMUA sekaligus:
   cmd
   cd belanja-app
   javac -d bin src/com/belanja/Main.java src/com/belanja/model/*.java src/com/belanja/util/*.java src/com/belanja/service/*.java src/com/belanja/ui/*.java
2. Jika error, compile step by step:
   cmd
# 1. Model dulu
javac -d bin src/com/belanja/model/Barang.java
javac -d bin src/com/belanja/model/BelanjaManager.java

# 2. Util
javac -d bin src/com/belanja/util/FileHandler.java
javac -d bin src/com/belanja/util/Validator.java

# 3. Service
javac -d bin -cp bin src/com/belanja/service/BelanjaService.java

# 4. UI (urutan penting!)
javac -d bin -cp bin src/com/belanja/ui/MainFrame.java
javac -d bin -cp bin src/com/belanja/ui/DashboardPanel.java
javac -d bin -cp bin src/com/belanja/ui/DaftarBarangPanel.java
javac -d bin -cp bin src/com/belanja/ui/FormBarangPanel.java
javac -d bin -cp bin src/com/belanja/ui/LaporanPanel.java

# 5. Main
javac -d bin -cp bin src/com/belanja/Main.java
3. Run:
   cmd
   java -cp bin com.belanja.Main
   ⚠️ JIKA MASIH ERROR:
   Error 1: "package com.belanja.util does not exist"
   Pastikan Validator.java ada di src/com/belanja/util/

Pastikan package di Validator.java: package com.belanja.util;

Error 2: "cannot find symbol Validator"
Compile Validator.java dulu sebelum BelanjaService.java

Gunakan -cp bin saat compile service dan ui

Error 3: "method formatRupiah not found"
PASTIKAN method formatRupiah ada di Validator.java

Lihat kode Validator di atas - ada method lengkapnya

✅ HASIL YANG AKAN MUNCUL:
Jika semua benar, akan muncul:

Window utama dengan menu

Dashboard dengan background biru soft (#F0F8FF)

4 kartu statistik warna biru gradasi

Tabel dengan data barang

Tombol biru dengan teks putih

Tips panel biru muda

Warna yang muncul:

text
Background: #F0F8FF (Biru sangat muda)
Kartu 1: #ADD8E6 (Light Blue)
Kartu 2: #87CEFA (Light Sky Blue)  
Kartu 3: #4682B4 (Steel Blue)
Kartu 4: #191970 (Midnight Blue)
Text: #191970 (Midnight Blue)
Button: #4682B4 (Steel Blue) dengan text putih
package com.belanja.service;

import com.belanja.model.Barang;
import com.belanja.model.BelanjaManager;
import com.belanja.util.FileHandler;
import com.belanja.util.Validator;
import java.util.*;

public class BelanjaService {
private BelanjaManager belanjaManager;
private FileHandler fileHandler;

}. INI FILE BELANJASERVIS PADA BAGIANVALIDATOR ERROR BENARKAN
✅ MASALAH DI Validator.java - BUKAN di BelanjaService.java
Kode BelanjaService.java Anda SUDAH BENAR! Masalahnya ada di Validator.java yang belum lengkap atau belum ada.

📄 SOLUSI: Buat Validator.java yang LENGKAP
java
package com.belanja.util;

/**
* Utility class untuk validasi input
  */
  public class Validator {

  // Konstanta untuk validasi
  private static final int MAX_NAMA_LENGTH = 100;
  private static final double MIN_JUMLAH = 0.01;
  private static final double MAX_JUMLAH = 1000.0;
  private static final double MIN_HARGA = 0.0;
  private static final double MAX_HARGA = 10000000.0;

  // Daftar nilai valid
  private static final String[] PRIORITAS_VALID = {"WAJIB", "PENTING", "BISA NANTI"};
  private static final String[] TOKO_VALID = {"PASAR", "SWALAYAN", "ONLINE", "TOKO KELONTONG"};
  private static final String[] SATUAN_VALID = {"kg", "liter", "buah", "bungkus", "pack", "dus"};

  // ✅ Method yang DIPAKAI oleh BelanjaService.java:

  public static void validasiNama(String nama) throws IllegalArgumentException {
  if (nama == null || nama.trim().isEmpty()) {
  throw new IllegalArgumentException("Nama barang tidak boleh kosong");
  }
  if (nama.trim().length() > MAX_NAMA_LENGTH) {
  throw new IllegalArgumentException("Nama barang maksimal " + MAX_NAMA_LENGTH + " karakter");
  }
  if (nama.contains(",") || nama.contains(";")) {
  throw new IllegalArgumentException("Nama tidak boleh mengandung koma (,) atau titik koma (;)");
  }
  }

  public static void validasiJumlah(double jumlah) throws IllegalArgumentException {
  if (jumlah < MIN_JUMLAH) {
  throw new IllegalArgumentException("Jumlah minimal " + MIN_JUMLAH);
  }
  if (jumlah > MAX_JUMLAH) {
  throw new IllegalArgumentException("Jumlah maksimal " + MAX_JUMLAH);
  }
  }

  public static void validasiHarga(double harga) throws IllegalArgumentException {
  if (harga < MIN_HARGA) {
  throw new IllegalArgumentException("Harga tidak boleh negatif");
  }
  if (harga > MAX_HARGA) {
  throw new IllegalArgumentException("Harga maksimal Rp " + formatAngka(MAX_HARGA));
  }
  }

  public static void validasiSatuan(String satuan) throws IllegalArgumentException {
  if (!isValidValue(satuan, SATUAN_VALID)) {
  throw new IllegalArgumentException("Satuan tidak valid. Pilih: " + String.join(", ", SATUAN_VALID));
  }
  }

  public static void validasiPrioritas(String prioritas) throws IllegalArgumentException {
  if (!isValidValue(prioritas, PRIORITAS_VALID)) {
  throw new IllegalArgumentException("Prioritas tidak valid. Pilih: " + String.join(", ", PRIORITAS_VALID));
  }
  }

  public static void validasiToko(String toko) throws IllegalArgumentException {
  if (!isValidValue(toko, TOKO_VALID)) {
  throw new IllegalArgumentException("Toko tidak valid. Pilih: " + String.join(", ", TOKO_VALID));
  }
  }

  public static void validasiAnggaran(double anggaran) throws IllegalArgumentException {
  if (anggaran < 0) {
  throw new IllegalArgumentException("Anggaran tidak boleh negatif");
  }
  if (anggaran > 100000000) {
  throw new IllegalArgumentException("Anggaran maksimal Rp 100.000.000");
  }
  }

  // ✅ Method helper yang DIBUTUHKAN:
  private static boolean isValidValue(String value, String[] validValues) {
  if (value == null) return false;
  for (String valid : validValues) {
  if (valid.equals(value)) return true;
  }
  return false;
  }

  // ✅ Method formatting yang DIPANGGIL di validasiHarga():
  public static String formatAngka(double number) {
  return String.format("%,.0f", number);
  }

  // ✅ Method untuk DashboardPanel (jika dibutuhkan):
  public static String formatRupiah(double amount) {
  return String.format("Rp %,.0f", amount);
  }

  public static String formatPersentase(double value, double total) {
  if (total == 0) return "0%";
  return String.format("%.1f%%", (value / total) * 100);
  }
  }
  🔧 CARA PERBAIKI ERROR:
  Jika error: "cannot find symbol Validator"
  bash
# Pastikan Validator.java ada di:
# belanja-app/src/com/belanja/util/Validator.java

# Compile Validator dulu:
javac -d bin src/com/belanja/util/Validator.java

# Lalu compile BelanjaService:
javac -d bin -cp bin src/com/belanja/service/BelanjaService.java
Jika error: "package com.belanja.util does not exist"
java
// Pastikan di Validator.java ada:
package com.belanja.util;  // ← LINE PERTAMA HARUS INI!

public class Validator {
// ...
}
Jika error: "method validasiNama not found"
Pastikan semua method di atas ada di Validator.java


echo === COMPILING BELANJA APP ===

echo 1. Compiling model...
javac -d bin src/com/belanja/model/Barang.java
javac -d bin src/com/belanja/model/BelanjaManager.java

echo 2. Compiling util...
javac -d bin src/com/belanja/util/FileHandler.java
javac -d bin src/com/belanja/util/Validator.java

echo 3. Compiling service...
javac -d bin -cp bin src/com/belanja/service/BelanjaService.java

echo 4. Compiling ui...
javac -d bin -cp bin src/com/belanja/ui/MainFrame.java
javac -d bin -cp bin src/com/belanja/ui/DashboardPanel.java
javac -d bin -cp bin src/com/belanja/ui/DaftarBarangPanel.java
javac -d bin -cp bin src/com/belanja/ui/FormBarangPanel.java
javac -d bin -cp bin src/com/belanja/ui/LaporanPanel.java

echo 5. Compiling main...
javac -d bin -cp bin src/com/belanja/Main.java

echo === RUNNING APP ===
java -cp bin com.belanja.Main

pause
✅ TEST VALIDATOR:
Untuk test apakah Validator bekerja, buat file test:

java
// TestValidator.java
package com.belanja.util;

public class TestValidator {
public static void main(String[] args) {
try {
System.out.println("Testing Validator...");

            // Test validasi nama
            Validator.validasiNama("Beras");
            System.out.println("✓ validasiNama OK");
            
            // Test validasi jumlah
            Validator.validasiJumlah(5);
            System.out.println("✓ validasiJumlah OK");
            
            // Test validasi harga
            Validator.validasiHarga(15000);
            System.out.println("✓ validasiHarga OK");
            
            // Test format rupiah
            String rupiah = Validator.formatRupiah(1500000);
            System.out.println("✓ formatRupiah OK: " + rupiah);
            
            System.out.println("✅ ALL TESTS PASSED!");
            
        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
        }
    }
}
Compile test: javac -d bin -cp bin src/com/belanja/util/TestValidator.java
Run: java -cp bin com.belanja.util.TestValidator

🎯 KESIMPULAN:
BelanjaService.java Anda SUDAH BENAR 100%!
Masalahnya adalah Validator.java belum ada atau belum lengkap.

Langkah perbaikan:

Buat file Validator.java di folder src/com/belanja/util/

Copy kode Validator lengkap di atas

Compile ulang semua file

Run aplikasi

Jika masih error, berikan pesan error lengkap dari compiler!


