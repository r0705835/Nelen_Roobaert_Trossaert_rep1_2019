package application;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Game;
import view.PlayerView;
import view.ScoreView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        new ScoreView(game);
        PlayerView pv1 = new PlayerView(game, 1);
        PlayerView pv2 = new PlayerView(game, 2);
        PlayerView pv3 = new PlayerView(game, 3);
        pv1.isPlaying(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
