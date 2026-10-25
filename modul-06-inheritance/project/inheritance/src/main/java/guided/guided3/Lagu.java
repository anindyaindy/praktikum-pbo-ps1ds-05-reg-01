package guided.guided3;

public class Lagu {
    String pencipta;
    String judul;

    void IsiParam(String param){
        judul = param;
        pencipta = "Tidak dikenal";
    }

    void IsiParam(String param1, String param2){
        judul = param1;
        pencipta = param2;
    }

    void tampilkan(){
        System.out.println("Judul: "+ judul + ", pencipta: "+ pencipta);
    }
}
