package domain.model;

public abstract class Product implements Comparable {
    private String title;
    private String type;
    private String id;

    public Product(String title, String type, String id) {
        this.title = title;
        this.type = type;
        this.id = id;
    }

    public String toString() {
        return title + " " + type + " " + id;
    }
}