package model;

public class Player {

    private int lastScore = 0;
    private int totalScore;

    public Player(int score) {
        this.totalScore = score;
    }

    public int throwDice() {
        return Die.roll();
    }

    public int calculateScore(int score1, int score2) {
        int newestScore = score1 + score2;
        if (score1 == score2) {
            newestScore *= 2;
        }
        if (this.lastScore == score1 + score2) {
            newestScore += 5;
        }
        this.lastScore = score1 + score2;
        return newestScore;
    }

    public void addScore(int newestScore) {
        this.totalScore += newestScore;
    }

    public int getTotalScore() {
        return this.totalScore;
    }
}
