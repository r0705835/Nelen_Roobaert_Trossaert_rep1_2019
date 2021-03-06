package ui.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CipherUI cipherUI = new CipherUI();
        cipherUI.start(primaryStage);
    }
}
