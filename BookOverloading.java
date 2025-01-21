class Book{
    
    String title;
    String author;
    int price;
    String publisher;

    Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    Book(String title, String author, int price, String publisher){
        this.title = title;
        this.author = author;
        this.price = price;
        this.publisher = publisher;
    }

    void display(){
        System.out.println("Title: "+title+" Author: "+author+" Price: "+price+" Publisher: "+publisher);
    }
}
public class BookOverloading {

    public static void main(String[] args) {
        Book b1 = new Book("H1", "Mani");
        b1.display();

        Book b2 = new Book("Joker", "Warner", 1000);
        b2.display();

        Book b3 = new Book("Harry Potter", "Rowling", 5000, "HBO");
        b3.display();
    }
    
}