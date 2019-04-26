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

    public MainController() {
        this.view = new MainView();
        this.partyItemDb = new PartyItemDb();
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
            handleInput(text);
            view.clearTextField();
        });
        if (mainScene == null)
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
            case 2:
                RemoveController removeController = new RemoveController();
                removeController.launch(this);
                break;
            case 3:
                RentController rentController = new RentController();
                rentController.launch(this);
                break;
            case 4:
                ReturnController returnController = new ReturnController();
                returnController.launch(this);
                break;
            case 5:
                RepairController repairController = new RepairController();
                repairController.launch(this);
                break;
            case 6:
                ShowController showController = new ShowController();
                showController.launch(this);
                break;
            default:
                // TODO show error message if input is wrong
                view.clearTextField();
                break;
        }
    }
}