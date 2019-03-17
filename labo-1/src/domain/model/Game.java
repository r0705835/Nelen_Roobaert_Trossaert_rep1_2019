package domain.model;

public class Game extends Product {

    public static final double price = 3;

    public Game(String title, int id) {
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

    @Override
    public int compareTo(Object o) {
        int i = 0;
        if (o instanceof Game) {
            Game game = (Game) o;
            return super.compareTo(game);
        }
        return -1;
    }
}