package ui.view;

import domain.model.CipherContext;
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
import ui.controller.DecodeHandler;
import ui.controller.EncodeHandler;

class CipherUI {

    private CipherContext cipherContext;

    // TODO refactor this!
    void start(Stage primaryStage) {
        primaryStage.setTitle("Decodeer/encodeer");
        GridPane root = new GridPane();
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setPadding(new Insets(10));
        root.setVgap(5);
        root.setHgap(5);
        final Label sentenceLabel = new Label("Typ zin:");
        root.add(sentenceLabel, 0, 0, 1, 1);
        GridPane.setVgrow(sentenceLabel, Priority.ALWAYS);
        final TextField sentenceTextField = new TextField();
        root.add(sentenceTextField, 1, 0, 1, 1);
        GridPane.setVgrow(sentenceTextField, Priority.ALWAYS);
        final Label algorithmLabel = new Label("Kies algoritme:");
        root.add(algorithmLabel, 0, 1, 1, 1);
        GridPane.setVgrow(algorithmLabel, Priority.ALWAYS);
        cipherContext = new CipherContext(sentenceTextField.getText());
        ObservableList<String> algorithmOptions = FXCollections.observableList(cipherContext.getCipherStrategyList());
        final ComboBox<String> algorithmBox = new ComboBox<>(algorithmOptions);
        algorithmBox.getSelectionModel().selectFirst();
        root.add(algorithmBox, 1, 1, 1, 1);
        GridPane.setVgrow(algorithmBox, Priority.ALWAYS);
        GridPane.setHalignment(algorithmBox, HPos.RIGHT);
        final Label resultLabel = new Label();
        final Button encodeButton = new Button("Codeer");
        encodeButton.setOnAction(new EncodeHandler(sentenceTextField, algorithmBox, resultLabel));
        root.add(encodeButton, 0, 2, 1, 1);
        GridPane.setVgrow(encodeButton, Priority.ALWAYS);
        final Button decodeButton = new Button("Decodeer");
        decodeButton.setOnAction(new DecodeHandler(sentenceTextField, algorithmBox, resultLabel));
        root.add(decodeButton, 1, 2, 1, 1);
        GridPane.setVgrow(decodeButton, Priority.ALWAYS);
        GridPane.setHalignment(decodeButton, HPos.RIGHT);
        root.add(resultLabel, 0, 3, 1, 1);
        GridPane.setVgrow(resultLabel, Priority.ALWAYS);
        Scene mainScene = new Scene(root, 500, 500);
        primaryStage.setScene(mainScene);
        //root.setGridLinesVisible(true);
        primaryStage.show();
    }
}