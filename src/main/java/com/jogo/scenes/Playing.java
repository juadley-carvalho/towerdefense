package com.jogo.scenes;

import com.jogo.helpMethods.LevelBuild;
import com.jogo.main.Game;
import com.jogo.managers.TileManager;

import java.awt.*;

public class Playing extends GameScene implements SceneMethods{

    private final int[][] level;
    private final TileManager tileManager = new TileManager();;

    public Playing(Game game) {

        super(game);
        level = LevelBuild.getLevelData();

    }

    @Override
    public void render(Graphics g) {

        for (int y = 0; y < level.length; y++){
            for (int x = 0; x < level[y].length; x ++){
                int id = level[y][x];
                g.drawImage(tileManager.getSprite(id), x*32, y*32, null);
            }
        }

    }

    @Override
    public void mouseClicked(int x, int y) {

    }
}
