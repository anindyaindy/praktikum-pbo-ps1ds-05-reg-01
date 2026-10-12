package unguided.model;

public class Dataset {
    private String nama;
    private int jumlahBaris;
    private int jumlahKolom;
    private int jumlahMissing;

    public static final double BATAS_MISSING = 5.0;
    private static int totalDataset = 0;

    public Dataset() {
        this.nama = "Tidak diketahui";
        this.jumlahBaris = 0;
        this.jumlahKolom = 0;
        this.jumlahMissing = 0;
        totalDataset++;
    }

    public Dataset(String nama) {
        this.nama = nama;
        this.jumlahBaris = 0;
        this.jumlahKolom = 0;
        this.jumlahMissing = 0;
        totalDataset++;
    }

    public Dataset(String nama, int jumlahBaris, int jumlahKolom, int jumlahMissing) {
        this.nama = nama;
        this.jumlahBaris = jumlahBaris;
        this.jumlahKolom = jumlahKolom;
        this.jumlahMissing = jumlahMissing;
        totalDataset++;
    }

    public static int getTotalDataset() {
        return totalDataset;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlahBaris() {
        return jumlahBaris;
    }

    public void setJumlahBaris(int jumlahBaris) {
        if (jumlahBaris >= 0) {
            this.jumlahBaris = jumlahBaris;
        }
    }

    public int getJumlahKolom() {
        return jumlahKolom;
    }

    public void setJumlahKolom(int jumlahKolom) {
        if (jumlahKolom >= 0) {
            this.jumlahKolom = jumlahKolom;
        }
    }

    public int getJumlahMissing() {
        return jumlahMissing;
    }

    public void setJumlahMissing(int jumlahMissing) {
        if (jumlahMissing >= 0) {
            this.jumlahMissing = jumlahMissing;
        }
    }

    public double getPersentaseMissing() {
        int totalSel = jumlahBaris * jumlahKolom;
        if (totalSel == 0) {
            return 0.0;
        }
        return ((double) jumlahMissing / totalSel) * 100.0;
    }

    public boolean perluDibersihkan() {
        return getPersentaseMissing() > BATAS_MISSING;
    }
}