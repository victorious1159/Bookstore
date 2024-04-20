package Model;

import java.util.List;

public class Order {
    private int Code;
    private String Name;
    private String Address;
    List<Book> Books;

    public Order() {
    }

    public Order(int code, String name, String address, List<Book> books) {
        Code = code;
        Name = name;
        Address = address;
        Books = books;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public List<Book> getBooks() {
        return Books;
    }

    public void setBooks(List<Book> books) {
        Books = books;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Code=" + Code +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Books=" + Books +
                '}';
    }
}
