package org.example;


import java.util.*;

public class Game implements ScoreTracker{

    private Map<Player, Integer> points;
    private Map<Player, PlayerRole> roles;
    public Game(List<Player> players) { //hay una manera de hacerlo más limpio sin que cada vez que creo un juego tenga que pasarle los dos jugadores?
        this.points = new HashMap<>();
        this.roles = new HashMap<>();
        for(Player player : players) {
            this.points.put(player, 0);
        }
        this.roles.put(players.get(0), PlayerRole.SERVER);
        this.roles.put(players.get(1), PlayerRole.RECEIVER);
    }

    @Override
    public boolean isWinner() {
        List<Integer> scores = new ArrayList<>(points.values());
        Collections.sort(scores);
        return scores.get(1) >= 4 && (scores.get(1) - scores.get(0)) >= 2;
    }

    public Player gameWinner(){
        assert isWinner();
        return this.points.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public void addPoint(PlayerRole role) {
        Player player = this.roles.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == role)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

        this.points.put(player, this.points.get(player) + 1);
    }

    public void swapService() {
        for(Player player : this.roles.keySet()) {
            this.roles.get(player).swapService();
        }
    }

    public Map<Player, PlayerRole> getRoles() {
        return this.roles;
    }
}
