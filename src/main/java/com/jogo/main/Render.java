package com.jogo.main;

import java.awt.*;

public class Render {

    private final GameScreen gameScreen;

    public Render(GameScreen gameScreen){
        this.gameScreen = gameScreen;
    }

    public void render(Graphics g){
        switch (GameStates.gameStates){
            case MENU -> System.out.println("Menu");
            case SETTINGS -> System.out.println("Settings");
            case PLAYING -> System.out.println("Playing");
        }
    }
}
