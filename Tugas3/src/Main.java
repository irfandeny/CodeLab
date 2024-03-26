import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public  ArrayList<Buku> bookList;
    private ArrayList<Student> userStudent = new ArrayList<>();
    private final Scanner scanner;
    private final Admin admin;

    public Main() {
        scanner = new Scanner(System.in);

        // Inisialisasi daftar buku

        admin = new Admin(userStudent);

        // Inisialisasi daftar user student
        userStudent = new ArrayList<>();
        userStudent.add(new Student("Keysya", "202310370311363", "Teknik", "Informatika"));
        userStudent.add(new Student("Irfan", "202310370311377", "Teknik", "Informatika"));
        userStudent.add(new Student("yazid", "202310370310964", "Teknik", "Informatika"));

    }
    //method menu
    public void menu(Scanner input) {
        Admin loga = new Admin();
        boolean selesai = false;
        while (!selesai) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Pilihan Opsi (1-3): ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    masukanNim();
                    break;
                case 2:
                    loga.loginAdmin();
                    break;
                case 3:
                    selesai = true;
                    System.out.println("Program selesai, Exit program");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }
        }
    }
    //method masukannim
    public void masukanNim() {
        System.out.print("Enter your NIM : ");
        String nim = scanner.nextLine();
        cekNim(nim);
    }
    //method ceknim
    public void cekNim(String nim) {
        Student murid = new Student();
        for (Student student : userStudent) {
            if (student.getNim().equals(nim)) {
                murid.displayInfo(student);
                murid.displayBook();
                menuStudent();
                return;
            }
        }
        System.out.println("NIM tidak ditemukan, silakan coba lagi");
    }
    //method menu student
    public void menuStudent() {
        Scanner input = new Scanner(System.in);
        Student tam = new Student();
        boolean selesai = false;
        while (!selesai) {
            System.out.println("===== Student Menu =====");
            System.out.println("1. Tampilkan Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Tampilkan Buku yang dipinjam");
            System.out.println("4. Kembalikan buku");
            System.out.println("5. Logout");
            System.out.print("Pilihan Opsi (1-5): ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    tam.displayBook();
                    break;
                case 2:
                    tam.pinjamBuku();
                    break;
                case 3:
                    tam.tampilBukuTerpinjam();
                    break;
                case 4:
                    tam.returnBooks();
                    break;
                case 5:
                    selesai = true;
                    tam.logout();
                    System.out.println("from student menu");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }
        }
    }
    //method menu admin
    public void menuAdmin() {
        Scanner input = new Scanner(System.in);
        boolean selesai = false;
        while (!selesai) {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Tampilkan Daftar Buku");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("5. Tambah Mahasiswa");
            System.out.println("6. Log out");
            System.out.print("Pilihan Opsi (1-6): ");
            int pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    tambahBuku();
                    break;
                case 2:
                    hapusBuku();
                    break;
                case 3:
                    tampilkanDaftarBuku();
                    break;
                case 4:
                    admin.tampilkanDaftarMahasiswa();
                    break;
                case 5:
                    admin.addStudent();
                    break;
                case 6:
                    selesai = true;
                    System.out.println("Logging out... from admin menu");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }
        }
    }
    //method tambah buku
    public void tambahBuku() {
        System.out.print("Masukkan ID buku: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan penulis buku: ");
        String penulis = scanner.nextLine();
        System.out.print("Masukkan kategori buku: ");
        String kategori = scanner.nextLine();
        System.out.print("Masukkan stok buku: ");
        int stok = scanner.nextInt();
        Buku bukuBaru = new Buku(id, judul, penulis, kategori, stok);
        bookList.add(bukuBaru);
    }
    //method hapus buku
    public void hapusBuku() {
        System.out.print("Masukkan ID buku yang ingin dihapus: ");
        String id = scanner.nextLine();
        for (Buku buku : bookList) {
            if (buku.getId().equals(id)) {
                bookList.remove(buku);
                System.out.println("Buku berhasil dihapus");
                return;
            }
        }
        System.out.println("Buku tidak ditemukan");
    }
    //method tampilkan daftar buku
    public void tampilkanDaftarBuku() {
        System.out.println("===== Daftar Buku =====");
        for (Buku buku : bookList) {
            System.out.println(buku.getId() + "\t||\t" + buku.getTitle() + "\t||\t" + buku.getAuthor() + "\t||\t" + buku.getCategory() + "\t||\t" + buku.getStock());
        }
    }
    //method utama
    public static void main(String[] args) {
        System.out.println("SELAMAT DATANG");
        Main lib = new Main();
        Scanner input = new Scanner(System.in);
        lib.menu(input);
        input.close();
    }
}