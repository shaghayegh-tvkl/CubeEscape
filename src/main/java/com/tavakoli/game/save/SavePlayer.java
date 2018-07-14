package com.tavakoli.game.save;

import com.tavakoli.player.NewPlayer;
import com.tavakoli.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;

public class SavePlayer extends Component {

    public static String path;

    public void createPlayer(){

        Player player = new Player();
        JFileChooser chooser = new JFileChooser();

        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Player (*.dat)", "dat"));
        chooser.setAcceptAllFileFilterUsed(true);

        chooser.setApproveButtonToolTipText("save your game");
        chooser.setCurrentDirectory(new File("/home/me"));

        int retrieval = chooser.showSaveDialog(null);
        if (retrieval == JFileChooser.APPROVE_OPTION) {

            path = chooser.getSelectedFile().getAbsolutePath() + ".dat";
            try{
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(player);

            out.close();
            file.close();

        }

        catch(IOException ex) {}

        }
    }


    public Player reloadPlayer(){

        Player player = new Player();
        JFileChooser chooser = new JFileChooser();

        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Player (*.dat)", "dat"));
        chooser.setAcceptAllFileFilterUsed(true);


        chooser.setCurrentDirectory(new File("/home/me"));
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        chooser.setApproveButtonText("Open");
        chooser.setApproveButtonToolTipText("reload your previous game");

        chooser.setDialogTitle("Open File");

        int retrieval = chooser.showSaveDialog(null);
        if (retrieval == JFileChooser.OPEN_DIALOG) {
            path = chooser.getSelectedFile().getAbsolutePath();
            try {
                FileInputStream file = new FileInputStream(path);
                ObjectInputStream in = new ObjectInputStream(file);

                player = (Player) in.readObject();

                in.close();
                file.close();
            } catch (IOException ex) {
            } catch (ClassNotFoundException ex) {
            }
        }
        return player;
    }

    public void savePlayer(Player player){
        try {
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(player);

            out.close();
            file.close();

        }

        catch(IOException ex) {}
    }

}