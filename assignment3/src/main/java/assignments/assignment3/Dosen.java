package assignments.assignment3;

public class Dosen extends ElemenFasilkom {

    private MataKuliah mataKuliah;      // Setiap dosen max hanya bisa mengajar 1 matkul

    // Constructor.
    public Dosen(String nama) {
        super();
        this.nama = nama;
        this.tipe = "Dosen";
    }

    public void mengajarMataKuliah(MataKuliah anotherMataKuliah) {
        // Mendaftarkan objek dosen ke mataKuliah

        // Cek apakah dosen sudah mengajar suatu mataKuliah atau blm
        if (mataKuliah == null) {
            if (anotherMataKuliah.cekDosen()) {
                System.out.println("[DITOLAK] " + anotherMataKuliah.toString() + " sudah memiliki dosen pengajar" );
            }
            else {
                mataKuliah = anotherMataKuliah;
                mataKuliah.addDosen(this);
                System.out.println(nama + " mengajar mata kuliah " + anotherMataKuliah.toString());
            }
        }
        
        else {      // Dosen sudah mengajar suatu mataKuliah
            System.out.println("[DITOLAK] " + nama + " sudah mengajar mata kuliah " + mataKuliah.toString());
        }
    }

    public void dropMataKuliah() {
        if (mataKuliah == null) {       // Dosen tidak mengajar apa2
            System.out.println("[DITOLAK] " + nama + " sedang tidak mengajar mata kuliah apapun");
        }
        else {
            mataKuliah.dropDosen();
            System.out.println(nama + " berhenti mengajar " + mataKuliah.toString());
            mataKuliah = null;      // Di null in
        }
    }

    // Getter setter
    public String getNama() {
        return this.nama;
    }

    public String getNamaMataKuliah() {
        return mataKuliah.toString();
    }
}