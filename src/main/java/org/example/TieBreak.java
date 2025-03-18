package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TieBreak extends Game{

    private Map<Player, Integer> points;
    private Map<Player, PlayerRole> roles;


    public TieBreak(List<Player> players) {
        super(players); //este super qué hereda exactamente
        super.swapService();
        super.swapService();
        //si hago aquí comprobación de qué rol es, no estoy pecando de un instanceOf?
        this.roles = super.getRoles(); //tiene sentido hacer esto o es mejor trabajar con el atributo de arriba directamente
    }

    @Override
    public boolean isWinner(){
        List<Integer> scores = new ArrayList<>(this.points.values());
        Collections.sort(scores);
        return scores.get(1) >= 7;
    }
}
