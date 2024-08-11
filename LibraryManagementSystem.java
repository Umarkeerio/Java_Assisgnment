// 4. Library Book Management:
// Create a Book class with attributes like title, author, ISBN, and availability status.
// Create a Library class that manages a collection of books.
// Implement methods to add books, search for books, and check out/return books.
// Maintain a simple lending history for each book (e.g., who borrowed it, when it was returned).
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int ISBN;
    boolean availability;
    ArrayList<String> lendingHistory;
    Book(String title, String author, int ISBN, boolean availability) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.availability = availability;
        this.lendingHistory = new ArrayList<>();
    }
    void addLendingRecord(String record) {
        lendingHistory.add(record);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Availability: " + (availability ? "Available" : "Checked out");
    }
}

class Library {
    ArrayList<Book> books;
    Map<Integer, Book> bookMap;
    Library() {
        this.books = new ArrayList<>();
        this.bookMap = new HashMap<>();
    }
    void addBook(Book book) {
        books.add(book);
        bookMap.put(book.ISBN, book);
    }
    Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    Book searchByISBN(int ISBN) {
        return bookMap.get(ISBN);
    }
    boolean checkOutBook(int ISBN, String borrower) {
        Book book = searchByISBN(ISBN);
        if (book != null && book.availability) {
            book.availability = false;
            book.addLendingRecord("Checked out by: " + borrower);
            return true;
        }
        return false;
    }
    boolean returnBook(int ISBN) {
        Book book = searchByISBN(ISBN);
        if (book != null && !book.availability) {
            book.availability = true;
            book.addLendingRecord("Returned");
            return true;
        }
        return false;
    }
    void printAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        library.addBook(new Book("The Dance of dragon", "R.R Martin", 12, true));
        library.addBook(new Book("Winds of winterfell", "R.R Martin", 11, true));
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Search Book by ISBN");
            System.out.println("4. Check Out Book");
            System.out.println("5. Return Book");
            System.out.println("6. Print All Books");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter ISBN: ");
                    int ISBN = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    library.addBook(new Book(title, author, ISBN, true));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter title: ");
                    title = sc.nextLine();
                    Book bookByTitle = library.searchByTitle(title);
                    if (bookByTitle != null) {
                        System.out.println(bookByTitle);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ISBN: ");
                    ISBN = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    Book bookByISBN = library.searchByISBN(ISBN);
                    if (bookByISBN != null) {
                        System.out.println(bookByISBN);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ISBN of the book to check out: ");
                    ISBN = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter your name: ");
                    String borrower = sc.nextLine();
                    if (library.checkOutBook(ISBN, borrower)) {
                        System.out.println("Book checked out successfully.");
                    } else {
                        System.out.println("Book could not be checked out.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ISBN of the book to return: ");
                    ISBN = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    if (library.returnBook(ISBN)) {
                        System.out.println("Book returned successfully.");
                    } else {
                        System.out.println("Book could not be returned.");
                    }
                    break;

                case 6:
                    library.printAllBooks();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
