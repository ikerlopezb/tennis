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
    public Set(Set lastSet){
        this.games = new ArrayList<>();
        this.games.add(lastSet.lastGame());
        this.lastGame().swapService();
    }
    public Game lastGame() {
        return this.games.getLast();
    }
    public void addPoint(PlayerRole playerRole) {
        this.lastGame().addPoint(playerRole);
        if (this.lastGame().isWinner(this.lastGame().playerWithRole(playerRole))) {
            this.games.add(new Game(this.lastGame()));
        }
        else{
            if(this.isTieBreak(this.lastGame().playerWithRole(playerRole))){
                this.games.add(new TieBreak(players));
            }
        }
    }

    @Override
    public boolean isWinner(Player player){
        if(isTieBreak(player)) {
            return this.lastGame().isWinner(player);
        }
        else {
            return this.countWinners(player) == 6 &&
                    (this.countWinners(player) - this.countWinners(this.other(player))) >= 2;
        }
    }

    private boolean isTieBreak(Player player){
        return this.countWinners(player) == 6 &&
                this.countWinners(this.other(player)) == 6;
    }
    public int countWinners(Player player){
        return (int)this.games.stream().filter(game -> game.isWinner(player)).count();
    }
    public Player other(Player player) {
        return players.stream().filter(p -> !p.equals(player)).findFirst().orElse(null);
    }
}


