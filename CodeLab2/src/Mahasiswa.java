import java.util.ArrayList;

public class Mahasiswa{
    String nama, nim, jurusan;

    Mahasiswa(String nama, String nim, String jurusan){
        this.nama=nama;
        this.nim=nim;
        this.jurusan=jurusan;
    }

    static String tampilUniversitas(){
        return "Universitas Muhammadiyah Malang";
    }

    static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public static void addDaftarMahasiswa(String nama, String nim, String jurusan){
        Mahasiswa mhswBaru = new Mahasiswa(nama, nim, jurusan);
        daftarMahasiswa.add(mhswBaru);
        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }

    public static void tampilDataMahasiswa() {
        System.out.println("Data Mahasiswa:");
        System.out.println("Universitas: " + tampilUniversitas());
        for (Mahasiswa mhs : daftarMahasiswa) {
            System.out.println("Nama: " + mhs.nama + ", NIM: " + mhs.nim + ", Jurusan: " + mhs.jurusan);
        }
    }
}