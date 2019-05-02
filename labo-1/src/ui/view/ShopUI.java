package ui.view;

import domain.model.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import javax.swing.*;


public class ShopUI {
    Shop shop = new Shop();
    Scene scene;
    Stage primaryStage;

    public ShopUI(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Lab 1");

        Label menu = new Label("1. Add product\n2. Show product\n3. Show rental price\n4. Show all products\n5. Loan product\n6. Check availability\n\n0. Quit");
        TextField textField = new TextField();
        Button button1 = new Button("Submit");
        button1.setOnAction(e -> getScene(Integer.parseInt(textField.getText())));
        //Layout1

        FlowPane root = new FlowPane();
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setVgap(5);
        root.setHgap(5);
        root.getChildren().addAll(menu, textField, button1);
        Scene mainScene = new Scene(root, 250, 250);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private void getScene(int number) {
        switch (number) {
            case 1:
                addProductPage(primaryStage, shop);
                break;
            case 2:
                showProduct(shop);
                break;
            case 3:
                showPrice(shop);
                break;
            case 4:
                showProducts(shop);
                break;
            case 5:
                loan(shop);
                break;
            case 6:
                showAvailability(shop);
                break;
            default:
                addProductPage(primaryStage, shop);
        }
    }

    public void addProductPage(Stage primaryStage, Shop shop) {
        Label title = new Label("Enter the title:");
        TextField titleField = new TextField();
        Label type = new Label("Enter the type (M for movie/G for game/ C for CD):");
        TextField typeField = new TextField();
        Button button1 = new Button("Submit");
        button1.setOnAction(e -> getScene(addProduct(titleField.getText(), typeField.getText().toUpperCase().charAt(0))));
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setVgap(5);
        root.setHgap(5);
        Scene scene = new Scene(root, 200, 200);
        root.getChildren().addAll(title, titleField, type, typeField);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private int addProduct(String title, char type) {
        Product p;
        switch (type) {
            case 'M':
                p = new Movie(title);
                break;
            case 'G':
                p = new Game(title);
                break;
            default:
                p = new CD(title);
        }
        shop.addProduct(p);
        return 1;
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
