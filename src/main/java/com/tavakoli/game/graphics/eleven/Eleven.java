package com.tavakoli.game.graphics.eleven;

import com.tavakoli.game.graphics.nine.Nine;
import com.tavakoli.game.graphics.two.Two;
import com.tavakoli.game.save.SavePlayer;
import com.tavakoli.player.NewPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Eleven {

    private JFrame elevenFrame;
    private JPanel elevenPanel;
    private JLabel ghostLabel;

    private ImageIcon icon;
    private ImageIcon ghostIcon;
    private ImageIcon background;


    public Eleven(){


        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();

        elevenFrame = new JFrame("Cube Escape");

        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        ghostIcon = new ImageIcon((this.getClass().getResource("/ghostWindow.png")));
        background = new ImageIcon((this.getClass().getResource("/eleven.jpg")));

        elevenPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background.getImage(), 0, 0, null);
            }
        };

    }

    public void showElevenFrame(){

        elevenFrame.setUndecorated(true);

        elevenFrame.setIconImage(icon.getImage());
        elevenFrame.setContentPane(elevenPanel);
        elevenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        elevenFrame.pack();

        elevenFrame.setLayout(null);
        elevenFrame.setBounds(0,0,1024,722);

        elevenFrame.setLocationRelativeTo(null);
        elevenFrame.setVisible(true);


        elevenFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    elevenFrame.setVisible(false);
                    Nine nine = new Nine();
                    nine.showNineFrame();
                }
                if (NewPlayer.getNewPlayer().isGameOver()) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                        Timer t = new Timer(30, new ActionListener() {
                            int x = 100;

                            @Override
                            public void actionPerformed(ActionEvent e) {

                                ghostLabel.setIcon(ghostIcon);
                                ghostLabel.setBounds(x, 150, 500, 500);
                                elevenFrame.add(ghostLabel);
                                if (x < 650)
                                    x += 1;
                                elevenFrame.repaint();
                            }
                        });
                        t.start();


                    }

                    elevenFrame.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent e) {

                            //if(ghostLabel.getX() + 100 > ) {
                                elevenFrame.setVisible(false);
                                Two two = new Two();
                                two.showTwoFrame();
                            //}
                        }
                    });

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
