package ui.controller;

import domain.db.PartyItemDb;
import domain.model.PartyItem;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.view.ShowView;

import java.util.List;
import java.util.stream.Collectors;

class ShowController {

    private ShowView view;
    private Stage primaryStage;
    private MainController mainController;

    ShowController() {
        this.view = new ShowView();
    }

    void launch(MainController controller) {
        this.mainController = controller;
        this.primaryStage = mainController.getPrimaryStage();
        view.setCancelListener(() -> mainController.launch(primaryStage));
        handleInput();
        Scene addScene = new Scene(view.getRootView(), 500, 300);
        primaryStage.setScene(addScene);
        primaryStage.show();
    }

    private void handleInput() {
        PartyItemDb partyItemDb = mainController.getPartyItemDb();
        List<PartyItem> partyItems = partyItemDb.getAll().stream()
                .filter(item -> item.getState().toString().equals("AVAILABLE")).collect(Collectors.toList());
        view.setPartyItems(partyItems);
    }
}
