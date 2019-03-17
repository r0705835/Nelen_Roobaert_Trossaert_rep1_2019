package domain.db;

import domain.model.Product;

import javax.print.attribute.standard.PrinterURI;
import java.util.ArrayList;
import java.util.List;

public class ShopDB {
    private List<Product> productList = new ArrayList<>();

    public ShopDB(){

    }

    public Product get(String productId){
        for(Product product: productList){
            if (product.getId().equals(productId)){
                return product;
            }
        }
        return null;
    }

    public double getPrice(String productid, int days) {
        Product p = get(productid);
        return p.getPrice(days);
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public Product getProduct(String productid){
        for(Product product: productList){
            if(product.getId().equals(productid)) return product;
        }
        throw new IllegalArgumentException();
    }

    public List<Product> getProductList(){
        return this.productList;
    }
}
