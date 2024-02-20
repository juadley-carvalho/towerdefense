package com.jogo.main;

import com.jogo.inputs.KeyboardListener;
import com.jogo.inputs.MyMouseListener;

import javax.swing.JPanel;
import java.awt.*;

public class GameScreen extends JPanel {


    private final Dimension size = new Dimension(640, 740);
    private final Game game;

    private KeyboardListener keyboardListener;
    private MyMouseListener myMouseListener;

    public GameScreen(Game game){
        this.game = game;
        setPanelSize();
        initInputs();
    }

    private void initInputs(){
        myMouseListener = new MyMouseListener(game);
        keyboardListener = new KeyboardListener();

        addMouseListener(myMouseListener);
        addMouseMotionListener(myMouseListener);
        addKeyListener(keyboardListener);

        requestFocus();
    }

    private void setPanelSize() {
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.getRender().render(g);
    }
}
