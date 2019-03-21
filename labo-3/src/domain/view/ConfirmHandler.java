package domain.view;

import domain.db.PartyItemDb;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
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
                pane.add(infoLabel, 0, 0 ,0, 0);
                Label nameLabel = new Label("Name:");
                pane.add(nameLabel, 0, 1 ,0, 0);
                TextField nameTextField = new TextField();
                pane.add(nameTextField, 0, 2, 0, 0);
                Label priceLabel = new Label("Price:");
                pane.add(priceLabel, 0, 1 ,0, 0);
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