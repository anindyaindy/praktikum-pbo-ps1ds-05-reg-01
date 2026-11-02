# Cinema POS Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Menyelesaikan empat tugas unguided Modul 7 sesuai spesifikasi pengguna.

**Architecture:** Package baru `com.indy.unguided` mengikuti namespace Maven yang sudah ada. `TiketBioskop` mengimplementasikan `ItemTransaksi`, sedangkan `PaketSnack` mengimplementasikan kontrak yang sama secara independen. `Main` memproses ketiganya melalui array `ItemTransaksi[]`.

**Tech Stack:** Java standar, kompatibel dengan Java 8+, tanpa dependensi tambahan.

**Spec:** Soal Unguided Modul 7 pada pesan pengguna dalam percakapan ini.

## Global Constraints

- Enam file Java berada di `project/guided/src/main/java/com/indy/unguided/`, dengan deklarasi `package com.indy.unguided;` pada baris pertama.
- Seluruh field private; akses dari luar melalui getter. Parameter constructor sama dengan field, dengan assignment melalui `this`.
- Constructor subclass memanggil `super`; biaya VIP dikenakan per kursi.
- Gunakan array standar, tanpa koleksi dinamis, casting, atau percabangan berdasarkan jenis item.
- Pertahankan format struk dan data transaksi persis seperti soal, termasuk komentar instansiasi kelas abstrak.

## Review Focus

- Biaya VIP harus menghasilkan Rp170000.0 untuk dua kursi.
- `getNominalBayar()` pada tiket harus mendelegasikan ke `hitungTotalBayar()`.
- Default method mengambil nama dan nominal melalui kontrak interface.
- `PaketSnack` tidak mewarisi `TiketBioskop`.
- Output contoh menghasilkan grand total Rp305000.0 dan kedua log kasir.

## Task 1: Implementasi package dan verifikasi struk

**Files:** Buat `ItemTransaksi.java`, `TiketBioskop.java`, `TiketReguler.java`, `TiketVIP.java`, `PaketSnack.java`, dan `Main.java` di direktori package tersebut.

**Interfaces:** Kontrak publik `double getNominalBayar()`, `String getNamaTransaksi()`, `default void cetakRincianItem()`, dan `static void catatLogKasir(String pesan)`. Kelas abstrak menyediakan tiga getter dan `public abstract double hitungTotalBayar()`; semua atribut tambahan juga memiliki getter.

- [x] Buat enam file sesuai spesifikasi tanpa mengubah kode guided yang sudah ada.
- [x] Kompilasi semua source dengan `javac --release 8 -encoding UTF-8 -Xlint:all -Xlint:-options` ke direktori terabaikan `project/guided/target/unguided-check`.
- [x] Jalankan `com.indy.unguided.Main` dan bandingkan seluruh output dengan contoh pengguna.
- [x] Tinjau keenam file terhadap ketentuan enkapsulasi, abstraksi, interface, dan array heterogen.

**Execution notes:** Kerjakan langsung di workspace yang diminta. Perubahan ini menambah package tugas praktikum; verifikasi memakai kompilasi dan perbandingan output, tanpa framework pengujian tambahan. Maven tidak tersedia pada PATH, sehingga gunakan JDK yang terpasang. Jangan membuat commit atau mengubah file pengguna yang sudah ada.

**Verification:** Seluruh 20 source Java berhasil dikompilasi dengan target Java 8 tanpa error atau warning. Kesembilan baris output cocok dengan contoh, termasuk total `Rp305000.0`. Review independen tidak menemukan masalah. Perilaku input di luar skenario contoh tidak ditambahkan karena soal menentukan data transaksi dan rumus secara eksplisit.
