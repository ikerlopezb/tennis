package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

public class Match {
    Stream<Set> sets;
    Date date;
    Stream<Player> players;

    public Match(Stream<Set> sets, Stream<Player> players, Date date){
        this.sets = sets;
        this.players = players;
        this.date = date;
    }
}
