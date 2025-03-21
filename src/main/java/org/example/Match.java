package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

public class Match implements ScoreTracker{
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

    @Override
    public boolean isWinner(Player player) {
        return countWinners(player) >= Math.ceil(this.setNumber/2.0);
    }

    public int countWinners(Player player){
        return (int)this.sets.stream().filter(set -> set.isWinner(player)).count();
    }


}

