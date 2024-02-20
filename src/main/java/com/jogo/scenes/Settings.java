package com.jogo.scenes;

import com.jogo.main.Game;
import com.jogo.main.GameStates;
import com.jogo.ui.MyButton;

import java.awt.*;

public class Settings extends GameScene implements SceneMethods{

    private MyButton btnMenu;

    public Settings(Game game) {
        super(game);
        btnMenu = new MyButton("Menu", 0, 0, 100, 30);

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(0, 0,640, 640);
        btnMenu.draw(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        GameStates.gameState = GameStates.MENU;
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
