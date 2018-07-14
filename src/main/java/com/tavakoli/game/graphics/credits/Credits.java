package com.tavakoli.game.graphics.credits;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Credits {

    private JFrame creditsFrame;
    private JLabel creditsLabel;
    private JPanel creditsPanel;


    private ImageIcon icon;
    private ImageIcon background;


    public Credits(){


        creditsFrame = new JFrame("Cube Escape");
        icon = new ImageIcon((this.getClass().getResource("/icon.png")));
        background = new ImageIcon((this.getClass().getResource("/credits.jpg")));
        creditsLabel.setIcon(background);

    }

    public void showCreditsFrame(){
        creditsFrame.setUndecorated(true);
        creditsFrame.setIconImage(icon.getImage());
        creditsFrame.setContentPane(creditsPanel);
        creditsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        creditsFrame.pack();

        creditsFrame.setLocationRelativeTo(null);
        creditsFrame.setVisible(true);

        creditsFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });

    }
}
