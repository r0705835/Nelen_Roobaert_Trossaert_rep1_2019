package domain.model;

public class CD extends Product {

    public static final double price = 5;

    public CD(String title, int id) {
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
    public int compareTo(Object o) {
        if (o instanceof CD) {
            CD cd = (CD) o;
            return super.compareTo(cd);
        }
        return -1;
    }
}
