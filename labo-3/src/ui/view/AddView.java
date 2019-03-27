package ui.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class AddView {
    private GridPane root;
    private TextField name;
    private TextField value;

    private AddView.OnCancelListener cancelListener;
    private AddView.OnConfirmListener confirmListener;

    public AddView() {
        this.root = new GridPane();
        this.root.setAlignment(Pos.BASELINE_CENTER);
        this.root.setPadding(new Insets(10));
        this.root.setVgap(5);
        this.root.setHgap(5);

        Label description = new Label("Add party item");
        root.add(description, 0, 0, 1, 1);
        GridPane.setVgrow(description, Priority.ALWAYS);

        Label nameLabel = new Label("Name:");
        root.add(nameLabel, 0, 1, 1, 1);
        GridPane.setVgrow(description, Priority.ALWAYS);

        TextField nameTextField = new TextField();
        GridPane.setVgrow(nameTextField, Priority.ALWAYS);
        root.add(nameTextField, 1, 1, 1, 1);
        this.name = nameTextField;

        Label valueLabel = new Label("Value:");
        root.add(valueLabel, 0, 2, 1, 1);
        GridPane.setVgrow(valueLabel, Priority.ALWAYS);

        TextField valueTextField = new TextField();
        GridPane.setVgrow(valueTextField, Priority.ALWAYS);
        root.add(valueTextField, 1, 2, 1, 1);
        this.value = valueTextField;

        Button cancelButton = new Button("Cancel");
        cancelButton.setPrefWidth(100);
        cancelButton.setOnAction(arg -> {
            if (this.cancelListener != null) {
                this.cancelListener.onCancel();
            }
        });
        GridPane.setVgrow(cancelButton, Priority.ALWAYS);
        root.add(cancelButton, 0, 3, 1, 1);

        Button confirmButton = new Button("Add item");
        confirmButton.setPrefWidth(100);
        confirmButton.setOnAction(arg -> {
            if (this.confirmListener != null) {
                this.confirmListener.onConfirm(
                        nameTextField.getText(), valueTextField.getText());
            }
        });
        GridPane.setVgrow(confirmButton, Priority.ALWAYS);
        root.add(confirmButton, 1, 3, 1, 1);
    }

    public void clearTextField() {
        this.name.setText("");
        this.value.setText("");
    }

    public void setCancelListener(AddView.OnCancelListener listener) {
        this.cancelListener = listener;
    }

    public void setConfirmListener(AddView.OnConfirmListener listener) {
        this.confirmListener = listener;
    }

    public Parent getRootView() {
        return root;
    }

    @FunctionalInterface
    public interface OnConfirmListener {
        void onConfirm(String name, String value);
    }

    @FunctionalInterface
    public interface OnCancelListener {
        void onCancel();
    }
}
