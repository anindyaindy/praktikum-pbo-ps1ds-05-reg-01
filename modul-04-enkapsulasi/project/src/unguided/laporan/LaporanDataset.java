package unguided.laporan;

import unguided.model.Dataset;

public class LaporanDataset {
    public static void cetak(Dataset dataset) {
        String status = dataset.perluDibersihkan() ? "Perlu dibersihkan" : "Bersih";
        
        System.out.println("=== Laporan Dataset ===");
        System.out.println("Nama         : " + dataset.getNama());
        System.out.println("Jumlah Baris : " + dataset.getJumlahBaris());
        System.out.println("Jumlah Kolom : " + dataset.getJumlahKolom());
        System.out.printf("Missing      : %d sel (%.2f%%)\n", dataset.getJumlahMissing(), dataset.getPersentaseMissing());
        System.out.println("Status       : " + status);
        System.out.println();
    }
}