package ui.view;

import domain.model.*;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

import static domain.model.Shop.*;

public class ShopUI {
    Shop shop = new Shop();

    public void start() {
        read();
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

    private void read() {
        try (Scanner scanner = new Scanner(new File("c:/temp/shop.txt"))) {
            while (scanner.hasNextLine()) {
                String type = scanner.next();
                int id = Integer.parseInt(scanner.next());
                String title = scanner.next();
                Product p;
                if (type.toUpperCase().equals("M")) {
                    p = new Movie(title, id);
                } else if (type.toUpperCase().equals("G")) {
                    p = new Game(title, id);
                } else {
                    p = new CD(title, id);
                }
                shop.getProducts().add(p);
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void print() throws IOException {
        FileWriter fileWriter = new FileWriter("c:/temp/shop.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (Product product : shop.getProducts()) {
            if (product instanceof Movie) {
                printWriter.print("M ");
            } else if (product instanceof Game) {
                printWriter.print("G ");
            } else {
                printWriter.print("C ");
            }
            printWriter.println(product.getId() + " " + product.getTitle());
        }
        printWriter.close();
    }
}
