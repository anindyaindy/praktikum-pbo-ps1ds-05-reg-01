package project.guided.komposisi;

public class Processor {
    private String brand;
    private int kecepatan;

    public Processor(String brand, int kecepatan) {
        this.brand = brand;
        this.kecepatan = kecepatan;
    }

    public void displaySpec() {
        System.out.println(this.brand + " " + this.kecepatan);
    }

    public void DisplaySpec() {
        displaySpec();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getKecepatan() {
        return kecepatan;
    }

    public void setKecepatan(int kecepatan) {
        this.kecepatan = kecepatan;
    }
}
