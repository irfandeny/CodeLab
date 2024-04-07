package books;

import com.data.Admin;
import com.data.User;

import java.util.Scanner;


public class StoryBook extends Buku{
    static Scanner scanner;
    //private String category;
    public StoryBook(String id, String title, String author, String category, int stock) {
        super(id, title, author, category, stock);
        scanner = new Scanner(System.in);
    }
    @Override
    public void inputBook(){
        setCategory("Story Book");
        System.out.print("Masukkan judul buku: ");
        setTitle(scanner.nextLine());
        System.out.print("Masukkan penulis buku: ");
        setAuthor(scanner.nextLine());
        System.out.print("Masukkan stok buku: ");
        setStock(scanner.nextInt());
        scanner.nextLine();
        setId(Admin.generateId());
        User.bookList.add(new StoryBook(id, getTitle(), getAuthor(), getCategory(), getStock()));
        System.out.println("Berhasil ditambahkan");
    }
}
