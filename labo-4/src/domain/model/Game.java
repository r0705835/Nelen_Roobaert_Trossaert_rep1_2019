package domain.model;

import jdk.jshell.spi.ExecutionControl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();
    private PropertyChangeSupport support;
    private int active;
    private int turn;

    public Game() {
        support = new PropertyChangeSupport(this);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        support.addPropertyChangeListener(propertyChangeListener);
    }

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        support.removePropertyChangeListener(propertyChangeListener);
    }

    public void startTurn(int player) {
        support.firePropertyChange("ActivePlayer", active, player);
        active = player;
    }

    public void verwerkWorp() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("error");
    }
}
