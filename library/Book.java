package library;

public class Book {
    String title;
    public Book(){
        title = "Unknown";
    }

    public Book(String title) {
        this.title = title;
    }

    public void displayBook(){
        System.out.println("Title : "+ title);
    }
    
}
