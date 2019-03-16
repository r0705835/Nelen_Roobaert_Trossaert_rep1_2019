package domain.model;

public class CD extends Product {

    public static final double price = 5;

    public CD(String title, String id) {
        super(title, id);
    }

    @Override
    public double getPrice(int dagen) {
        return price * dagen;
    }

    @Override
    public double getPrice() {
        return price;

    }

    @Override
    public int compareTo(Object o)  {
        if (o instanceof Product){
            Product p = (Product) o;
            double difference = this.getPrice() - p.getPrice();
            if (difference == 0){
                difference = this.getId().compareTo(p.getId());
            }
        }
        return -1;
    }
}
