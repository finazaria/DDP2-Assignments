package assignments.assignment3;

// bukan subclass dari apapun
public class Makanan {

    /* TODO: Silahkan menambahkan visibility pada setiap method dan variabel apabila diperlukan */

    private String nama;
    private long harga;

    // Constructor
    public Makanan(String nama, long harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String toString() {
        return this.nama;
    }
    
    public long getHarga() {
        return this.harga;
    }
}