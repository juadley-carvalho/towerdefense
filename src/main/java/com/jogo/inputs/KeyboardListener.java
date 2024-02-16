package com.jogo.inputs;

import com.jogo.main.GameStates;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A){
            System.out.println("Key 'A' pressed!");
            GameStates.gameState = GameStates.MENU;
        }
        if (e.getKeyCode() == KeyEvent.VK_S){
            System.out.println("Key 'S' pressed!");
            GameStates.gameState = GameStates.PLAYING;
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            System.out.println("Key 'D' pressed!");
            GameStates.gameState = GameStates.SETTINGS;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
