package project.guided.agregasi;

public class Jurusan {
    private static int jumlahMahasiswa;
    private String kodeJurusan, namaJurusan;
    private Mahasiswa[] daftarMahasiswa = new Mahasiswa[32];

    //contructor
    public Jurusan (String kodeJurusan, String namaJurusan){
        this.kodeJurusan = kodeJurusan;
        this.namaJurusan = namaJurusan;
    }

    //Behavior
    public void addMahasiswa(Mahasiswa m){
        this.daftarMahasiswa[jumlahMahasiswa] = m;
        jumlahMahasiswa++;
    }

    public void displayMahasiswa(){
        System.out.println("Kode Jurusan: " + this.kodeJurusan);
        System.out.println("Nama Jurusan: " + this.namaJurusan);

        System.out.println("Daftar Mahasiswa: ");

        for (int i = 0; i<jumlahMahasiswa;i++){
            System.out.println(i+1 + ". " + 
            daftarMahasiswa[i].getNim() + " "
            + daftarMahasiswa[i].getNama());
        }
    }

    //Getter
    public String getKodeJurusan(){
        return kodeJurusan;
    }
    
    public String getNamaJurusan(){
        return namaJurusan;
    }
    //Setter

    public void setKodeJurusan(String kodeJurusan){
        this.kodeJurusan = kodeJurusan;
    }

    public void setNamaJurusan(String namaJurusan){
        this.namaJurusan = namaJurusan;
    }

    public static void main(String[] args) {
        Jurusan j = new Jurusan("D3IF", "D3 Rekayasa Perangkat Lunak Aplikasi");
        Mahasiswa m1 = new Mahasiswa("6701", "Budi");
        Mahasiswa m2 = new Mahasiswa("6702", "Siti");

        j.addMahasiswa(m1);
        j.addMahasiswa(m2);

        j.displayMahasiswa();
    }
}
