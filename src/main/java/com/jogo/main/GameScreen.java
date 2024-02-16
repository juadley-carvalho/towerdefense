package com.jogo.main;

import javax.swing.JPanel;
import java.awt.*;

public class GameScreen extends JPanel {


    private final Dimension size = new Dimension(640, 640);
    private final Game game;

    public GameScreen(Game game){
        this.game = game;
        setPanelSize();
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
