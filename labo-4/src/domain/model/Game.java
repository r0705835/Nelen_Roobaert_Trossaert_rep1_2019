package domain.model;

import javafx.beans.InvalidationListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Game extends Observable {
    private Player active;
    private int turn;

    public Game() {
    }

    public void setActivePlayer(Player player){
        this.active = player;
        notifyObservers(player);
    }
}
