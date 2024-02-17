package com.jogo.inputs;

import com.jogo.main.Game;
import com.jogo.main.GameStates;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyMouseListener implements MouseListener, MouseMotionListener {

    private Game game;

    public MyMouseListener(Game game){
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1){
            System.out.println("Click pos: " + e.getX() + "/" + e.getY());
            switch (GameStates.gameState){
                case MENU -> game.getMenu().mouseClicked(e.getX(), e.getY());
            }
        }
        if (e.getButton() == MouseEvent.BUTTON3){
            System.out.println("Right click!");
        }
        if (e.getButton() == MouseEvent.BUTTON2){
            System.out.println("Scroll click!");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
