package org.example;

public enum PlayerRole {
    SERVER, RECEIVER;
    public PlayerRole swap() {
        return this == SERVER ? RECEIVER : SERVER;
    }
}
