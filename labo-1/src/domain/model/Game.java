package domain.model;

public class Game extends Product {

    public Game(String title, String type, String id) {
        super(title, type, id);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}