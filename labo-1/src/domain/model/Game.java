package domain.model;

import domain.model.Product;

public class Game extends Product {

    public Game(String title, String type, String id) {
        super(title, type, id);
    }

    @Override
    public String getPrice() {
        return "$60";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}