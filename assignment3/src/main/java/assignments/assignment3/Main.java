package assignments.assignment3;

import java.util.Scanner;

public class Main {

    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    private static ElemenFasilkom[] daftarElemenFasilkom = new ElemenFasilkom[100];
    private static MataKuliah[] daftarMataKuliah = new MataKuliah[100];
    private static int totalMataKuliah = 0;        // Sebagai counter
    private static int totalElemenFasilkom = 0;    // Sebagai counter

    // Getter setter

    // Static karena mau dipake di method static juga, harus sama2 static
    private static ElemenFasilkom getElemen(String nama) {              // Untuk mencari elemenFasilkom hanya berdasarkan nama
        for (int i = 0; i < totalElemenFasilkom; i++) {
            if (daftarElemenFasilkom[i] != null) {
                if (daftarElemenFasilkom[i].toString().equals(nama)) {
                    return daftarElemenFasilkom[i];
                }
            }
        }
        return null;
    }

    private static MataKuliah getMatkul(String namaMataKuliah) {
        for (int i = 0; i < 100; i++) {
            if (daftarMataKuliah[i] != null) {
                if (daftarMataKuliah[i].toString().equals(namaMataKuliah)) {
                    return daftarMataKuliah[i];
                }
            }
        }
        return null;
    }

    private static int getJumlahElemenFasilkom() {
        int jumlahElemenFasilkom = 0;           // Inisiasi
        for (int i = 0; i < daftarElemenFasilkom.length; i++) {
            if (daftarElemenFasilkom[i] != null) {
                jumlahElemenFasilkom++;
            }
        }
        return jumlahElemenFasilkom;
    }

    private static void addMahasiswa(String nama, long npm) {      // Private => hanya bisa dipake di file ini
                                                            // Kan gamau dipake di file lain
        // Membuat object mahasiswa baru, dan nambahin ke array daftar elemen fasilkom
        // Nama dijamin unik dan belum pernah terdaftar sblmnya
        Mahasiswa mahasiswa = new Mahasiswa(nama, npm);
        daftarElemenFasilkom[totalElemenFasilkom] = mahasiswa;
        totalElemenFasilkom++;
        System.out.println(nama + " berhasil ditambahkan");
    }

    private static void addDosen(String nama) {
        Dosen dosen = new Dosen(nama);
        daftarElemenFasilkom[totalElemenFasilkom] = dosen;
        totalElemenFasilkom++;
        System.out.println(nama + " berhasil ditambahkan");
    }

    private static void addElemenKantin(String nama) {
        // ElemenKantin elemenKantin = new ElemenKantin(nama);
        // daftarElemenFasilkom[totalElemenFasilkom] = elemenKantin;
        // totalElemenFasilkom++;

        daftarElemenFasilkom[totalElemenFasilkom++] = new ElemenKantin(nama);
        System.out.println(nama + " berhasil ditambahkan");
    }

    private static void menyapa(String objek1, String objek2) {
        // Dijamin objek1 dan objek2 ada di daftarElemenFasilkom
        // Pastikan 2 orang yg berbeda
        if (objek1 == objek2){
            System.out.println("[DITOLAK] Objek yang sama tidak bisa saling menyapa");
        }
        else {
            ElemenFasilkom elemen1 = getElemen(objek1);
            ElemenFasilkom elemen2 = getElemen(objek2);
            elemen1.menyapa(elemen2);
            elemen2.menyapa(elemen1);
            
        }

    }

    private static void addMakanan(String objek, String namaMakanan, long harga) {
        // Menambahkan makanan sesuai parameter jadi objek makanan
        // Dijamin objek berasal dari daftarElemenFasilkom
        
        // Cek apakah objek merupakan elemenKantin
        ElemenFasilkom elemen = getElemen(objek);
        if (elemen.getTipe().equals("ElemenKantin")) {
            ((ElemenKantin) elemen).setMakanan(namaMakanan, harga);         // Casting
        }
        else {
            System.out.println("[DITOLAK] " + elemen.toString() + " bukan merupakan elemen kantin");
        }


    }

    private static void membeliMakanan(String objek1, String objek2, String namaMakanan) {
        // objek1 membeli dr objek2
        // Dijamin : objek merupakan bagian dari daftarElemenFasilkom
        // Dijamin : namaMakanan merupakan makanan yg dijual objek2

        // Prioritas validasi : cek apakah objek2 merupakan elemen kantin
        // 2. objek1 != objek2

        ElemenFasilkom elemen1 = getElemen(objek1);     // Ini gapapa namanya elemen1 juga kyk di menyapa() soalnya local variable
        ElemenFasilkom elemen2 = getElemen(objek2);

        if (elemen2.getTipe().equals("ElemenKantin")) {
            if (elemen1.toString() != elemen2.toString()) {     // Memastikan elemen1 dan elemen2 merupakan orang yang berbeda
                elemen1.membeliMakanan(elemen1, elemen2, namaMakanan);
            }
            else {
                System.out.println("[DITOLAK] Elemen kantin tidak bisa membeli makanan sendiri");
            }
        }
        else {      // Kalau objek2 bukan elemenKantin
            System.out.println("[DITOLAK] Hanya elemen kantin yang dapat menjual makanan");
        }
    }

    private static void createMatkul(String nama, int kapasitas) {
        // Membuat object mataKuliah dan memasukkanya ke array daftarMataKuliah
        MataKuliah mataKuliah = new MataKuliah(nama, kapasitas);
        daftarMataKuliah[totalMataKuliah] = mataKuliah;
        totalMataKuliah++;
    }

    private static void addMatkul(String objek, String namaMataKuliah) {
        // Menambahkan mataKuliah ke objek
        // Objek harus MAHASISWA
        // Si objek mahasiswa itu ingin menambah mataKuliah
        // Dijamin objek udh ada di daftarElemenFasilkom
        // dan dijamin namaMataKuliah udah ada di daftarMataKuliah

        ElemenFasilkom elemen = getElemen(objek);
        // Bikin method getMataKuliah() berdasarkan nama 
        // Karena addMatkul() nerima param object mataKuliah
        if (elemen.getTipe().equals("Mahasiswa")) {
            MataKuliah objekMataKuliah = getMatkul(namaMataKuliah);
            ((Mahasiswa) elemen).addMatkul(objekMataKuliah);
        }
        else {
            System.out.println("[DITOLAK] Hanya mahasiswa yang dapat menambahkan matkul");
        }
    }

    private static void dropMatkul(String objek, String namaMataKuliah) {
        // Dijamin namaMataKuliah ada di daftarMataKuliah
        // Dijamin objek merupakan elemenFasilkom

        ElemenFasilkom elemen = getElemen(objek);
        if (elemen.getTipe().equals("Mahasiswa")) {
            MataKuliah objekMataKuliah = getMatkul(namaMataKuliah);
            ((Mahasiswa) elemen).dropMatkul(objekMataKuliah);
        }
        else {      // Jika objek bukanlah mahasiswa
            System.out.println("[DITOLAK] Hanya mahasiswa yang dapat drop matkul");
        }
    }

    private static void mengajarMatkul(String objek, String namaMataKuliah) {
        // Mendaftarkan objek (dosen) ke matkul
        // Si dosen daftar ngajar
        // Validasi : Pastiin dia dosen

        ElemenFasilkom elemen = getElemen(objek);
        if (elemen.getTipe().equals("Dosen")) {
            MataKuliah objekMataKuliah = getMatkul(namaMataKuliah);
            ((Dosen) elemen).mengajarMataKuliah(objekMataKuliah);
        }
        else {      // Jika objek bukanlah dosen
            System.out.println("[DITOLAK] Hanya dosen yang dapat mengajar matkul");
        }
    }

    private static void berhentiMengajar(String objek) {
        // Menghapus mataKuliah yang sedang diajar objek (dosen)
        // Dijamin objek ada di daftarElemenFasilkom
        // Validasi : pastiin dia dosen

        ElemenFasilkom elemen = getElemen(objek);
        if (elemen.getTipe().equals("Dosen")) {
            ((Dosen) elemen).dropMataKuliah();
        }
        else {      // Jika objek bukanlah dosen
            System.out.println("[DITOLAK] Hanya dosen yang dapat berhenti mengajar");
        }
    }

    private static void ringkasanMahasiswa(String objek) {
        // Print info si mahasiswa

        // Validasi 1 : pastiin dia mahasiswa
        // Trs kalo blm ada mataKuliah yg diambil, print ... (Cek apakah dia udah ngambil suatu matkul)

        ElemenFasilkom elemen = getElemen(objek);
        if (elemen.getTipe().equals("Mahasiswa")) {
            Mahasiswa mahasiswa = (Mahasiswa) elemen;       // Casting ke subclass Mahasiswa, agar bisa menggunakan method2 get yang ada di subclass Mahasiswa
            String tanggalLahir = mahasiswa.extractTanggalLahir(mahasiswa.getNPM());
            String tanggal = tanggalLahir.substring(0,2);
            String bulan = tanggalLahir.substring(2, 4);
            String tahun = tanggalLahir.substring(4, 8);

            System.out.println("Nama: " + mahasiswa.getNama());
            System.out.println(String.format("Tanggal lahir: %s-%s-%s", tanggal, bulan, tahun));
            System.out.println("Jurusan: " + mahasiswa.extractJurusan(mahasiswa.getNPM()));

            MataKuliah[] daftarMataKuliah = mahasiswa.getDaftarMataKuliah();
            if (daftarMataKuliah[0] != null) { 
                for (int i = 0; i < 10; i++) {
                    while (daftarMataKuliah[i] != null) {
                        System.out.println(i+1 + ". " + daftarMataKuliah[i].toString());
                        break;
                    }
                }
            }
            else {
                System.out.println("Belum ada mata kuliah yang diambil");
            }
        }
        else {
            System.out.println("[DITOLAK] " + objek + " bukan merupakan seorang mahasiswa");
        }
    }

    private static void ringkasanMataKuliah(String namaMataKuliah) {
        // Dijamin objek berasal dari daftarMataKuliah

        MataKuliah mataKuliah = getMatkul(namaMataKuliah);
        System.out.println("Nama mata kuliah: " + mataKuliah.toString());
        System.out.println("Jumlah mahasiswa: " + mataKuliah.getJumlahMahasiswa());
        System.out.println("Kapasitas: " + mataKuliah.getKapasitas());
        
        String dosen = mataKuliah.getNamaDosen();
        if (dosen != null) {
            System.out.println("Dosen pengajar: " + dosen);
        }
        else {
            System.out.println("Dosen pengajar: Belum ada");
        }

        Mahasiswa[] daftarMahasiswa = mataKuliah.getDaftarMahasiswa();
        if (mataKuliah.getJumlahMahasiswa() != 0) { 
            for (int i = 0; i < 10; i++) {
                while (daftarMahasiswa[i] != null) {
                    System.out.println(i+1 + ". "+ daftarMahasiswa[i].getNama());
                    break;
                }
            }
        
            for (int i = 0; i < 10; i++) {
            if (daftarMahasiswa[i] != null) {
                while (daftarMahasiswa[i] != null) {
                    System.out.println(i+1 + ". " + daftarMahasiswa[i].getNama());
                    break;
                }
            }
            else {
                System.out.println("Belum ada mahasiswa yang mengambil mata kuliah ini");
            }
        }
        }

    }

    private static void nextDay() {

        // Kalkulasi friendship

        // Nilai friendship 0-100

        // Jika suatu elemenFasilkom sudah menyapa >= setengah dari daftarElemenFasilkom (minus dirinya sendiri) => friendship +10
        // Sebaliknya -5

        // Variable friendship ada di setiap ElemenFasilkom, dia adanya di parent class

        for (int i = 0; i < daftarElemenFasilkom.length; i++) {
            if (daftarElemenFasilkom[i] != null) {
                ElemenFasilkom elemen = daftarElemenFasilkom[i];
                int setengahDari = (getJumlahElemenFasilkom() - 1) / 2;         // Minus diri dia sendiri
                if (elemen.getJumlahOrangDisapa() >= setengahDari) {
                    elemen.setFriendship(10);
                }
                else {              // Jika tidak menyapa orang sampai dari setengah dari totalJumlahElemenFasilkom
                    elemen.setFriendship(-5);
                }
            }
            else {
                break;
            }
        }

        System.out.println("Hari telah berakhir dan nilai friendship telah diupdate");
        friendshipRanking();

        // Akan me-reset array
        for (int i = 0; i < daftarElemenFasilkom.length; i++) {
            if (daftarElemenFasilkom[i] != null) {
                daftarElemenFasilkom[i].resetMenyapa();
            }
        }
    }

    private static void friendshipRanking() {
        // Menampilkan friendshipRanking dari yg paling tinggi ke rendah,
        // Jika ada yg sama => alphabetical order

        ElemenFasilkom temp;       // Membuat objek temp untuk menyimpan sementara
        for (int i = 0; i < daftarElemenFasilkom.length; i++) {
            for (int j = i+1; j < daftarElemenFasilkom.length; j++) {
                if (daftarElemenFasilkom[i] != null && daftarElemenFasilkom[j] != null) {

                if (daftarElemenFasilkom[i].getFriendship() < daftarElemenFasilkom[j].getFriendship()) {
                    temp = daftarElemenFasilkom[j];
                    daftarElemenFasilkom[j] = daftarElemenFasilkom[i];
                    daftarElemenFasilkom[i] = temp;
                }
            }
            }
        }

        // Di cek lagi kalo ada yang sama gimana
        for (int i = 0; i < daftarElemenFasilkom.length; i++) {
            for (int j = i+1; j < daftarElemenFasilkom.length; j++) {
                if (daftarElemenFasilkom[i] != null && daftarElemenFasilkom[j] != null) {
                if (daftarElemenFasilkom[i].toString().compareTo(daftarElemenFasilkom[j].toString()) < 0) {
                    temp = daftarElemenFasilkom[j];
                    daftarElemenFasilkom[j] = daftarElemenFasilkom[i];
                    daftarElemenFasilkom[i] = temp;
                }
            }
            }
        }

        for (int i = 0; i < daftarElemenFasilkom.length; i++) {
            if (daftarElemenFasilkom[i] != null) {
                System.out.println(i+1 + ". " + daftarElemenFasilkom[i].toString() + "(" + daftarElemenFasilkom[i].getFriendship() + ")" );
            }
        }
    }

    private static void programEnd() {
        System.out.println("Program telah berakhir. Berikut nilai terakhir dari friendship pada Fasilkom : ");
        friendshipRanking();
        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            String in = input.nextLine();
            if (in.split(" ")[0].equals("ADD_MAHASISWA")) {
                addMahasiswa(in.split(" ")[1], Long.parseLong(in.split(" ")[2]));
            } else if (in.split(" ")[0].equals("ADD_DOSEN")) {
                addDosen(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("ADD_ELEMEN_KANTIN")) {
                addElemenKantin(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("MENYAPA")) {
                menyapa(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("ADD_MAKANAN")) {
                addMakanan(in.split(" ")[1], in.split(" ")[2], Long.parseLong(in.split(" ")[3]));
            } else if (in.split(" ")[0].equals("MEMBELI_MAKANAN")) {
                membeliMakanan(in.split(" ")[1], in.split(" ")[2], in.split(" ")[3]);
            } else if (in.split(" ")[0].equals("CREATE_MATKUL")) {
                createMatkul(in.split(" ")[1], Integer.parseInt(in.split(" ")[2]));
            } else if (in.split(" ")[0].equals("ADD_MATKUL")) {
                addMatkul(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("DROP_MATKUL")) {
                dropMatkul(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("MENGAJAR_MATKUL")) {
                mengajarMatkul(in.split(" ")[1], in.split(" ")[2]);
            } else if (in.split(" ")[0].equals("BERHENTI_MENGAJAR")) {
                berhentiMengajar(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("RINGKASAN_MAHASISWA")) {
                ringkasanMahasiswa(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("RINGKASAN_MATKUL")) {
                ringkasanMataKuliah(in.split(" ")[1]);
            } else if (in.split(" ")[0].equals("NEXT_DAY")) {
                nextDay();
            } else if (in.split(" ")[0].equals("PROGRAM_END")) {
                programEnd();
                break;
            }
        }
        input.close();
    }
}