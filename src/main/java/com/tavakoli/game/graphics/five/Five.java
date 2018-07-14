package com.tavakoli.game.graphics.five;

import com.tavakoli.game.graphics.four.FourFirst;
import com.tavakoli.game.graphics.four.FourSecond;
import com.tavakoli.game.graphics.nine.Nine;
import com.tavakoli.game.graphics.one.One;
import com.tavakoli.game.graphics.seven.Seven;
import com.tavakoli.game.graphics.six.Six;
import com.tavakoli.game.graphics.three.Three;
import com.tavakoli.game.graphics.twelve.Twelve;
import com.tavakoli.game.save.SavePlayer;
import com.tavakoli.player.NewPlayer;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Five {
    private JFrame fiveFrame;
    private JLabel fiveLabel;
    private JPanel fivePanel;


    private ImageIcon icon;
    private ImageIcon wallIcon;
    private ImageIcon background;



    public Five(){


        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();

        fiveFrame = new JFrame("Cube Escape");
        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        wallIcon = new ImageIcon((this.getClass().getResource("/wallIcon.png")));
        background = new ImageIcon((this.getClass().getResource("/five.jpg")));
        fiveLabel.setIcon(background);
    }

    public void showFiveFrame(){
        fiveFrame.setUndecorated(true);

        fiveFrame.setIconImage(icon.getImage());
        fiveFrame.setContentPane(fivePanel);
        fiveFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fiveFrame.pack();

        fiveFrame.setLocationRelativeTo(null);
        fiveFrame.setVisible(true);

        fiveFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    fiveFrame.setVisible(false);
                        Seven seven = new Seven();
                        seven.showSevenFrame();
                }

                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    fiveFrame.setVisible(false);
                    Twelve twelve = new Twelve();
                    twelve.showTwelveFrame();
                }

                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                    if (!(NewPlayer.getNewPlayer().hasSeenWallSix())){
                        JOptionPane.showMessageDialog(null, "Remember. You can only look at this wall once. It'll be gone.", "Cube Escape", JOptionPane.PLAIN_MESSAGE, wallIcon);
                        fiveFrame.setVisible(false);
                        Six six = new Six();
                        six.showSixFrame();
                        NewPlayer.getNewPlayer().setSeenWallSix(true);
                    }

                    else if(NewPlayer.getNewPlayer().hasSeenWallSix()){
                        JOptionPane.showMessageDialog(null, "I told you. You can only look at this wall once.", "Cube Escape", JOptionPane.PLAIN_MESSAGE, wallIcon);
                    }

                }

                else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    fiveFrame.setVisible(false);
                    Nine nine = new Nine();
                    nine.showNineFrame();

                }

                else if((e.getKeyCode()) == 83){
                    if(NewPlayer.getNewPlayer().hasStone() && NewPlayer.getNewPlayer().hasSeenWallSix()){
                        JOptionPane.showMessageDialog(null, "This stone shows you the wall that cannot be seen anymore!", "Cube Escape", JOptionPane.PLAIN_MESSAGE, wallIcon);
                        fiveFrame.setVisible(false);
                        Six six = new Six();
                        six.showSixFrame();
                    }

                }

                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }

        });


    }
}