package com.tavakoli.game.graphics.seven;

import com.tavakoli.game.graphics.five.Five;
import com.tavakoli.game.graphics.two.Two;
import com.tavakoli.game.save.SavePlayer;
import com.tavakoli.player.NewPlayer;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Seven {

    private JFrame sevenFrame;
    private JLabel sevenLabel;
    private JPanel sevenPanel;
    private ImageIcon icon;
    private ImageIcon background;
    private ImageIcon stoneIcon;
    private ImageIcon ghostIcon;


    public Seven(){



        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();

        sevenFrame = new JFrame("Cube Escape");
        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        background = new ImageIcon((this.getClass().getResource("/seven.jpg")));
        stoneIcon = new ImageIcon((this.getClass().getResource("/stone.png")));
        ghostIcon = new ImageIcon((this.getClass().getResource("/ghost.png")));


        sevenLabel.setIcon(background);
        
    }
    
    public void showSevenFrame(){
        sevenFrame.setUndecorated(true);


        sevenFrame.setIconImage(icon.getImage());
        sevenFrame.setContentPane(sevenPanel);
        sevenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sevenFrame.pack();
        sevenFrame.setLocationRelativeTo(null);
        sevenFrame.setVisible(true);


        sevenFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    sevenFrame.setVisible(false);
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


        sevenFrame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                int mouseX = e.getX();
                int mouseY = e.getY();

                if(mouseX > 580 && mouseX < 800){
                    if(mouseY > 40 && mouseY < 350){
                        JOptionPane.showMessageDialog(null, "Have you ever questioned the nature of your reality?", "Cube Escape", JOptionPane.PLAIN_MESSAGE, ghostIcon);
                        NewPlayer.getNewPlayer().setQuestioningReality(true);
                    }
                }

                if(mouseX > 580 && mouseX < 800){
                    if(mouseY > 40 && mouseY < 350){
                        if (!(NewPlayer.getNewPlayer().hasStone())) {
                            JOptionPane.showMessageDialog(null, "Here's a Stone.\nKeep it, you may need it. \nS will help you", "Cube Escape", JOptionPane.PLAIN_MESSAGE, stoneIcon);
                            NewPlayer.getNewPlayer().findStone(true);
                        }
                    }
                }


            }
        });
    }
}
