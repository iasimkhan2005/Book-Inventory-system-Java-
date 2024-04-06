package myTestProject;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

        BookInventorySystem inventorySystem = new BookInventorySystem();

        // Adding some books to the inventory
        inventorySystem.addBook(new Book("Java Programming", "John Smith", 29.99, 10));
        inventorySystem.addBook(new Book("Data Structures and Algorithms", "Alice Johnson", 39.99, 8));
        inventorySystem.addBook(new Book("Introduction to Python", "Emily Brown", 24.99, 15));

        // Searching for books by title
        ArrayList<Book> booksByTitle = inventorySystem.searchBookByTitle("Java Programming");
        System.out.println("Books found by title:");
        for (Book book : booksByTitle) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

        // Searching for books by author
        ArrayList<Book> booksByAuthor = inventorySystem.searchBookByAuthor("Alice Johnson");
        System.out.println("\nBooks found by author:");
        for (Book book : booksByAuthor) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

        // Removing a book
        try {
            inventorySystem.removeBook("Java Programming");
            System.out.println("\n'Java Programming' removed from the inventory.");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Updating a book
        Book updatedBook = new Book("Data Structures and Algorithms", "Alice Johnson", 39.99, 10);
        try {
            inventorySystem.updateBook("Data Structures and Algorithms", updatedBook);
            System.out.println("\n'Data Structures and Algorithms' updated in the inventory.");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    

	}

}
