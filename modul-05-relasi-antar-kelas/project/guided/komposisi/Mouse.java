package project.guided.komposisi;

public class Mouse {
    private String brand;
    private String tipe;
    
    public Mouse(String brand, String tipe) {
        this.brand = brand;
        this.tipe = tipe;
    }

    public void displaySpec() {
        System.out.println(this.brand + ", " + this.tipe);
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

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }
}