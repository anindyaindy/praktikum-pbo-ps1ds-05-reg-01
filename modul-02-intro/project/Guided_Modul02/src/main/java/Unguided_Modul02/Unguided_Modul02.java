package Unguided_Modul02;

public class Unguided_Modul02 {
    public static void main(String[] args) {
        final double KKM = 75.0;

        String[] nama = {"Calya", "Isna", "Balqis"};
        double[][] nilai = {
            {70.0, 75.0},
            {70.0, 85.0},
            {85.0, 90.0}
        };

        System.out.println("REKAP NILAI PRAKTIKUM");
        System.out.println("KKM: " + KKM);

        for (int i = 0; i < nama.length; i++) {
            double rataRata = (nilai[i][0] + nilai[i][1]) / 2.0;

            String status;
            if (rataRata >= KKM) {
                status = "LULUS";
            } else {
                status = "REMEDIAL";
            }

            System.out.println();
            System.out.println("Mahasiswa " + (i + 1) + ": " + nama[i]);
            System.out.println("Nilai Modul 1 : " + nilai[i][0]);
            System.out.println("Nilai Modul 2 : " + nilai[i][1]);
            System.out.println("Rata-rata     : " + rataRata);
            System.out.println("Status        : " + status);
        }
    }
}