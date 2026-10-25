package unguided;

public class ModelDasar {
    private final String identitasModel;
    private final int totalData;

    public ModelDasar(String nama, int dataTraining) {
        this.identitasModel = nama;
        this.totalData = dataTraining;
    }

    public int getTotalData() {
        return totalData;
    }

    public void cetakInfo() {
        System.out.printf("Model: %s | Data latih: %d%n", identitasModel, totalData);
    }

    public int estimasiBiaya() {
        return totalData * 2;
    }

    public int estimasiBiaya(int jumlahEpoch) {
        return totalData * jumlahEpoch;
    }
}
