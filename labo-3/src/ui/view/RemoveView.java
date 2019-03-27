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

public class RemoveView {

    private GridPane root;
    private TextField choice;

    private RemoveView.OnConfirmListener confirmListener;
    private RemoveView.OnCancelListener cancelListener;

    public RemoveView() {
        this.root = new GridPane();
        this.root.setAlignment(Pos.BASELINE_CENTER);
        this.root.setPadding(new Insets(10));
        this.root.setVgap(5);
        this.root.setHgap(5);

        Label description = new Label("Remove party item");
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

        Button cancelButton = new Button("Cancel");
        cancelButton.setPrefWidth(100);
        cancelButton.setOnAction(arg -> {
            if (this.cancelListener != null) {
                this.cancelListener.onCancel();
            }
        });
        GridPane.setVgrow(cancelButton, Priority.ALWAYS);
        root.add(cancelButton, 0, partyItems.size() + 2, 1, 1);

        Button confirmButton = new Button("Remove item");
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

    public void setTextField(String text) {
        this.choice.setText(text);
    }

    public void setConfirmListener(RemoveView.OnConfirmListener listener) {
        this.confirmListener = listener;
    }

    public void setCancelListener(RemoveView.OnCancelListener listener) {
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
