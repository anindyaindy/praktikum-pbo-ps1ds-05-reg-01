package unguided;

public class DeepLearning extends Klasifikasi {
    private final int totalLayer;

    public DeepLearning(String nama, int dataTraining, int kelas, int layer) {
        super(nama, dataTraining, kelas);
        this.totalLayer = layer;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.printf("Jumlah layer: %d%n", totalLayer);
    }

    @Override
    public int estimasiBiaya() {
        int biayaKlasifikasi = super.estimasiBiaya();
        int tambahanLayer = totalLayer * 200;
        return biayaKlasifikasi + tambahanLayer;
    }
}
