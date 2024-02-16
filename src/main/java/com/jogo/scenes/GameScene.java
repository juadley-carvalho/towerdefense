package com.jogo.scenes;

import com.jogo.main.Game;

public class GameScene {

    private final Game game;
    public GameScene(Game game){
        this.game = game;
    }

    public Game getGame(){
        return game;
    }
}
