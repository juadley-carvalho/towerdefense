package com.jogo.main;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel {

    private final Random random = new Random();;
    private final BufferedImage image;
    private final ArrayList<BufferedImage> sprites = new ArrayList<>();
    private final Dimension size = new Dimension(640, 640);
    private final Render render;

    public GameScreen(BufferedImage image){
        this.image = image;
        render = new Render(this);
        setPanelSize();
        loadSprites();
    }

    private void setPanelSize() {
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
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
    }
}
