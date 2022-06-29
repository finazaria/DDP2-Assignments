package assignments.assignment3;

public abstract class ElemenFasilkom {
    // Abstract class => method2nya harus diimplementasikan lagi nantinya

    protected String tipe;      // Protected => agar bisa diakses di class lain asalkan satu package atau subclassnya
    protected String nama;
    protected int friendship;
    protected ElemenFasilkom[] telahMenyapa = new ElemenFasilkom[100];
    // Setiap elemen fasilkom memiliki array telahMenyapa-nya masing2

    // Gaada constructor. Langsung aja di subclass2nya
    public void menyapa(ElemenFasilkom elemenFasilkom) {        // ada korelasi nya sama menyapa yg di main

        // Menyapa main => works both ways
        // Method ini akan menyimpan orang yang DISAPA ke array telahMenyapa
        for (int i = 0; i < telahMenyapa.length; i++) {
            if (telahMenyapa[i] != null && telahMenyapa[i].toString().equals(elemenFasilkom.toString())) {
                System.out.println("[DITOLAK] " + this.toString() + " telah menyapa " + elemenFasilkom.toString() + " hari ini.");
                if (this.getTipe().equals("Mahasiswa") && elemenFasilkom.getTipe().equals("Dosen")) {
                    Mahasiswa mahasiswa = (Mahasiswa) this;
                    MataKuliah[] daftarMatkulMahasiswa = mahasiswa.getDaftarMataKuliah();

                    Dosen dosen = (Dosen) elemenFasilkom;
                    String mataKuliahDosen = dosen.getNamaMataKuliah();

                    for (int a = 0; a < daftarMatkulMahasiswa.length; a++) {
                        if (daftarMatkulMahasiswa[i].toString().equals(mataKuliahDosen)) {
                            this.friendship++;
                            elemenFasilkom.friendship++;
                            break;
                        }
                    }
                }
                else if (this.getTipe().equals("Dosen") && elemenFasilkom.getTipe().equals("Mahasiswa")) {
                    Mahasiswa mahasiswa = (Mahasiswa) elemenFasilkom;
                    MataKuliah[] daftarMatkulMahasiswa = mahasiswa.getDaftarMataKuliah();

                    Dosen dosen = (Dosen) this;
                    String mataKuliahDosen = dosen.getNamaMataKuliah();

                    for (int x = 0; x < daftarMatkulMahasiswa.length; x++) {
                        if (daftarMatkulMahasiswa[x].toString().equals(mataKuliahDosen)) {
                            this.friendship++;
                            elemenFasilkom.friendship++;
                            break;
                        }
                    }

                }
            }
            else {
                telahMenyapa[i] = elemenFasilkom;       // Masukin orang tersebut ke array
                System.out.println(this.toString() + " menyapa dengan " + elemenFasilkom.toString());
                break;
            }
        }
        }
    

    public void resetMenyapa() {
        // Menghapus data orang yang telah disapa
        // Mengosongkan array
        for (int i = 0; i < telahMenyapa.length; i++) {
            if (telahMenyapa[i] != null) {
                telahMenyapa[i] = null;
            }
        }
    }

    public void membeliMakanan(ElemenFasilkom pembeli, ElemenFasilkom penjual, String namaMakanan) {

        ElemenKantin penjualMakanan = (ElemenKantin) penjual;       // Casting penjual ke ElemenKantin biar bisa menjalankan method
        // Cek dulu apakah makanan tsb dijual oleh penjual
        Makanan[] daftarMakanan = penjualMakanan.getDaftarMakanan();
        for (int i = 0; i < daftarMakanan.length; i++) {
            if (daftarMakanan[i] != null && daftarMakanan[i].toString().equals(namaMakanan)) {
                System.out.println(pembeli.toString() + " berhasil membeli " + namaMakanan + " seharga" + daftarMakanan[i].getHarga());
                pembeli.friendship++;
                penjual.friendship++;
            }
            else {
                System.out.println("[DITOLAK] " + penjual.toString() + " tidak menjual " + namaMakanan);
                break;
            }
        }
    }

    public String toString() {
        return this.nama;
    }

    public String getTipe() {
        return this.tipe;
    }

    public ElemenFasilkom[] getArrayTelahMenyapa() {
        return this.telahMenyapa;
    }

    public int getJumlahOrangDisapa() {
        int jumlah = 0;
        for (int i = 0; i < telahMenyapa.length; i++) {
            if (telahMenyapa[i] != null) {
                jumlah++;
            }
        }
        return jumlah;
    }

    public void setFriendship(int poin) {
        // Tapi ada validasi dimana poin friendship hanya bisa dari 0-100
        this.friendship += poin;

        if (this.friendship < 0) {          // Batas bawah
            this.friendship = 0;
        }
        else if (this.friendship > 100) {      // Batas atas
            this.friendship = 100;
        }
    }

    public int getFriendship() {
        return this.friendship;
    }
}