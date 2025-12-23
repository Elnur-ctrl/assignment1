import java.util.*;

class Rectangle {
    private double width;
    private double height;
    private int id;
    private static int idGen = 1;

    public Rectangle() {
        width = 1.0;
        height = 1.0;
        id = idGen++;
    }

    public Rectangle(double width, double height) {
        this();
        this.width = width;
        this.height = height;
    }

    public double area() { return width * height; }
    public double perimeter() { return 2 * (width + height); }

    @Override
    public String toString() {
        return "Rectangle " + id + ": " + width + " x " + height;
    }
}

class Book {
    private int id;
    private static int idGen = 1;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book() {
        id = idGen++;
        available = true;
    }

    public Book(String title, String author, int year) {
        this();
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }

    public void markAsBorrowed() { available = false; }
    public void markAsReturned() { available = true; }

    @Override
    public String toString() {
        return id + ": " + title + " by " + author + " (" + year + ") " +
                (available ? "Available" : "Borrowed");
    }
}

class LibraryApp {
    private List<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Quit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> printBooks();
                case 2 -> addBook();
                case 3 -> { return; }
            }
        }
    }

    private void printBooks() {
        if (books.isEmpty()) System.out.println("No books");
        else for (Book b : books) System.out.println(b);
    }

    private void addBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        books.add(new Book(title, author, year));
    }

    public static void main(String[] args) {
        new LibraryApp().run();
    }
}
