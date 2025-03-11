package org.example;

public enum PlayerRole {
    SERVER(0), RECEIVER(1);


    private int index;

    PlayerRole(int index) {
        this.index = index;
    }

    public static void nextRole(PlayerRole current) { //swap o swapService
        for(PlayerRole playerRole : PlayerRole.values()){
            playerRole.nextRole();
        }
    }

    private void nextRole(){
        this.index = (this.index + 1) % PlayerRole.values().length;
    }

}
