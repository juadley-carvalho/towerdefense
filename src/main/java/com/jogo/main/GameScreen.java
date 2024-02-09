package com.jogo.main;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class GameScreen extends JPanel {

    private Random random;

    public GameScreen(){
        random = new Random();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int line = 0; line < 20; line ++){
            for (int column = 0; column < 20; column ++){
                g.setColor(getRandomColor());
                g.fillRect(line * 32, column * 32, 32, 32);
            }
        }
    }

    private Color getRandomColor(){
        int red = random.nextInt(0, 255);
        int green = random.nextInt(0, 255);
        int blue = random.nextInt(0, 255);
        return new Color(red, green, blue);
    }
}
