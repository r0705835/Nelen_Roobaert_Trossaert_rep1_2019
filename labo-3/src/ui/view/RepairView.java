package ui.view;

import domain.model.PartyItem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.List;

public class RepairView {

    private GridPane root;
    private TextField choice;

    private RepairView.OnConfirmListener confirmListener;
    private RepairView.OnCancelListener cancelListener;

    public RepairView() {
        this.root = new GridPane();
        this.root.setAlignment(Pos.BASELINE_CENTER);
        this.root.setPadding(new Insets(10));
        this.root.setVgap(5);
        this.root.setHgap(5);

        Label description = new Label("Repair party item \n(only for damaged items)");
        root.add(description, 0, 0, 1, 1);
        GridPane.setVgrow(description, Priority.ALWAYS);
    }

    public void setPartyItems(List<PartyItem> partyItems) {
        int currentRowIndex = 1;
        for (int i = currentRowIndex; i < partyItems.size() + 1; i++) {
            PartyItem currentItem = partyItems.get(i - 1);
            Label itemLabel = new Label(i + ". " + currentItem.toString() + "\n" + currentItem.getState().toString());
            root.add(itemLabel, 0, i, 1, 1);
            GridPane.setVgrow(itemLabel, Priority.ALWAYS);
        }

        Label choiceLabel = new Label("Make your choice:");
        root.add(choiceLabel, 0, partyItems.size() + 1, 1, 1);
        GridPane.setVgrow(choiceLabel, Priority.ALWAYS);

        TextField choiceTextField = new TextField();
        GridPane.setVgrow(choiceTextField, Priority.ALWAYS);
        root.add(choiceTextField, 1, partyItems.size() + 1, 1, 1);
        this.choice = choiceTextField;

        Button cancelButton = new Button("Go back");
        cancelButton.setPrefWidth(100);
        cancelButton.setOnAction(arg -> {
            if (this.cancelListener != null) {
                this.cancelListener.onCancel();
            }
        });
        GridPane.setVgrow(cancelButton, Priority.ALWAYS);
        root.add(cancelButton, 0, partyItems.size() + 2, 1, 1);

        Button confirmButton = new Button("Repair item");
        confirmButton.setPrefWidth(100);
        confirmButton.setOnAction(arg -> {
            if (this.confirmListener != null) {
                this.confirmListener.onConfirm(
                        choiceTextField.getText());
            }
        });
        GridPane.setVgrow(confirmButton, Priority.ALWAYS);
        root.add(confirmButton, 1, partyItems.size() + 2, 1, 1);
    }

    public void clearTextField() {
        this.choice.setText("");
    }

    public void setChoiceTextField(String text) {
        this.choice.setText(text);
    }

    public void setConfirmListener(RepairView.OnConfirmListener listener) {
        this.confirmListener = listener;
    }

    public void setCancelListener(RepairView.OnCancelListener listener) {
        this.cancelListener = listener;
    }

    public Parent getRootView() {
        return root;
    }

    @FunctionalInterface
    public interface OnConfirmListener {
        void onConfirm(String number);
    }

    @FunctionalInterface
    public interface OnCancelListener {
        void onCancel();
    }
}
