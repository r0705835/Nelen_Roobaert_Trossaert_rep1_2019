package view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Game;

import java.util.Arrays;

public class ScoreView implements Observer {

    private Stage stage = new Stage();
    private Scene scoreScene;
    private Label scoreLabel;

    private final int MAX_TURNS = 2;
    private final int PLAYER_AMOUNT = 3;

    private StringBuilder scoreLine = new StringBuilder();

    public ScoreView(Game game) {
        game.registerObserver(this);

        scoreLabel = new Label();
        scoreLabel.setStyle("-fx-font-family: \"Courier new\"; -fx-font-size: 12; -fx-text-fill: darkred;");

        layoutComponents();

        stage.setScene(scoreScene);
        stage.setTitle("Score overview");
        stage.setResizable(false);
        stage.setX(100);
        stage.setY(400);
        stage.show();
    }

    private void layoutComponents() {
        VBox root = new VBox();
        scoreScene = new Scene(root, 400, 200);
        root.getChildren().add(scoreLabel);
    }

    private void addScoreLine(String scoreLine) {
        scoreLabel.setText(scoreLabel.getText() + "\n" + scoreLine);
        this.scoreLine = new StringBuilder();
    }

    public void update(int turnNumber, int playerNumber, int score1, int score2, int newestScore, int totalScore) {
        if (turnNumber <= MAX_TURNS) {
            if (playerNumber == 1) {
                this.scoreLine.append("Turn ").append(turnNumber).append(": pl1: ").append(totalScore);
            } else {
                this.scoreLine.append(" pl").append(playerNumber).append(": ").append(totalScore);
            }
            if (playerNumber == PLAYER_AMOUNT) {
                String newScoreLine = this.scoreLine.toString();
                addScoreLine(newScoreLine);
            }
        }
        if (turnNumber == MAX_TURNS && playerNumber == PLAYER_AMOUNT) {
            String scoreLine = calculateWinner(scoreLabel.getText());
            addScoreLine(scoreLine);
        }
    }

    private String calculateWinner(String playerScores) {
        String[] lines = playerScores.split("\\r?\\n");
        String finalLine = lines[lines.length - 1];
        /*scores.
        scores = Arrays.stream(scores)
                .map(s -> s.replaceAll("[^\\d.]", ""))
                .toArray(String[]::new);*/
        return "\n" + finalLine;
    }
}
