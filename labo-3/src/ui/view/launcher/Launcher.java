package ui.view.launcher;

import domain.db.PartyItemDb;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.controller.MainController;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        PartyItemDb partyItemDb = new PartyItemDb();
        MainController controller = new MainController(partyItemDb);
        controller.launch(primaryStage);
    }
}