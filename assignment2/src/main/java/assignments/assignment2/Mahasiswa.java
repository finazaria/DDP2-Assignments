package assignments.assignment2;


public class Mahasiswa {
    private MataKuliah[] mataKuliah = new MataKuliah[10];       // Satu mahasiswa max 10 matkul
    private String[] masalahIRS = new String[10];        // Array untuk menyimpan masalah IRS
    private int totalSKS;
    private String nama;
    private String jurusan;
    private long npm;

    public Mahasiswa(String nama, long npm){
        // inisiasi atribut
        this.nama = nama;
        this.npm = npm;
    }

    public long getNPM() {
        return this.npm;
    }

    // Getter matakuliah
    // Untuk ngeakses mata kuliah dari suatu mahasiswa => untuk ringkasanMahasiswa
    public MataKuliah[] getMataKuliah() {
        return this.mataKuliah;         // ngereturn suatu box mataKuliah
    }

    public String setJurusan() {
        // npm masih type long
        String npmString = String.valueOf(this.npm);
        String kodeJurusan = npmString.substring(2,4);
        
        if (kodeJurusan.equals("01")) {
            this.jurusan = "Ilmu Komputer";
        }
        else if (kodeJurusan.equals("02")) {
            this.jurusan = "Sistem Informasi";
        }
        return this.jurusan;        // return null kalo bukan 01 ataupun 02
    }
    
    public String getInisialJurusan() {         // diperlukan untuk validasi matkul yang boleh diambil
        String npmString = String.valueOf(this.npm);
        String kodeJurusan = npmString.substring(2,4);
        String inisialJurusan;

        // IK atau SI
        if (kodeJurusan.equals("01")) {
            inisialJurusan = "IK";
        }
        else {
            inisialJurusan = "SI";
        }
        return inisialJurusan;
    }
    
    public String[] getMasalahIRS() {
        return masalahIRS;
    }

    public void addMatkul(MataKuliah mataKuliah){
        // Ada beberapa validasi yang harus dilakukan disini
        // Ada skala prioritasnya
        // Ide => menggunakan boolean; buat per method biar codingan rapih
        
        if (pernahDiambil(mataKuliah)) {
            System.out.println("[DITOLAK] " + mataKuliah.toString() + " telah diambil sebelumnya.");
        }
        else { 
            if (kapasitasMataKuliah(mataKuliah)) {
                if (jumlahMataKuliah() < 10 ) {
                    for (int i = 0; i < 10; i++) {
                        if (this.mataKuliah[i] == null) {            // Kalo spot di array tersebut masih kosong => masukkan
                            this.mataKuliah[i] = mataKuliah;    // Memasukan box mataKuliah kedapan lemari mataKuliah
                            break;
                        }
                    }
                }
                else {
                    System.out.println("[DITOLAK] Maksimal mata kuliah yang diambil hanya 10");
                }
            }
            else {
                System.out.println("[DITOLAK] " + mataKuliah.toString() + " telah penuh kapasitasnya.");
            }
        }
    }

    public void dropMatkul(MataKuliah mataKuliah){

        // Cek dulu apakah array mataKuliah sudah ada isinya atau belum
        // Berarti mahasiswa tersebut sudah mengambil matkul atau belum
        
        for (int i = 0; i < 10; i++) {
            if (this.mataKuliah[i] != null) {
                if (this.mataKuliah[i].toString().equals(mataKuliah.toString())) {
                    this.mataKuliah[i] = null;
                    break;
                }
                else {          // Setelah di check di dalem gaada yang sama
                    System.out.println("[DITOLAK] " + mataKuliah.toString() + " belum pernah diambil");
                    break;
                }
            }
            else {      // kalo isinya null
                System.out.println("[DITOLAK] Belum ada mata kuliah yang diambil.");
                break;
            }
        }
    }
    
    public void cekIRS(){
        
        int hitung = 0;     // untuk masukin masalahIRS
        setTotalSKS();
        String inisialJurusan = getInisialJurusan();

        // Validasi 1 : Jumlah SKS < 24
        if (this.totalSKS > 24) {
            masalahIRS[hitung] = "SKS yang Anda ambil lebih dari 24";
            hitung++;
        }

        for (int i = 0; i < 10; i++) {
            if (mataKuliah[i] != null) {
                if (mataKuliah[i].getKode().equals(inisialJurusan) || mataKuliah[i].getKode().equals("CS") ) {
                }
                else {
                    masalahIRS[hitung] = "Mata Kuliah " + mataKuliah[i].toString() + " tidak dapat diambil jurusan " + inisialJurusan;
                    hitung++;
                }
            }
        }
    }

    // Untuk check apakah matakuliah sudah pernah diambil sebelumnya
    public boolean pernahDiambil(MataKuliah anotherMataKuliah) {
        for (int i = 0; i < 10; i++) {
            if (this.mataKuliah[i] != null && this.mataKuliah[i].toString().equals(anotherMataKuliah.toString())) {
                return true;
            }
        }
        return false;       // Kalo tidak
    }

    // Untuk check apakah mataKuliah tersebut kapasitasnya sudah penuh/belum
    public boolean kapasitasMataKuliah(MataKuliah anotherMataKuliah) {
        int kapasitasNya = anotherMataKuliah.getKapasitas();
        if (anotherMataKuliah.getJumlahMahasiswa() < kapasitasNya) {
            return true;
        }
        return false;
    }

    // jumlahMataKuliah si mahasiswa ini
    public int jumlahMataKuliah() {
        int jumlahMataKuliah = 0;
        for (int i = 0; i < 10; i++) {
            if (this.mataKuliah[i] != null) {
                jumlahMataKuliah += 1;
            }
        }
        return jumlahMataKuliah;
    }
    public String toString() {
        return this.nama;
    }

    // Setter untuk nge sum sks dari mata kuliah yang diambil si mahasiswa tersebut
    public int setTotalSKS() {
        this.totalSKS = 0;
        for (int i = 0; i < 10; i++) {
            if (mataKuliah[i] != null) {
                this.totalSKS += mataKuliah[i].getSKS();
            }                       // kan mataKuliah[i] berasal dari class MataKuliah, berarti bisa dong pake
                                    // method getSKS()
        }
        return this.totalSKS;
    }
}
