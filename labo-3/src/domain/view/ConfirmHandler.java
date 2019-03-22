package domain.view;

import domain.db.PartyItemDb;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConfirmHandler extends ButtonHandler implements EventHandler<ActionEvent> {

    ConfirmHandler(TextField choiceTextField, PartyItemDb partyItemDb, Stage primaryStage) {
        super(choiceTextField, partyItemDb, primaryStage);
    }

    @Override
    public void handle(ActionEvent event) {
        String choiceNumber = getChoiceTextField().getText();
        switch (choiceNumber) {
            case "0":
                Platform.exit();
                break;
            case "1":
                GridPane pane = new GridPane();
                pane.setAlignment(Pos.BASELINE_CENTER);
                pane.setPadding(new Insets(10));
                pane.setVgap(5);
                pane.setHgap(5);
                Label infoLabel = new Label("Add party item");
                pane.add(infoLabel, 0, 0 ,1, 1);
                Label nameLabel = new Label("Name:");
                pane.add(nameLabel, 0, 1 ,1, 1);
                TextField nameTextField = new TextField();
                pane.add(nameTextField, 0, 2, 1, 1);
                Label priceLabel = new Label("Price:");
                pane.add(priceLabel, 0, 3 ,1, 1);
                TextField priceTextField = new TextField();
                pane.add(priceTextField, 0, 4, 1, 1);
                Button cancelButton = new Button("Cancel");
                cancelButton.setOnAction(new CancelHandler(getChoiceTextField(), getPartyItemDb(), getPrimaryStage()));
                pane.add(cancelButton, 0, 5, 1, 1);
                Button addButton = new Button("Add item");
/*
                addButton.setOnAction(new AddItemHandler(getPartyItemDb(), nameTextField, priceTextField, getPrimaryStage()));
*/
                pane.add(addButton, 1, 5, 1, 1);
                Scene scene = new Scene(pane, 500, 300);
                getPrimaryStage().setScene(scene);
                getPrimaryStage().show();
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            default:
                getChoiceTextField().setText("");
        }
    }
}