package org.example;


import java.util.ArrayList;

public class Game implements ScoreTracker{

    private ArrayList<Integer> points;
    public Game() {
        this.points = new ArrayList<>(2);
    }

    @Override
    public boolean isWinner() {
        return (this.points.get(0) >= 4 || this.points.get(1) >=4) &&
            Math.abs(this.points.get(0) - this.points.get(1)) >=2;
    }
}
