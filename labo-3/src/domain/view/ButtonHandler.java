package domain.view;

import domain.db.PartyItemDb;
import domain.model.PartyItem;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

abstract class ButtonHandler {

    private TextField choiceTextField;
    private PartyItemDb partyItemDb;
    private Stage primaryStage;
    private Scene initialScene;

    ButtonHandler(TextField choiceTextField, PartyItemDb partyItemDb, Stage primaryStage) {
        setChoiceTextField(choiceTextField);
        setPartyItemDb(partyItemDb);
        setPrimaryStage(primaryStage);
    }

    TextField getChoiceTextField() {
        return this.choiceTextField;
    }

    void setChoiceTextField(TextField choiceTextField) {
        this.choiceTextField = choiceTextField;
    }

    PartyItemDb getPartyItemDb() {
        return this.partyItemDb;
    }

    void setPartyItemDb(PartyItemDb partyItemDb) {
        this.partyItemDb = partyItemDb;
    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        setInitialScene(primaryStage.getScene());
    }

    public Scene getInitialScene() {
        return initialScene;
    }

    public void setInitialScene(Scene initialScene) {
        this.initialScene = initialScene;
    }

}