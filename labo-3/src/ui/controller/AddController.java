package ui.controller;

import domain.db.PartyItemDb;
import domain.model.PartyItem;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.view.AddView;

class AddController {
    private AddView view;
    private PartyItemDb partyItemDb;
    private Stage primaryStage;

    AddController() {
        this.view = new AddView();
    }

    void launch(MainController mainController) {
        this.primaryStage = mainController.getPrimaryStage();
        view.setCancelListener(() -> view.clearTextField());
        view.setConfirmListener((name, value) -> {
            handleInput(name, value, mainController);

        });
        Scene addScene = new Scene(view.getRootView(), 500, 300);
        primaryStage.setScene(addScene);
        primaryStage.show();
    }

    // TODO enforce name uniqueness + show error message if input is wrong
    private void handleInput(String name, String value, MainController mainController) {
        double actualValue;
        try {
            this.partyItemDb = mainController.getPartyItemDb();
            actualValue = Double.parseDouble(value);
            partyItemDb.add(new PartyItem(name, actualValue));
            mainController.launch(primaryStage);
        } catch (NumberFormatException exc) {
            view.clearTextField();
        }
    }
}
