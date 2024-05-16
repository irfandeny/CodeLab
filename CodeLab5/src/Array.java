import java.util.ArrayList;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> namaMahasiswa = new ArrayList<>();

        int i = 1;
        while (true) {
            System.out.print("Masukkan nama ke-" + i + ": ");
            String nama = scanner.nextLine();

            if (nama.trim().isEmpty()) {
                try {
                    throw new IllegalArgumentException("Nama tidak boleh kosong");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }
            if (nama.equalsIgnoreCase("selesai")) {
                break;
            }
            namaMahasiswa.add(nama);
            i++;
        }

        System.out.println("\nDaftar mahasiswa yang diinputkan:");
        for (String nama : namaMahasiswa) {
            System.out.println(nama);
        }
    }    
}