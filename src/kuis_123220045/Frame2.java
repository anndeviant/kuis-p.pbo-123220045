package kuis_123220045;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Frame2 extends JFrame {

    int totalSaldo = 0;
    JTextField inputSaldo;
    JButton ulang, toMain, simpan, ambil;
    JLabel saldo;

    public Frame2() {
        super("Financial");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 5, 5));

        JLabel labelSaldo = new JLabel("Saldo: ");
        saldo = new JLabel("0");
        panel.add(labelSaldo);
        panel.add(saldo);

        JLabel iptSaldo = new JLabel("Input Saldo: ");
        inputSaldo = new JTextField(15);
        panel.add(iptSaldo);
        panel.add(inputSaldo);

        simpan = new JButton("Simpan");
        panel.add(simpan);
        simpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int inputedSaldo = Integer.parseInt(inputSaldo.getText());
                    int hasilSaldo = totalSaldo + inputedSaldo;
                    saldo.setText(String.valueOf(hasilSaldo));
                    totalSaldo = hasilSaldo;
                } catch (NumberFormatException p) {
                    JOptionPane.showMessageDialog(null, "Input Angka!", "Error", JOptionPane.WARNING_MESSAGE);
                    inputSaldo.setText("");
                }
            }
        });

        ambil = new JButton("Ambil");
        panel.add(ambil);
        ambil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int inputedSaldo = Integer.parseInt(inputSaldo.getText());
                    int hasilSaldo = totalSaldo - inputedSaldo;
                    if (totalSaldo < inputedSaldo) {
                        JOptionPane.showMessageDialog(null, "Saldo Tidak Cukup!", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        saldo.setText(String.valueOf(hasilSaldo));
                        totalSaldo = hasilSaldo;
                    }
                } catch (NumberFormatException p) {
                    JOptionPane.showMessageDialog(null, "Input Angka!", "Error", JOptionPane.WARNING_MESSAGE);
                    inputSaldo.setText("");
                }
            }
        });

        ulang = new JButton("Reset Input");
        panel.add(ulang);
        ulang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputSaldo.setText("");
            }
        });

        toMain = new JButton("Back to Login");
        panel.add(toMain);
        toMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame1 frame1 = new Frame1();
                frame1.setVisible(true);
                dispose();
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(panel);

        pack();
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
