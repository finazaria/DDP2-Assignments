package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class RingkasanMataKuliahGUI {
    // Array untuk menampung nama matkul
    private String[] namaMatkulArray = new String[SistemAkademikGUI.getJumlahMatkul()];

    public RingkasanMataKuliahGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        JPanel mainPanel = new JPanel();                            // Panel untuk menempelkan Label dan button
        mainPanel.setBounds(20, 80, frame.getWidth() - 50, 250);
		mainPanel.setLayout(new GridLayout(0, 1, 10, 10));
        // Any number of rows, but ONE column

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Ringkasan Mata Kuliah");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(SistemAkademikGUI.fontTitle);

        JLabel pilihMatkulLabel = new JLabel("Pilih Nama Matkul");
        pilihMatkulLabel.setHorizontalAlignment(JLabel.CENTER);     
        pilihMatkulLabel.setFont(SistemAkademikGUI.fontGeneral); 

        // Mempersiapkan array untuk dropdown
        String[] namaMatkulArray = createArrayNamaMatkul(daftarMataKuliah);     // Mengambil nama matkul saja dari arrayList daftarMataKuliah
        String[] namaMatkulArraySorted = sortNamaMatkul(namaMatkulArray);
        JComboBox<String> matkulDropDown = new JComboBox<String>(namaMatkulArraySorted);
        if (namaMatkulArraySorted.length > 0) {          // namaMatkulArraySorted.length > 0 => berarti array nya udah ada isinya
            matkulDropDown.setSelectedIndex(0);
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
                
                String selectedMatkul = (String) matkulDropDown.getSelectedItem();       // Objek nya di casting menjadi String
                if (selectedMatkul == null) {
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh field");
                }
                else {
                    frame.remove(mainPanel);
                    // Get MataKuliah
                    MataKuliah mataKuliah = getMataKuliah(selectedMatkul);
                    new DetailRingkasanMataKuliahGUI(frame, mataKuliah, daftarMahasiswa, daftarMataKuliah);
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
        mainPanel.add(pilihMatkulLabel);
        mainPanel.add(matkulDropDown);
        mainPanel.add(lihatBtn);
        mainPanel.add(kembaliBtn);

        frame.add(mainPanel);
        frame.repaint();
        frame.setVisible(true);
        
    }

    public String[] createArrayNamaMatkul(ArrayList<MataKuliah> arr) {
        int counter = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != null) {
                namaMatkulArray[counter++] = arr.get(i).getNama();
            }
        }
        return namaMatkulArray;
    }

    public String[] sortNamaMatkul(String[] namaMatkulArray) {
        String temp;
        for (int i = 0; i < namaMatkulArray.length-1; i++) {
            for (int j = i+1; j < namaMatkulArray.length; j++) {
                if (namaMatkulArray[j].compareTo(namaMatkulArray[i]) < 0) {
                    temp = namaMatkulArray[j];
                    namaMatkulArray[j] = namaMatkulArray[i];
                    namaMatkulArray[i] = temp;
                }
            }  
        }
        return namaMatkulArray;
    }
    
    private MataKuliah getMataKuliah(String nama) {
        ArrayList<MataKuliah> daftarMataKuliah = SistemAkademikGUI.getDaftarMataKuliah();
        for (MataKuliah mataKuliah : daftarMataKuliah) {
            if (mataKuliah.getNama().equals(nama)){
                return mataKuliah;
            }
        }
        return null;
    }
}
