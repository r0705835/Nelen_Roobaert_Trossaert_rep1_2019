package model;

import view.Observer;

import java.util.ArrayList;

public class Game implements Subject {

    private ArrayList<Observer> observers;

    private int turnNumber;
    private int playerNumber;
    private int score1, score2, newestScore, totalScore;

    public Game() {
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (Object o : observers) {
            Observer observer = (Observer) o;
            observer.update(turnNumber, playerNumber, score1, score2, newestScore, totalScore);
        }
    }

    private void gameDataChanged() {
        notifyObservers();
    }

    public void setGameData(int turnNumber, int playerNumber, int score1, int score2, int newestScore, int totalScore) {
        this.turnNumber = turnNumber;
        this.playerNumber = playerNumber;
        this.score1 = score1;
        this.score2 = score2;
        this.newestScore = newestScore;
        this.totalScore = totalScore;
        gameDataChanged();
    }
}
