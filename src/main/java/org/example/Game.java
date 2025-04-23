package org.example;


import java.util.*;

public class Game implements ScoreTracker{

    private Map<Player, Integer> points;
    private Map<PlayerRole, Player> roles;
    private final int MAXPOINTS = 4;
    private final int DIFFERENCE = 2;

    public Game(List<Player> players) {
        this.points = new HashMap<>();
        this.roles = new HashMap<>();
        this.rolesInitializer(players);
        this.pointsInitializer(players);
    }
    public Game(Game previousGame) {
        this.points = new HashMap<>();
        this.roles.putAll(previousGame.getRoles());
        this.swapService();
        this.pointsInitializer(this.roles.values());
    }

    private void pointsInitializer(Collection <Player> players){
        for(Player player : players) {
            this.points.put(player, 0);
        }
    }

    private void rolesInitializer(List<Player> players) {
        Collections.shuffle(players);
        int i = 0;
        for (PlayerRole playerRole : PlayerRole.values()) {
            this.roles.put(playerRole, players.get(i));
            i++;
        }
    }

    /*
    private void rolesInitializer(List<Player> players) {
        PlayerRole[] roleOrder = PlayerRole.values();
        for (int i = 0; i < roleOrder.length; i++) {
            this.roles.put(roleOrder[i], players.get(i));
        }
    }
     */

    @Override
    public boolean isWinner(Player player) {
        return this.points.get(player) >= this.MAXPOINTS &&
                (this.points.get(player) - this.points.get(this.other(player)) == this.DIFFERENCE);
    }

    public Player other(Player player) {
        return this.points.keySet().stream()
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

    public void addPoint(PlayerRole playerRole) {
        Player player = this.playerWithRole(playerRole);
        this.points.put(player, this.points.get(player) + 1);
    }

    public void addPointTieBreak(PlayerRole playerRole){ //este addPoint debe ir aquí o en TieBreak
        this.addPoint(playerRole);
        swapService();
    }

    public void swapService() {
        for(Player player : this.roles.keySet()) {
            this.roles.get(player).swapService();
        }
    }

    /*
    public Player playerWithRole(PlayerRole role) { //esto comentamos que sobraba
        return this.roles
                .entrySet()
                .stream().
                filter(entry -> entry.getValue() == role)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
    }
     */

    public int getPoints(Player player) {
        return this.points.get(player);
    }
    public Map<PlayerRole, Player> getRoles() {
        return this.roles;
    }
    public Map<Player, Integer> getPoints() {
        return this.points;
    }
}
