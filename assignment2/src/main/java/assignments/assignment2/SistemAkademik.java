package assignments.assignment2;

import java.util.Arrays;
import java.util.Scanner;

public class SistemAkademik {
    private static final int ADD_MATKUL = 1;
    private static final int DROP_MATKUL = 2;
    private static final int RINGKASAN_MAHASISWA = 3;
    private static final int RINGKASAN_MATAKULIAH = 4;
    private static final int KELUAR = 5;
    private static Mahasiswa[] daftarMahasiswa = new Mahasiswa[100];
    private static MataKuliah[] daftarMataKuliah = new MataKuliah[100];
    
    private Scanner input = new Scanner(System.in);
    
    // Mencari mahasiswa berdasarkan NPM
    private Mahasiswa getMahasiswa(long npm) {

        // Mencari mahasiswa => mencari data satu object mahasiswa (box)
        // Kita cari di array daftarMahasiswa (lemari)
        for (int i = 0; i < 100; i++) {
            if (daftarMahasiswa[i] != null) {   // Kalo daftar mahasiswa di index tersebut kosong, maka langsung return null
                if (daftarMahasiswa[i].getNPM() == npm) {           // mengambil dan menyocokkan npm mahasiswa tersebut => bikin method getNPM()
                    return daftarMahasiswa[i];              // Jika sama, return data mahasiswa tersebut (box)
                }         
            }
        }
        return null;       
    }

    private MataKuliah getMataKuliah(String namaMataKuliah) {

        // Kayak method getMahasiswa tapi bedanya ini ke daftarMataKuliah
        for (int i = 0; i < 100; i++) {
            if (daftarMataKuliah[i] != null) {
                if (daftarMataKuliah[i].toString().equals(namaMataKuliah)) {
                    return daftarMataKuliah[i];
                }
            }
        }
        return null;
    }

    private void addMatkul() {
        System.out.println("\n--------------------------ADD MATKUL--------------------------\n");

        System.out.print("Masukkan NPM Mahasiswa yang akan melakukan ADD MATKUL : ");
        long npm = Long.parseLong(input.nextLine());
    
        // Disini kita ingin menambahkan matkul untuk satu spesifik mahasiswa
        // Karena input hanya berupa npm => getMahasiswa()
        // Karena getMahasiswa mereturn satuan object, maka harus kita tangkap dengan satuan object juga (box)
        Mahasiswa mahasiswa = getMahasiswa(npm);

        // Add matkul => AddMatkul untuk mahasiswa tersebut, DAN addMahasiswa untuk matkul tersebut
        System.out.print("Banyaknya Matkul yang Ditambah: ");
        int banyakMatkul = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan nama matkul yang ditambah");
        for(int i=0; i<banyakMatkul; i++){
            System.out.print("Nama matakuliah " + i+1 + " : ");     // i+1 => 0+1 = 1
            String namaMataKuliah = input.nextLine();

            // Mencari (box) mataKuliah dari daftarMataKuliah => getMataKuliah()
            // Karena getMataKuliah mereturn object (box), maka harus ditangkap dengan box juga
            MataKuliah mataKuliah = getMataKuliah(namaMataKuliah);

            // Setelah udah dapet data object2nya, baru di add
            mahasiswa.addMatkul(mataKuliah);
            mataKuliah.addMahasiswa(mahasiswa);

        }
        System.out.println("\nSilakan cek rekap untuk melihat hasil pengecekan IRS.\n");
    }

    private void dropMatkul() {
        System.out.println("\n--------------------------DROP MATKUL--------------------------\n");

        System.out.print("Masukkan NPM Mahasiswa yang akan melakukan DROP MATKUL : ");
        long npm = Long.parseLong(input.nextLine());


        Mahasiswa mahasiswa = getMahasiswa(npm);
        MataKuliah[] daftarMataKuliah = mahasiswa.getMataKuliah();
    
        if (mahasiswa.setTotalSKS() != 0) {             // mereturn total sks yang dimiliki mahasiswa tsb
            System.out.print("Banyaknya Matkul yang Di-drop: ");
            int banyakMatkul = Integer.parseInt(input.nextLine());
            System.out.println("Masukkan nama matkul yang di-drop:");
            
            for (int a=0; a<banyakMatkul; a++) {
                System.out.print("Nama matakuliah " + a+1 + " : ");
                String namaMataKuliah = input.nextLine();

                MataKuliah mataKuliah = getMataKuliah(namaMataKuliah);

                // Setelah udah dapet data object2nya, baru di drop
                mahasiswa.dropMatkul(mataKuliah);
                mataKuliah.dropMahasiswa(mahasiswa);
            }
            System.out.println("\nSilakan cek rekap untuk melihat hasil pengecekan IRS.\n");
        }

        else {
            System.out.println("[DITOLAK] Belum ada mata kuliah yang diambil.");
        }
    }

    private void ringkasanMahasiswa() {
        System.out.print("Masukkan npm mahasiswa yang akan ditunjukkan ringkasannya : ");
        long npm = Long.parseLong(input.nextLine());
    
        Mahasiswa mahasiswa = getMahasiswa(npm);        // berarti kita udah dapet si mahasiswa x tersebut
        String nama = mahasiswa.toString();

        // Jurusan tinggal diambil dari sini aja
        String jurusan = mahasiswa.setJurusan();        // berarti kan kita ngeakses jurusan dari mahasiswa
                                                        // Kita skrg udah ada di dalem box mahasiswa

        int totalSKS = mahasiswa.setTotalSKS();

        // Karena getMataKuliah me-return box, maka harus kita tangkap dengan box juga
        MataKuliah[] mataKuliah = mahasiswa.getMataKuliah();    // untuk mendapatkan mataKuliah dari si mahasiswa tersebut
        
        System.out.println("\n--------------------------RINGKASAN--------------------------\n");
        System.out.println("Nama: " + "" + nama);      
        System.out.println("NPM: " + npm);
        System.out.println("Jurusan: " + "" + jurusan);
        System.out.println("Daftar Mata Kuliah: ");

        if (mataKuliah[0] != null) {
            for (int i = 0; i < 10; i++) {
                while (mataKuliah[i] != null) {
                    System.out.println(i+1 + ". " + mataKuliah[i].toString());
                    break;
                }
            }
        }
        else {
            System.out.println("Belum ada mata kuliah yang diambil");
        }

        System.out.println("Total SKS: " + "" + totalSKS);
        
        System.out.println("Hasil Pengecekan IRS:");
        mahasiswa.cekIRS();
        String[] masalahIRS = mahasiswa.getMasalahIRS();

        if (masalahIRS[0] == null) {
            System.out.println("IRS tidak bermasalah.");
        }
        else {
            for (int i = 0; i < 10; i++) {
                if (masalahIRS[i] != null) {
                    System.out.println(i+1 + ". " + masalahIRS[i]);
                }
            }
        }
    }
    
    private void ringkasanMataKuliah() {
        System.out.print("Masukkan nama mata kuliah yang akan ditunjukkan ringkasannya : ");
        String namaMataKuliah = input.nextLine();
        
        // Berarti disini kita nge akses lemari daftar mata kuliah
        MataKuliah mataKuliah = getMataKuliah(namaMataKuliah);
        // Nge-return box

        String mataKuliah_name = mataKuliah.toString();
        String kodeMatkul = mataKuliah.getKode();
        int sks = mataKuliah.getSKS();
        // Jumlah mahasiswa di matkul tersebut didapat dari ngitung isi array
        int jumlahMahasiswa = mataKuliah.getJumlahMahasiswa();
        int kapasitas = mataKuliah.getKapasitas();          // bisa pake variable kapasitas, karena nama ini dipake di method lain
                                                            // jadi bisa dipake lagi

        Mahasiswa[] daftarMahasiswa = mataKuliah.getDaftarMahasiswa();

        System.out.println("\n--------------------------RINGKASAN--------------------------\n");
        System.out.println("Nama mata kuliah: " + "" + mataKuliah_name );
        System.out.println("Kode: " + "" + kodeMatkul);
        System.out.println("SKS: " + "" + Integer.toString(sks));
        System.out.println("Jumlah mahasiswa: " + "" + Integer.toString(jumlahMahasiswa));
        System.out.println("Kapasitas: " + "" + Integer.toString(kapasitas));
        System.out.println("Daftar mahasiswa yang mengambil mata kuliah ini: ");

        
        // Handle jika belum ada mahasiswa yang mengambil mata kuliah tersebut
        if (jumlahMahasiswa > 0) {
            for (int i = 0; i < daftarMahasiswa.length; i++) {
                if (daftarMahasiswa[i] != null) {
                    System.out.print((i+1) + ". " + daftarMahasiswa[i].toString() + "\n");
                }
            }
        }
        else {
            System.out.println("Belum ada mahasiswa yang mengambil mata kuliah ini.");
        }
    }

    private void daftarMenu() {
        int pilihan = 0;
        boolean exit = false;
        while (!exit) {
            System.out.println("\n----------------------------MENU------------------------------\n");
            System.out.println("Silakan pilih menu:");
            System.out.println("1. Add Matkul");
            System.out.println("2. Drop Matkul");
            System.out.println("3. Ringkasan Mahasiswa");
            System.out.println("4. Ringkasan Mata Kuliah");
            System.out.println("5. Keluar");
            System.out.print("\nPilih: ");
            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
            System.out.println();
            if (pilihan == ADD_MATKUL) {
                addMatkul();
            } else if (pilihan == DROP_MATKUL) {
                dropMatkul();
            } else if (pilihan == RINGKASAN_MAHASISWA) {
                ringkasanMahasiswa();
            } else if (pilihan == RINGKASAN_MATAKULIAH) {
                ringkasanMataKuliah();
            } else if (pilihan == KELUAR) {
                System.out.println("Sampai jumpa!");
                exit = true;
            }
        }

    }


    private void run() {
        System.out.println("====================== Sistem Akademik =======================\n");
        System.out.println("Selamat datang di Sistem Akademik Fasilkom!");
        
        System.out.print("Banyaknya Matkul di Fasilkom: ");
        int banyakMatkul = Integer.parseInt(input.nextLine());      // cuma bisa dipake disini
        System.out.println("Masukkan matkul yang ditambah");
        System.out.println("format: [Kode Matkul] [Nama Matkul] [SKS] [Kapasitas]");

        for(int i=0; i<banyakMatkul; i++){
            String[] dataMatkul = input.nextLine().split(" ", 4);
            String kode = dataMatkul[0];
            String nama = dataMatkul[1];
            int sks = Integer.parseInt(dataMatkul[2]);          
            int kapasitas = Integer.parseInt(dataMatkul[3]);    
            
            daftarMataKuliah[i] = new MataKuliah(kode, nama, sks, kapasitas);
            // declaring object using constructor
        }

        System.out.print("Banyaknya Mahasiswa di Fasilkom: ");          // berapa banyak nih mahasiswa yang mau dimasukin kedalam array?
        int banyakMahasiswa = Integer.parseInt(input.nextLine());       // buat bikin array daftarMahasiswa
        System.out.println("Masukkan data mahasiswa");
        System.out.println("format: [Nama] [NPM]");

        for(int i=0; i<banyakMahasiswa; i++){
            String[] dataMahasiswa = input.nextLine().split(" ", 2);
            String nama = dataMahasiswa[0];
            long npm = Long.parseLong(dataMahasiswa[1]);

            daftarMahasiswa[i] = new Mahasiswa(nama, npm);
        }

        daftarMenu();
        input.close();
    }

    public static void main(String[] args) {
        SistemAkademik program = new SistemAkademik();
        program.run();
    }
}
