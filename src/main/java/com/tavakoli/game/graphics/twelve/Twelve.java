package com.tavakoli.game.graphics.twelve;

import com.tavakoli.game.graphics.five.Five;
import com.tavakoli.game.graphics.four.FourFirst;
import com.tavakoli.game.graphics.four.FourSecond;
import com.tavakoli.game.graphics.one.One;
import com.tavakoli.game.graphics.three.Three;
import com.tavakoli.game.save.SavePlayer;
import com.tavakoli.player.NewPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Twelve {

    private JFrame twelveFrame;
    private JLabel twelveLabel;
    private JPanel twelvePanel;


    private ImageIcon icon;
    private ImageIcon background;



    public Twelve(){

        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();

        twelveFrame = new JFrame("Cube Escape");
        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        background = new ImageIcon((this.getClass().getResource("/twelve.jpg")));
        twelveLabel.setIcon(background);

    }

    public void showTwelveFrame(){

        twelveFrame.setUndecorated(true);

        twelveFrame.setIconImage(icon.getImage());
        twelveFrame.setContentPane(twelvePanel);
        twelveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        twelveFrame.pack();

        twelveFrame.setLocationRelativeTo(null);
        twelveFrame.setVisible(true);

        twelveFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    twelveFrame.setVisible(false);
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
                        twelveFrame.setVisible(false);
                        Five five = new Five();
                        five.showFiveFrame();

                }

                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    twelveFrame.setVisible(false);
                    Three three = new Three();
                    three.showThreeFrame();
                }

                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    twelveFrame.setVisible(false);
                    One one = new One();
                    one.showOneFrame();
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
