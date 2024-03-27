import java.util.ArrayList;

public class User {
    public ArrayList<Buku> bookList;

    public User(){
    }

    public void displayBook(){
        System.out.println("Buku yang tersedia");
        System.out.println("=========================================================================================================");
        for (Buku buku : bookList) {
            System.out.println(buku.getId() + "\t||\t" + buku.getTitle() + "\t||\t" + buku.getAuthor() + "\t||\t" + buku.getStock());
        }
        System.out.println("=========================================================================================================");
    }
}