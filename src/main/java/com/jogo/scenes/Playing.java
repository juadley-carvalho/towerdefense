package com.jogo.scenes;

import com.jogo.helpMethods.LevelBuild;
import com.jogo.main.Game;
import com.jogo.managers.TileManager;
import com.jogo.ui.BottomBar;

import java.awt.*;

public class Playing extends GameScene implements SceneMethods{

    private final int[][] level;
    private final TileManager tileManager = new TileManager();
    private final BottomBar bottomBar;

    public Playing(Game game) {

        super(game);
        level = LevelBuild.getLevelData();

        bottomBar = new BottomBar(0, 640, 640, 100, this);

    }

    @Override
    public void render(Graphics g) {

        for (int y = 0; y < level.length; y++){
            for (int x = 0; x < level[y].length; x ++){
                int id = level[y][x];
                g.drawImage(tileManager.getSprite(id), x*32, y*32, null);
            }
        }

        bottomBar.draw(g);
    }

    public TileManager getTileManager(){
        return tileManager;
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (y >= 640){
            bottomBar.mouseClicked(x, y);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        if (y >= 640){
            bottomBar.mouseMoved(x, y);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (y >= 640){
            bottomBar.mousePressed(x, y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        bottomBar.mouseReleased(x, y);
    }
}
