package domain.view;

import domain.db.PartyItemDb;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CancelHandler extends ButtonHandler implements EventHandler<ActionEvent> {

    CancelHandler(TextField choiceTextField, PartyItemDb partyItemDb, Stage primaryStage) {
        super(choiceTextField, partyItemDb, primaryStage);
    }

    @Override
    public void handle(ActionEvent event) {
        getPrimaryStage().setScene(getInitialScene());
    }
}