package domain.model;

public class Game extends Product {

    public static final double price = 3;

    public Game(String title, String id) {
        super(title, id);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double getPrice(int days) {
        double result = price;
        int daysLeft = days - 3;
        if (daysLeft > 0) {
            result += (daysLeft * 2);
        }
        return result;
    }

    @Override
    public double getPrice() {
        return price;
    }
}