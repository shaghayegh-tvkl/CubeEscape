package com.tavakoli.game.save;

import com.tavakoli.game.graphics.one.One;
import com.tavakoli.game.graphics.start.Start;
import com.tavakoli.player.NewPlayer;
import com.tavakoli.player.Player;

import javax.swing.*;

public class GameFile {



    ImageIcon icon;
    public GameFile(){
            icon =new ImageIcon((this.getClass().getResource("/icon.png")));

    }

    public void choose(){

        int dialogButton = JOptionPane.showConfirmDialog(null, "Were you here before? ", "Cube Escape", JOptionPane.YES_NO_OPTION);
        switch (dialogButton){
            case JOptionPane.YES_OPTION:
                NewPlayer.setNewPlayer(new SavePlayer().reloadPlayer());

                break;
            case JOptionPane.NO_OPTION:
                new SavePlayer().createPlayer();
                Player player = new Player();
                NewPlayer.setNewPlayer(player);
                break;
        }
        Start start = new Start();
        start.execute();

    }



}
