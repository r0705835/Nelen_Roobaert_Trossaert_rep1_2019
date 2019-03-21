package domain.model;

public class Player {

    private int id;
    private int score;

    public Player(int id, int score) {
        setId(id);
        setScore(score);
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setScore(int score) {
        this.score = score;
    }

    //method CalculateScore
}
