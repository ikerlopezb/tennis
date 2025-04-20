package org.example;


import java.util.*;

public class Game implements ScoreTracker{

    private Map<Player, Integer> points;
    private Map<Player, PlayerRole> roles;
    
    private final int maxPoints = 4;
    private final int difference = 2;

    public Game(List<Player> players) {
        this.points = new HashMap<>();
        this.roles = new HashMap<>();
        for(Player player : players) {
            this.points.put(player, 0);
        }
        this.roles.put(players.get(0), PlayerRole.SERVER);
        this.roles.put(players.get(1), PlayerRole.RECEIVER);
    }
    public Game(Game game) { //no sabemos cómo modificarlo
        this.points = new HashMap<>();
        game.swapService();
        for(Player player : this.points.keySet()) {
            this.points.put(player, 0);
        }
    }

    @Override
    public boolean isWinner(Player player) {
        return this.points.get(player) >= this.maxPoints &&
                (this.points.get(player) - this.points.get(this.other(player)) == this.difference);
    }

    public Player other(Player player) {
        return this.roles.keySet().stream()
        .filter(p -> !p.equals(player))
        .findFirst().get();
    }

    public Player gameWinner(){
        return this.points.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    public void addPoint(PlayerRole role) {
        Player player = this.playerWithRole(role);
        this.points.put(player, this.points.get(player) + 1);
    }

    public void addPointTieBreak(PlayerRole role){ //aquí o en tieBreak
        this.addPoint(role);
        swapService();
    }

    public void swapService() {
        for(Player player : this.roles.keySet()) {
            this.roles.get(player).swapService();
        }
    }

    public Player playerWithRole(PlayerRole role) { //esto comentamos que sobraba?
        return this.roles
                .entrySet()
                .stream().
                filter(entry -> entry.getValue() == role)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }

    public int getPoints(Player player) {
        return this.points.get(player);
    }
    public Map<Player, PlayerRole> getRoles() {
        return this.roles;
    }
    public Map<Player, Integer> getPoints() {
        return points;
    }
}
