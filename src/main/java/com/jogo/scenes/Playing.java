package com.jogo.scenes;

import com.jogo.helpMethods.LevelBuild;
import com.jogo.helpMethods.LoadSave;
import com.jogo.main.Game;
import com.jogo.managers.TileManager;
import com.jogo.objects.Tile;
import com.jogo.ui.BottomBar;

import java.awt.*;

public class Playing extends GameScene implements SceneMethods{

    private final int[][] level;
    private final TileManager tileManager = new TileManager();
    private final BottomBar bottomBar;
    private Tile selectedTile;
    private int mouseX;
    private int mouseY;
    private boolean drawSelect;
    private int lastTileX;
    private int lastTileY;
    private int lastTileId;

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
        drawSelectedTile(g);
    }

    private void drawSelectedTile(Graphics g) {
        if (selectedTile != null && drawSelect){
            g.drawImage(selectedTile.getSprite(), mouseX, mouseY, 32, 32, null);
        }
    }

    public void setSelectedTile(Tile tile){
        selectedTile = tile;
        drawSelect = true;
    }

    public TileManager getTileManager(){
        return tileManager;
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (y >= 640){
            bottomBar.mouseClicked(x, y);
        }else {
            changeTile(mouseX, mouseY);
        }
    }

    private void changeTile(int mouseX, int mouseY) {
        if (selectedTile != null){
            int tileX = mouseX / 32;
            int tileY = mouseY / 32;

            if (lastTileX == tileX && lastTileY == tileY && lastTileId == selectedTile.getId()) return;

            lastTileX = tileX;
            lastTileY = tileY;
            lastTileId = selectedTile.getId();

            level[tileY][tileX] = selectedTile.getId();
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        if (y >= 640){
            bottomBar.mouseMoved(x, y);
            drawSelect = false;
        }else{
            mouseX = (x / 32) * 32;
            mouseY = (y / 32) * 32;
            drawSelect = true;
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

    @Override
    public void mouseDragged(int x, int y) {
        if (y < 640){
            changeTile(x, y);
        }
    }
}
