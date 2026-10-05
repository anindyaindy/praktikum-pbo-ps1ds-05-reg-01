package unguided3;

import java.util.Arrays;

public class PengolahSuhu {

    // Instance field (hanya dapat diakses melalui method dalam class ini)
    private double[] suhuHarian;

    // Class field / konstanta (bernilai sama untuk semua objek dan tidak dapat diubah)
    public static final double NILAI_KOSONG = -1.0;

    // Constructor dengan nama parameter yang sama dengan nama instance field
    public PengolahSuhu(double[] suhuHarian) {
        // Penggunaan keyword 'this' secara eksplisit untuk membedakan field dan parameter
        // Constructor ini menyimpan referensi alamat memori dari array, bukan membuat salinan baru
        this.suhuHarian = suhuHarian;
    }

    // Method untuk menampilkan seluruh data suhu 7 hari
    public void tampilkanData() {
        for (int i = 0; i < suhuHarian.length; i++) {
            if (suhuHarian[i] == NILAI_KOSONG) {
                System.out.println("Hari " + (i + 1) + " : (kosong)");
            } else {
                System.out.println("Hari " + (i + 1) + " : " + suhuHarian[i] + "°C");
            }
        }
    }

    // Method untuk mencari index data yang bernilai NILAI_KOSONG (-1.0)
    public int cariIndexKosong() {
        for (int i = 0; i < suhuHarian.length; i++) {
            if (suhuHarian[i] == NILAI_KOSONG) {
                return i; // Mengembalikan index jika ditemukan
            }
        }
        return -1; // Mengembalikan -1 jika tidak ada data kosong
    }

    // Method untuk mengisi data kosong menggunakan rumus imputasi deret waktu
    public void isiDataKosong() {
        int indexKosong = cariIndexKosong();

        // Memastikan index kosong ditemukan dan memiliki elemen sebelum serta sesudahnya
        if (indexKosong != -1 && indexKosong > 0 && indexKosong < suhuHarian.length - 1) {
            suhuHarian[indexKosong] = (suhuHarian[indexKosong - 1] + suhuHarian[indexKosong + 1]) / 2.0;
        }
    }

    // Method untuk menghitung rata-rata suhu harian
    public double hitungRataRata() {
        double total = 0.0;
        for (double suhu : suhuHarian) {
            total += suhu;
        }
        return total / suhuHarian.length;
    }

    // Main method sebagai titik awal jalannya program
    public static void main(String[] args) {
        // Data suhu awal harian
        double[] suhuHarian = { 30.4, 24.3, 26.8, -1.0, 31.4, 30.8, 32.9 };

        // Membuat objek PengolahSuhu
        PengolahSuhu pengolah = new PengolahSuhu(suhuHarian);

        // Menampilkan data suhu awal
        System.out.println("=== Data Suhu Awal ===");
        pengolah.tampilkanData();
        System.out.println();

        // Mencari dan menampilkan index hari kosong
        int indexKosong = pengolah.cariIndexKosong();
        System.out.println("Index hari kosong (dimulai dari 0): " + indexKosong);
        System.out.println();

        // Mengisi data kosong dengan metode imputasi
        pengolah.isiDataKosong();

        // Menampilkan data suhu setelah proses pengisian
        System.out.println("=== Data Suhu Setelah Pengisian ===");
        pengolah.tampilkanData();
        System.out.println();

        // Menampilkan hasil perhitungan rata-rata suhu
        System.out.printf("Rata-rata : %.2f°C\n", pengolah.hitungRataRata());
        System.out.println();

        // Mencetak langsung variabel array suhuHarian milik method main
        System.out.println("Isi array suhuHarian di main setelah isiDataKosong() dijalankan:");
        System.out.println(Arrays.toString(suhuHarian));
        System.out.println("(ikut berubah: constructor menyimpan referensi array yang sama)");
    }
}