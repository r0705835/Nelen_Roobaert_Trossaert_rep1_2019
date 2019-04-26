package ui.view.launcher;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.controller.MainController;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainController controller = new MainController();
        controller.launch(primaryStage);
    }
}