package org.example;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Scoreboard {
    private Match match;

    public Scoreboard(Match match) {
        this.match = match;
    }

    private String names() {
       ArrayList<Player> players = this.match.getPlayers();
       return players.get(0).toString() + "\n" + players.get(1).toString();
    }
    public String toString(){
        return this.names() + ":" + currentGamePoints() + setPoints();

    }

    private String setPoints() {
        return this.match.getPlayers().stream()
                .map(player -> String.valueOf(this.match.countWinners(player)))
                .collect(Collectors.joining("\n"));
    }
    private String currentGamePoints() {
        return this.match.getPlayers().stream()
                .map(player -> String.valueOf(this.match.pointsLatestGame(player)))
                .collect(Collectors.joining("\n"));
    }
}
