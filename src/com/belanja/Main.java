package com.belanja;

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
}