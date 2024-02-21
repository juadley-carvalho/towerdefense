package com.jogo.ui;

import com.jogo.main.GameStates;
import com.jogo.objects.Tile;
import com.jogo.scenes.Playing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BottomBar {

    private final int x, y, width, height;
    private final Playing playing;
    private MyButton btnMenu;
    private final ArrayList<MyButton> tileButtons = new ArrayList<>();

    public BottomBar(int x, int y, int width, int height, Playing playing){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.playing = playing;

        initButtons();
    }

    private void initButtons() {
        btnMenu = new MyButton("Menu", 1, 641, 100, 30);

        int x = 60;
        int id = 0;
        for (Tile tile : playing.getTileManager().tiles){
            x+=50;
            tileButtons.add(new MyButton(tile.getName(), x, 641, 32, 32, id++));
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
        drawButtons(g);
    }

    public void drawButtons(Graphics g){
        btnMenu.draw(g);

        drawTileButtons(g);


    }

    private void drawTileButtons(Graphics g) {
        for (MyButton myButton : tileButtons){
            //Sprite
            g.drawImage(getButtonImage(myButton.id), myButton.x, myButton.y, myButton.width, myButton.height, null);

            //MouseOver
            if (myButton.isMouseOver()){
                g.setColor(Color.WHITE);
            }else{
                g.setColor(Color.BLACK);
            }

            g.drawRect(myButton.x, myButton.y, myButton.width, myButton.height);

            //MousePressed
            if (myButton.isMousePressed()){

            }
        }
    }

    public BufferedImage getButtonImage(int id){
        return playing.getTileManager().getSprite(id);
    }

    public void mouseClicked(int x, int y) {
        if (btnMenu.getBounds().contains(x, y)){
            GameStates.gameState = GameStates.MENU;
        }
    }

    public void mouseMoved(int x, int y) {
        btnMenu.setMouseOver(btnMenu.getBounds().contains(x, y));
        for (MyButton myButton : tileButtons){
            myButton.setMouseOver(myButton.getBounds().contains(x, y));
        }
    }

    public void mousePressed(int x, int y) {
        btnMenu.setMousePressed(btnMenu.getBounds().contains(x, y));
        for (MyButton myButton : tileButtons){
            myButton.setMousePressed(myButton.getBounds().contains(x, y));
        }
    }

    public void mouseReleased(int x, int y) {
        for (MyButton myButton : tileButtons){
            myButton.setMousePressed(false);
        }
    }

}
