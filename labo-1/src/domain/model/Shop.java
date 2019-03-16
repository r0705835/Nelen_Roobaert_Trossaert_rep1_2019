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
        int idx = -1;
        boolean found = false;
        for (int i = 0; i < shopDB.getProductList().size() && !found; i++) {
            if (shopDB.getProductList().get(i).equals(id)) {
                idx = i;
                found = true;
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(null, shopDB.getProductList().get(idx));
        }
    }

    public static void showPrice(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        int idx = -1;
        boolean found = false;
        for (int i = 0; i < shopDB.getProductList().size() && !found; i++) {
            if (shopDB.getProductList().get(i).equals(id)) {
                idx = i;
                found = true;
            }
        }
        if (found) {
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            JOptionPane.showMessageDialog(null, shopDB.getPrice(idx, days));
        }
    }
}
