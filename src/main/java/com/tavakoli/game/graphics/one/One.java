package com.tavakoli.game.graphics.one;

import com.tavakoli.game.graphics.two.Two;
import com.tavakoli.game.save.SavePlayer;
import com.tavakoli.player.NewPlayer;
import com.tavakoli.player.Player;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class One {
    private JFrame oneFrame;
    private JPanel onePanel;
    private JLabel oneLabel;
    private ImageIcon icon;
    private ImageIcon background;



    public One(){

        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();
        oneFrame = new JFrame("Cube Escape");
        icon = new ImageIcon(this.getClass().getResource("/icon.png"));
        background = new ImageIcon(this.getClass().getResource("/one.jpg"));
        oneLabel.setIcon(background);
    }

    public void showOneFrame(){
        oneFrame.setUndecorated(true);


        oneFrame.setIconImage(icon.getImage());
        oneFrame.setContentPane(onePanel);
        oneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oneFrame.pack();




        oneFrame.setLocationRelativeTo(null);

        oneFrame.setVisible(true);

        oneFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    oneFrame.setVisible(false);

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

    }

}
