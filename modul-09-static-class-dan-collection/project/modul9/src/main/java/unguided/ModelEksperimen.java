package unguided;

public class ModelEksperimen implements Comparable<ModelEksperimen> {
    private String namaModel;
    private double akurasi;
    private int waktuTraining;

    // Static variable untuk menghitung jumlah eksperimen yang dibuat
    private static int jumlahEksperimen = 0;

    // Constructor
    public ModelEksperimen(String namaModel, double akurasi, int waktuTraining) {
        this.namaModel = namaModel;
        this.akurasi = akurasi;
        this.waktuTraining = waktuTraining;
        jumlahEksperimen++; // Bertambah setiap kali objek baru dibuat
    }

    // Getter
    public String getNamaModel() {
        return namaModel;
    }

    public double getAkurasi() {
        return akurasi;
    }

    public int getWaktuTraining() {
        return waktuTraining;
    }

    // Static method untuk mengambil nilai jumlah eksperimen
    public static int getJumlahEksperimen() {
        return jumlahEksperimen;
    }

    @Override
    public String toString() {
        return "Model=" + namaModel + ", akurasi=" + akurasi + ", waktu=" + waktuTraining + " detik";
    }

    @Override
    public int compareTo(ModelEksperimen o) {
        // Mengurutkan berdasarkan akurasi dari yang tertinggi ke terendah (Descending)
        return Double.compare(o.akurasi, this.akurasi);
    }
}