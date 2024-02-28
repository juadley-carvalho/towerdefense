package com.jogo.ui;

import com.jogo.helpMethods.LoadSave;
import com.jogo.main.GameStates;
import com.jogo.objects.Tile;
import com.jogo.scenes.Playing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BottomBar {

    private final int x, y, width, height;
    private final Playing playing;
    private MyButton btnMenu, btnSave;
    private final ArrayList<MyButton> tileButtons = new ArrayList<>();
    private Tile selectedTile;

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
        btnSave = new MyButton("Save", 1, 676, 100, 30);

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
        btnSave.draw(g);

        drawTileButtons(g);

        drawSelectedTile(g);

    }

    private void drawSelectedTile(Graphics g) {
        if (selectedTile != null){
            g.drawImage(selectedTile.getSprite(), 607, 707, 32, 32, null);
            g.setColor(Color.BLACK);
            g.drawRect(607, 707, 32, 32);
        }
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
                g.drawRect(myButton.x+1, myButton.y+1, myButton.width-2, myButton.height-2);
                g.drawRect(myButton.x+2, myButton.y+2, myButton.width-4, myButton.height-4);
            }
        }
    }

    private void saveLevel(){
        LoadSave.saveLevel("newLevel", playing.getLevel());
    }

    public BufferedImage getButtonImage(int id){
        return playing.getTileManager().getSprite(id);
    }

    public void mouseClicked(int x, int y) {
        if (btnMenu.getBounds().contains(x, y)){
            GameStates.gameState = GameStates.MENU;
        }else if (btnSave.getBounds().contains(x, y)){
            saveLevel();
        }else{
            for (MyButton myButton : tileButtons){
                if (myButton.getBounds().contains(x, y)){
                    selectedTile = playing.getTileManager().getTile(myButton.getId());
                    playing.setSelectedTile(selectedTile);
                }
            }
        }
    }

    public void mouseMoved(int x, int y) {
        btnMenu.setMouseOver(btnMenu.getBounds().contains(x, y));
        btnSave.setMouseOver(btnSave.getBounds().contains(x, y));
        for (MyButton myButton : tileButtons){
            myButton.setMouseOver(myButton.getBounds().contains(x, y));
        }
    }

    public void mousePressed(int x, int y) {
        btnMenu.setMousePressed(btnMenu.getBounds().contains(x, y));
        btnSave.setMousePressed(btnSave.getBounds().contains(x, y));
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
