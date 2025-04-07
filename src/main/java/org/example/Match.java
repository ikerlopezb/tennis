package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Match implements ScoreTracker {
    private ArrayList<Player> players;
    private ArrayList<Set> sets;
    private Date date;
    private final int maxSets;

    public Match(ArrayList<Player> players, Date date, int maxSets) {
        this.players = players;
        this.date = date;
        this.maxSets = maxSets;
        this.sets = new ArrayList<>();
        this.sets.add(new Set(players));
    }

    private Set lastSet() {
        return this.sets.getLast();
    }

    @Override
    public boolean isWinner(Player player) {
        return this.countWinners(player) >= Math.ceil(this.maxSets / 2.0);
    }

    public int countWinners(Player player) {
        return (int) this.sets.stream().filter(set -> set.isWinner(player)).count();
    }

    public void addPoint(PlayerRole playerRole){
        this.lastSet().addPoint(playerRole);
        if (this.lastSet().isWinner(playerRole){
            this.sets.add(new Set(this.lastSet()));
        }
    }

    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    public ArrayList<Set> getSets() {
        return this.sets;
    }
}

