package org.example;

import java.util.*;

public class Set implements ScoreTracker {
    private Map<Player, List<Game>> wonGames;
    private List<Game> games;
    private Game currentGame;

    public Set(List<Player> players) {
        this.wonGames = new HashMap<>();
        this.games = new ArrayList<>();
        this.games.add(new Game(players));
        this.currentGame = this.games.getLast();
    }

    public void newGame(List<Player> players) {
        if (this.currentGame.isWinner()) {
            this.currentGame = new Game(players);
            this.currentGame = this.games.getLast();
            this.currentGame.swapService();
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
}


