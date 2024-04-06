package myTestProject;
import java.util.ArrayList;
import java.util.HashMap;

public class BookInventorySystem {
    private ArrayList<Book> inventory;

    public BookInventorySystem() {
        inventory = new ArrayList<>();
    }

    public void addBook(Book book) {
        inventory.add(book);
    }

    public void removeBook(String title) throws BookNotFoundException {
        boolean removed = false;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getTitle().equalsIgnoreCase(title)) {
                inventory.remove(i);
                removed = true;
                break;
            }
        }
        if (!removed) {
            throw new BookNotFoundException("Book with title '" + title + "' not found.");
        }
    }

    public void updateBook(String title, Book updatedBook) throws BookNotFoundException {
        boolean updated = false;
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getTitle().equalsIgnoreCase(title)) {
                inventory.set(i, updatedBook);
                updated = true;
                break;
            }
        }
        if (!updated) {
            throw new BookNotFoundException("Book with title '" + title + "' not found.");
        }
    }

    public ArrayList<Book> searchBookByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : inventory) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public ArrayList<Book> searchBookByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : inventory) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }
}

class Book {
    private String title;
    private String author;
    private double price;
    private int quantity;

    public Book(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}
