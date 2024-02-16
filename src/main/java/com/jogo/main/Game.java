package com.jogo.main;

import com.jogo.inputs.KeyboardListener;
import com.jogo.inputs.MyMouseListener;
import com.jogo.scenes.Playing;
import com.jogo.scenes.Settings;
import com.jogo.scenes.Menu;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Game extends JFrame implements Runnable {

    private GameScreen gameScreen;
    private Thread gameThread;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    private KeyboardListener keyboardListener;
    private MyMouseListener myMouseListener;

    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;

    public Game(){
        //setSize(656, 679);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        initClasses();

        add(gameScreen);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        initInputs();
        start();
    }

    private void initClasses() {
        gameScreen = new GameScreen(this);
        render = new Render(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
    }

    public Render getRender(){
        return render;
    }

    private void initInputs(){
        myMouseListener = new MyMouseListener();
        keyboardListener = new KeyboardListener();

        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyboardListener);

        requestFocus();
    }

    public Menu getMenu(){
        return menu;
    }
    public Playing getPlaying(){
        return playing;
    }
    public Settings getSettings(){
        return settings;
    }

    private void start(){
        gameThread = new Thread(this){
        };
        gameThread.start();
    }

    @Override
    public void run() {

        long lastFrame = System.nanoTime();
        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastTimeCheck = System.currentTimeMillis();
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long lastUpdate = System.nanoTime();

        int frames = 0;
        int updates = 0;

        long now;

        while (true){

            now = System.nanoTime();
            //Render
            if (now - lastFrame >= timePerFrame){ //Verifica se já se passou o tempo para atualizar a tela
                lastFrame = now;
                repaint();
                frames++;
            }
            //Update
            if (now - lastUpdate >= timePerUpdate){ //Verifica se já se passou o tempo para atualizar a tela
                lastUpdate = now;
                updates++;
            }
            //Check
            if (System.currentTimeMillis() - lastTimeCheck >= 1000){
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }
}
