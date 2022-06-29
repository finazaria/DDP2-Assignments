package assignments.assignment3;

// bukan subclass dari apapun
public class MataKuliah {

    private String nama;
    private int kapasitas;
    private Dosen dosen;
    private Mahasiswa[] daftarMahasiswa = new Mahasiswa[kapasitas];

    // Constructor
    public MataKuliah(String nama, int kapasitas) {
        /* TODO: implementasikan kode Anda di sini */
        this.nama = nama;
        this.kapasitas = kapasitas;
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        // Menambahkan objek mahasiswa ke dlm array daftarMahasiswa
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i] == null) {
                daftarMahasiswa[i] = mahasiswa;
            }
        }
    }

    public void dropMahasiswa(Mahasiswa mahasiswa) {
        // Menghapus objek mahasiswa dari array daftarMahasiswa
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i] != null && daftarMahasiswa[i].getNama().equals(mahasiswa.getNama())) {
                daftarMahasiswa[i] = null;
                break;
            }
        }
    }

    public void addDosen(Dosen dosen) {
        // Menambahkan objek dosen ke mataKuliah
        this.dosen = dosen;
    }

    public void dropDosen() {
        // ngenull in dosen
        this.dosen = null;
    }

    public boolean cekDosen() {
        if (this.dosen != null) {
            return true;                // Berarti sudah ada dosen
        }
        return false;
    }

    public String toString() {
        return this.nama;
    }

    public int getKapasitas() {
        return this.kapasitas;
    }

    public int getJumlahMahasiswa() {
        int jumlahMahasiswa = 0;
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i] != null) {
                jumlahMahasiswa++;
            }
        }
        return jumlahMahasiswa;
    }

    public String getNamaDosen() {
        return this.dosen.getNama();
    }

    public Mahasiswa[] getDaftarMahasiswa() {
        return this.daftarMahasiswa;
    }
}