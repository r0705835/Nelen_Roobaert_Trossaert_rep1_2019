public abstract class Product {
    private String title;
    private String type;
    private String id;

    public Product(String title, String type, String id) {
        this.title = title;
        this.type = type;
        this.id = id;
    }

    public abstract String getPrice();

    public String toString() {
        return title + " " + type + " " + id;
    }
}