package com.tavakoli.game.graphics.nine;

import com.tavakoli.game.graphics.eight.Eight;
import com.tavakoli.game.graphics.eleven.Eleven;
import com.tavakoli.game.graphics.ten.Ten;
import com.tavakoli.game.save.SavePlayer;
import com.tavakoli.player.NewPlayer;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Nine {

    private JFrame nineFrame;
    private JLabel nineLabel;
    private JPanel ninePanel;


    private ImageIcon icon;
    private ImageIcon keyIcon;
    private ImageIcon background;


    public Nine(){


            NewPlayer.getNewPlayer().setSteps();
            NewPlayer.getNewPlayer().limitedSteps();

            nineFrame = new JFrame("Cube Escape");
            icon = new ImageIcon((this.getClass().getResource("/icon.png")));
            keyIcon = new ImageIcon((this.getClass().getResource("/keyIcon.png")));
            background = new ImageIcon((this.getClass().getResource("/nine.jpg")));
            nineLabel.setIcon(background);

    }

    public void showNineFrame(){
        nineFrame.setUndecorated(true);

        nineFrame.setIconImage(icon.getImage());
        nineFrame.setContentPane(ninePanel);
        nineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nineFrame.pack();

        nineFrame.setLocationRelativeTo(null);
        nineFrame.setVisible(true);

        nineFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if ((e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_LEFT)){

                    nineFrame.setVisible(false);
                    Eleven eleven = new Eleven();
                    eleven.showElevenFrame();

                }


                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    nineFrame.setVisible(false);
                    Eight eight = new Eight();
                    eight.showEightFrame();
                }

                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    nineFrame.setVisible(false);
                    Ten ten = new Ten();
                    ten.showTenFrame();

                }

                else if(((int)e.getKeyChar()) == 19){
                    new SavePlayer().savePlayer(NewPlayer.getNewPlayer());
                    JOptionPane.showMessageDialog(null, "Saved.", "Cube Escape", JOptionPane.PLAIN_MESSAGE, icon);



                }

                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }

        });





    }

}
