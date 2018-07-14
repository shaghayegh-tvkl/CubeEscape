package com.tavakoli.game.graphics.six;

import com.tavakoli.game.graphics.five.Five;
import com.tavakoli.game.graphics.four.FourFirst;
import com.tavakoli.game.graphics.four.FourSecond;
import com.tavakoli.game.graphics.one.One;
import com.tavakoli.game.graphics.three.Three;
import com.tavakoli.game.graphics.two.Two;
import com.tavakoli.game.save.SavePlayer;
import com.tavakoli.player.NewPlayer;

import com.tavakoli.game.graphics.five.Five;
import com.tavakoli.game.graphics.four.FourFirst;
import com.tavakoli.game.graphics.four.FourSecond;
import com.tavakoli.game.graphics.one.One;
import com.tavakoli.game.graphics.three.Three;
import com.tavakoli.player.NewPlayer;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Six {
    private JLabel sixLabel;
    private JPanel sixPanel;
    private JFrame sixFrame;

    private ImageIcon icon;
    private ImageIcon keyIcon;

    private ImageIcon background;



    public Six(){

        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();


        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();

        sixFrame = new JFrame("Cube Escape");
        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        keyIcon = new ImageIcon((this.getClass().getResource("/keyIcon.png")));
        background = new ImageIcon((this.getClass().getResource("/six.jpg")));
        sixLabel.setIcon(background);
    }

    public void showSixFrame(){
        sixFrame.setUndecorated(true);

        sixFrame.setIconImage(icon.getImage());
        sixFrame.setContentPane(sixPanel);
        sixFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sixFrame.pack();

        sixFrame.setLocationRelativeTo(null);
        sixFrame.setVisible(true);


        sixFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    sixFrame.setVisible(false);

                    Five five = new Five();
                    five.showFiveFrame();

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