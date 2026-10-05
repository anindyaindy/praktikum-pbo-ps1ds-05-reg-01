package guided;

public class Rekening {
   private int saldo = 0;

    public void tambahsaldo (int jumlah) {
        saldo += jumlah;
        System.out.println("Saldo berhasil ditambahkan: " + saldo);
    }

    public void tampilkansaldo(){
        System.out.println("Saldo saat ini: " + saldo);
    }
}
