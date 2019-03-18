package domain.model;

import domain.db.ShopDB;

import java.util.List;


public class Shop {

    private static ShopDB shopDB = new ShopDB();

    public void addProduct(Product product) {
        shopDB.addProduct(product);
    }

    public Product getProduct(int id) {
        return shopDB.getProduct(id);
    }

    public double getPrice(int id, int days) {
        return shopDB.getPrice(id, days);
    }

    public List<List<Product>> getSortedList() {
        return shopDB.getSortedList();
    }

    public void loan(int id) {
        shopDB.getProduct(id).loan();
    }

    public boolean showAvailability(int id) {
        return shopDB.getProduct(id).isAvailable();
    }

    public List<Product> getProducts() {
        return shopDB.getProductList();
    }
}
