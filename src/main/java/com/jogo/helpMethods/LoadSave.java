package com.jogo.helpMethods;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class LoadSave {

    public static BufferedImage getSpriteAtlas(){

        BufferedImage image = null;

        InputStream inputStream = LoadSave.class.getResourceAsStream("/spriteatlas.png");
        try{
            image = ImageIO.read(inputStream);
        }catch(Exception e){
            System.out.println("Image not found!");
        }

        return image;
    }

    public static BufferedImage getBackground(){

        BufferedImage image = null;

        InputStream inputStream = LoadSave.class.getResourceAsStream("/background1.png");
        try{
            image = ImageIO.read(inputStream);
        }catch(Exception e){
            System.out.println("Image not found!");
        }

        return image;
    }
}
