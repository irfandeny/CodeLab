import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User{
    String name, nim, faculty, studyProgram;
    public static ArrayList<Buku> bukuTerpinjam;
    public static ArrayList<Student> maLog;
    static Scanner scanner;
//construktor
    public Student(String name, String nim, String faculty, String studyProgram) {
        this.name = name;
        this.nim = nim;
        this.faculty = faculty;
        this.studyProgram = studyProgram;
        bukuTerpinjam = new ArrayList<>();
        maLog =new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public Student() {
    }
//getter setter
    public String getNim() {
        return nim;
    }
    public String getName() {
        return name;
    }
    public String getFaculty(){
        return faculty;
    }
    public String getStudyProgram(){
        return studyProgram;
    }


    public void displayInfo(Student student){
        System.out.println("Login sebagai: " + student.getName() + " " + student.getNim());
    }

    //method displayBook
    @Override
    public void displayBook() {
        User buk1 = new User();
        super.displayBook();
        for (Buku buku : buk1.bookList) {
            System.out.println(buku.getTitle() + "\t||\t" + buku.getAuthor() + "\t||\t" + buku.getStock());
        }
    }
    //method tampilBukuterpinjam
    public void tampilBukuTerpinjam() {
        if (bukuTerpinjam.isEmpty()) {
            System.out.println("Kamu belum meminjam buku");
        } else {
            System.out.println("Books yang dipinjam oleh " + name + " (" + nim + "):");
            for (Buku buku : bukuTerpinjam) {
                System.out.println(buku.getId() + "\t||\t" + buku.getTitle() + "\t||\t" + buku.getAuthor() + buku.getDaysToReturn());
            }
        }
    }
    //method Pinjam buku
    public void pinjamBuku() {
        User buk2 = new User();
        System.out.println("Masukkan Id buku yang ingin dipinjam:");
        String idBuku = scanner.nextLine();
        Buku bukuygPinjam = null;
        for (Buku buku : buk2.bookList) {
            if (buku.getId().equals(idBuku)) {
                bukuygPinjam = buku;
                buku.setStock(buku.getStock() - 1);
                break;
            }
        }
        if (bukuygPinjam != null) {
            if (bukuygPinjam.getStock() > 0) {
                bukuTerpinjam.add(bukuygPinjam);
                bukuygPinjam.updateStock(bukuygPinjam.getStock() - 1);
                System.out.println("Buku berhasil dipinjam");
            } else {
                System.out.println("Buku tidak ditemukan");
            }
        }
    }
//method log out
    public void logout() {
        if(bukuTerpinjam.isEmpty()){
            System.out.println("log out");
        }else{
            System.out.println("kamu ingin untuk batal meminjan buku? (Y/N)");
            String jawab = scanner.next();
            if(jawab.equalsIgnoreCase("Y")){
                returnBooks();
            }
        }
    }

    public void returnBooks(){
        User buk = new User();
        if(bukuTerpinjam.isEmpty()){
            System.out.println("kamu tidak ada buku terpinjam untuk dikembalikan.");
            return;
        }
        System.out.println("Masukkan id buku yang ingin di kembalikan:");
        String idbuku =scanner.nextLine();
        Buku buku = null;
        for(Buku book : buk.bookList){
            if(book.getId().equals(idbuku)){
                buku = book;
                break;
            }
        }
        if(buku != null){
            bukuTerpinjam.remove(buku);
            buku.setDaysToReturn(0);
            buku.updateStock(buku.getStock() + 1);
            System.out.println("Buku berhasil dikembalikan");
        }else{
            System.out.println("Buku tidak ditemukan");
        }
    }
}
