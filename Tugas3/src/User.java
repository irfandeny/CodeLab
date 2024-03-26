import java.util.ArrayList;

public class User {
    public ArrayList<Buku> bookList;

    public User(){
        bookList = new ArrayList<>();
        bookList.add(new Buku("388c-e681-9152", "Foxit eSign", "Accessibility", "Author1", 1));
        bookList.add(new Buku("d95e-8c4-9523", "Nana Buku", "Category", "Author2", 2));
        bookList.add(new Buku("Sejarah1", "Sejarah", "Sejarah", "Author3", 8));
        bookList.add(new Buku("Sejarah2", "Sejarah", "Sejarah", "Author3", 8));
    }

    public void displayBook(){
        System.out.println("Buku yang tersedia:");
    }

}
