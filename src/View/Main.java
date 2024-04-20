package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import Controller.BookController;
import Controller.OrderController;
import Controller.SearchController;
import Model.Book;
import Model.Customer;
import Model.Order;

public class Main {
    public static void main(String[] args) {

        //fix cung cho du lieu cua user
        Customer customer = new Customer();
        customer.setName("Thanh Huy");
        customer.setPhone("1234567890");
        customer.setAddress("Da Nang");

        //fix cung du lieu cua books
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setTitle("Summit 1");
        book1.setAuthor("Cambrige");
        book1.setPrice(100000.0);
        book1.setQuantity(10);
        books.add(book1);

        Book book2 = new Book();
        book2.setTitle("Summit 2");
        book2.setAuthor("CamQuytXoaiOi");
        book2.setPrice(150000.0);
        book2.setQuantity(22);
        books.add(book2);

        OrderController orderController = new OrderController();

        // Nhận lựa chọn từ người dùng
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // Vòng lặp để chọn và xử lý các chức năng
        while (choice != 6) {
            //Menu
            System.out.println("Welcome to Book Store!");
            System.out.println("-------------------------------------");
            System.out.println("Please choose an option below:");
            System.out.println("*");
            System.out.println("1. Show list of Books");
            System.out.println("2. Add a new to list of Books");
            System.out.println("3. Order");
            System.out.println("4. Order View");
            System.out.println("5. Search a Book");
            System.out.println("6. Exit store");


            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    // Hiển thị danh sách sách
                    new BookController().showListOfBooks(books);
                    System.out.println();
                    break;
                case 2:
                    // Thêm sách mới
                    new BookController().addNewBook(books);
                    System.out.println();
                    break;
                case 3:
                    // Đặt sách
                    System.out.println("Placing an Order...");
                    orderController.placeOrder(customer, books);
                    break;
                case 4:
                    // Chi tiết đơn hàng
                    showOrderDetailMenu(orderController);
                    break;
                case 5:
                    // Tìm sách
                    System.out.println("Searching a Book...");
                    break;
                case 6:
                    // Thoát khỏi cửa hàng
                    System.out.println("Exiting store..." );
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }

    public static void showOrderDetailMenu(OrderController orderController) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("Order Detail Menu:");
            System.out.println("------------------");
            System.out.println("1. Search By");
            System.out.println("2. View List Order");
            System.out.println("3. Back to Main Menu");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    searchByMenu(orderController.getOrders());
                    break;
                case 2:
                    orderController.showOrder();
                    break;
                case 3:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    private static void searchByMenu(Queue<Order> orders) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("Search By:");
            System.out.println("-----------");
            System.out.println("1. Code");
            System.out.println("2. Name");
            System.out.println("3. Address");
            System.out.println("4. Back to Order Detail Menu");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter code to search: ");
                    int code = scanner.nextInt();
                    SearchController.searchByCode(orders, code);
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    String name = scanner.next();
                    SearchController.searchByName(orders, name);
                    break;
                case 3:
                    System.out.print("Enter address to search: ");
                    String address = scanner.next();
                    SearchController.searchByAddress(orders, address);
                    break;
                case 4:
                    System.out.println("Returning to Order Detail Menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


}
