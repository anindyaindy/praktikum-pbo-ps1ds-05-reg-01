package project.guided2.main;

import project.guided2.HargaToken.HargaToken;
import project.guided2.HargaPulsa.HargaPulsa;

public class Main {
    public static void main(String[] args){
        HargaToken objectToken = new HargaToken();
        objectToken.info();

        HargaPulsa objectPulsa = new HargaPulsa();
        objectPulsa.info();
    }
}