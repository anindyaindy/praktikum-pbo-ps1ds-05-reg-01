package Guided_Modul02;

public class SwitchCase {
    public static void main(String[] args) {
        int hari = 7;
        String hariString;

        switch (hari) {
            case 1:  hariString = "Senin"; break;
            case 2:  hariString = "Selasa"; break;
            case 3:  hariString = "Rabu"; break;
            case 4:  hariString = "Kamis"; break;
            case 5:  hariString = "Jumat"; break;
            case 6:  hariString = "Sabtu"; break;
            case 7:  hariString = "Minggu"; break;
            default: hariString = "Invalid month"; break;
        }
        System.out.println(hariString);

        int a = 4;
        int b = 5;
        int nilai = 3 > 2 ? a : b;
        System.out.println("nilai = " + nilai);
    }
}