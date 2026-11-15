# MODUL PRAKTIKUM: JAVA COLLECTION FRAMEWORK
**Mata Kuliah:** Pemrograman Berorientasi Objek  
**Modul:** 09 - Collection Framework (Iteration, Sorting, & Filtering)  
**Target Pembaca:** Praktikan / Mahasiswa  

---

## Capaian Pembelajaran
Setelah menyelesaikan modul praktikum ini, mahasiswa diharapkan mampu:
1. Memahami konsep struktur data dinamis menggunakan antarmuka Collection dan List.
2. Menerapkan Generics untuk mencegah galat runtime (type safety).
3. Menguasai 5 variasi teknik iterasi/traversal data pada koleksi Java.
4. Membedakan serta mengimplementasikan pengurutan bawaan (Comparable) dan pengurutan fleksibel (Comparator).
5. Menyaring (filtering) dan mencari (searching) data koleksi menggunakan pendekatan imperatif (loop konvensional) serta deklaratif (Java Stream API).

---

## Pembagian Package Proyek
Praktikum ini dibagi ke dalam 3 package modular:
* package `iteration`: Berisi kelas `MainIteration.java`
* package `sorting`: Berisi kelas `Employee.java`, `SalaryComparator.java`, dan `MainSort.java`
* package `filtering`: Berisi kelas `Mahasiswa.java` dan `MainFilter.java`

---

## BAGIAN 1: Package iteration (Traversal & Type Safety)

### 1.1 Konsep Singkat
* **Generics (`<T>`):** Menentukan tipe objek spesifik yang boleh masuk ke dalam list. Tanpa generics, list akan menampung `Object` mentah (raw type), sehingga rentan memicu `ClassCastException`.
* **Prinsip Polimorfisme:** Deklarasi dianjurkan menggunakan interface sebagai tipe referensi:
  ```java
  List<String> list = new ArrayList<>(); // Dianjurkan
  // ArrayList<String> list = new ArrayList<>(); // Kurang fleksibel
  ```

### 1.2 Langkah Pengerjaan
Buat berkas `MainIteration.java` pada package `iteration`, lalu ketik kode berikut:

```java
package iteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainIteration {
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
```

### 1.3 Expected Output
```text
Total elemen: 4
Apakah ada 'Mangga'? true

--- 1. Normal For-Loop (Indeks) ---
Index 0: Apel
Index 1: Mangga
Index 2: Jeruk

--- 2. Enhanced For-Loop (For-each) ---
Apel
Mangga
Jeruk

--- 3. Menggunakan Iterator ---
Apel
Mangga
Jeruk

--- 4. Lambda Expression ---
Apel
Mangga
Jeruk

--- 5. Method Reference ---
Apel
Mangga
Jeruk
```

> **Catatan Kritis:**  
> Jika Anda perlu menghapus elemen di tengah perulangan, jangan gunakan for-each atau for-loop biasa secara langsung karena akan memicu `ConcurrentModificationException`. Gunakan `Iterator` dengan method bawaannya: `itr.remove()`.

---

## BAGIAN 2: Package sorting (Comparable vs Comparator)

### 2.1 Konsep Singkat
* **`Comparable<T>` (Natural Ordering):** 
  Diimplementasikan langsung pada kelas data (internal). Digunakan untuk mendefinisikan satu aturan urutan baku (default). Method wajib: `compareTo(T other)`.
* **`Comparator<T>` (Custom Ordering):** 
  Dibuat pada kelas terpisah (eksternal). Digunakan jika membutuhkan beragam skenario urutan tanpa mengubah kelas aslinya. Method wajib: `compare(T o1, T o2)`.
* **Kontrak Nilai Kembalian:**
  * Nilai negatif ($< 0$): Objek pertama diletakkan sebelum objek kedua.
  * Nilai nol ($0$): Kedua objek dianggap setara.
  * Nilai positif ($> 0$): Objek pertama diletakkan setelah objek kedua.

### 2.2 Langkah Pengerjaan

#### Langkah 1: Buat Model `Employee.java`
Implementasikan antarmuka `Comparable<Employee>` untuk mengurutkan nama secara alfabetis (A-Z).

```java
package sorting;

public class Employee implements Comparable<Employee> {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    // Default sorting: Berdasarkan nama (A-Z)
    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return String.format("Employee[name=%-6s, salary=%d]", name, salary);
    }
}
```

#### Langkah 2: Buat Comparator `SalaryComparator.java`
Buat strategi pengurutan kustom berdasarkan nominal gaji terkecil ke terbesar (ascending).

```java
package sorting;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getSalary(), e2.getSalary());
    }
}
```

#### Langkah 3: Eksekusi pada `MainSort.java`
```java
package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainSort {
    public static void main(String[] args) {
        List<Employee> listEmp = new ArrayList<>();
        listEmp.add(new Employee("Bobby", 3000));
        listEmp.add(new Employee("Erick", 1600));
        listEmp.add(new Employee("Rey", 2500));
        listEmp.add(new Employee("Anna", 3500));

        System.out.println("--- Data Awal ---");
        listEmp.forEach(System.out::println);

        // Sorting 1: Natural Order via Comparable (compareTo)
        Collections.sort(listEmp);
        System.out.println("\n--- Sorted by Name (Comparable / Natural Order) ---");
        listEmp.forEach(System.out::println);

        // Sorting 2: Custom Order via Comparator (compare)
        Collections.sort(listEmp, new SalaryComparator());
        System.out.println("\n--- Sorted by Salary (Comparator / Custom Order) ---");
        listEmp.forEach(System.out::println);
    }
}
```

### 2.3 Expected Output
```text
--- Data Awal ---
Employee[name=Bobby , salary=3000]
Employee[name=Erick , salary=1600]
Employee[name=Rey   , salary=2500]
Employee[name=Anna  , salary=3500]

--- Sorted by Name (Comparable / Natural Order) ---
Employee[name=Anna  , salary=3500]
Employee[name=Bobby , salary=3000]
Employee[name=Erick , salary=1600]
Employee[name=Rey   , salary=2500]

--- Sorted by Salary (Comparator / Custom Order) ---
Employee[name=Erick , salary=1600]
Employee[name=Rey   , salary=2500]
Employee[name=Bobby , salary=3000]
Employee[name=Anna  , salary=3500]
```

---

## BAGIAN 3: Package filtering (Imperatif vs Stream API)

### 3.1 Konsep Singkat
* **Pendekatan Imperatif:** Menulis instruksi bagaimana data diproses secara rinci langkah demi langkah (menggunakan list manual, percabangan if, dan loop).
* **Pendekatan Deklaratif (Stream API):** Menulis instruksi apa hasil akhir yang diinginkan lewat serangkaian pipeline operasi:
  $$\text{Source} \rightarrow \text{Intermediate Operation } (\text{filter}) \rightarrow \text{Terminal Operation } (\text{collect / findFirst})$$
* **Sifat Lazy:** Intermediate operation pada Stream tidak akan dieksekusi sebelum ada terminal operation yang memicu pengaliran data.
* **Null-Safety:** Metode `orElse(null)` menangani data bertipe Optional agar terhindar dari potensi galat saat hasil pencarian tidak ditemukan.

### 3.2 Langkah Pengerjaan

#### Langkah 1: Buat Model `Mahasiswa.java`
```java
package filtering;

public class Mahasiswa {
    private String nim;
    private String nama;
    private double ipk;

    public Mahasiswa(String nim, String nama, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public double getIpk() {
        return ipk;
    }

    @Override
    public String toString() {
        return String.format("Mhs[NIM=%s, Nama=%-6s, IPK=%.2f]", nim, nama, ipk);
    }
}
```

#### Langkah 2: Buat Eksekusi pada `MainFilter.java`
```java
package filtering;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainFilter {
    public static void main(String[] args) {
        List<Mahasiswa> list = new ArrayList<>();
        list.add(new Mahasiswa("001", "Bobby", 3.25));
        list.add(new Mahasiswa("002", "Erick", 2.80));
        list.add(new Mahasiswa("003", "Rey", 3.75));
        list.add(new Mahasiswa("004", "Anna", 3.90));

        System.out.println("=== 1. FILTERING (IPK >= 3.50) ===");

        // --- Pendekatan 1: Imperatif (Konvensional) ---
        System.out.println("Cara Konvensional:");
        List<Mahasiswa> mhsCumlaudeKonven = new ArrayList<>();
        for (Mahasiswa m : list) {
            if (m.getIpk() >= 3.50) {
                mhsCumlaudeKonven.add(m);
            }
        }
        for (Mahasiswa m : mhsCumlaudeKonven) {
            System.out.println(m);
        }

        // --- Pendekatan 2: Deklaratif (Stream API) ---
        System.out.println("\nCara Stream API:");
        List<Mahasiswa> mhsCumlaudeStream = list.stream()
                .filter(m -> m.getIpk() >= 3.50)
                .collect(Collectors.toList());
        mhsCumlaudeStream.forEach(System.out::println);

        System.out.println("\n=== 2. SEARCHING / PENCARIAN TUNGGAL ===");

        // --- Pencarian Konvensional ---
        System.out.println("Cara Konvensional (Cari 'Erick'):");
        Mahasiswa targetKonven = null;
        for (Mahasiswa m : list) {
            if (m.getNama().equalsIgnoreCase("Erick")) {
                targetKonven = m;
                break; // Hentikan loop saat ditemukan
            }
        }
        System.out.println(targetKonven != null ? targetKonven : "Data tidak ditemukan");

        // --- Pencarian via Stream API ---
        System.out.println("\nCara Stream API (Cari 'Erick'):");
        Mahasiswa targetStream = list.stream()
                .filter(m -> m.getNama().equalsIgnoreCase("Erick"))
                .findFirst()
                .orElse(null);
        System.out.println(targetStream != null ? targetStream : "Data tidak ditemukan");
    }
}
```

### 3.3 Expected Output
```text
=== 1. FILTERING (IPK >= 3.50) ===
Cara Konvensional:
Mhs[NIM=003   , Nama=Rey   , IPK=3.75]
Mhs[NIM=004   , Nama=Anna  , IPK=3.90]

Cara Stream API:
Mhs[NIM=003   , Nama=Rey   , IPK=3.75]
Mhs[NIM=004   , Nama=Anna  , IPK=3.90]

=== 2. SEARCHING / PENCARIAN TUNGGAL ===
Cara Konvensional (Cari 'Erick'):
Mhs[NIM=002   , Nama=Erick , IPK=2.80]

Cara Stream API (Cari 'Erick'):
Mhs[NIM=002   , Nama=Erick , IPK=2.80]
```