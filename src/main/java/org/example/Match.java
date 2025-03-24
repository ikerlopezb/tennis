package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Match implements ScoreTracker {
    private ArrayList<Player> players;
    private ArrayList<Set> sets;
    private Date date;
    private Scoreboard scoreboard;
    private final int setNumber;

    public Match(ArrayList<Player> players, Date date, int setNumber) {
        this.players = players;
        this.date = date;
        this.setNumber = setNumber;
        this.sets = new ArrayList<>();
        this.sets.add(new Set(players));
    }

    public Set lastSet() {
        return this.sets.getLast();
    }

    @Override
    public boolean isWinner(Player player) {
        return countWinners(player) >= Math.ceil(this.setNumber / 2.0);
    }

    public int countWinners(Player player) {
        return (int) this.sets.stream().filter(set -> set.isWinner(player)).count();
    }

    public void showScoreboard() {
        this.scoreboard.showScoreboard(players, sets);//Creo que habría que hacer el método currentGame públic
    }

    public void addPoint(PlayerRole playerRole){
        this.lastSet().addPoint(playerRole);
        if (this.lastSet().lastGame().isWinner(this.lastSet().lastGame().playerWithRole(playerRole))){
            this.sets.add(new Set(this.lastSet()));
        }
    }
}

