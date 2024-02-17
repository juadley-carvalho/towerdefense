package com.jogo.scenes;

import com.jogo.main.Game;
import com.jogo.main.GameStates;
import com.jogo.ui.MyButton;
import static com.jogo.main.GameStates.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Menu extends GameScene implements SceneMethods{

    private BufferedImage image;
    private final Random random = new Random();
    private final ArrayList<BufferedImage> sprites = new ArrayList<>();
    private MyButton btnPlaying, btnSettings, btnQuit;

    public Menu(Game game){
        super(game);
        importImage();
        loadSprites();
        initButtons();
    }

    private void initButtons() {
        btnPlaying = new MyButton("Play", 270, 100, 100, 30);
        btnSettings = new MyButton("Settings", 270, 160, 100, 30);
        btnQuit = new MyButton("Quit", 270, 220, 100, 30);
    }

    @Override
    public void render(Graphics g) {
        btnPlaying.draw(g);
        btnSettings.draw(g);
        btnQuit.draw(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (btnPlaying.getBounds().contains(x, y)){
            gameState = PLAYING;
        }
    }

    private void loadSprites() {
        for (int line = 0; line < 10; line ++){
            for (int column = 0; column < 10; column ++){
                sprites.add(image.getSubimage(column*32, line*32, 32, 32));
            }
        }
    }

    private void importImage() {
        InputStream inputStream = getClass().getResourceAsStream("/spriteatlas.png");
        try{
            image = ImageIO.read(inputStream);
        }catch(Exception e){
            System.out.println("Image not found!");
        }
    }
}
