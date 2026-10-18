package project.guided.komposisi;

public class Main {
    public static void main(String[] args) {
        // Membuat objek Komputer. 
        // Secara otomatis objek Processor, Monitor, dan Mouse akan di-instansiasi di dalam constructor (Komposisi).
        Komputer komputerku = new Komputer("Intel Core i7", 3800, "ASUS", "Logitech", "Wireless");

        // Menampilkan spesifikasi komputer beserta komponen di dalamnya
        komputerku.displaySpecKomputer();
    }
}