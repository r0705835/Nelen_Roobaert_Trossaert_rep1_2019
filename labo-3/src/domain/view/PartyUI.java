package domain.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class PartyUI {

    void start(Stage primaryStage) {
        primaryStage.setTitle("FunForRent");
        GridPane root = new GridPane();
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setPadding(new Insets(10));
        root.setVgap(5);
        root.setHgap(5);
        final Label addLabel = new Label("1. Add party item");
        root.add(addLabel, 0, 0, 1, 1);
        GridPane.setVgrow(addLabel, Priority.ALWAYS);
        final Label removeLabel = new Label("2. Remove party item");
        root.add(removeLabel, 0, 1, 1, 1);
        GridPane.setVgrow(removeLabel, Priority.ALWAYS);
        final Label rentLabel = new Label("3. Rent party item");
        root.add(rentLabel, 0, 2, 1, 1);
        GridPane.setVgrow(rentLabel, Priority.ALWAYS);
        final Label returnLabel = new Label("4. Return party item");
        root.add(returnLabel, 0, 3, 1, 1);
        GridPane.setVgrow(returnLabel, Priority.ALWAYS);
        final Label repairLabel = new Label("5. Repair party item");
        root.add(repairLabel, 0, 4, 1, 1);
        GridPane.setVgrow(repairLabel, Priority.ALWAYS);
        final Label showLabel = new Label("6. Show available party items");
        root.add(showLabel, 0, 5, 1, 1);
        GridPane.setVgrow(showLabel, Priority.ALWAYS);
        final Label emptyLabel1 = new Label("");
        root.add(emptyLabel1, 0, 6, 1, 1);
        emptyLabel1.setPrefHeight(10);
        final Label stopLabel = new Label("0. Stop");
        root.add(stopLabel, 0, 7, 1, 1);
        GridPane.setVgrow(addLabel, Priority.ALWAYS);
        final Label emptyLabel2 = new Label("");
        emptyLabel2.setPrefHeight(10);
        root.add(emptyLabel2, 0, 8, 1, 1);
        final Label choiceLabel = new Label("Make your choice:");
        root.add(choiceLabel, 0, 9, 1, 1);
        GridPane.setVgrow(choiceLabel, Priority.ALWAYS);
        TextField choiceTextField = new TextField();
        root.add(choiceTextField, 0, 10, 3, 1);
        GridPane.setVgrow(choiceTextField, Priority.ALWAYS);
        Button cancelButton = new Button("Cancel");
        cancelButton.setPrefWidth(100);
        root.add(cancelButton, 0, 11, 1, 1);
        GridPane.setVgrow(cancelButton, Priority.ALWAYS);
        Button confirmButton = new Button("OK");
        confirmButton.setPrefWidth(100);
        root.add(confirmButton, 1, 11, 1, 1);
        GridPane.setVgrow(confirmButton, Priority.ALWAYS);
        Scene mainScene = new Scene(root, 500, 300);
        primaryStage.setScene(mainScene);
        //root.setGridLinesVisible(true);
        primaryStage.show();
    }
}