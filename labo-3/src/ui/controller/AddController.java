package ui.controller;

import domain.db.PartyItemDb;
import domain.model.PartyItem;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.view.AddView;

class AddController {

    private AddView view;
    private Stage primaryStage;
    private MainController mainController;

    AddController() {
        this.view = new AddView();
    }

    void launch(MainController controller) {
        this.mainController = controller;
        this.primaryStage = mainController.getPrimaryStage();
        view.setCancelListener(() -> view.clearTextField());
        view.setConfirmListener(this::handleInput);
        Scene addScene = new Scene(view.getRootView(), 500, 300);
        primaryStage.setScene(addScene);
        primaryStage.show();
    }

    // TODO enforce name uniqueness + show error message if input is wrong
    private void handleInput(String name, String value) {
        PartyItemDb partyItemDb = mainController.getPartyItemDb();
        try {
            partyItemDb.add(new PartyItem(name, Double.parseDouble(value)));
            mainController.launch(primaryStage);
        } catch (NumberFormatException exc) {
            view.clearTextField();
        }
    }
}
