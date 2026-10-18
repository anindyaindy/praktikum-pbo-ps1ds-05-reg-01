package project.unguided.main;

import project.unguided.agregasi.Pesanan;
import project.unguided.asosiasi.Kasir;
import project.unguided.komposisi.ItemPesanan;

public class Main {
    public static void main(String[] args) {
        // 1. Buat 1 objek Kasir
        Kasir kasir = new Kasir("Budi");

        // 2. Buat 3 objek ItemPesanan secara independen (Agregasi)
        ItemPesanan item1 = new ItemPesanan("Iced Americano", 18000);
        ItemPesanan item2 = new ItemPesanan("Beef Croissant", 25000);
        ItemPesanan item3 = new ItemPesanan("Matcha Latte", 22000);

        // 3. Buat 1 objek Pesanan untuk Meja 4 dengan kapasitas array 5
        Pesanan pesanan = new Pesanan(4, 5);

        // 4. Masukkan ketiga objek ItemPesanan ke dalam objek Pesanan
        pesanan.tambahItem(item1);
        pesanan.tambahItem(item2);
        pesanan.tambahItem(item3);

        // 5. Tampilkan rincian pesanan
        pesanan.tampilkanPesanan();
        System.out.println();

        // 6. Jalankan pemrosesan pembayaran oleh Kasir (Asosiasi)
        kasir.prosesPembayaran(pesanan);
    }
}