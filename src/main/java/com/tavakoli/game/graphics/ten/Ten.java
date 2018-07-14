package com.tavakoli.game.graphics.ten;

import com.tavakoli.game.graphics.nine.Nine;
import com.tavakoli.game.save.SavePlayer;
import com.tavakoli.player.NewPlayer;

import javax.swing.*;
import java.awt.event.*;

public class Ten {
    private JPanel tenPanel;
    private JLabel tenLabel;
    private JTextField pinkTextField;
    private JTextField blueTextField;
    private JTextField greenTextField;
    private JTextField orangeTextField;
    private JButton checkButton;



    private JFrame tenFrame;

    private ImageIcon icon;
    private ImageIcon background;
    private ImageIcon tombstoneIcon;


    public Ten(){


        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();

        tenFrame = new JFrame("Cube Escape");
        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        background = new ImageIcon((this.getClass().getResource("/ten.jpg")));
        tombstoneIcon = new ImageIcon((this.getClass().getResource("/tombstone.png")));
        tenLabel.setIcon(background);

    }

    public void showTenFrame() {

        tenFrame.setUndecorated(true);
        tenFrame.setIconImage(icon.getImage());
        tenFrame.setContentPane(tenPanel);
        tenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tenFrame.pack();

        tenFrame.setVisible(true);

        tenFrame.setLayout(null);

        tenFrame.setBounds(0,0,1024,722);

        tenFrame.setLocationRelativeTo(null);

        checkButton.setBounds(130,480, 80,30);
        greenTextField.setBounds(150,120, 25,25);
        pinkTextField.setBounds(520,380,25,25);
        orangeTextField.setBounds(500, 80, 25,25);
        blueTextField.setBounds(850,280,25,25);

        tenLabel.setBounds(0,0,1024,722);

        KeyListener keyListener = new KeyListener() {
            public void keyTyped(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                    tenFrame.setVisible(false);
                    Nine nine = new Nine();
                    nine.showNineFrame();
                }

                else if(((int)keyEvent.getKeyChar()) == 19){
                    new SavePlayer().savePlayer(NewPlayer.getNewPlayer());
                    JOptionPane.showMessageDialog(null, "Saved.", "Cube Escape", JOptionPane.PLAIN_MESSAGE, icon);



                }

                else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }

            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                    tenFrame.setVisible(false);
                    Nine nine = new Nine();
                    nine.showNineFrame();
                }

                else if(((int)keyEvent.getKeyChar()) == 19){
                    new SavePlayer().savePlayer(NewPlayer.getNewPlayer());
                    JOptionPane.showMessageDialog(null, "Saved.", "Cube Escape", JOptionPane.PLAIN_MESSAGE, icon);



                }

                else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                }
            }

            public void keyReleased(KeyEvent e) {
            }
        };

        blueTextField.addKeyListener(keyListener);
        orangeTextField.addKeyListener(keyListener);
        pinkTextField.addKeyListener(keyListener);
        greenTextField.addKeyListener(keyListener);
        tenFrame.addKeyListener(keyListener);
        tenPanel.addKeyListener(keyListener);
        tenLabel.addKeyListener(keyListener);
        checkButton.addKeyListener(keyListener);

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String green, orange, blue, pink;

                green = greenTextField.getText();
                orange = orangeTextField.getText();
                blue = blueTextField.getText();
                pink = pinkTextField.getText();

                if ( orange.equals("50")
                    && blue.equals("83")
                    && pink.equals("11")
                    && green.equals("5")) {
                                JOptionPane.showMessageDialog(null, "50 People.. \n1983/5/11", "Cube Escape", JOptionPane.PLAIN_MESSAGE, tombstoneIcon);
                                NewPlayer.getNewPlayer().setDate(true);
                }
            }
        });
    }

}
