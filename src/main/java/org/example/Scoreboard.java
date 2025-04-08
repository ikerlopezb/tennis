package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Scoreboard {
    Match match;

    public Scoreboard(Match match) {
        this.match = match;
    }

    private String names() {
       ArrayList<Player> players = this.match.getPlayers();
    }
    public String toString(){
        return this.names() + ":" + currentGamePoints() + setPoints();

    }

    private String setPoints() {
        int pointsPlayer1 = 0;
        int pointsPlayer2 = 0;

        for(Set set : this.match.getSets()) {
            if (set.isWinner(this.match.getPlayers().get(0))){
                pointsPlayer1++;
            }
            else
                pointsPlayer2++;
        }
        return String.valueOf(pointsPlayer1) + "\n" + String.valueOf(pointsPlayer2);
    }

    private String currentGamePoints() { //revisar llamadas de métodos
        this.match.getSets().getLast().lastGame().getPoints();
    }

}
