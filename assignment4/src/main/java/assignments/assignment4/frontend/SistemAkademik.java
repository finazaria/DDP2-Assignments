package assignments.assignment4.frontend;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import assignments.assignment4.backend.*;

public class SistemAkademik {
    public static void main(String[] args) { 
        new SistemAkademikGUI();
    }
}

class SistemAkademikGUI extends JFrame{
    private static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<Mahasiswa>();
    private static ArrayList<MataKuliah> daftarMataKuliah = new ArrayList<MataKuliah>();
    
    public static Font fontListing = new Font("Calibri", Font.BOLD , 13);                // Font untuk listing daftarMatkul, hasil pengecekan IRS             
    public static Font fontGeneral = new Font("Century Gothic", Font.PLAIN , 14);
    public static Font fontTitle = new Font("Century Gothic", Font.BOLD, 20);

    public SistemAkademikGUI(){

        setTitle("Administrator - Sistem Akademik");        // Menambahkan judul ke frame
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);                        // Agar pada saat buka window kebukanya langsung ditengah
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         // Stop program apabila windows di close   
        
        // Halaman default yg ditampilkan adalah HOME
        // "this" merujuk kpd SistemAkademikGUI, dioper sebagai frame di HomeGUI
        // extends JFrame => frame
        new HomeGUI(this, daftarMahasiswa, daftarMataKuliah);      // Memanggil HomeGUI
    }

    public static boolean cekMahasiswaAda(String npmString) {       
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (String.valueOf(daftarMahasiswa.get(i).getNpm()).equals(npmString)) {        // Kalo ada nama yang sama;
                return true;
            }
        }
        return false;
    }

    // Cek matkul dari nama (menggunakan parameter nama matkul)
    public static boolean cekMatkulAda (String nama) {
        for (int i = 0; i < daftarMataKuliah.size(); i++) {
            if (daftarMataKuliah.get(i).getNama().equals(nama)) {
                return true;
            }
        }
        return false;
    }

    public static int getJumlahMahasiswa() {
        int jumlahMahasiswa = 0;            // Inisiasi
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i) != null) {
                jumlahMahasiswa++;
            }
        }
        return jumlahMahasiswa;
    }

    public static int getJumlahMatkul() {
        int jumlahMataKuliah = 0;
        for (int i = 0; i < daftarMataKuliah.size(); i++) {
            if (daftarMataKuliah.get(i) != null) {
                jumlahMataKuliah++;
            }
        }
        return jumlahMataKuliah;
    }
    
    public static ArrayList<Mahasiswa> getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

    public static ArrayList<MataKuliah> getDaftarMataKuliah() {
        return daftarMataKuliah;
    }
}
