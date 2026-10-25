package unguided;

public class Regresi extends ModelDasar {
    private final int banyakFitur;

    public Regresi(String nama, int dataTraining, int fitur) {
        super(nama, dataTraining);
        this.banyakFitur = fitur;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.printf("Jumlah fitur: %d%n", banyakFitur);
    }

    @Override
    public int estimasiBiaya() {
        int tambahanFitur = banyakFitur * 10;
        return super.estimasiBiaya() + tambahanFitur;
    }

    public int estimasiBiaya(int jumlahEpoch, int ukuranBatch) {
        return super.estimasiBiaya(jumlahEpoch) / ukuranBatch;
    }
}
