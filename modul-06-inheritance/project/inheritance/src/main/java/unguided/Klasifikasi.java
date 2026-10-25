package unguided;

public class Klasifikasi extends ModelDasar {
    private final int banyakKelas;

    public Klasifikasi(String nama, int dataTraining, int kelas) {
        super(nama, dataTraining);
        this.banyakKelas = kelas;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.printf("Jumlah kelas: %d%n", banyakKelas);
    }

    @Override
    public int estimasiBiaya() {
        return super.estimasiBiaya() * banyakKelas;
    }
}
