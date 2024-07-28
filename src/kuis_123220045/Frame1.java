package kuis_123220045;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Frame1 extends JFrame {
    // Deklarasi variabel
    JTextField tpin;
    JLabel lblLogin;
    JButton btnLogin, btnCancel;
    
    // constructor Frame1
    public Frame1() {
        super("Login Page");

        // Menggunakan fungsi JPanel
        JPanel mainPanel = new JPanel();
        
        // Menggunakan fungsi Layout untuk menata letak
        mainPanel.setLayout(new GridLayout(3, 2, 5, 5));

        // Inisialisasi Variabel
        JLabel lbPIN = new JLabel("Masukkan PIN : ");
        tpin = new JTextField(15);
        mainPanel.add(lbPIN);
        mainPanel.add(tpin);

        // Inisialisasi tombol login
        btnLogin = new JButton("Login");
        mainPanel.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pin = tpin.getText();
                if ("123220045".equals(pin)) {
                    Frame2 frame2 = new Frame2();
                    frame2.setVisible(true);
                    dispose();
                } else {
                    lblLogin.setText("Status: Login Gagal");
                }
            }
        });

        // Inisialisasi tombol Keluar
        btnCancel = new JButton("Exit");
        mainPanel.add(btnCancel);
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

        // Inisialisasi status login
        lblLogin = new JLabel("Status: None");
        mainPanel.add(lblLogin);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(mainPanel);
        
        // Fungsi tambahan untuk panel (Menampilkan, resize, layout center, autoclose)
        pack();
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
