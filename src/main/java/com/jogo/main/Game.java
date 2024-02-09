package com.jogo.main;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Game extends JFrame {

    private final GameScreen gameScreen;
    private BufferedImage image;
    private double timePerFrame;
    private long lastFrame;
    private double timePerUpdate;
    private long lastUpdate;

    public Game(){
        setSize(656, 679);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        importImage();

        gameScreen = new GameScreen(importImage());

        timePerFrame = 1000000000.0 / 120.0; //Define taxa de atualização em 60fps
        timePerUpdate = 1000000000.0 / 60.0;

        add(gameScreen);
        setVisible(true);
        gameLoop();
    }

    private void gameLoop() {

        while (true){

            if (System.nanoTime() - lastUpdate >= timePerUpdate){ //Verifica se já se passou o tempo para atualizar a tela
                lastUpdate = System.nanoTime();
                updateGame();
            }

            if (System.nanoTime() - lastFrame >= timePerFrame){ //Verifica se já se passou o tempo para atualizar a tela
                lastFrame = System.nanoTime();
                repaint();
            }
        }
    }

    private void updateGame() {
        System.out.println("Game updated!");
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
