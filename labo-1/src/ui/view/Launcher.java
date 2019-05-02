package ui.view;

import domain.db.TextDB;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ShopUI shopUI = new ShopUI(primaryStage);
        TextDB textDB = new TextDB();
        textDB.read(shopUI.shop);
        textDB.print(shopUI.shop);
    }
}