package ui.view;

import domain.model.Shop;

import javax.swing.*;

import static domain.model.Shop.*;

public class ShopUI {
    public void start() {
        Shop shop = new Shop();
        String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Show all products\n5. Check availability\n\n0. Quit";
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
                showAvailability(shop);
            }
        }
    }
}
