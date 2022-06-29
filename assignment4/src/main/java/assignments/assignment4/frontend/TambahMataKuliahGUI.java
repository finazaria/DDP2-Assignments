package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class TambahMataKuliahGUI{

    public TambahMataKuliahGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
        
        JPanel mainPanel = new JPanel();                            // Panel untuk menempelkan Label dan button
        mainPanel.setBounds(20, 30, frame.getWidth() - 50, 400);
		mainPanel.setLayout(new GridLayout(0, 1, 10, 10));
        // Any number of rows, but ONE column

        JLabel titleLabel = new JLabel("Tambah Mata Kuliah");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);     
        titleLabel.setFont(SistemAkademikGUI.fontTitle);  
        
        JLabel kodeMatkulLabel = new JLabel("Kode Mata Kuliah: ");
        kodeMatkulLabel.setHorizontalAlignment(JLabel.CENTER);     
        kodeMatkulLabel.setFont(SistemAkademikGUI.fontGeneral); 

        JTextField kodeMatkulTextField = new JTextField();

        JLabel namaMatkulLabel = new JLabel("Nama Mata Kuliah: ");
        namaMatkulLabel.setHorizontalAlignment(JLabel.CENTER);     
        namaMatkulLabel.setFont(SistemAkademikGUI.fontGeneral); 

        JTextField namaMatkulTextField = new JTextField();

        JLabel sksLabel = new JLabel("SKS: ");
        sksLabel.setHorizontalAlignment(JLabel.CENTER);     
        sksLabel.setFont(SistemAkademikGUI.fontGeneral); 

        JTextField sksTextField = new JTextField();

        JLabel kapasitasLabel = new JLabel("Kapasitas: ");
        kapasitasLabel.setHorizontalAlignment(JLabel.CENTER);     
        kapasitasLabel.setFont(SistemAkademikGUI.fontGeneral); 

        JTextField kapasitasTextField = new JTextField();

        // Handler2 nya akan muncul di message box
        JButton tambahkanBtn = new JButton("Tambahkan");
        tambahkanBtn.setFont(SistemAkademikGUI.fontGeneral);
        tambahkanBtn.setBackground(Color.GREEN);
		tambahkanBtn.setForeground(Color.BLACK);
        // Action
        tambahkanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pengecekan : 1. Textfield harus terisi semua
                // 2. Mahasiswa belum pernah di add sebelumnya
                if (kodeMatkulTextField.getText().equals("") || namaMatkulTextField.getText().equals("")
                || sksTextField.getText().equals("") || kapasitasTextField.equals("")) {      // Kalau salah satunya true, maka true
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh field");
                }
                else if (SistemAkademikGUI.cekMatkulAda(namaMatkulTextField.getText())){
                    JOptionPane.showMessageDialog(frame, "Mata Kuliah " + namaMatkulTextField.getText() + " sudah pernah ditambahkan sebelumnya");
                }
                else {
                    // Urutan parameter mataKuliah : String kode, String nama, int sks, int kapasitas
                    String kode = kodeMatkulTextField.getText();
                    String nama = namaMatkulTextField.getText();
                    int sksInt = Integer.parseInt(sksTextField.getText());
                    int kapasitasInt = Integer.parseInt(kapasitasTextField.getText());

                    // Membuat objek Mata Kuliah
                    MataKuliah matkul = new MataKuliah(kode, nama, sksInt, kapasitasInt);
                    // Nambahin ke arrayList daftarMataKuliah
                    daftarMataKuliah.add(matkul);
                    JOptionPane.showMessageDialog(frame, "Mata Kuliah " + nama + " berhasil ditambahkan");

                    // Udah ditambahin, textField dikosongkan
                    kodeMatkulTextField.setText("");
                    namaMatkulTextField.setText("");
                    sksTextField.setText("");
                    kapasitasTextField.setText("");
                }
            }
            
        });
        
        // Sama seperti class lainnya
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
        mainPanel.add(kodeMatkulLabel);
        mainPanel.add(kodeMatkulTextField);
        mainPanel.add(namaMatkulLabel);
        mainPanel.add(namaMatkulTextField);
        mainPanel.add(sksLabel);
        mainPanel.add(sksTextField);
        mainPanel.add(kapasitasLabel);
        mainPanel.add(kapasitasTextField);
        mainPanel.add(tambahkanBtn);
        mainPanel.add(kembaliBtn);

        frame.add(mainPanel);
        frame.repaint();
        frame.setVisible(true);


    }
    
}
