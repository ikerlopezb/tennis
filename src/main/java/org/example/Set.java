package org.example;

import java.util.*;

public class Set implements ScoreTracker{
    private List<Game> games;
    private List<Player> players;
    private final int maxGames = 12;
    private final int oneSet = 6;
    private final int difference = 2;

    public Set(List<Player> players) {
        this.players = players;
        this.games = new ArrayList<>();
        this.games.add(new Game(players));
    }
    public Set(Set lastSet){
        this.games = new ArrayList<>();
        this.games.add(new Game(this.lastGame()));
    }
    public Game lastGame() {
        return this.games.getLast();
    }
    public void addPoint(PlayerRole playerRole) {
        this.lastGame().addPoint(playerRole);
        if (this.lastGame().isWinner(this.lastGame().playerWithRole(playerRole))) { //está bien pasarle a isWinner de esa manera el Player??
            Game nextGame;
            if (this.isTieBreak(this.lastGame().playerWithRole(playerRole))) {
                nextGame = new TieBreak(players);
            } else {
                nextGame = new Game(this.lastGame());
            }
            this.games.add(nextGame);
        }
    }

    @Override
    public boolean isWinner(Player player){
        if(isTieBreak(player)) {
            return this.lastGame().isWinner(player);
        }
        else {
            return this.countWinners(player) == this.oneSet &&
                    (this.countWinners(player) - this.countWinners(this.other(player))) >= this.difference;
        }
    }

    private boolean isTieBreak(Player player){
        return this.countWinners(player) + this.countWinners(this.other(player)) == this.maxGames;
    }
    public int countWinners(Player player){
        return (int)this.games.stream().filter(game -> game.isWinner(player)).count();
    }
    public Player other(Player player) {
        return this.players.stream().filter(p -> !p.equals(player)).findFirst().orElse(null);
    }
}


