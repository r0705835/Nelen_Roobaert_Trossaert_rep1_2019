package ui.controller;

import domain.db.PartyItemDb;
import domain.model.PartyItem;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.view.MainView;

public class MainController {
    private MainView view;
    private PartyItemDb partyItemDb;
    private Stage primaryStage;
    private Scene mainScene;

    public MainController(PartyItemDb partyItemDb) {
        this.view = new MainView();
        this.partyItemDb = partyItemDb;
    }

    PartyItemDb getPartyItemDb() {
        return this.partyItemDb;
    }

    Stage getPrimaryStage() {
        return primaryStage;
    }

    public void launch(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("FunForRent");
        view.setCancelListener(() -> view.clearTextField());
        view.setConfirmListener(text -> {
            System.out.println("" + text + " was selected");
            handleInput(text);
            view.clearTextField();
        });
        if(mainScene == null)
            mainScene = new Scene(view.getRootView(), 500, 300);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private void handleInput(String input) {
        int choice = -1;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException exc) {
            // TODO show error message if input is wrong
            view.clearTextField();
        }

        switch (choice) {
            case -1:
                Platform.exit();
            case 0:
                view.clearTextField();
                break;
            case 1:
                AddController addController = new AddController();
                addController.launch(this);
                break;
            case 6:
                ShowController showController = new ShowController();
                showController.launch(this);
            default:
                // TODO show error message if input is wrong
                view.clearTextField();
                break;
        }
    }
}