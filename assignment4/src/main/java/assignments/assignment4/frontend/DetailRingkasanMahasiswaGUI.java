package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class DetailRingkasanMahasiswaGUI {
    public DetailRingkasanMahasiswaGUI(JFrame frame, Mahasiswa mahasiswa, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        JPanel mainPanel = new JPanel();                            // Panel untuk menempelkan Label dan button
        mainPanel.setBounds(20, 40, frame.getWidth() - 50, frame.getHeight() - 150);
		mainPanel.setLayout(new GridLayout(0, 1, 5, 5));
        // Any number of rows, but ONE column

        JLabel titleLabel = new JLabel("Detail Ringkasan Mahasiswa");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);     
        titleLabel.setFont(SistemAkademikGUI.fontTitle);  

        // Label Nama
        JLabel nameLabel = new JLabel("Nama: " + mahasiswa.getNama());
        nameLabel.setHorizontalAlignment(JLabel.CENTER);     
        nameLabel.setFont(SistemAkademikGUI.fontGeneral);

        // Label NPM
        JLabel npmLabel = new JLabel("NPM: " + mahasiswa.getNpm());
        npmLabel.setHorizontalAlignment(JLabel.CENTER);     
        npmLabel.setFont(SistemAkademikGUI.fontGeneral); 

        // Label Jurusan
        JLabel jurusanLabel = new JLabel("Jurusan: " + mahasiswa.getJurusan());
        jurusanLabel.setHorizontalAlignment(JLabel.CENTER);     
        jurusanLabel.setFont(SistemAkademikGUI.fontGeneral);

        // Label DaftarMataKuliah
        JLabel titleDaftarMatkul = new JLabel("Daftar Mata Kuliah: ");
        titleDaftarMatkul.setHorizontalAlignment(JLabel.CENTER);     
        titleDaftarMatkul.setFont(SistemAkademikGUI.fontGeneral);

        // Label TotalSKS
        JLabel totalSKSLabel = new JLabel("Total SKS: " + mahasiswa.getTotalSKS());
        totalSKSLabel.setHorizontalAlignment(JLabel.CENTER);     
        totalSKSLabel.setFont(SistemAkademikGUI.fontGeneral);

        // Label Hasil Pengecekan IRS
        JLabel titleHasilCekIRS = new JLabel("Hasil Pengecekan IRS: ");
        titleHasilCekIRS.setHorizontalAlignment(JLabel.CENTER);     
        titleHasilCekIRS.setFont(SistemAkademikGUI.fontGeneral);
        
        JButton selesaiBtn = new JButton("Selesai");
        selesaiBtn.setFont(SistemAkademikGUI.fontGeneral);
        selesaiBtn.setBackground(Color.BLUE);
		selesaiBtn.setForeground(Color.BLACK);
        // Action
        selesaiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainPanel);
				new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });

        mainPanel.add(titleLabel);
        mainPanel.add(nameLabel);
        mainPanel.add(npmLabel);
        mainPanel.add(jurusanLabel);
        mainPanel.add(titleDaftarMatkul);
        // Label MataKuliah apa saja yang sudah diambil
        if (mahasiswa.getBanyakMatkul() == 0) {
            JLabel namaMatkul = new JLabel("Belum ada mata kuliah yang diambil.");
            namaMatkul.setHorizontalAlignment(JLabel.CENTER);     
            namaMatkul.setFont(SistemAkademikGUI.fontListing);      // tulisannya agak bold
            mainPanel.add(namaMatkul);
        }
        else {
            MataKuliah[] daftarMatkulYangDiambil = mahasiswa.getMataKuliah();       // Untuk di iterasi dan print
            for (int i = 0; i < daftarMatkulYangDiambil.length; i++) {
                if (daftarMatkulYangDiambil[i] != null){
                    JLabel namaMatkul = new JLabel(i+1 + ". " + daftarMatkulYangDiambil[i].getNama());
                    namaMatkul.setHorizontalAlignment(JLabel.CENTER);     
                    namaMatkul.setFont(SistemAkademikGUI.fontListing);      // tulisannya agak bold
                    mainPanel.add(namaMatkul);
                }
            }
        }
        mainPanel.add(totalSKSLabel);
        mainPanel.add(titleHasilCekIRS);

        // Cetak Hasil Pengecekan IRS
        mahasiswa.cekIRS();                 // Cek IRS dulu
        if (mahasiswa.getBanyakMasalahIRS() == 0){
            JLabel masalahIRS = new JLabel("IRS tidak bermasalah.");
            masalahIRS.setHorizontalAlignment(JLabel.CENTER);     
            masalahIRS.setFont(SistemAkademikGUI.fontListing);      // tulisannya agak bold
            mainPanel.add(masalahIRS);
        }
        else {      // Kalau ada masalah
            String[] daftarMasalahIRS = mahasiswa.getMasalahIRS();
            for (int i = 0; i < daftarMasalahIRS.length; i++) {
                if (daftarMasalahIRS[i] != null){
                    JLabel masalahIRS = new JLabel(i+1 + ". " + daftarMasalahIRS[i]);
                    masalahIRS.setHorizontalAlignment(JLabel.CENTER);     
                    masalahIRS.setFont(SistemAkademikGUI.fontListing);      // tulisannya agak bold
                    mainPanel.add(masalahIRS);
                }
            }
        }
        mainPanel.add(selesaiBtn);

        frame.add(mainPanel);
        frame.repaint();
        frame.setVisible(true);
    }
}
