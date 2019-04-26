package view;

public interface Observer {
    void update(int turnNumber, int playerNumber, int score1, int score2, int newestScore, int totalScore);
}
