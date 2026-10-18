package project.unguided.komposisi;

public class ItemPesanan {
    private String namaItem;
    private RincianHarga rincian; // Objek internal (Komposisi)

    public ItemPesanan(String namaItem, double hargaDasar) {
        this.namaItem = namaItem;
        this.rincian = new RincianHarga(hargaDasar); // Di-instansiasi langsung di constructor
    }

    public String getNamaItem() {
        return namaItem;
    }

    public RincianHarga getRincian() {
        return rincian;
    }
}