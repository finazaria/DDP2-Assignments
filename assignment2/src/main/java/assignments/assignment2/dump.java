package assignments.assignment2;

public class dump {
    public static void main (String[] args) {
//         if (this.mataKuliah.length < 1) {
//             System.out.println("[DITOLAK] Belum ada mata kuliah yang diambil.");
//         }
//         else {
//             for (int i = 0; i < 10; i++) {
//                 if (this.mataKuliah[i] != null && this.mataKuliah[i].toString().equals(mataKuliah.toString())) {
//                         this.mataKuliah[i] = null;
//                         break;
//                 }
//             } 
//         }
//     }
// }

// Cek IRS
        // // IRS bermasalah bila :
        // // 1. Mata kuliah yang diambil tidak sesuai jurusan. cek kode jurusan si mahasiswa tersebut dan matkulnya
        // // 2. Maksimal sks yang dapat diambil mahasiswa adalah 24.
        // System.out.println("masuk cek IRS");
        // String npmString = String.valueOf(this.npm);
        // String kodeJurusan = npmString.substring(2,4);
        // this.totalSKS = 0;    
        // for (int i = 0; i < 10; i++) {
        //     if (this.mataKuliah[i] != null) {
        //         this.totalSKS += this.mataKuliah[i].getSKS();
        //     }                
        // }
        // String[] temp = new String[masalahIRS.length + 1];
        // for (int i = 0; i < 10; i++) { 
        //     if (this.mataKuliah[0] != null) {
        //         if (this.totalSKS > 24) {
        //             String sksBerlebih = "SKS yang Anda ambil lebih dari 24";
        //             this.masalahIRS[this.jumlahMasalahIRS] = sksBerlebih;
        //             this.jumlahMasalahIRS++;
        //         }

        //     // prioritas kedua; kalo totalSKS nya udah sesuai
        //         if (kodeJurusan.equals("01")) {          // Jurusan Ilmu Komputer => IK
        //             for (int i = 0; i < 10; i++) {
        //                 if (this.mataKuliah[i].getKode().equals("SI")) {     // Yang gaboleh SI
        //                     String matkulGakbisa_IK = "Mata Kuliah " + this.mataKuliah[i].toString() + 
        //                     " tidak dapat diambil jurusan IK";
        //                     this.masalahIRS[this.jumlahMasalahIRS] = matkulGakbisa_IK;
        //                     this.jumlahMasalahIRS++;
        //                     System.out.println("Eh udah sampe ini");
        //                 }
        //             }
        //         }
            
        //         else {      // Jika kodeJurusan == "02"
        //             for (int i = 0; i < 10; i++) {
        //                 if (this.mataKuliah[i].getKode().equals("IK")) {
        //                     String matkulGakbisa_SI = "Mata Kuliah " + this.mataKuliah[i].toString() + 
        //                     " tidak dapat diambil jurusan SI";
        //                     this.masalahIRS[this.jumlahMasalahIRS] = matkulGakbisa_SI;
        //                     this.jumlahMasalahIRS++;
        //                 }
        //             }
        //         }
        //     }
        // }

        // if (totalSKS != 0) {
        //     for (int i = 0; i < 10; i++) {         
        //         System.out.println(i+1 + ". " + mataKuliah[i].toString());      // untuk mendapatkan nama matkul
        //     }
        // }                                            
        // else {      // Handling jika mahasiswa tsb belum mengambil mata kuliah apa2
        //     System.out.println("Belum ada mata kuliah yang diambil");
        // }
        
        
        // for (int i = 0; i < 10; i++) {
        //     if (mataKuliah[i] != null) {
        //         System.out.println(i+1 + ". " + mataKuliah[i].toString());
        //     }
            
        //     else {
        //         System.out.println("Belum ada mata kuliah yang diambil");
        //         break;
        //     }
        // }


                // for (String m : masalahIRS) {
        //     if (m != null) {
        //         for (int i = 0; i < masalahIRS.length; i++) {
        //             System.out.println(i+1 + ". " + masalahIRS[i]);
        //             break;
        //         }
        //     }
        //     else {
        //         System.out.println("IRS tidak bermasalah.");
        //         break;
        //     }
    }
}
