package domain.model;

import domain.db.ShopDB;

import javax.swing.*;
import java.util.ArrayList;


public class Shop {

    private static ShopDB shopDB = new ShopDB();

    public Shop() {
    }

    public static void addProduct(Shop shop) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String id = JOptionPane.showInputDialog("Enter the id:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/ C for CD):");
        Product p;

        if(type.equals("M")){
            p = new Movie(title, id);
        }
        else if(type.equals("G")){
            p = new Game(title, id);
        }
        else {
            p = new CD(title, id);
        }
        shopDB.addProduct(p);
    }

    public static void showProduct(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        try {
            JOptionPane.showMessageDialog(null, shopDB.getProduct(id));
        }
        catch (IllegalArgumentException E){
            JOptionPane.showMessageDialog(null, "Requested product not found");
        }
    }

    public static void showPrice(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        String daysString = JOptionPane.showInputDialog("Enter the number of days:");
        int days = Integer.parseInt(daysString);
        JOptionPane.showMessageDialog(null, shopDB.getPrice(id, days));
    }

    public static void showProducts(Shop shop){
        JOptionPane.showMessageDialog(null, shopDB.getProductList());
    }
}
