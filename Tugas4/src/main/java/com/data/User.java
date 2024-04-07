package com.data;

import books.Buku;

import java.util.ArrayList;

public class User {
    public static ArrayList<Buku>bookList = new ArrayList<>();
    ArrayList<Buku> buku = getBookList();

    public static ArrayList<Buku> getBookList() {
        return bookList;
    }

    public void addBook(){

    }

    public void displayBook() {
        System.out.println("=========================================================================================================================");
        System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3s ||", "ID Buku", "Nama Buku", "Penulis", "Kategori", "Stok");
        System.out.println("\n=========================================================================================================================");

        for (Buku buku : bookList) {
            System.out.printf("|| %-25s || %-25s || %-25s || %-20s || %-3d  ||\n", buku.getId(), buku.getTitle(),buku.getCategory() ,buku.getAuthor(), buku.getStock());
        }
        System.out.print("=========================================================================================================================\n");
    }

}
