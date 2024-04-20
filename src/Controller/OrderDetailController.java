package Controller;

import Model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDetailController {
    public List<Book> selectBooksForOrder(List<Book> availableBooks) {
        List<Book> orderedBooks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String continueOrder = "y";

        while (continueOrder.equalsIgnoreCase("y")) {
            // Nhập số thứ tự của sách muốn đặt
            System.out.print("Enter the number of the book you want to order (0 to finish ordering): ");
            int bookNumber = scanner.nextInt();
            if (bookNumber == 0) {
                break;
            }

            // Kiểm tra số thứ tự hợp lệ
            if (bookNumber < 1 || bookNumber > availableBooks.size()) {
                System.out.println("Invalid book number. Please enter a valid number.");
                continue;
            }

            // Lấy thông tin về sách được chọn
            Book selectedBook = availableBooks.get(bookNumber - 1);

            // Hiển thị thông tin về sách và yêu cầu nhập số lượng
            System.out.println("Book: " + selectedBook.getTitle() + " - Author: " + selectedBook.getAuthor() +
                    " - Price: $" + selectedBook.getPrice() + " - Quantity available: " + selectedBook.getQuantity());
            System.out.print("Enter quantity to order: ");
            int quantity = scanner.nextInt();
            System.out.println();

            // Kiểm tra số lượng hợp lệ
            if (quantity <= 0 || quantity > selectedBook.getQuantity()) {
                System.out.println("Invalid quantity. Please enter a valid quantity.");
                continue;
            }

            // Thêm sách vào danh sách đặt hàng
            orderedBooks.add(new Book(selectedBook.getId(), selectedBook.getTitle(), selectedBook.getAuthor(), selectedBook.getPrice(), quantity));

            selectedBook.setQuantity(selectedBook.getQuantity() - quantity);

            // Kiểm tra và xóa sách nếu số lượng về 0
            if (selectedBook.getQuantity() == 0) {
                availableBooks.remove(selectedBook);
            }

            // Hỏi người dùng có muốn tiếp tục đặt sách không
            System.out.print("Do you want to continue ordering? (y/n): ");
            continueOrder = scanner.next();
        }

        return orderedBooks;
    }

    // Hàm sắp xếp QuickSort
    public void quickSort(List<Book> orderedBooks, int low, int high) {
        if (low < high) {
            int pi = partition(orderedBooks, low, high);

            quickSort(orderedBooks, low, pi - 1);
            quickSort(orderedBooks, pi + 1, high);
        }
    }

    // Hàm chia mảng và trả về chỉ số phân hoạch
    private int partition(List<Book> orderedBooks, int low, int high) {
        Book pivot = orderedBooks.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // So sánh tiêu đề của sách
            if (orderedBooks.get(j).getTitle().compareToIgnoreCase(pivot.getTitle()) < 0) {
                i++;

                // Hoán đổi sách
                Book temp = orderedBooks.get(i);
                orderedBooks.set(i, orderedBooks.get(j));
                orderedBooks.set(j, temp);
            }
        }

        // Hoán đổi sách
        Book temp = orderedBooks.get(i + 1);
        orderedBooks.set(i + 1, orderedBooks.get(high));
        orderedBooks.set(high, temp);

        return i + 1;
    }


}
