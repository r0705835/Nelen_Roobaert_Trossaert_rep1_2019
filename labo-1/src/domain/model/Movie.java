package domain.model;

public class Movie extends Product {

    public static final double price = 5;

    public Movie(String title, int id) {
        super(title, id);
    }

    public Movie(String title){
        super(title);
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

}