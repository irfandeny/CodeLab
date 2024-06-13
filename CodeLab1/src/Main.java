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

public class PalindromeChecker {
    static boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "radar";
        System.out.println("Is " + word + " a palindrome? " + isPalindrome(word));
    }
}

public class Bintang {
    public static void main(String[] args){
        int angka [] = {1,2,3,4,5};

        for (int i = 0; i < angka.length;i++){

            StringBuilder result = new StringBuilder();
            for (int j = 1; j <= angka[i] ; j++){
            result.append(j);
        }
        int bintang = 5 - angka[i];
            for (int k = 0; k < bintang; k++){
                result.append("*");
            }
            System.out.println(result);
        }




    }
}
