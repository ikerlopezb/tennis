package org.example;

import java.util.ArrayList;
import java.util.List;

abstract class ScoreTracker {

    private final List<Integer> scores;

    public ScoreTracker() {
        this.scores = new ArrayList<>(2);
    }

    public void addScore(int playerPosition) {
        scores.set(playerPosition, scores.get(playerPosition)+1);
    }

    public int getScore(int playerPosition) {
        return scores.get(playerPosition);
    }

    public boolean hasDifferenceOfTwo() {
        return Math.abs(scores.get(0) - scores.get(1)) >= 2;
    }

    abstract boolean hasAchievedMinimum();

    abstract boolean isWinner();

}
