package books;

import com.data.Admin;
import com.data.User;

import java.util.Scanner;


public class HistoryBook extends Buku {
    private String category;
    static Scanner scanner;
    public HistoryBook(String id, String title, String author, String category, int stock) {
        super(id, title, author, category, stock);
        scanner = new Scanner(System.in);
    }
    @Override
    public void inputBook(){
        setCategory("History Book");
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
