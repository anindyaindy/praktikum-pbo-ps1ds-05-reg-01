package project.guided1.main;

import project.guided1.Manusia.Manusia;

public class DemoManusia {
    public static void main(String[] args){
        Manusia arrMns[] = new Manusia[3];

        Manusia objMns1 = new Manusia();

        // kedua
        Manusia objMns2 = new Manusia("John");

        // ketiga
        Manusia objMns3 = new Manusia("Sean", 44);

        arrMns[0] = objMns1;
        arrMns[1] = objMns2;
        arrMns[2] = objMns3;

        for (int i =0; i<3; i++) {
            System.out.println("Nama: " + arrMns[i].getNama());
            System.out.println("Umur: " + arrMns[i].getUmur());
            System.out.println();
        }
    }
}
