package com.jogo.scenes;

import com.jogo.main.Game;

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

    public Menu(Game game){
        super(game);
        this.image = importImage();
        loadSprites();
    }

    @Override
    public void render(Graphics g) {
        for (int line = 0; line < 20; line ++){
            for (int column = 0; column < 20; column ++){
                g.drawImage(sprites.get(random.nextInt(0, 79)), column*32, line*32, null);
            }
        }
    }

    private void loadSprites() {
        for (int line = 0; line < 10; line ++){
            for (int column = 0; column < 10; column ++){
                sprites.add(image.getSubimage(column*32, line*32, 32, 32));
            }
        }
    }

    private BufferedImage importImage() {
        InputStream inputStream = getClass().getResourceAsStream("/spriteatlas.png");
        try{
            image = ImageIO.read(inputStream);
        }catch(Exception e){
            System.out.println("Image not found!");
        }
        return image;
    }
}
