package com.tavakoli.player;

public class NewPlayer {

    private static Player newPlayer;

    public static Player getNewPlayer() {
        return newPlayer;
    }

    public static void setNewPlayer(Player newPlayer) {
        NewPlayer.newPlayer = newPlayer;
    }

}
