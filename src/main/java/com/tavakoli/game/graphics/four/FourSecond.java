package com.tavakoli.game.graphics.four;

import com.tavakoli.game.graphics.credits.Credits;
import com.tavakoli.game.graphics.two.Two;
import com.tavakoli.player.NewPlayer;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FourSecond {

    private JFrame fourSecondFrame;
    private JLabel fourSecondLabel;
    private JPanel fourSecondPanel;

    private ImageIcon icon;
    private ImageIcon background;

    public FourSecond(){


        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();




        fourSecondFrame = new JFrame("Cube Escape");
        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        background = new ImageIcon((this.getClass().getResource("/fourThird.jpg")));
        fourSecondLabel.setIcon(background);

    }

    public void showFourSecondFrame(){

        fourSecondFrame.setUndecorated(true);

        fourSecondFrame.setIconImage(icon.getImage());
        fourSecondFrame.setContentPane(fourSecondPanel);
        fourSecondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fourSecondFrame.pack();


        fourSecondFrame.setLocationRelativeTo(null);

        fourSecondFrame.setVisible(true);

        fourSecondFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                    fourSecondFrame.setVisible(false);
                    Credits credits = new Credits();
                    credits.showCreditsFrame();

            }
        });
        fourSecondFrame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                fourSecondFrame.setVisible(false);
                Credits credits = new Credits();
                credits.showCreditsFrame();
            }
        });
    }
}



