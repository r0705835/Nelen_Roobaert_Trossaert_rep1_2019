package domain.model;

import domain.db.ShopDB;

import javax.swing.*;
import java.util.Collections;
import java.util.List;


public class Shop {

    private static ShopDB shopDB = new ShopDB();

    public Shop() {
    }

    public static void addProduct(Shop shop) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        char type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/ C for CD):").toUpperCase().charAt(0);
        Product p;

        if (type == 'M') {
            p = new Movie(title);
            shopDB.addProduct(p);
        } else if (type == 'G') {
            p = new Game(title);
            shopDB.addProduct(p);
        } else if (type == 'C') {
            p = new CD(title);
            shopDB.addProduct(p);
        } else {
            JOptionPane.showMessageDialog(null, "The given type does not exist!");
        }
    }

    public static void showProduct(Shop shop) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        try {
            JOptionPane.showMessageDialog(null, shopDB.getProduct(id));
        } catch (IllegalArgumentException E) {
            JOptionPane.showMessageDialog(null, "Requested product not found");
        }
    }

    public static void showPrice(Shop shop) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        int days = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of days:"));
        try {
            JOptionPane.showMessageDialog(null, shopDB.getPrice(id, days));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Requested product not found");

        }
    }

    public static void showProducts(Shop shop) {
        JOptionPane.showMessageDialog(null, shopDB.getSortedList());
    }

    public static void loan(Shop shop) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        try {
            if (shopDB.getProduct(id).isAvailable()) {
                shopDB.getProduct(id).loan();
                JOptionPane.showMessageDialog(null, "Product is now lend.");
            } else {
                JOptionPane.showMessageDialog(null, "Cannot loan already lend products!");

            }
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Requested product not found.");
        }
    }

    public static void showAvailability(Shop shop) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        try {
            String message = "";
            boolean available = shopDB.getProduct(id).isAvailable();
            if (available) {
                message = "Requested product is available";
            } else {
                message = "Requested product is not available";
            }
            JOptionPane.showMessageDialog(null, message);

        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Requested product not found");
        }
    }

    public List<Product> getProducts(){
        return shopDB.getProductList();
    }
}
