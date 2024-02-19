package com.jogo.ui;

import java.awt.*;

public class MyButton {

    private final int x, y, width, height;
    private final String text;
    private Rectangle bounds;
    private boolean mouseOver;

    public MyButton(String text, int x, int y, int width, int height){
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initBounds();
    }

    public void draw(Graphics g){

        drawBody(g);
        drawText(g);

        //Border
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);

    }

    private void drawBody(Graphics g){
        if (mouseOver){
            g.setColor(Color.BLUE);
            g.fillRect(x, y, width, height);
            g.setColor(Color.WHITE);
        }else{
            g.setColor(Color.white);
            g.fillRect(x, y, width, height);
            g.setColor(Color.blue);
        }

    }

    private void drawText(Graphics g) {
        int w = g.getFontMetrics().stringWidth(text);
        int h = g.getFontMetrics().getHeight();
        g.drawString(text,x + width/2 - w/2, y + height/2 + h/2);
    }

    public void setMouseOver(boolean mouseOver){
        this.mouseOver = mouseOver;
    }

    public void initBounds(){
        this.bounds = new Rectangle(x, y, width, height);
    }

    public Rectangle getBounds(){
        return bounds;
    }
}
