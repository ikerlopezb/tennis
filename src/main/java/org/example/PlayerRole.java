package org.example;

public enum PlayerRole {
    SERVER, RECEIVER;
    //private int index;

    PlayerRole() {
        this.index = index;
    }

    public static void swapService() {
        for(PlayerRole playerRole : PlayerRole.values()){
            playerRole.swap();
        }
    }

    private void swap(){
        this.index = (this.index + 1) % PlayerRole.values().length;
    }

}
