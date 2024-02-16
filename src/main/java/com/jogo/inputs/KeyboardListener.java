package com.jogo.inputs;

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
        }
        if (e.getKeyCode() == KeyEvent.VK_B){
            System.out.println("Key 'B' pressed!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
