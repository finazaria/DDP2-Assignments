package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class TambahMahasiswaGUI{

    public TambahMahasiswaGUI(JFrame frame, ArrayList<Mahasiswa> daftarMahasiswa, ArrayList<MataKuliah> daftarMataKuliah){
    
        JPanel mainPanel = new JPanel();                            // Panel untuk menempelkan Label dan button
        mainPanel.setBounds(20, 80, frame.getWidth() - 50, 250);
		mainPanel.setLayout(new GridLayout(0, 1, 10, 10));
        // Any number of rows, but ONE column

        JLabel titleLabel = new JLabel("Tambah Mahasiswa");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);     
        titleLabel.setFont(SistemAkademikGUI.fontTitle);  
        
        JLabel nameLabel = new JLabel("Nama: ");
        nameLabel.setHorizontalAlignment(JLabel.CENTER);     
        nameLabel.setFont(SistemAkademikGUI.fontGeneral); 

        JTextField nameTextField = new JTextField();

        JLabel npmLabel = new JLabel("NPM: ");
        npmLabel.setHorizontalAlignment(JLabel.CENTER);     
        npmLabel.setFont(SistemAkademikGUI.fontGeneral); 

        JTextField npmTextField = new JTextField();

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
                if (nameTextField.getText().equals("") || npmTextField.getText().equals("")) {      // Kalau salah satunya true, maka true
                    JOptionPane.showMessageDialog(frame, "Mohon isi seluruh field");
                }
                else if (SistemAkademikGUI.cekMahasiswaAda(npmTextField.getText())){
                    JOptionPane.showMessageDialog(frame, "NPM " + npmTextField.getText() + " sudah pernah ditambahkan sebelumnya");
                }
                else {
                    // Menyimpan nama dan NPM untuk nanti ditambahkan ke mahasiswa
                    String nama = nameTextField.getText();
                    long npm = Long.parseLong(npmTextField.getText());
                    Mahasiswa mahasiswa = new Mahasiswa(nama, npm);
                    // Nambahin ke arrayList Mahasiswa
                    daftarMahasiswa.add(mahasiswa);
                    JOptionPane.showMessageDialog(frame, "Mahasiswa " + npm + "-" + nama + " berhasil ditambahkan");

                    // Udah ditambahin, textField dikosongkan
                    nameTextField.setText("");
                    npmTextField.setText("");
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
        mainPanel.add(nameLabel);
        mainPanel.add(nameTextField);
        mainPanel.add(npmLabel);
        mainPanel.add(npmTextField);
        mainPanel.add(tambahkanBtn);
        mainPanel.add(kembaliBtn);

        frame.add(mainPanel);
        frame.repaint();
        frame.setVisible(true);

    }
}
