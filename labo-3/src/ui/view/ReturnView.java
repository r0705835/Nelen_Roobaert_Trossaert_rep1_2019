package ui.view;

import domain.model.PartyItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.List;

public class ReturnView {

    private GridPane root;
    private TextField choice;
    private List<Label> itemLabelList;
    private ComboBox<String> damaged;
    private Label returnLabel;

    private ReturnView.OnConfirmListener confirmListener;
    private ReturnView.OnCancelListener cancelListener;

    public ReturnView() {
        this.root = new GridPane();
        this.root.setAlignment(Pos.BASELINE_CENTER);
        this.root.setPadding(new Insets(10));
        this.root.setVgap(5);
        this.root.setHgap(5);

        Label description = new Label("Return party item \n(only for rented items)");
        root.add(description, 0, 0, 1, 1);
        GridPane.setVgrow(description, Priority.ALWAYS);
    }

    public void setPartyItems(List<PartyItem> partyItems) {
        itemLabelList = new ArrayList<>();
        int currentRowIndex = 1;
        for (int i = currentRowIndex; i < partyItems.size() + 1; i++) {
            PartyItem currentItem = partyItems.get(i - 1);
            Label itemLabel = new Label(i + ". " + currentItem.toString() + "\n" + currentItem.getState().toString());
            itemLabelList.add(i-1, itemLabel);
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

        Label damagedLabel = new Label("Damaged?");
        root.add(damagedLabel, 0, partyItems.size() + 2, 1, 1);
        GridPane.setVgrow(damagedLabel, Priority.ALWAYS);

        damaged = new ComboBox<>();
        ObservableList<String> damagedOptions = FXCollections.observableArrayList("Yes", "No");
        ComboBox<String> damagedBox = new ComboBox<>(damagedOptions);
        this.damaged = damagedBox;
        root.add(damagedBox, 1, partyItems.size() + 2, 1, 1);
        GridPane.setVgrow(damagedBox, Priority.ALWAYS);

        Button cancelButton = new Button("Go back");
        cancelButton.setPrefWidth(100);
        cancelButton.setOnAction(arg -> {
            if (this.cancelListener != null) {
                this.cancelListener.onCancel();
            }
        });
        GridPane.setVgrow(cancelButton, Priority.ALWAYS);
        root.add(cancelButton, 0, partyItems.size() + 3, 1, 1);

        Button confirmButton = new Button("Return item");
        confirmButton.setPrefWidth(100);
        confirmButton.setOnAction(arg -> {
            if (this.confirmListener != null) {
                this.confirmListener.onConfirm(
                        choiceTextField.getText(), damaged.getValue());
            }
        });
        GridPane.setVgrow(confirmButton, Priority.ALWAYS);
        root.add(confirmButton, 1, partyItems.size() + 3, 1, 1);

        returnLabel = new Label("");
        root.add(returnLabel, 0, GridPane.getRowIndex(choice) + 4, 1, 1);
        GridPane.setVgrow(returnLabel, Priority.ALWAYS);
    }

    public void repaintPartyItems(List<PartyItem> partyItems, double returnCost) {
        for (int i = 0; i < partyItems.size(); i++) {
            PartyItem currentItem = partyItems.get(i);
            Label itemLabel = itemLabelList.get(i);
            itemLabel.setText(i + ". " + currentItem.toString() + "\n" + currentItem.getState().toString());
        }
        if (returnCost > 0)
            this.returnLabel.setText("You are returning this damaged item for a cost of € " + returnCost + ".");
    }

    public void clearTextField() {
        this.choice.setText("");
    }

    public void setChoiceTextField(String text) {
        this.choice.setText(text);
    }

    public void setConfirmListener(ReturnView.OnConfirmListener listener) {
        this.confirmListener = listener;
    }

    public void setCancelListener(ReturnView.OnCancelListener listener) {
        this.cancelListener = listener;
    }

    public Parent getRootView() {
        return root;
    }

    @FunctionalInterface
    public interface OnConfirmListener {
        void onConfirm(String number, String damaged);
    }

    @FunctionalInterface
    public interface OnCancelListener {
        void onCancel();
    }
}
