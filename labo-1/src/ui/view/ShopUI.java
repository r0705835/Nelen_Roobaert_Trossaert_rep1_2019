package ui.view;

import domain.model.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import javax.swing.*;


public class MainView {
    Shop shop = new Shop();


    private OnCancelListener cancelListener;
    private OnConfirmListener confirmListener;

    public MainView() {
        this.root = new GridPane();
        this.root.setAlignment(Pos.BASELINE_CENTER);
        this.root.setPadding(new Insets(10));
        this.root.setVgap(5);
        this.root.setHgap(5);

        Label description = new Label("1. Add party item\n2. Remove party item\n3. Rent party item\n4. Return party item"
                + "\n5. Repair party item\n6. Show available party items\n\n0. Stop\n\nMake your choice:");
        root.add(description, 0, 0, 1, 1);
        GridPane.setVgrow(description, Priority.ALWAYS);

        TextField choiceTextField = new TextField();
        GridPane.setVgrow(choiceTextField, Priority.ALWAYS);
        root.add(choiceTextField, 0, 1, 1, 1);
        this.input = choiceTextField;

        Button cancelButton = new Button("Cancel");
        cancelButton.setPrefWidth(100);
        cancelButton.setOnAction(arg -> {
            if (this.cancelListener != null) {
                this.cancelListener.onCancel();
            }
        });
        GridPane.setVgrow(cancelButton, Priority.ALWAYS);
        root.add(cancelButton, 0, 2, 1, 1);

        Button confirmButton = new Button("OK");
        confirmButton.setPrefWidth(100);
        confirmButton.setOnAction(arg -> {
            if (this.confirmListener != null) {
                this.confirmListener.onConfirm(choiceTextField.getText());
            }
        });
        GridPane.setVgrow(confirmButton, Priority.ALWAYS);
        root.add(confirmButton, 1, 2, 1, 1);
        /*int choice = -1;
        while (choice != 0) {
            TextField choiceString = JOptionPane.showInputDialog(menu);
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
    }*/

    @FunctionalInterface
    public interface OnConfirmListener {
        void onConfirm(String value);
    }

    @FunctionalInterface
    public interface OnCancelListener {
        void onCancel();
    }
}
