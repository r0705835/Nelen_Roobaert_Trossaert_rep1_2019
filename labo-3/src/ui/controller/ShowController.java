package ui.controller;

import domain.db.PartyItemDb;
import domain.model.PartyItem;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.view.ShowView;

import java.util.List;

class ShowController {
    private ShowView view;
    private PartyItemDb partyItemDb;
    private Stage primaryStage;

    ShowController() {
        this.view = new ShowView();
    }

    void launch(MainController mainController) {
        this.primaryStage = mainController.getPrimaryStage();
        view.setCancelListener(() -> mainController.launch(primaryStage));
        handleInput(mainController);
        Scene addScene = new Scene(view.getRootView(), 500, 300);
        primaryStage.setScene(addScene);
        primaryStage.show();
    }

    private void handleInput(MainController mainController) {
        this.partyItemDb = mainController.getPartyItemDb();
        List<PartyItem> partyItems = partyItemDb.getAll();
        view.setPartyItems(partyItems);
    }
}
