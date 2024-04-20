package Controller;

import Model.Order;
import java.util.Queue;
public class SearchController {

    public static void searchByCode(Queue<Order> orders, int code) {
        boolean found = false;
        for (Order order : orders) {
            if (order.getCode() == code) {
                System.out.println(order);
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Order with code " + code + " not found.");
        }
    }

    public static void searchByName(Queue<Order> orders, String name) {
        boolean found = false;
        for (Order order : orders) {
            if (order.getName().equalsIgnoreCase(name)) {
                System.out.println(order);
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Order(s) for customer " + name + " not found.");
        }
    }

    public static void searchByAddress(Queue<Order> orders, String address) {
        boolean found = false;
        for (Order order : orders) {
            if (order.getAddress().equalsIgnoreCase(address)) {
                System.out.println(order);
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Order(s) for address " + address + " not found.");
        }
    }
}


