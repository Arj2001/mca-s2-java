package main;

import library.Book;

public class TestBook {
    
    public static void main(String[] args) {
        
        Book bk1 = new Book();
        bk1.displayBook();

        Book bk2 = new Book("Twenty");
        bk2.displayBook();
    }
}
