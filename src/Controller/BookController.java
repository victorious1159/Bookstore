package Controller;

import Model.Book;

import java.util.List;
import java.util.Scanner;

public class BookController {
    public void showListOfBooks(List<Book> books) {
        int count = 0;
        System.out.println("List of Books:");
        for (Book book : books) {
            count++;
            System.out.println(count + ", " + book.getTitle() + " by " + book.getAuthor() + " - Price: $" + book.getPrice());
        }
    }

    public void addNewBook(List<Book> books) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adding a new Book:");

        Book newBook = new Book();

        System.out.print("Enter title: ");
        newBook.setTitle(scanner.nextLine());

        System.out.print("Enter author: ");
        newBook.setAuthor(scanner.nextLine());

        System.out.print("Enter price: ");
        newBook.setPrice(scanner.nextDouble());

        System.out.print("Enter quantity: ");
        newBook.setQuantity(scanner.nextInt());

        books.add(newBook);

        System.out.println("New book added successfully!");
    }
}
