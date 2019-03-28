package ui.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class PlayerView implements Observer {
    private Stage stage = new Stage();
    private Scene playerScene;
    private Label diceLabel;
    private Button playButton;
    private Label messageLabel;
    private int playerId;

    public PlayerView(int playerId) {
        this.playerId = playerId;
        diceLabel = new Label("turn 1: ");
        playButton = new Button("Throw dice");
        playButton.setOnAction(new ThrowDiceHandler());
        playButton.setDisable(true);
        messageLabel = new Label("Game hasn't started yet!");
        layoutComponents();
        stage.setScene(playerScene);
        stage.setTitle("Player " + playerId);
        stage.setResizable(false);
        stage.setX(100 + (playerId - 1) * 350);
        stage.setY(200);
        stage.show();
    }

    private void layoutComponents() {
        VBox root = new VBox(10);
        playerScene = new Scene(root, 250, 100);
        root.getChildren().add(playButton);
        root.getChildren().add(diceLabel);
        root.getChildren().add(messageLabel);
    }

    public void isPlaying(boolean playing) {
        playButton.setDisable(!playing);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    class ThrowDiceHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

        }
    }
}
