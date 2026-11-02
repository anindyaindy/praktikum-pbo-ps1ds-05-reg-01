package com.indy.unguided;

public class Main {
    public static void main(String[] args) {
        // TiketBioskop bersifat abstract sehingga tidak dapat diinstansiasi.
        // TiketBioskop tiket = new TiketBioskop("Interstellar", 40000, 2);

        ItemTransaksi.catatLogKasir("Membuka transaksi baru untuk Pelanggan #042.");

        TiketReguler tiketReguler = new TiketReguler("Interstellar", 40000, 2, 3);
        TiketVIP tiketVIP = new TiketVIP("Dune: Part Two", 60000, 2, 25000);
        PaketSnack paketSnack = new PaketSnack("Combo Popcorn Caramel + 2 Soda", 1, 55000);

        ItemTransaksi[] keranjang = {tiketReguler, tiketVIP, paketSnack};

        System.out.println("=== DAFTAR TRANSAKSI BIOSKOP ===");

        double totalTransaksi = 0;
        for (ItemTransaksi item : keranjang) {
            item.cetakRincianItem();
            totalTransaksi += item.getNominalBayar();
        }

        System.out.println("-------------------------------------------------------------");
        System.out.println("TOTAL TRANSAKSI : Rp" + totalTransaksi);
        System.out.println("=============================================================");

        ItemTransaksi.catatLogKasir("Transaksi #042 selesai diproses.");
    }
}
