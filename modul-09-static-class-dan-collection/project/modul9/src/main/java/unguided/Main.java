package unguided;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 5. Menyimpan data ke dalam List menggunakan generics
        List<ModelEksperimen> listEksperimen = new ArrayList<>();
        listEksperimen.add(new ModelEksperimen("Logistic Regression", 0.82, 12));
        listEksperimen.add(new ModelEksperimen("Random Forest", 0.91, 45));
        listEksperimen.add(new ModelEksperimen("SVM", 0.87, 60));
        listEksperimen.add(new ModelEksperimen("KNN", 0.79, 5));
        listEksperimen.add(new ModelEksperimen("Decision Tree", 0.84, 8));

        // 6.1. Tampilkan jumlah eksperimen yang tercatat menggunakan static method
        System.out.println("Jumlah eksperimen: " + ModelEksperimen.getJumlahEksperimen());

        // 6.2. Daftar model yang diurutkan berdasarkan akurasi tertinggi (Comparable)
        System.out.println("\nSorted by akurasi");
        Collections.sort(listEksperimen);
        listEksperimen.forEach(System.out::println);

        // 6.3. Daftar model yang diurutkan berdasarkan waktu training tercepat (Comparator)
        System.out.println("\nSorted by waktu training");
        Collections.sort(listEksperimen, new WaktuComparator());
        listEksperimen.forEach(System.out::println);

        // 6.4. Daftar model dengan akurasi minimal 0.85 (filtering menggunakan ekspresi lambda)
        System.out.println("\nModel dengan akurasi minimal 0.85");
        List<ModelEksperimen> filteredAkurasi = listEksperimen.stream()
                .filter(e -> e.getAkurasi() >= 0.85)
                .collect(Collectors.toList());
        filteredAkurasi.forEach(System.out::println);

        // 6.5. Data model dengan nama "KNN" (pencarian menggunakan ekspresi lambda, null jika tidak ada)
        System.out.println("\nPencarian model KNN");
        ModelEksperimen hasilKNN = listEksperimen.stream()
                .filter(e -> e.getNamaModel().equals("KNN"))
                .findFirst()
                .orElse(null);
        System.out.println(hasilKNN);
    }
}