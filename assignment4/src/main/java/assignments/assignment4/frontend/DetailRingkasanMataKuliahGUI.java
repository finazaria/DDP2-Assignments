package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class DetailRingkasanMataKuliahGUI {
    public DetailRingkasanMataKuliahGUI(JFrame frame, MataKuliah mataKuliah, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        JPanel mainPanel = new JPanel();                            // Panel untuk menempelkan Label dan button
        mainPanel.setBounds(20, 40, frame.getWidth() - 50, frame.getHeight() - 150);
		mainPanel.setLayout(new GridLayout(0, 1, 5, 5));
        // Any number of rows, but ONE column

        JLabel titleLabel = new JLabel("Detail Ringkasan Mata Kuliah");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);     
        titleLabel.setFont(SistemAkademikGUI.fontTitle);  

        // Label Nama Mata Kuliah
        JLabel nameLabel = new JLabel("Nama Mata Kuliah: " + mataKuliah.getNama());
        nameLabel.setHorizontalAlignment(JLabel.CENTER);     
        nameLabel.setFont(SistemAkademikGUI.fontGeneral);

        // Label kode
        JLabel kodeLabel = new JLabel("Kode: " + mataKuliah.getKode());
        kodeLabel.setHorizontalAlignment(JLabel.CENTER);     
        kodeLabel.setFont(SistemAkademikGUI.fontGeneral); 

        // Label SKS
        JLabel sksLabel = new JLabel("SKS: " + mataKuliah.getSKS());
        sksLabel.setHorizontalAlignment(JLabel.CENTER);     
        sksLabel.setFont(SistemAkademikGUI.fontGeneral);

        // Label Jumlah Mahasiswa
        JLabel jmlhMhsLabel = new JLabel("Jumlah Mahasiswa: " + mataKuliah.getJumlahMahasiswa());
        jmlhMhsLabel.setHorizontalAlignment(JLabel.CENTER);     
        jmlhMhsLabel.setFont(SistemAkademikGUI.fontGeneral);

        // Label Kapasitas
        JLabel kapasitasLabel = new JLabel("Kapasitas: " + mataKuliah.getKapasitas());
        kapasitasLabel.setHorizontalAlignment(JLabel.CENTER);     
        kapasitasLabel.setFont(SistemAkademikGUI.fontGeneral);
        
        // Label Title Daftar Mahasiswa
        JLabel titleDaftarMahasiswa = new JLabel("Daftar Mahasiswa: ");
        titleDaftarMahasiswa.setHorizontalAlignment(JLabel.CENTER);     
        titleDaftarMahasiswa.setFont(SistemAkademikGUI.fontGeneral);
        
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
        mainPanel.add(kodeLabel);
        mainPanel.add(sksLabel);
        mainPanel.add(jmlhMhsLabel);
        mainPanel.add(kapasitasLabel);
        mainPanel.add(titleDaftarMahasiswa);

        // Mencetak daftar mahasiswa di matkul tersebut
        if (mataKuliah.getJumlahMahasiswa() == 0) {           // Jika belum ada mahasiswa yang mengambil mata kuliah ini
            JLabel namaMhs = new JLabel("Belum ada mahasiswa yang mengambil mata kuliah ini.");
            namaMhs.setHorizontalAlignment(JLabel.CENTER);     
            namaMhs.setFont(SistemAkademikGUI.fontListing);      // tulisannya agak bold
            mainPanel.add(namaMhs);
        }
        else {      
            Mahasiswa[] daftarMahasiswaYangMengambil = mataKuliah.getDaftarMahasiswa();      
            for (int i = 0; i < daftarMahasiswaYangMengambil.length; i++) {
                if (daftarMahasiswaYangMengambil[i] != null){
                    JLabel namaMhs = new JLabel(i+1 + ". " + daftarMahasiswaYangMengambil[i].getNama());
                    namaMhs.setHorizontalAlignment(JLabel.CENTER);     
                    namaMhs.setFont(SistemAkademikGUI.fontListing);      // tulisannya agak bold
                    mainPanel.add(namaMhs);
                }
            }
        }
    
        mainPanel.add(selesaiBtn);

        frame.add(mainPanel);
        frame.repaint();
        frame.setVisible(true);
    }
}
