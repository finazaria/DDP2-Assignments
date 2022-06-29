package assignments.assignment1;

import java.util.Scanner;

public class ExtractNPM {
    /*
    You can add other method do help you solve
    this problem
    
    Some method you probably need like
    - Method to get tahun masuk or else
    - Method to help you do the validation
    - and so on
    */
    
    public static boolean validate(long npm) {
        // TODO: validate NPM, return it with boolean

        // Agar codingan terlihat rapih dan terstruktur, gunakan method within method
        if (validateTahunMasuk(npm) && validateLength(npm) && validateKodeJurusan(npm) 
                && validateUmur(npm) && validateKodeNPM(npm)) {
                return true;
        }
        else {
            return false;       // dengan ini extract npm tidak dapat dijalankan
        }
    }

        // Adanya revisi soal : harus memvalidasi tahun masuk mahasiswa >= 10
        // Memastikan tidak ada NPM yang diawali dengan angka 0
        public static boolean validateTahunMasuk (long npm) {
            String npmString = String.valueOf(npm);
            String tahunMasuk = npmString.substring(0,2);           // substring(inklusif,ekslusif)
            int tahunMasukInt = Integer.parseInt(tahunMasuk);
            if (tahunMasukInt < 10) {
                return false;
            }
            else {
                return true;
            }
        }

        public static boolean validateLength(long npm) {
            String npmString = String.valueOf(npm);         // diulang di setiap method, karena npmString merupakan variable local

            // sesuai dengan validasi yang diminta soal,
            // NPM HARUS 14 digit
            if (npmString.length() != 14) {            
                return false;
            }
            return true;
        }


        public static boolean validateKodeJurusan(long npm) {
            String npmString = String.valueOf(npm);         // diulang di setiap method, karena npmString merupakan variable local
            
            // Cek kode jurusan : digit ke 3-4
            // Untuk mendapatkan digit ke 3-4 dari npmString => method substring()
            // substring(inclusive,exclusive)
            String kodeJurusan = npmString.substring(2, 4);
            
            // Kalau kode jurusan tidak sesuai dengan permintaan soal, maka NPM tidak valid
            String kodeJurusan01 = "01";
            String kodeJurusan02 = "02";
            String kodeJurusan03 = "03";
            String kodeJurusan11 = "11";
            String kodeJurusan12 = "12";
            
            boolean cekKodeJurusan = false;
            while (!cekKodeJurusan){ 
                if (kodeJurusan.equals(kodeJurusan01)) {
                    cekKodeJurusan = true;                  // karena sudah benar, jadi keluar dari loop
                }
                else if (kodeJurusan.equals(kodeJurusan02)) {
                    cekKodeJurusan = true;
                }
                else if (kodeJurusan.equals(kodeJurusan03)) {
                    cekKodeJurusan = true;
                }
                else if (kodeJurusan.equals(kodeJurusan11)) {
                    cekKodeJurusan = true;
                }
                else if (kodeJurusan.equals(kodeJurusan12)) {
                    cekKodeJurusan = true;
                }
                else {
                    cekKodeJurusan = true;
                    return false;
                }
            }
            return true;       
        }
                

        public static boolean validateUmur (long npm) {
            String npmString = String.valueOf(npm);         // diulang di setiap method, karena npmString merupakan variable local
            
            // Validasi umur sesuai dengan ketentuan soal
            // Umur harus >= 15 tahun
            String tahunMasuk = "20" + npmString.substring(0, 2);
            
            // Untuk mengubah string angka menjadi integer => Integer.parseInt(stringnya)
            int tahunLahirInt = Integer.parseInt(npmString, 8, 12, 10);
            int tahunMasukInt = Integer.parseInt(tahunMasuk);
            int umur = tahunMasukInt - tahunLahirInt; 
            
            if (umur < 15) {
                return false;
            }
            return true;
        }


        public static boolean validateKodeNPM (long npm) {
            String npmString = String.valueOf(npm);         // diulang di setiap method, karena npmString merupakan variable local
            // Pastikan hasil perhitungan bagian E sesuai dengan digit ke-14 NPM

            // Mengambil satu persatu digit, dan diubah ke integer
            int digit1 = Integer.parseInt(npmString, 0, 1, 10);
            int digit2 = Integer.parseInt(npmString, 1, 2, 10);
            int digit3 = Integer.parseInt(npmString, 2, 3, 10);
            int digit4 = Integer.parseInt(npmString, 3, 4, 10);
            int digit5 = Integer.parseInt(npmString, 4, 5, 10);
            int digit6 = Integer.parseInt(npmString, 5, 6, 10);
            int digit7 = Integer.parseInt(npmString, 6, 7, 10);    
            int digit8 = Integer.parseInt(npmString, 7, 8, 10);
            int digit9 = Integer.parseInt(npmString, 8, 9, 10);
            int digit10 = Integer.parseInt(npmString, 9, 10, 10);
            int digit11 = Integer.parseInt(npmString, 10, 11, 10);
            int digit12 = Integer.parseInt(npmString, 11, 12, 10);
            int digit13 = Integer.parseInt(npmString, 12, 13, 10);
            int digit14 = Integer.parseInt(npmString, 13, 14, 10);

            int hasilPenjumlahanE = (digit1 * digit13) + (digit2 * digit12) + (digit3 * digit11)
                                + (digit4 * digit10) + (digit5 * digit9)
                                + (digit6 * digit8) + digit7;
            
            // Jika hasil penjumlahan E masih >= 10, maka harus dijumlahkan lagi => pake while
            while (hasilPenjumlahanE >= 10) {
                String E = Integer.toString(hasilPenjumlahanE);
                String E1 = E.substring(0,1);
                String E2 = E.substring(1,2);

                int E1_int = Integer.parseInt(E1);
                int E2_int = Integer.parseInt(E2);
                hasilPenjumlahanE = E1_int + E2_int;
            }
            // Sudah dapat hasil perhitungan bagian E nya,
            // Tinggal kita check dengan digit14 pada NPM tersebut,
            // Jika sama, maka NPM valid; jika tidak, maka NPM tidak valid
            
            if (hasilPenjumlahanE != digit14) {
                return false;
            }
        return true;
        }
    

    public static String extract(long npm) {
        // TODO: Extract information from NPM, return string with given format
        
        String npmString = String.valueOf(npm);     // untuk mendapatkan variable yang tadi ada di validate lagi
                                                    // namanya sama gapapa, karena tidak ada koneksi
        
        String tahunMasuk = "20" + npmString.substring(0, 2);
        String kodeJurusan = npmString.substring(2, 4);

        // Hanya ada 5 jurusan

        String namaJurusan = new String();
        switch (kodeJurusan) {
            case "01" :
            namaJurusan = "Ilmu Komputer";
                break;
            case "02" :
            namaJurusan = "Sistem Informasi";
                break;
            case "03" :
            namaJurusan = "Teknologi Informasi";
                break;
            case "11" :
            namaJurusan = "Teknik Telekomunikasi";
                break;
            case "12" :
            namaJurusan = "Teknik Elektro";
                break;
        }

        String tanggalLahir = npmString.substring(4,6);
        String bulanLahir = npmString.substring(6,8);
        String tahunLahir = npmString.substring(8,12);

        String printFormat = String.format("Tahun masuk: %s\nJurusan: %s\nTanggal Lahir: %s-%s-%s",
                            tahunMasuk, namaJurusan, tanggalLahir, bulanLahir, tahunLahir);

        return printFormat;         // me-return String yang sudah sesuai dengan print format soal
    }

    public static void main(String args[]) {
        
        Scanner input = new Scanner(System.in);
        // Langsung aja ya gausah pake pesan inputan
        boolean exitFlag = false;
        while (!exitFlag) {         // while exitFlag == False, akan terus jalanin ini
            long npm = input.nextLong();       // si nomor NPM nya disimpan di variable "npm"
            if (npm < 0) {
                exitFlag = true;    // kalo ada isinya kan berarti langsung keluar dari while loop itu kan soalnya true
                break;              // break => to jump out of the loop
            }
            // TODO: Check validate and extract NPM
            boolean npmValid = validate(npm);
            if (npmValid) {         // equals to => if (npmValid == true)       
                                    // kalo validate nya udah bener, baru di extract NPM nya

                String keluaranFinal = extract(npm);        // return dari method extract(npm) ditangkap, agar bisa di print
                System.out.println(keluaranFinal);
            }

            else {      // jika NPM gabisa melewati validasi
                System.out.println("NPM tidak valid!");
                // Ini udah mencakup semuanya karena if yang ada di method validate menggunakan 
                // logical operation AND. Yang jika salah satu method ada yg false, maka akan
                // me-return false, dan langsung ke else ini.

            }
        }
        input.close();
    }
}