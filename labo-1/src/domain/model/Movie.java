package domain.model;

public class Movie extends Product {

    public static final double price = 5;

    public Movie(String title, int id) {
        super(title, id);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double getPrice(int dagen) {
        return price * dagen;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public int compareTo(Object o) {
        int i = 0;
        if (o instanceof Movie) {
            Movie movie = (Movie) o;
            i = 3;
        }
        return i + super.compareTo(o);
    }
}