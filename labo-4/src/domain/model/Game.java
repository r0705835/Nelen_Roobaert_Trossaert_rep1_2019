package domain.model;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();

    public Game(Player player1, Player player2, Player player3){
        players.add(player1);
        players.add(player2);
        players.add(player3);
    }
}
