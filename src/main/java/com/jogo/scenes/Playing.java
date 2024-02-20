package com.jogo.scenes;

import com.jogo.helpMethods.LevelBuild;
import com.jogo.main.Game;
import com.jogo.main.GameStates;
import com.jogo.managers.TileManager;
import com.jogo.ui.MyButton;

import java.awt.*;

public class Playing extends GameScene implements SceneMethods{

    private final int[][] level;
    private final TileManager tileManager = new TileManager();;
    private final MyButton btnMenu;

    public Playing(Game game) {

        super(game);
        level = LevelBuild.getLevelData();

        btnMenu = new MyButton("Menu", 0, 0, 100, 30);

    }

    @Override
    public void render(Graphics g) {

        for (int y = 0; y < level.length; y++){
            for (int x = 0; x < level[y].length; x ++){
                int id = level[y][x];
                g.drawImage(tileManager.getSprite(id), x*32, y*32, null);
            }
        }

        btnMenu.draw(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (btnMenu.getBounds().contains(x, y)){
            GameStates.gameState = GameStates.MENU;
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        btnMenu.setMouseOver(btnMenu.getBounds().contains(x, y));
    }

    @Override
    public void mousePressed(int x, int y) {
        btnMenu.setMousePressed(btnMenu.getBounds().contains(x, y));
    }

    @Override
    public void mouseReleased(int x, int y) {

    }
}
