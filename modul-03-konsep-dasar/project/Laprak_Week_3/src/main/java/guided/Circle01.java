package guided;

public class Circle01 {
    public static final double PI = 3.14;

    public static double radiansToDegrees(double rads) {
        return rads * (180 / PI);
    }
 
    public double r;

    public double area() {
        return PI * r * r;
    }

    public double circumference() {
        return 2 * PI * r;
    }
    
}
