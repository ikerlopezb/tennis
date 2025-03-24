package org.example;


import java.util.*;

public class Game implements ScoreTracker{

    private Map<Player, Integer> points;
    private Map<Player, PlayerRole> roles;
    public Map<Player, PlayerRole> getRoles() {
        return this.roles;
    }

    public Game(List<Player> players) {
        this.points = new HashMap<>();
        this.roles = new HashMap<>();
        for(Player player : players) {
            this.points.put(player, 0);
        }
        this.roles.put(players.get(0), PlayerRole.SERVER);
        this.roles.put(players.get(1), PlayerRole.RECEIVER);
    }
    public Game(Game lastGame) {//No sé como hacerlo. La idea es tener este constructor ya que en el primero se van a
                                //inicializar los roles para el primer juego, pero en los siguientes hay que ir cambiándolos
                                //a partir de ese primer juego. De manera que no podemos inicializarlos a SERVER y RECIEVER en cada
                                //juego que creamos, porque no se va a hacer bien el swap.
        this.points = new HashMap<>();
        lastGame.swapService();
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
                .findFirst()
                .orElse(null);
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
}
