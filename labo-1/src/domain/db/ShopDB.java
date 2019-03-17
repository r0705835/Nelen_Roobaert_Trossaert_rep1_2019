package domain.db;

import domain.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ShopDB {
    private List<Product> productList = new ArrayList<>();

    public ShopDB() {

    }

    public double getPrice(int productid, int days) {
        Product p = getProduct(productid);
        return p.getPrice(days);
    }

    public void addProduct(Product product) {
        int id = 1;
        for (Product p : productList) {
            if (p.getId() >= id) id = 1 + p.getId();
        }
        product.setId(id);
        productList.add(product);
    }

    public Product getProduct(int productid) {
        for (Product product : productList) {
            if (product.getId() == productid) return product;
        }
        throw new IllegalArgumentException();
    }

    public List<Product> getProductList() {
        return this.productList;
    }
}
