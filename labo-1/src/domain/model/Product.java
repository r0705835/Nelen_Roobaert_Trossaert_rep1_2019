package domain.model;

public abstract class Product implements Comparable {
    private String title;
    private String id;

    public Product(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String toString() {
        return title + " " + id;
    }

    public abstract double getPrice(int days);
    public abstract double getPrice();
    public String getId(){
        return this.id;
    }
    @Override
    public int compareTo(Object o) {
        if (o instanceof Product){
            Product p = (Product) o;
            double difference = this.getPrice() - p.getPrice();
            if (difference == 0){
                difference = this.getId().compareTo(p.getId());
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Product){
            Product p = (Product) obj;
            return p.getId().equals(this.id);
        }
        return false;
    }
}