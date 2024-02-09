package com.jogo.main;

import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Game extends JFrame {

    private GameScreen gameScreen;
    private BufferedImage image;

    public Game(){
        setSize(656, 679);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        importImage();

        gameScreen = new GameScreen();

        //add(gameScreen);
        setVisible(true);
    }

    private void importImage() {
        InputStream inputStream = getClass().getResourceAsStream("spriteatlas.png");
        System.out.println(inputStream);
    }
}
