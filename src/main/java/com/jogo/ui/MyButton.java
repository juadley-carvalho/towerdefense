package com.jogo.ui;

import java.awt.*;

public class MyButton {

    private final int x, y, width, height;
    private final String text;
    private Rectangle bounds;

    public MyButton(String text, int x, int y, int width, int height){
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initBounds();
    }

    public void draw(Graphics g){

        //Body
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);

        //Border
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);

        //Text
        g.setColor(Color.blue);
        drawText(g);

    }

    private void drawText(Graphics g) {
        int w = g.getFontMetrics().stringWidth(text);
        int h = g.getFontMetrics().getHeight();
        g.drawString(text,x + width/2 - w/2, y + height/2 + h/2);
    }

    public void initBounds(){
        this.bounds = new Rectangle(x, y, width, height);
    }

    public Rectangle getBounds(){
        return bounds;
    }
}
