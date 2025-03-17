package org.example;

public enum PlayerRole {
    SERVER(0), RECEIVER(1);
    private int index;

    PlayerRole(int index) {
        this.index = index;
    }

    public void swapService() { //swap o swapService
        for(PlayerRole playerRole : PlayerRole.values()){
            playerRole.swap();
        }
    }

    private void swap(){
        this.index = (this.index + 1) % PlayerRole.values().length;
    }

}
