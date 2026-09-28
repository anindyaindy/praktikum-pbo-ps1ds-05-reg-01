package Guided_Modul02;

public class Array2NonRectangular {
    public static void main(String[] args) {
        int twoDim[][] = new int[2][];
        twoDim[0] = new int[2];
        twoDim[1] = new int[3];

        twoDim[0][0] = 1;
        twoDim[0][1] = 4;
        twoDim[1][0] = 1;
        twoDim[1][1] = 4;
        twoDim[1][2] = 4;

        System.out.println(twoDim[0][0]);
        System.out.println(twoDim[0][1]);
        System.out.println(twoDim[1][0]);
        System.out.println(twoDim[1][1]);
        System.out.println(twoDim[1][2]);
    }
}