package com.tavakoli.game.graphics.start;

import com.tavakoli.game.graphics.one.One;
import com.tavakoli.player.NewPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Start {

    private JFrame startFrame;
    private JLabel startLabel;
    private JPanel startPanel;
    private JLabel ghostLabel;


    private ImageIcon icon;
    private ImageIcon ghostIcon;
    private ImageIcon background;


    public Start(){


        NewPlayer.getNewPlayer().setSteps();
        NewPlayer.getNewPlayer().limitedSteps();

        startFrame = new JFrame("Cube Escape");

        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        ghostIcon = new ImageIcon((this.getClass().getResource("/whiteGhost.png")));
        background = new ImageIcon((this.getClass().getResource("/start.jpg")));

        startPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background.getImage(), 0, 0, null);
            }
        };

    }

    public void execute(){
        //startFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        startFrame.setUndecorated(true);


        startFrame.setIconImage(icon.getImage());
        startFrame.setContentPane(startPanel);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.pack();

        startFrame.setLayout(null);
        startFrame.setBounds(0,0,1024,722);

        startFrame.setLocationRelativeTo(null);
        startFrame.setVisible(true);

        Timer t = new Timer(20, new ActionListener() {
            int x = 100;

            @Override
            public void actionPerformed(ActionEvent e) {

                ghostLabel.setIcon(ghostIcon);
                ghostLabel.setBounds(x, 150, 500, 500);
                startFrame.add(ghostLabel);
                if (x < 650)
                    x += 1;
                startFrame.repaint();
            }
        });
        t.start();

        startFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                startFrame.setVisible(false);
                One one = new One();
                one.showOneFrame();
            }
        });

    }
}
