package ui.view;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ScoreView implements PropertyChangeListener {
    private Stage stage = new Stage();
    private Scene scoreScene;
    private Label scoreLabel;

    public ScoreView() {
        scoreLabel = new Label();
        scoreLabel.setStyle("-fx-font-family: \"Courier new\"; -fx-font-size: 12; -fx-text-fill: darkred;");

        layoutComponents();
        stage.setScene(scoreScene);
        stage.setTitle("Overview scores");
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
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
