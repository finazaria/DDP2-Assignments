package assignments.assignment2;

public class MataKuliah {
    private String kode;    // kode mata kuliah (IK, SI, CS)
    private String nama;    // Nama mata kuliah
    private int sks;
    private int kapasitas;
    private Mahasiswa[] daftarMahasiswa;    // daftar mahasiswa yang mendaftar di kuliah tersebut

    public MataKuliah(String kode, String nama, int sks, int kapasitas){
        
        // inisiasi atribut
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
        this.kapasitas = kapasitas;
        this.daftarMahasiswa = new Mahasiswa[this.kapasitas];        // besaran array daftarMahasiswa tergantung kapasitas
    }

    public String getNama() {
        return this.nama;
    }

    public int getSKS() {
        return this.sks;
    }
    
    public String getKode() {
        return this.kode;
    }
    
    public int getJumlahMahasiswa() {
        int jumlahMahasiswa = 0;                // variable jumlahMahasiswa ini lokal
        for (int i = 0; i < this.kapasitas; i++) {
            if (daftarMahasiswa[i] != null) {
                jumlahMahasiswa += 1;
            }
        }
        return jumlahMahasiswa;
    }

    public int getKapasitas(){
        return this.kapasitas;
    }

    public Mahasiswa[] getDaftarMahasiswa() {
        return this.daftarMahasiswa;         
    }

    // void => tidak usah me-return apa2
    public void addMahasiswa(Mahasiswa mahasiswa) {    

        // Memasukkan box mahasiswa ke dalam lemari daftarMahasiswa yang sudah mendaftar di matkul tersebut
        for (int i = 0; i < this.kapasitas; i++) {
            if (this.daftarMahasiswa[i] == null) {
                this.daftarMahasiswa[i] = mahasiswa;
                break;          // harus di break biar gak terus2an
            }
        }
    }

    // void => tidak usah me-return apa2
    public void dropMahasiswa(Mahasiswa mahasiswa) {
        for (int i = 0; i < this.kapasitas; i++) {
            if (this.daftarMahasiswa[i] != null && this.daftarMahasiswa[i].toString().equals(mahasiswa.toString())) {
                this.daftarMahasiswa[i] = null;
                break;
            }
        }
    }
    
    public String toString() {
        return this.nama;
    }
}
