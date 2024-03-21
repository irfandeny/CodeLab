import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("Menu:");
            System.out.println("1. Tambah data mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            int choice = input.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Masukkan nama mahasiswa\t\t: ");
                    input.nextLine();
                    String nmMhs = input.nextLine();
                    System.out.print("Masukkan nim mahasiswa\t\t: ");
                    String nimMhs = input.nextLine();
                    while (nimMhs.length() != 15){
                        System.out.println("Nim Harus 15 Digit!!");
                        System.out.print("Masukkan NIM mahasiswa\t\t: ");
                        nimMhs = input.nextLine();
                    }
                    System.out.print("Masukkan jurusan mahasiwa\t: ");
                    String jurusanMhs = input.nextLine();
                    Mahasiswa.addDaftarMahasiswa(nmMhs, nimMhs, jurusanMhs);
                    break;
                case 2:
                    Mahasiswa.tampilDataMahasiswa();
                    break;
                case 3:
                    System.out.print("Keluar dari program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid.");
            }
        }
    }
}