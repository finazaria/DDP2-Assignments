package assignments.assignment3;

public class ElemenKantin extends ElemenFasilkom {
    
    private long harga;         // Harga makanan
    private Makanan[] daftarMakanan = new Makanan[10];
    // Setiap elemen kantin punya daftarMakanan sendiri2

    // Constructor.
    public ElemenKantin(String nama) {
        super();
        this.nama = nama;
        this.tipe = "ElemenKantin";
    }

    public void setMakanan(String namaMakanan, long hargaMakanan) {
        // Membuat object makanan
        // Memasukkan makanan tersebut ke array daftarMakanan si penjual ini tuh

        // Validasi dulu, apakah makanan tersebut sudah ada di daftarMakanan
        for (int i = 0; i < daftarMakanan.length; i++) {
            if (daftarMakanan[i] != null && daftarMakanan[i].toString().equals(namaMakanan)) {     // Jika nama makanan sudah ada dlm array datarMakanan,
                System.out.println("[DITOLAK] " + namaMakanan + " sudah pernah terdaftar");
            }
            else {
                if (daftarMakanan[i] == null) {
                    Makanan makananBaru = new Makanan(namaMakanan, hargaMakanan);     // Membuat object makanan baru
                    daftarMakanan[i] = makananBaru;                     // Memasukkannya ke dalam array
                    System.out.println(this.nama + " telah mendaftarkan makanan " + namaMakanan + " dengan harga " + hargaMakanan);
                    break;
                }
            }
        }
    }

    // Getter setter
    public String getNama() {
        return this.nama;
    }

    public Makanan[] getDaftarMakanan() {
        return this.daftarMakanan;
    }
}