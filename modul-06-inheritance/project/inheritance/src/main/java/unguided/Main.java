package unguided;

public class Main {
    public static void main(String[] args) {
        Regresi regresiLinear = new Regresi("Regresi Linier", 500, 4);

        ModelDasar[] daftarUji = new ModelDasar[3];
        daftarUji[0] = regresiLinear;
        daftarUji[1] = new Klasifikasi("Decision Tree", 800, 3);
        daftarUji[2] = new DeepLearning("Neural Network", 1000, 5, 3);

        int biayaKeseluruhan = 0;
        for (int posisi = 0; posisi < daftarUji.length; posisi++) {
            ModelDasar modelAktif = daftarUji[posisi];
            modelAktif.cetakInfo();

            int biayaModel = modelAktif.estimasiBiaya();
            biayaKeseluruhan += biayaModel;
            System.out.printf("Biaya komputasi: %d%n---%n", biayaModel);
        }

        System.out.printf("Total biaya: %d%n", biayaKeseluruhan);

        int epochUji = 10;
        int ukuranKelompok = 50;
        System.out.printf("Biaya %d epoch (Neural Network): %d%n",
                epochUji, daftarUji[2].estimasiBiaya(epochUji));
        System.out.printf("Biaya %d epoch (Regresi Linier): %d%n",
                epochUji, regresiLinear.estimasiBiaya(epochUji));
        System.out.printf("Biaya %d epoch batch %d (Regresi Linier): %d%n",
                epochUji, ukuranKelompok, regresiLinear.estimasiBiaya(epochUji, ukuranKelompok));
    }
}
