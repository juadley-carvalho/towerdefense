package com.jogo.main;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel {

    private Random random;
    private BufferedImage image;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private long lastTime;
    private int frames;

    public GameScreen(BufferedImage image){
        this.image = image;
        loadSprites();
        random = new Random();
    }

    private void loadSprites() {
        for (int line = 0; line < 10; line ++){
            for (int column = 0; column < 10; column ++){
                sprites.add(image.getSubimage(column*32, line*32, 32, 32));
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int line = 0; line < 20; line ++){
            for (int column = 0; column < 20; column ++){
                g.drawImage(sprites.get(random.nextInt(0, 79)), column*32, line*32, null);
            }
        }

        callFPS();
    }

    private void callFPS(){

        frames++;
        if (System.currentTimeMillis() - lastTime >= 1000){
            System.out.println("FPS: " + frames);
            frames = 0;
            lastTime = System.currentTimeMillis();
        }

    }
}
