package com.main;

import books.HistoryBook;
import books.StoryBook;
import books.TextBook;
import com.data.Admin;
import com.data.Student;
import com.data.User;
import com.util.iMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    Admin admin = new Admin();
    String inputUsername, inputPassword;
    public static ArrayList<Student>  studentList;

    public Main() {
        this.addTempBook();
        this.addTempStudent();
    }

    public static ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void addTempBook(){
        User.bookList = new ArrayList<>();
        User.bookList.add(new TextBook("388c-e681-9152", "Foxit eSign", "Accessibility", "Author1", 1));
        User.bookList.add(new TextBook("d95e-28c4-9523", "Nana Buku", "Category", "Author2", 2));
        User.bookList.add(new StoryBook("sgsg-ytgf-we54", "Sejarah", "Sejarah", "Author3", 8));
        User.bookList.add(new HistoryBook("rdgf-rtgf-evgt", "Sejarah", "Sejarah", "Author3", 8));
    }
    public void addTempStudent(){
        studentList = new ArrayList<>();
        studentList.add(new Student("Keysya", "202310370311363", "Teknik", "Informatika"));
        studentList.add(new Student("Irfan", "202310370311377", "Teknik", "Informatika"));
        studentList.add(new Student("tauk", "202310370310964", "Teknik", "Informatika"));
    }
    //method menu
    public void menu(Scanner input) {
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
                    inputNim();
                    break;
                case 2:
                    loginAsAdmin();
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
    public void inputNim() {
        System.out.print("Enter your NIM : ");
        String nim = scanner.nextLine();
        checkNim(nim);
    }
    //method ceknim
    public void checkNim(String nim) {
        iMenu menuStudent = new Student();
        for (Student student :  studentList) {
            if (student.getNim().equals(nim)) {
                student.displayInfo(student);
                menuStudent.Menu();
                return;
            }
        }
        System.out.println("NIM tidak ditemukan, silakan coba lagi");
    }
    public void loginAsAdmin() {
        iMenu menuAdmin = new Admin();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        inputPassword = scanner.nextLine();
        if (admin.isAdmin(inputUsername, inputPassword)) {
            System.out.println("Login berhasil. Selamat datang " + inputUsername);
            menuAdmin.Menu();
        } else {
            System.out.println("Username atau password salah. Silakan coba lagi.");
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
