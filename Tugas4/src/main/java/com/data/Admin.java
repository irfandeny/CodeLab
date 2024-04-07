package com.data;

import books.Buku;
import books.HistoryBook;
import books.StoryBook;
import books.TextBook;
import com.main.Main;
import com.util.iMenu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Admin extends User implements iMenu {
    String adminUsername = "admin";
    String adminPassword = "password";
    public static ArrayList<Student> studentList;
    Scanner scanner =  new Scanner(System.in);

    //method isAdmin
    public boolean isAdmin(String inputUsername, String inputPassword) {
        return this.adminUsername.equals(inputUsername) && this.adminPassword.equals(inputPassword);
    }

    //method displayStudent
    public void displayStudents() {
        System.out.println("===== Daftar Mahasiswa =====");
        for(Student student : student) {
            System.out.println(student.getNim() + "\t||\t" + student.getName() + "\t||\t" + student.getFaculty() + "\t||\t" + student.getStudyProgram());
        }
    }
    //method addStudent
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter NIM: ");
        String nim;
        do {
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("Invalid NIM format. NIM should have 15 characters.");
                System.out.print("Enter NIM again: ");
            }
        } while (nim.length() != 15);

        System.out.print("Enter faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter study program: ");
        String studyProgram = scanner.nextLine();
        Main.studentList.add(new Student(name, nim, faculty, studyProgram));
        System.out.println("Berhasil ditambahkan");
    }

    public void inputBook() {
        System.out.println("Pilih kategori buku: ");
        System.out.println("1. History Book");
        System.out.println("2. Story Book");
        System.out.println("3. TextBook");
        System.out.print("Pilihan Opsi (1-3): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        switch (pilihan) {
            case 1:
                HistoryBook historyBook = new HistoryBook("","","","",0);
                historyBook.inputBook();
                break;
            case 2:
                StoryBook storyBook = new StoryBook("","","","",0);
                storyBook.inputBook();
                break;
            case 3:
                TextBook textBook = new TextBook("","","","",0);
                textBook.inputBook();
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
        }
    }
    @Override
    public void displayBook() {
        super.displayBook();
    }
    public void hapusBuku() {
        System.out.print("Masukkan ID buku yang ingin dihapus: ");
        String id = scanner.nextLine();
        for (Buku buku : User.bookList) {
            if (buku.getId().equals(id)) {
                User.bookList.remove(buku);
                System.out.println("Buku berhasil dihapus");
                return;
            }
        }
        System.out.println("Buku tidak ditemukan");
    }

    public static String generateId() {
        String uuid = UUID.randomUUID().toString();
        String[] uuidParts = uuid.split("-");
        return uuidParts[0].substring(0, 4) + "-" + uuidParts[1].substring(0, 4) + "-" + uuidParts[2].substring(0, 4);
    }
    ArrayList<Student> student = Main.getStudentList();

    @Override
    public void Menu() {
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
                    inputBook();
                    break;
                case 2:
                    hapusBuku();
                    break;
                case 3:
                    displayBook();
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    addStudent();
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

}
