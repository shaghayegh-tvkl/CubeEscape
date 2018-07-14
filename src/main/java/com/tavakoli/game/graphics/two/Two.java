package com.tavakoli.game.graphics.two;

import com.tavakoli.game.graphics.five.Five;
import com.tavakoli.game.graphics.four.FourFirst;
import com.tavakoli.game.graphics.four.FourSecond;
import com.tavakoli.game.graphics.one.One;
import com.tavakoli.game.graphics.three.Three;
import com.tavakoli.game.save.SavePlayer;
import com.tavakoli.player.NewPlayer;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Two {
    private JPanel twoPanel;
    private JLabel twoLabel;
    private JFrame twoFrame;

    private ImageIcon icon;
    private ImageIcon keyIcon;
    private ImageIcon background;



    public Two(){


        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();

        twoFrame = new JFrame("Cube Escape");
        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        keyIcon = new ImageIcon((this.getClass().getResource("/keyIcon.png")));
        background = new ImageIcon((this.getClass().getResource("/two.jpg")));
        twoLabel.setIcon(background);
    }

    public void showTwoFrame(){
        twoFrame.setUndecorated(true);

        twoFrame.setIconImage(icon.getImage());
        twoFrame.setContentPane(twoPanel);
        twoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        twoFrame.pack();

        twoFrame.setLocationRelativeTo(null);
        twoFrame.setVisible(true);

        twoFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    twoFrame.setVisible(false);
                    if(NewPlayer.getNewPlayer().isGameOver()){
                        FourSecond fourSecond = new FourSecond();
                        fourSecond.showFourSecondFrame();
                    }
                    else{
                        FourFirst fourFirst = new FourFirst();
                        fourFirst.showFourFirstFrame();
                    }
                }

                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    twoFrame.setVisible(false);
                    One one = new One();
                    one.showOneFrame();
                }

                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if(NewPlayer.getNewPlayer().hasKeyToSecondRoom()) {
                        twoFrame.setVisible(false);
                        Five five = new Five();
                        five.showFiveFrame();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "The Door Is Locked", "Cube Escape", JOptionPane.PLAIN_MESSAGE, keyIcon);
                    }
                }
                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    twoFrame.setVisible(false);
                    Three three = new Three();
                    three.showThreeFrame();
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
