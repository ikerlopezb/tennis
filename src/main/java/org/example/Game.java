package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class Game {

    List<Point> points;

    public Game() {
        this.points = new ArrayList<>(2);
    }

    public void addPoint(int number){
        points.get(number);
    }
}
