package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TieBreak extends Game {

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
    public boolean isWinner(Player player){
        return this.points.get(player) >= 7 &&
                (this.points.get(player) - this.points.get(this.other(player)) == 2);
    }
}
