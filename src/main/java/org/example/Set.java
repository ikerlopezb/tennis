package org.example;

import java.util.*;

public class Set implements ScoreTracker {
    private List<Game> games;
    private List<Player> players;

    private Game currentGame() {
        return this.games.getLast();
    }

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
        this.currentGame().point(playerRole);
        if (this.currentGame().isWinner()) {
            this.games.add(new Game(this.currentGame()));
        }
    }

    @Override
    public boolean isWinner () {
        List<Integer> games = this.wonGames.values().stream()
                .map(List::size)
                .sorted(Collections.reverseOrder())
                .toList();
        return games.get(1) >= 6 && (games.get(1) - games.get(0)) >= 2;
    }

    public int countWinners(Player player){
        return this.games.stream().filter(game -> game.isWinner(player)).count();
    }

    public boolean isWinner(Player player){
        int x = this.countWinners(this.other(player));
        return this.countWinners(player) == 6 && this.other(player);
    }

    public boolean isWon(){

    }

    public Player other(Player player){
        for () {

        }
    }


}


