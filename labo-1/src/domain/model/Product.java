package domain.model;

public abstract class Product implements Comparable<Product> {
    private String title;
    private int id;
    private boolean available;

    public Product(String title, int id, boolean available) {
        this.title = title;
        this.id = id;
        this.available = true;
    }

    public Product(String title, int id) {
        this(title, id, true);
    }

    public Product(String title) {
        this(title, 0, true);
    }

    public String toString() {
        return title + " " + id;
    }

    public abstract double getPrice(int days);

    public abstract double getPrice();

    public String getTitle() {
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
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;
            return p.getId() == this.id;
        }
        return false;
    }

    @Override
    public int compareTo(Product o) {
        if (o == null) return 1;
        if (this.id - o.id == 0) {
            return this.title.compareTo(o.title);
        }
        return this.id - o.id;
    }
}