package domain.model;

import javax.swing.*;
import java.util.ArrayList;


public class Shop {

    private ArrayList<String> productTitles;
    private ArrayList<String> productTypes;
    private ArrayList<String> productIds;

    public Shop() {
        productTitles = new ArrayList<>();
        productTypes = new ArrayList<>();
        productIds = new ArrayList<>();
    }

    public double getPrice(int productidx, int days) {
        double price = 0;
        if (productTypes.get(productidx).equals("M")) {
            price = 5;
            int daysLeft = days - 3;
            if (daysLeft > 0) {
                price += (daysLeft * 2);
            }
        } else if (productTypes.get(productidx).equals("G")) {
            price = days * 3;
        }
        return price;
    }


    public static void addProduct(Shop shop) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String id = JOptionPane.showInputDialog("Enter the id:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");

        shop.productTitles.add(title);
        shop.productIds.add(id);
        shop.productTypes.add(type);
    }

    public static void showProduct(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        int idx = -1;
        boolean found = false;
        for (int i = 0; i < shop.productIds.size() && !found; i++) {
            if (shop.productIds.get(i).equals(id)) {
                idx = i;
                found = true;
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(null, shop.productTitles.get(idx));
        }
    }

    public static void showPrice(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        int idx = -1;
        boolean found = false;
        for (int i = 0; i < shop.productIds.size() && !found; i++) {
            if (shop.productIds.get(i).equals(id)) {
                idx = i;
                found = true;
            }
        }
        if (found) {
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            JOptionPane.showMessageDialog(null, shop.getPrice(idx, days));
        }
    }
}
