package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Scoreboard {
    private Match match;

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
        StringJoiner
        return this.match.getSets()
                .stream()
                .filter(set -> set.isWinner(this.match.getPlayer(0))).count()
                + "\n" +
                this.match.getSets()
                        .stream()
                        .filter(set -> set.isWinner(this.match.getPlayer(1))).count();

    }

    private String currentGamePoints() {//revisar llamadas de métodos
        StringJoiner joiner = new StringJoiner("\n");
        for(Player player: this.match.getPlayers()) {
            int points = this.match.pointsLatestGame(player);
            joiner.add(String.valueOf(points));
        }
        return joiner.toString();
    }

}
