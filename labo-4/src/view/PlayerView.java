package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Game;
import model.Player;

public class PlayerView implements Observer {
    private Stage stage = new Stage();
    private Scene playerScene;
    private Label diceLabel;
    private Button playButton;
    private Label messageLabel;

    private Game game;
    private final int MAX_TURNS = 4;
    private final int PLAYER_AMOUNT = 3;
    private int turnNumber;
    private int playerNumber;
    private Player player;

    public PlayerView(Game game, int playerNumber) {
        this.game = game;
        game.registerObserver(this);
        this.playerNumber = playerNumber;
        player = new Player(0);
        turnNumber = 1;

        diceLabel = new Label("Turn " + turnNumber + ": ");
        playButton = new Button("Throw dice");
        playButton.setOnAction(new ThrowDiceHandler());
        playButton.setDisable(true);
        messageLabel = new Label("Game has not started yet");
        layoutComponents();
        stage.setScene(playerScene);
        stage.setTitle("Player " + playerNumber);
        stage.setResizable(false);
        stage.setX(100 + (playerNumber - 1) * 350);
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

    public void update(int turnNumber, int playerNumber, int score1, int score2, int newestScore, int totalScore) {
        if (turnNumber < MAX_TURNS && playerNumber == PLAYER_AMOUNT) {
            this.turnNumber += 1;
            diceLabel.setText("Turn " + this.turnNumber + ": ");
        }
        if (this.playerNumber == playerNumber) {
            messageLabel.setText(score1 + " and " + score2 + " - score " + newestScore);
            this.isPlaying(false);
        } else {
            messageLabel.setText("Player " + playerNumber + " throws "
                    + score1 + " and " + score2 + " - score " + newestScore);
            if (turnNumber <= MAX_TURNS && playerNumber == this.playerNumber - 1) {
                this.isPlaying(true);
            } else if (turnNumber < MAX_TURNS && (playerNumber == PLAYER_AMOUNT && this.playerNumber == 1)) {
                this.isPlaying(true);
            }

        }
        if (turnNumber == MAX_TURNS && playerNumber == PLAYER_AMOUNT) {
            diceLabel.setText("Game over!");
            messageLabel.setText("");
        }
    }

    class ThrowDiceHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            int newestPartialScore1 = player.throwDice();
            int newestPartialScore2 = player.throwDice();
            int newestScore = player.calculateScore(newestPartialScore1, newestPartialScore2);
            player.addScore(newestScore);
            int totalScore = player.getTotalScore();
            game.setGameData(turnNumber, playerNumber,
                    newestPartialScore1, newestPartialScore2, newestScore, totalScore);
        }
    }
}
