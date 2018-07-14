package com.tavakoli.game.graphics.four;

import com.tavakoli.game.graphics.two.Two;
import com.tavakoli.game.save.SavePlayer;
import com.tavakoli.player.NewPlayer;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FourFirst {

    private JFrame fourFirstFrame;
    private JLabel fourFirstLabel;
    private JPanel fourFirstPanel;

    private ImageIcon icon;
    private ImageIcon background;
    private ImageIcon backgroundTwo;


    public FourFirst(){


        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();

        fourFirstFrame = new JFrame("Cube Escape");
        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        background = new ImageIcon((this.getClass().getResource("/fourFirst.jpg")));
        backgroundTwo = new ImageIcon((this.getClass().getResource("/fourSecond.jpg")));
        if(!(NewPlayer.getNewPlayer().hasSeenWallFour()))
            fourFirstLabel.setIcon(background);
        else
            fourFirstLabel.setIcon(backgroundTwo);

    }

    public void showFourFirstFrame(){

        fourFirstFrame.setUndecorated(true);


        fourFirstFrame.setIconImage(icon.getImage());
        fourFirstFrame.setContentPane(fourFirstPanel);
        fourFirstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fourFirstFrame.pack();


        fourFirstFrame.setLocationRelativeTo(null);

        fourFirstFrame.setVisible(true);

        fourFirstFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    fourFirstFrame.setVisible(false);
                    Two two = new Two();
                    two.showTwoFrame();
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

        fourFirstFrame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                fourFirstLabel.setIcon(backgroundTwo);
                NewPlayer.getNewPlayer().setSeenWallFour(true);
            }
        });
    }

}
