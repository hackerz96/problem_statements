class Book {
    // Instance variables
    private String title;
    private String author;
    private double price;

    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        System.out.println("Default Constructor:");
        printDetails();
    }

    // Constructor with title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.price = 0.0;
        System.out.println("Constructor with Title and Author:");
        printDetails();
    }

    // Constructor with title, author, and price
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        System.out.println("Constructor with Title, Author, and Price:");
        printDetails();
    }

    // Method to print book details
    private void printDetails() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : " + price);
        System.out.println();
    }
}

// Main class to test the Book class
public class BookExample {
    public static void main(String[] args) {
        Book book1 = new Book(); // Default constructor
        Book book2 = new Book("The Alchemist", "Paulo Coelho"); // 2-arg constructor
        Book book3 = new Book("1984", "George Orwell", 299.99); // 3-arg constructor
    }
}
