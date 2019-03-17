package domain.model;

import domain.db.ShopDB;

import javax.swing.*;
import java.util.Collections;


public class Shop {

    private static ShopDB shopDB = new ShopDB();

    public Shop() {
    }

    public static void addProduct(Shop shop) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/ C for CD):");
        Product p;

        if (type.equals("M")) {
            p = new Movie(title, id);
        } else if (type.equals("G")) {
            p = new Game(title, id);
        } else {
            p = new CD(title, id);
        }
        shopDB.addProduct(p);
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
        Collections.sort(shopDB.getProductList());
        JOptionPane.showMessageDialog(null, shopDB.getProductList());
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
}
