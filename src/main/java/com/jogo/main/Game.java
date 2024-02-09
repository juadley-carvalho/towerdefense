package com.jogo.main;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Game extends JFrame {

    private final GameScreen gameScreen;
    private BufferedImage image;

    public Game(){
        setSize(656, 679);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        importImage();

        gameScreen = new GameScreen(importImage());

        add(gameScreen);
        setVisible(true);
    }

    private BufferedImage importImage() {
        InputStream inputStream = getClass().getResourceAsStream("/spriteatlas.png");
        try{
            image = ImageIO.read(inputStream);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Imagem não encontrada!");
        }
        return image;
    }
}