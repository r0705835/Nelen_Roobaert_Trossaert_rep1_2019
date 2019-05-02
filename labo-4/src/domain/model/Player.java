package domain.model;

public class Player {

    private int id;
    private int currentScore;
    private int totalScore;
    private boolean isActive;

    public Player(int id) {
        setId(id);
        totalScore = 0;
        isActive = false;
    }

    private void setId(int id) {
        this.id = id;
    }

    public void setCurrentScore(int score){
        this.currentScore = score;
        this.totalScore = totalScore + currentScore;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void calculateTotalScore(int score){
        totalScore += score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setActive() {
        isActive = true;
    }

    public void setNotActive() {
        isActive = false;
    }

    public boolean isActive() {
        return this.isActive;
    }
}
