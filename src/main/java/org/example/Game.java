package org.example;


import java.util.*;

public class Game implements ScoreTracker{

    private Map<Player, Integer> points;
    private Map<Player, PlayerRole> roles;
    public Game(List<Player> players) {
        this.points = new HashMap<>();
        this.roles = new HashMap<>();
        for(Player player : players) {
            this.points.put(player, 0);
        }
        this.roles.put(players.get(0), PlayerRole.SERVER);
        this.roles.put(players.get(1), PlayerRole.RECEIVER);
    }
    public Game(Game game) {
        this.points = new HashMap<>();
        game.swapService();
        for(Player player : this.points.keySet()) {
            this.points.put(player, 0);
        }
    }
    @Override
    public boolean isWinner(Player player) {
        return this.points.get(player) >= 4 &&
                (this.points.get(player) - this.points.get(this.other(player)) == 2);
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

    public void swapService() {
        for(Player player : this.roles.keySet()) {
            this.roles.get(player).swapService();
        }
    }

    public Player playerWithRole(PlayerRole role) {
        return this.roles
                .entrySet()
                .stream().
                filter(entry -> entry.getValue() == role)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }
    public Map<Player, PlayerRole> getRoles() {
        return this.roles;
    }
}
