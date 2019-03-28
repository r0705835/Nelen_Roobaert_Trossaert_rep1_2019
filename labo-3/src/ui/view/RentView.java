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

import java.util.ArrayList;
import java.util.List;

public class RentView {

    private GridPane root;
    private TextField choice;
    private List<Label> itemLabelList;
    private Label costLabel;

    private RentView.OnConfirmListener confirmListener;
    private RentView.OnCancelListener cancelListener;

    public RentView() {
        this.root = new GridPane();
        this.root.setAlignment(Pos.BASELINE_CENTER);
        this.root.setPadding(new Insets(10));
        this.root.setVgap(5);
        this.root.setHgap(5);

        Label description = new Label("Rent party item \n(only for available items)");
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

        Button cancelButton = new Button("Go back");
        cancelButton.setPrefWidth(100);
        cancelButton.setOnAction(arg -> {
            if (this.cancelListener != null) {
                this.cancelListener.onCancel();
            }
        });
        GridPane.setVgrow(cancelButton, Priority.ALWAYS);
        root.add(cancelButton, 0, partyItems.size() + 2, 1, 1);

        Button confirmButton = new Button("Rent item");
        confirmButton.setPrefWidth(100);
        confirmButton.setOnAction(arg -> {
            if (this.confirmListener != null) {
                this.confirmListener.onConfirm(
                        choiceTextField.getText());
            }
        });
        GridPane.setVgrow(confirmButton, Priority.ALWAYS);
        root.add(confirmButton, 1, partyItems.size() + 2, 1, 1);

        costLabel = new Label("");
        root.add(costLabel, 0, GridPane.getRowIndex(choice) + 2, 1, 1);
        GridPane.setVgrow(costLabel, Priority.ALWAYS);
    }

    public void repaintPartyItems(List<PartyItem> partyItems, double rentCost) {
        for (int i = 0; i < partyItems.size(); i++) {
            PartyItem currentItem = partyItems.get(i);
            Label itemLabel = itemLabelList.get(i);
            itemLabel.setText(i + ". " + currentItem.toString() + "\n" + currentItem.getState().toString());
        }
        this.costLabel.setText("You are renting this item for a cost of € " + rentCost + ".");
    }

    public void clearTextField() {
        this.choice.setText("");
    }

    public void setChoiceTextField(String text) {
        this.choice.setText(text);
    }

    public void setConfirmListener(RentView.OnConfirmListener listener) {
        this.confirmListener = listener;
    }

    public void setCancelListener(RentView.OnCancelListener listener) {
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
