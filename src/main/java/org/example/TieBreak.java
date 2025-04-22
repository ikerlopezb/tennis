package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TieBreak extends Game {
    private final int maxPointTieBreak = 7;
    private final int difference = 2;
    public TieBreak(List<Player> players) {
        super(players);
        super.swapService();
    }

    @Override
    public boolean isWinner(Player player) {
        int playerPoints = super.getPoints().get(player);
        int opponentPoints = super.getPoints().get(this.other(player));

        return playerPoints >= this.maxPointTieBreak && (playerPoints - opponentPoints) >= this.difference;
    }
}
