package ui.view;

import domain.model.PartyItem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.List;

public class ShowView {

    private GridPane root;
    private ShowView.OnCancelListener cancelListener;

    public ShowView() {
        this.root = new GridPane();
        this.root.setAlignment(Pos.BASELINE_CENTER);
        this.root.setPadding(new Insets(10));
        this.root.setVgap(5);
        this.root.setHgap(5);

        Label description = new Label("Show available party items");
        root.add(description, 0, 0, 1, 1);
        GridPane.setVgrow(description, Priority.ALWAYS);

        Label nameLabel = new Label("Name");
        root.add(nameLabel, 0, 1, 1, 1);
        GridPane.setVgrow(description, Priority.ALWAYS);

        Label valueLabel = new Label("Value");
        root.add(valueLabel, 1, 1, 1, 1);
        GridPane.setVgrow(valueLabel, Priority.ALWAYS);
    }

    public void setPartyItems(List<PartyItem> partyItems) {
        int currentRowIndex = 2;
        for (int i = currentRowIndex; i < partyItems.size() + 2; i++) {
            PartyItem currentItem = partyItems.get(i - 2);
            Label itemName = new Label(currentItem.getName());
            root.add(itemName, 0, i, 1, 1);
            GridPane.setVgrow(itemName, Priority.ALWAYS);

            Label itemValue = new Label("€ " + currentItem.getValue());
            root.add(itemValue, 1, i, 1, 1);
            GridPane.setVgrow(itemValue, Priority.ALWAYS);
        }

        Button backButton = new Button("Go back");
        backButton.setPrefWidth(100);
        backButton.setOnAction(arg -> {
            if (this.cancelListener != null) {
                this.cancelListener.onCancel();
            }
        });
        GridPane.setVgrow(backButton, Priority.ALWAYS);
        root.add(backButton, 0, partyItems.size() + 3, 1, 1);
    }

    public void setCancelListener(ShowView.OnCancelListener listener) {
        this.cancelListener = listener;
    }

    public Parent getRootView() {
        return root;
    }

    @FunctionalInterface
    public interface OnCancelListener {
        void onCancel();
    }
}
