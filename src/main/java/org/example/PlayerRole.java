package org.example;

import java.util.List;

public enum PlayerRole {
    SERVER(0), RECEIVER(1);

    private static final List<PlayerRole> roles = List.of(SERVER, RECEIVER);

    private final int index;

    PlayerRole(int index) {
        this.index = index;
    }

    public static PlayerRole nextRole(PlayerRole current) {
        int nextIndex = (roles.indexOf(current) + 1) % roles.size();
        return roles.get(nextIndex);
    }

    public int getIndex() {
        return this.index;
    }

}
