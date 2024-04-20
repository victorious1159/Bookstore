package Model;

public class Book {
    private int Id;
    private String Title;
    private String Author;
    private Double Price;
    private int Quantity;

    public Book() {
    }

    public Book(int id, String title, String author, Double price, int quantity) {
        Id = id;
        Title = title;
        Author = author;
        Price = price;
        Quantity = quantity;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", Price=" + Price +
                ", Quantity=" + Quantity +
                '}';
    }
}
