package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class RingkasanMahasiswaGUI {
    // Membuat array[] untuk menampung npm dlm bentuk String yang nanti akan disort ulang
    private String[] npmStringArray = new String[SistemAkademikGUI.getJumlahMahasiswa()];

    public RingkasanMahasiswaGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        JPanel mainPanel = new JPanel();                            // Panel untuk menempelkan Label dan button
        mainPanel.setBounds(20, 80, frame.getWidth() - 50, 250);
		mainPanel.setLayout(new GridLayout(0, 1, 10, 10));
        // Any number of rows, but ONE column

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Ringkasan Mahasiswa");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);

        JLabel pilihNPMLabel = new JLabel("Pilih NPM");
        pilihNPMLabel.setHorizontalAlignment(JLabel.CENTER);     
        pilihNPMLabel.setFont(SistemAkademikGUI.fontGeneral); 

        // Dropdown NPM dalam type String
        String[] npmStringArray = longToString(daftarMahasiswa);
        String[] npmStringArraySorted = sortNPM(npmStringArray);
        JComboBox<String> NPMDropDown = new JComboBox<String>(npmStringArraySorted);
        // Dropdown secara default nampilin data terkecil yang sudah ada
        // Kan array nya dibuat berdasarkan jumlahMahasiswa nya kan. Kalau blm ada, berarti array nya blm ada
        if (npmStringArraySorted.length > 0) {          // npmStringArraySorted.length > 0 => berarti array nya udah ada isinya
            NPMDropDown.setSelectedIndex(0);
        }

        // Handler2 nya akan muncul di message box
        JButton lihatBtn = new JButton("Lihat");
        lihatBtn.setFont(SistemAkademikGUI.fontGeneral);
        lihatBtn.setBackground(Color.GREEN);
		lihatBtn.setForeground(Color.BLACK);
        // Action
        lihatBtn.addActionListener(new ActionListener() {           // Beralih ke class DetailRingkasanMahasiswaGUI
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String selectedNPM = (String) NPMDropDown.getSelectedItem();        // Objek nya di casting menjadi String
                if (selectedNPM == null) {
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh field");
                }
                else {
                    frame.remove(mainPanel);
                    // Get mahasiswa
                    Mahasiswa mahasiswa = getMahasiswa(Long.valueOf(selectedNPM));
                    new DetailRingkasanMahasiswaGUI(frame, mahasiswa, daftarMahasiswa, daftarMataKuliah);
                }
            }
        });
        
    
        JButton kembaliBtn = new JButton("Kembali");
        kembaliBtn.setFont(SistemAkademikGUI.fontGeneral);
        kembaliBtn.setBackground(Color.BLUE);
		kembaliBtn.setForeground(Color.BLACK);
        // Action
        kembaliBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainPanel);
				new HomeGUI(frame, daftarMahasiswa, daftarMataKuliah);
            }
        });


        mainPanel.add(titleLabel);
        mainPanel.add(pilihNPMLabel);
        mainPanel.add(NPMDropDown);
        mainPanel.add(lihatBtn);
        mainPanel.add(kembaliBtn);

        frame.add(mainPanel);
        frame.repaint();
        frame.setVisible(true);
    }

      // Mengambil NPM di arrayList daftarMahasiswa dan memasukkannya ke array baru
    public String[] longToString(ArrayList<Mahasiswa> arr) {
        int counter = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != null) {
                npmStringArray[counter++] = String.valueOf(arr.get(i).getNpm());
            }
        }
        return npmStringArray;
    }

    // Sort NPM dari kecil ke besar
    public String[] sortNPM(String[] npmStringArray) {
        String temp;
        for (int i = 0; i < npmStringArray.length-1; i++) {
            for (int j = i+1; j < npmStringArray.length; j++) {
                if (npmStringArray[j].compareTo(npmStringArray[i]) < 0) {
                    temp = npmStringArray[j];
                    npmStringArray[j] = npmStringArray[i];
                    npmStringArray[i] = temp;
                }
            }  
        }
        return npmStringArray;
    }
    
    private Mahasiswa getMahasiswa(long npm) {
        ArrayList<Mahasiswa> daftarMahasiswa = SistemAkademikGUI.getDaftarMahasiswa();
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            if (mahasiswa.getNpm() == npm){
                return mahasiswa;
            }
        }
        return null;
    }
}
