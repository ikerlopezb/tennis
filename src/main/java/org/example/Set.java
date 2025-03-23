package org.example;

import java.util.*;

public class Set implements ScoreTracker{
    private List<Game> games;
    private List<Player> players;
    public Set(List<Player> players) {
        this.players = players;
        this.games = new ArrayList<>();
        this.games.add(new Game(players));
    }
    public Set(Set set){
        this.games = new ArrayList<>();
        this.games.add(set.lastGame());
    }

    public void point(PlayerRole playerRole) { //revisar nombre
        this.lastGame().addPoint(playerRole);
        if (this.lastGame().isWinner(this.lastGame().playerWithRole(playerRole))) {
            this.games.add(new Game(this.players, this.lastGame().swapService()));
        }
    }

    public boolean isWinner(Player player){
        return this.countWinners(player) == 6 &&
                (this.countWinners(player) - this.countWinners(this.other(player))) >= 2;
    }

    public int countWinners(Player player){
        return (int)this.games.stream().filter(game -> game.isWinner(player)).count();
    }

    public Game lastGame() {
        return this.games.getLast();
    }

    public boolean isWon(){

    }

    public Player other(Player player) {
        return players.stream().filter(p -> !p.equals(player)).findFirst().orElse(null);
    }


}


