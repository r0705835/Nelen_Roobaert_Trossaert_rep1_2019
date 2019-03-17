package domain.model;

public abstract class Product implements Comparable {
    private String title;
    private int id;
    private boolean available;

    public Product(String title, int id, double available) {
        this.title = title;
        this.id = id;
        this.available = true;
    }

    public Product(String title, int id) {
        this.title = title;
        this.id = id;
        this.available = true;
    }

    public String toString() {
        return title + " " + id;
    }

    public abstract double getPrice(int days);

    public abstract double getPrice();

    public  String getTitle() {
        return this.title;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void loan() {
        available = false;
    }

    public void setAvailable() {
        available = true;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Product) {
            Product p = (Product) o;
            return this.getId() - p.getId();
        }
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;
            return p.getId() == this.id;
        }
        return false;
    }
}