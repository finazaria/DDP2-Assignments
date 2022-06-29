package assignments.assignment4.frontend;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class HomeGUI {
    
    public HomeGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        JPanel homePanel = new JPanel();                            // Panel untuk menempelkan Label dan button
        homePanel.setBounds(20, 80, frame.getWidth() - 50, 250);
		homePanel.setLayout(new GridLayout(0, 1, 10, 10));
        // Any number of rows, but ONE column

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Selamat datang di Sistem Akademik");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);       // Agar label berada di tengah
        titleLabel.setFont(SistemAkademikGUI.fontTitle);        // Jadi, font title sama font general nya udah ke set. tinggal dipanggil2 lagi aja

        // Size dari button nya belum sesuai ya
        
        // Semua text saya set menjadi warna hitam terlebih dahulu. Karena GUI pada macbook tidak bisa membacanya
        // Untuk kemudahan saya mengerjakan Tugas Pemrograman ini
        JButton tmbhMhsBtn = new JButton("Tambah Mahasiswa");
        tmbhMhsBtn.setFont(SistemAkademikGUI.fontGeneral);
        tmbhMhsBtn.setBackground(Color.GREEN);
		tmbhMhsBtn.setForeground(Color.BLACK);
        tmbhMhsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                new TambahMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Pindah ke class TambahMahasiswaGUI
            }
            
        });

        JButton tmbhMatkulBtn = new JButton("Tambah Mata Kuliah");
        tmbhMatkulBtn.setFont(SistemAkademikGUI.fontGeneral);
        tmbhMatkulBtn.setBackground(Color.GREEN);
		tmbhMatkulBtn.setForeground(Color.BLACK);
        tmbhMatkulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                new TambahMataKuliahGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Pindah ke class TambahMataKuliahGUI
            }
            
        });

        JButton tmbhIRSBtn = new JButton("Tambah IRS");
        tmbhIRSBtn.setFont(SistemAkademikGUI.fontGeneral);
        tmbhIRSBtn.setBackground(Color.GREEN);
		tmbhIRSBtn.setForeground(Color.BLACK);
        tmbhIRSBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                new TambahIRSGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Pindah ke class TambahIRSGUI
            }
            
        });

        JButton hapusIRSBtn = new JButton("Hapus IRS");
        hapusIRSBtn.setFont(SistemAkademikGUI.fontGeneral);
        hapusIRSBtn.setBackground(Color.GREEN);
		hapusIRSBtn.setForeground(Color.BLACK);
        hapusIRSBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                new HapusIRSGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Pindah ke class HapusIRSGUI
            }
            
        });

        JButton ringkasanMhsBtn = new JButton("Lihat Ringkasan Mahasiswa");
        ringkasanMhsBtn.setFont(SistemAkademikGUI.fontGeneral);
        ringkasanMhsBtn.setBackground(Color.GREEN);
		ringkasanMhsBtn.setForeground(Color.BLACK);
        ringkasanMhsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                new RingkasanMahasiswaGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Pindah ke class RingkasanMahasiswaGUI
            }
            
        });

        JButton ringkasanMatkulBtn = new JButton("Lihat Ringkasan Mata Kuliah");
        ringkasanMatkulBtn.setFont(SistemAkademikGUI.fontGeneral);
        ringkasanMatkulBtn.setBackground(Color.GREEN);
		ringkasanMatkulBtn.setForeground(Color.BLACK);
        ringkasanMatkulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                new RingkasanMataKuliahGUI(frame, daftarMahasiswa, daftarMataKuliah);
                // Pindah ke class RingkasanMataKuliahGUI
            }
            
        });

        // Add button dan label ke homePanel
        homePanel.add(titleLabel);
        homePanel.add(tmbhMhsBtn);
        homePanel.add(tmbhMatkulBtn);
        homePanel.add(tmbhIRSBtn);
        homePanel.add(hapusIRSBtn);
        homePanel.add(ringkasanMhsBtn);
        homePanel.add(ringkasanMatkulBtn);

        // Add homePanel ke frame
        frame.add(homePanel);
        frame.setVisible(true);
        frame.repaint();






    }
}
