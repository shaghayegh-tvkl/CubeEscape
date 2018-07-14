package com.tavakoli.game.graphics.three;

import com.tavakoli.game.graphics.two.Two;
import com.tavakoli.game.save.SavePlayer;
import com.tavakoli.player.NewPlayer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Three {
    private JFrame threeFrame;
    private JLabel threeLabel;
    private JPanel threePanel;

    private ImageIcon icon;
    private ImageIcon background;
    private ImageIcon keyIcon;

    public Three(){


        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();

        threeFrame = new JFrame("Cube Escape");
        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        background = new ImageIcon((this.getClass().getResource("/three.jpg")));
        keyIcon = new ImageIcon((this.getClass().getResource("/keyIcon.png")));

        threeLabel.setIcon(background);
    }

    public void showThreeFrame(){

        threeFrame.setUndecorated(true);
        threeFrame.setIconImage(icon.getImage());
        threeFrame.setContentPane(threePanel);
        threeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        threeFrame.pack();
        threeLabel.setBounds(0,0,500,300);
        threeFrame.setBounds(0,0,1024,722);
        threeFrame.setLocationRelativeTo(null);
        threeFrame.setVisible(true);



        threeFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    threeFrame.setVisible(false);
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


        threeFrame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                int mouseX = e.getX();
                int mouseY = e.getY();

                if(mouseX > 200 && mouseX < 850){
                    if(mouseY > 200 && mouseY < 450){
                        if(!(NewPlayer.getNewPlayer().hasKeyToSecondRoom())) {
                            NewPlayer.getNewPlayer().setKeyToSecondRoom(true);
                            JOptionPane.showMessageDialog(null, "Ohhhh! You Found a Key", "Cube Escape", JOptionPane.PLAIN_MESSAGE, keyIcon);
                        }
                    }
                }
            }

        });
    }

}