package org.example;

import java.util.ArrayList;
import java.util.List;

public interface ScoreTracker {
    boolean isWinner();  /*¿al haber cambiado este método de gamePoint a isWinner
    tiene sentido tener esta interfaz?
    */


    /* todo este código irá a un controller
    private final List<Integer> scores;



    public ScoreTracker() {
        this.scores = new ArrayList<>(List.of(0,0));
    }

    public void addScore(PlayerRole winnerRole) {
        int playerIndex = winnerRole.getIndex();
        scores.set(playerIndex, scores.get(playerIndex) + 1);
    }

    public int getScore(int playerPosition) {
        return scores.get(playerPosition);
    }

     */


}
