package guided3.iteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Inisialisasi List bertipe String
        List<String> listBuah = new ArrayList<>();

        // 2. Menambah elemen ke dalam List
        listBuah.add("Apel");
        listBuah.add("Mangga");
        listBuah.add("Jeruk");
        listBuah.add("Pisang");

        // 3. Operasi utilitas List
        System.out.println("Total elemen: " + listBuah.size());
        System.out.println("Apakah ada 'Mangga'? " + listBuah.contains("Mangga"));

        // Menghapus data
        listBuah.remove("Pisang");

        // --- TEKNIK 1: For-Loop Tradisional (Indeks) ---
        System.out.println("\n--- 1. Normal For-Loop (Indeks) ---");
        for (int i = 0; i < listBuah.size(); i++) {
            System.out.println("Index " + i + ": " + listBuah.get(i));
        }

        // --- TEKNIK 2: Enhanced For-Loop (For-Each) ---
        System.out.println("\n--- 2. Enhanced For-Loop (For-each) ---");
        for (String buah : listBuah) {
            System.out.println(buah);
        }

        // --- TEKNIK 3: Iterator Interface ---
        System.out.println("\n--- 3. Menggunakan Iterator ---");
        Iterator<String> itr = listBuah.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // --- TEKNIK 4: Lambda Expression (Java 8+) ---
        System.out.println("\n--- 4. Lambda Expression ---");
        listBuah.forEach(item -> System.out.println(item));

        // --- TEKNIK 5: Method Reference (Java 8+) ---
        System.out.println("\n--- 5. Method Reference ---");
        listBuah.forEach(System.out::println);
    }
}