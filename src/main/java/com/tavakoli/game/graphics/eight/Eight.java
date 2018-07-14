package com.tavakoli.game.graphics.eight;

import com.tavakoli.game.graphics.nine.Nine;
import com.tavakoli.game.graphics.seven.Seven;
import com.tavakoli.game.graphics.six.Six;
import com.tavakoli.game.graphics.twelve.Twelve;
import com.tavakoli.game.save.SavePlayer;
import com.tavakoli.player.NewPlayer;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Eight {

    private JFrame eightFrame;
    private JLabel eightLabel;
    private JPanel eightPanel;

    private ImageIcon icon;
    private ImageIcon wallIcon;
    private ImageIcon background;


    public Eight(){

        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();

        eightFrame = new JFrame("Cube Escape");
        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        wallIcon = new ImageIcon((this.getClass().getResource("/wallIcon.png")));
        background = new ImageIcon((this.getClass().getResource("/eight.jpg")));
        eightLabel.setIcon(background);
    }

    public void showEightFrame(){
        eightFrame.setIconImage(icon.getImage());
        eightFrame.setContentPane(eightPanel);
        eightFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eightFrame.pack();

        eightFrame.setLocationRelativeTo(null);
        eightFrame.setVisible(true);


        eightFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    eightFrame.setVisible(false);
                    Seven seven = new Seven();
                    seven.showSevenFrame();
                }

                else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    eightFrame.setVisible(false);
                    Twelve twelve = new Twelve();
                    twelve.showTwelveFrame();
                }

                else if (e.getKeyCode() == KeyEvent.VK_UP) {

                    if (!(NewPlayer.getNewPlayer().hasSeenWallSix())){
                        JOptionPane.showMessageDialog(null, "Remember. You can only look at this wall once. It'll be gone.", "Cube Escape", JOptionPane.PLAIN_MESSAGE, wallIcon);
                        eightFrame.setVisible(false);
                        Six six = new Six();
                        six.showSixFrame();
                        NewPlayer.getNewPlayer().setSeenWallSix(true);
                    }

                    else if(NewPlayer.getNewPlayer().hasSeenWallSix()){
                        JOptionPane.showMessageDialog(null, "I told you. You can only look at this wall once.", "Cube Escape", JOptionPane.PLAIN_MESSAGE, wallIcon);
                    }


                }

                else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    eightFrame.setVisible(false);
                    Nine nine = new Nine();
                    nine.showNineFrame();

                }
                else if((e.getKeyCode()) == 83){

                    if(NewPlayer.getNewPlayer().hasStone() && NewPlayer.getNewPlayer().hasSeenWallSix()){
                        JOptionPane.showMessageDialog(null, "This stone shows you the wall that cannot be seen anymore!", "Cube Escape", JOptionPane.PLAIN_MESSAGE, wallIcon);
                        eightFrame.setVisible(false);
                        Six six = new Six();
                        six.showSixFrame();
                    }

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
