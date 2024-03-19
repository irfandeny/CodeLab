import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nama: ");
        String nama = input.nextLine();

        System.out.print("Jenis Kelamin (L/P): ");
        String genderInput = input.nextLine();
        String gender;
        if (genderInput.equalsIgnoreCase("L")) {
            gender = "Laki-laki";
        } else if (genderInput.equalsIgnoreCase("P")) {
            gender = "Perempuan";
        } else {
            System.out.println("Jenis kelamin tidak valid.");
            return;
        }

        System.out.print("Tanggal Lahir (yyyy-mm-dd): ");
        String ttlinput = input.nextLine();
        LocalDate tanggalLahir = LocalDate.parse(ttlinput);

        LocalDate tanggalSekarang = LocalDate.now();
        Period periode = Period.between(tanggalLahir, tanggalSekarang);

        System.out.println("\n-----------------------------------");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + gender);
        System.out.println("Umur Anda: " + periode.getYears() + " tahun " + periode.getMonths() + " bulan " + periode.getDays() + " hari");
    }
}