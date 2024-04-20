package Controller;

import Model.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class OrderController {
    private Queue<Order> orders;
    private int nextOrderCode;

    public Queue<Order> getOrders() {
        return orders;
    }

    public OrderController() {
        this.orders = new LinkedList<>();
        this.nextOrderCode = 1000;
    }

    // Phương thức đặt hàng
    public void placeOrder(Customer customer, List<Book> availableBooks) {
        Scanner scanner = new Scanner(System.in);
        String continueOrder = "y";

        while (continueOrder.equalsIgnoreCase("y")) {
            // Nhập thông tin tên và địa chỉ từ người dùng
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter customer address: ");
            String customerAddress = scanner.nextLine();

            // Tạo một đơn hàng mới
            Order order = createOrder(customerName, customerAddress);

            // Hiển thị danh sách sách
            new BookController().showListOfBooks(availableBooks);
            System.out.println();

            // Chọn sách để đặt hàng
            OrderDetailController orderDetailController = new OrderDetailController();
            List<Book> orderedBooks = orderDetailController.selectBooksForOrder(availableBooks);

            // Lưu danh sách sách vào đơn hàng
            order.setBooks(orderedBooks);
            orderDetailController.quickSort(orderedBooks, 0, orderedBooks.size() - 1);


            // Lưu đơn hàng vào queue
            orders.offer(order);

            // Hỏi người dùng có muốn tiếp tục đặt hàng không
            System.out.print("Do you want to continue placing orders? (y/n): ");
            continueOrder = scanner.next();
        }
    }

    // Tạo một đơn hàng mới
    private Order createOrder(String customerName, String customerAddress) {
        Order order = new Order();
        order.setCode(generateOrderCode());
        order.setName(customerName);
        order.setAddress(customerAddress);
        return order;
    }

    public void showOrder(){
        Scanner scanner = new Scanner(System.in);
        String continueView = "y";

        while (continueView.equalsIgnoreCase("y")) {
            int count = 0;
            if (orders.isEmpty()) {
                System.out.println("There are no completed orders.");
                return;
            }

            System.out.println("Completed Orders:");
            for (Order order : orders) {
                count++;
                System.out.println("Order Num: " + count + ", Order Code: " + order.getCode() + ", Customer Name: " + order.getName() + ", Customer Address: " + order.getAddress());
            }
            System.out.println();
            System.out.print("Enter the order number to view details (0 to exit): ");
            int orderNumber = scanner.nextInt();
            System.out.println();
            if (orderNumber == 0) {
                break;
            }

            if (orderNumber < 1 || orderNumber > orders.size()) {
                System.out.println("Invalid order number. Please enter a valid number.");
                continue;
            }

            showCompletedOrders();

            System.out.print("Do you want to continue view order detail? (y/n): ");
            continueView = scanner.next();
        }
    }


    // Hiển thị danh sách các đơn hàng đã hoàn thành
    public void showCompletedOrders() {
        if (orders.isEmpty()) {
            System.out.println("There are no completed orders.");
            return;
        }

        System.out.println("Completed Orders:");
        for (Order order : orders) {
            System.out.println("Order Code: " + order.getCode());
            System.out.println("Customer Name: " + order.getName());
            System.out.println("Customer Address: " + order.getAddress());
            System.out.println("Books:");
            for (Book book : order.getBooks()) {
                System.out.println("- " + book.getTitle() + " (Quantity: " + book.getQuantity() + ")");
            }
            System.out.println();
        }
    }

    // Hàm sinh mã đơn hàng
    private int generateOrderCode() {
        return nextOrderCode++;
    }
}
