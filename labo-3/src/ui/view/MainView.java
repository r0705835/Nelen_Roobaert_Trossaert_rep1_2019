package ui.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class MainView {
    private GridPane root;
    private TextField input;

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
    }

    public void clearTextField() {
        this.input.setText("");
    }

    public void setCancelListener(OnCancelListener listener) {
        this.cancelListener = listener;
    }

    public void setConfirmListener(OnConfirmListener listener) {
        this.confirmListener = listener;
    }

    public Parent getRootView() {
        return root;
    }

    @FunctionalInterface
    public interface OnConfirmListener {
        void onConfirm(String value);
    }

    @FunctionalInterface
    public interface OnCancelListener {
        void onCancel();
    }
}
