package org.example;

import java.util.ArrayList;

public class Set implements ScoreTracker{
    private ArrayList<Integer> games;

    public Set() {
        assert isWinner(); //mismo problema que en constructor de Game
        this.games = new ArrayList<>(2);
    }

    @Override
    public boolean isWinner() {
        return (this.games.get(0) == 6 || this.games.get(1) == 6) &&
                Math.abs(this.games.get(0) - this.games.get(1)) >=2;
    }

}


