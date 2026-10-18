package project.guided.komposisi;

public class Monitor {
    private String brand;
    
    public Monitor(String brand) {
        this.brand = brand;
    }

    public void displaySpec() {
        System.out.println(this.brand);
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
}