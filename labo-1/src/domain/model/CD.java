package domain.model;

public class CD extends Product {

    public static final double price = 5;

    public CD(String title, int id) {
        super(title, id);
    }

    public CD(String title){
        super(title);
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
