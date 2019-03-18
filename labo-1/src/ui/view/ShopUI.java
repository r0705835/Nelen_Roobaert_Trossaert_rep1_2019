package ui.view;

import domain.model.*;

import javax.swing.*;


public class ShopUI {
    Shop shop = new Shop();

    public void start() {
        String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Show all products\n5. Loan product\n6. Check availability\n\n0. Quit";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                addProduct(shop);
            } else if (choice == 2) {
                showProduct(shop);
            } else if (choice == 3) {
                showPrice(shop);
            } else if (choice == 4) {
                showProducts(shop);
            } else if (choice == 5) {
                loan(shop);
            } else if (choice == 6) {
                showAvailability(shop);
            }
        }
    }

    public static void addProduct(Shop shop) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        char type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/ C for CD):").toUpperCase().charAt(0);
        Product p;
        if (type == 'M') {
            p = new Movie(title);
            shop.addProduct(p);
        } else if (type == 'G') {
            p = new Game(title);
            shop.addProduct(p);
        } else if (type == 'C') {
            p = new CD(title);
            shop.addProduct(p);
        } else {
            JOptionPane.showMessageDialog(null, "The given type does not exist!");
        }
    }

    public static void showProduct(Shop shop) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        try {
            JOptionPane.showMessageDialog(null, shop.getProduct(id));
        } catch (IllegalArgumentException E) {
            JOptionPane.showMessageDialog(null, "Requested product not found");
        }
    }

    public static void showPrice(Shop shop) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        int days = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of days:"));
        try {
            JOptionPane.showMessageDialog(null, shop.getPrice(id, days));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Requested product not found");

        }
    }

    public static void showProducts(Shop shop) {
        JOptionPane.showMessageDialog(null, shop.getSortedList());
    }

    public static void loan(Shop shop) {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id:"));
        try {
            if (shop.getProduct(id).isAvailable()) {
                shop.getProduct(id).loan();
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
            boolean available = shop.showAvailability(id);
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
