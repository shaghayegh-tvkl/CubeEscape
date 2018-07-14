package com.tavakoli.player;

import javax.swing.*;
import java.io.Serializable;

public class Player implements Serializable {

    private boolean keyToSecondRoom;
    private boolean seenWallFour;
    private boolean seenWallSix;
    private boolean date;
    private boolean QuestioningReality;
    private boolean gameOver;
    private boolean stone;
    private int steps;

    public Player(){
        steps = 0;
        setDate(false);
        setQuestioningReality(false);
        setSeenWallSix(false);
        setKeyToSecondRoom(false);
        gameOver = false;
    }

    public void setSteps() {
        steps++;
    }
    public void limitedSteps(){
        ImageIcon gameOverIcon = new ImageIcon((this.getClass().getResource("/gameOver.png")));
        if(steps > 100) {
            JOptionPane.showMessageDialog(null, "100 Steps?? This can't go on forever. Bye", "Cube Escape", JOptionPane.PLAIN_MESSAGE, gameOverIcon);
            System.exit(0);
        }
    }

    public boolean hasKeyToSecondRoom() {
        return keyToSecondRoom;
    }
    public void setKeyToSecondRoom(boolean keyToSecondRoom) {
        this.keyToSecondRoom = keyToSecondRoom;
    }

    public boolean hasSeenWallFour() {
        return seenWallFour;
    }
    public void setSeenWallFour(boolean seenWallFour) {
        this.seenWallFour = seenWallFour;
    }

    public boolean hasSeenWallSix() {
        return seenWallSix;
    }
    public void setSeenWallSix(boolean seenWallSix) {
        this.seenWallSix = seenWallSix;
    }


    public boolean hasStone() {
        return stone;
    }
    public void findStone(boolean stone) {
        this.stone = stone;
    }


    public boolean hasSeenDate() {
        return date;
    }
    public void setDate(boolean date) {
        this.date = date;
        setGameOver();
    }

    public boolean isQuestioningReality() {
        return QuestioningReality;
    }
    public void setQuestioningReality(boolean reality) {
        this.QuestioningReality = reality;
        setGameOver();
    }

    public boolean isGameOver() {
        return gameOver;
    }
    public void setGameOver() {
        if(hasSeenDate() == true
                && isQuestioningReality() == true)
            gameOver = true;

    }

}