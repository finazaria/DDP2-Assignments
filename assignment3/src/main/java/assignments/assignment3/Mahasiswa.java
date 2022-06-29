package assignments.assignment3;

// ElemenFasilkom (abstract), tapi Mahasiswa gausah abstract juga gpp
public class Mahasiswa extends ElemenFasilkom {
    
    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    private MataKuliah[] daftarMataKuliah = new MataKuliah[10];         // Max mataKuliah yg diambil adalah 10

    private long npm;
    private String tanggalLahir;
    private String jurusan;

    // Constructor.
    public Mahasiswa(String nama, long npm) {
        super();
        this.nama = nama;
        this.npm = npm;
        this.tipe = "Mahasiswa";
    }

    public int jumlahMataKuliah() {
        int jumlah =0;
        for (MataKuliah matkul : daftarMataKuliah) {
            if (matkul != null) {
                jumlah++;
            } 
        }
        return jumlah;
    }

    public void addMatkul(MataKuliah mataKuliah) {
        // mataKuliah di add to array
        // mahasiswa juga di add ke list mahasiswa di class Matakuliah
        // condition 1 : cek apakah matakuliah tersebut sudah pernah diambil
        // condition 2 : cek kapasitas
        for (int i = 0; i < daftarMataKuliah.length; i++) {
            if (daftarMataKuliah[i] != null) {
                if (daftarMataKuliah[i].equals(mataKuliah)) {         // Jika matkul tersebut sudah pernah diambil
                    System.out.println("[DITOLAK] " + mataKuliah.toString() + " telah diambil sebelumnya");
                }
                else if (mataKuliah.getJumlahMahasiswa() >= mataKuliah.getKapasitas()) {
                    System.out.println("[DITOLAK] " + mataKuliah.toString() + " telah penuh kapasitasnya");
                }
                else {
                    daftarMataKuliah[i] =  mataKuliah;
                    mataKuliah.addMahasiswa(this);
                    System.out.println(this.getNama() + "berhasil menambahkan mata kuliah" + mataKuliah.toString());
                }
            }
        }
    }

    public void dropMatkul(MataKuliah mataKuliah) {
        // Hapus mataKuliah dari array daftarMataKuliah
        for (int i = 0; i < daftarMataKuliah.length; i++) {
            if (daftarMataKuliah[i] != null && daftarMataKuliah[i].toString().equals(mataKuliah.toString())) {
                daftarMataKuliah[i] = null;     // Perlu di geser gak ya?
                mataKuliah.dropMahasiswa(this);     // Mengahapus mahasiswa dari array daftarMahasiswa di class mataKuliah
                System.out.println(this.getNama() + " berhasil drop mata kuliah" + mataKuliah.toString());
            }
            else {
                System.out.println("[DITOLAK] " + mataKuliah.toString() + " belum pernah diambil");
                break;
            }
        }
    }

    public String extractTanggalLahir(long npm) {
        String stringNPM = String.valueOf(npm);
        tanggalLahir = stringNPM.substring(4,12);
        return tanggalLahir;
    }

    public String extractJurusan(long npm) {
        String stringNPM = String.valueOf(npm);
        if (stringNPM.substring(2,4).equals("01")) {
            jurusan = "Ilmu Komputer";
        }
        else {
            jurusan = "Sistem Informasi";
        }
        return jurusan;
    }

    public String getNama() {
        return this.nama;
    }

    public long getNPM() {
        return this.npm;
    }

    public MataKuliah[] getDaftarMataKuliah() {
        return this.daftarMataKuliah;
    }
}
