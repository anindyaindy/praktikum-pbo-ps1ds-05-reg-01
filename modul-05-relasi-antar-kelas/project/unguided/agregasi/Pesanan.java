package project.unguided.agregasi;

import project.unguided.komposisi.ItemPesanan;
import project.unguided.komposisi.RincianHarga;

public class Pesanan {
    private int nomorMeja;
    private ItemPesanan[] daftarItem; // Array penampung (Agregasi)
    private int jumlahItem;

    public Pesanan(int nomorMeja, int kapasitasMax) {
        this.nomorMeja = nomorMeja;
        this.daftarItem = new ItemPesanan[kapasitasMax];
        this.jumlahItem = 0;
    }

    public void tambahItem(ItemPesanan item) {
        if (jumlahItem < daftarItem.length) {
            daftarItem[jumlahItem] = item;
            jumlahItem++;
        } else {
            System.out.println("Kapasitas pesanan sudah penuh!");
        }
    }

    public void tampilkanPesanan() {
        System.out.println("=== DAFTAR PESANAN CAFE ===");
        System.out.println("Nomor Meja: " + nomorMeja);
        for (int i = 0; i < jumlahItem; i++) {
            ItemPesanan item = daftarItem[i];
            RincianHarga rin = item.getRincian();
            System.out.println((i + 1) + ". " + item.getNamaItem() + " - Rp " + rin.getHargaTotal() + 
                               " (Harga: " + rin.getHargaDasar() + ", Pajak: " + rin.getPajak() + ")");
        }
    }

    public int getNomorMeja() {
        return nomorMeja;
    }

    public ItemPesanan[] getDaftarItem() {
        return daftarItem;
    }

    public int getJumlahItem() {
        return jumlahItem;
    }
}