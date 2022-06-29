package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class HapusIRSGUI {
    // Membuat array[] untuk menampung npm dlm bentuk String yang nanti akan disort ulang
    private String[] npmStringArray = new String[SistemAkademikGUI.getJumlahMahasiswa()];
    // Array untuk menampung nama matkul
    private String[] namaMatkulArray = new String[SistemAkademikGUI.getJumlahMatkul()];

    public HapusIRSGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){

        JPanel mainPanel = new JPanel();                            // Panel untuk menempelkan Label dan button
        mainPanel.setBounds(20, 80, frame.getWidth() - 50, 250);
		mainPanel.setLayout(new GridLayout(0, 1, 10, 10));
        // Any number of rows, but ONE column

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Hapus IRS");
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

        JLabel pilihMatkulLabel = new JLabel("Pilih Nama Matkul");
        pilihMatkulLabel.setHorizontalAlignment(JLabel.CENTER);     
        pilihMatkulLabel.setFont(SistemAkademikGUI.fontGeneral); 

        // Drop down pilih nama matkul
        // Juga di sort scr alphabetical

        // Mengambil nama matkul saja dari arrayList daftarMataKuliah
        String[] namaMatkulArray = createArrayNamaMatkul(daftarMataKuliah);
        String[] namaMatkulArraySorted = sortNamaMatkul(namaMatkulArray);
        JComboBox<String> matkulDropDown = new JComboBox<String>(namaMatkulArraySorted);
        if (namaMatkulArraySorted.length > 0) {          // namaMatkulArraySorted.length > 0 => berarti array nya udah ada isinya
            matkulDropDown.setSelectedIndex(0);
        }

        // Handler2 nya akan muncul di message box
        JButton tambahkanBtn = new JButton("Hapus");
        tambahkanBtn.setFont(SistemAkademikGUI.fontGeneral);
        tambahkanBtn.setBackground(Color.GREEN);
		tambahkanBtn.setForeground(Color.BLACK);
        // Action
        tambahkanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Semua pengecekan sudah dilakukan di method dropMatkul()
                
                String selectedNPM = (String) NPMDropDown.getSelectedItem();        // Objek nya di casting menjadi String
                String selectedMatkul = (String) matkulDropDown.getSelectedItem();  // selectedMatkul => nama Matkul
                
                // getMahasiswa(long npm)
                Mahasiswa mahasiswa = getMahasiswa(Long.valueOf(selectedNPM));
                // getMatkul(String namaMatkul)
                MataKuliah mataKuliah = getMataKuliah(selectedMatkul);
                
                if (selectedNPM == null || selectedMatkul == null) {                // Jika salah satu dari dropdown masih belum dipilih
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh field");
                }
                else {
                    String pesan = mahasiswa.dropMatkul(mataKuliah);      // Akan mereturn String format untuk message box
                    JOptionPane.showMessageDialog(frame, pesan);
                }
            }
            }
        );
        

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
        mainPanel.add(pilihMatkulLabel);
        mainPanel.add(matkulDropDown);
        mainPanel.add(tambahkanBtn);
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
