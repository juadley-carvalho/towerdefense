package com.jogo.threads;

import javazoom.jl.player.Player;
import javazoom.jlgui.basicplayer.BasicPlayer;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class Music implements Runnable{

    @Override
    public void run() {
        try {
            BasicPlayer player = new BasicPlayer();
            player.open(new java.io.File("C:\\Users\\u1203536\\Documents\\Desenvolvimento\\Java\\TowerDefense\\src\\main\\resources\\bgm.mp3"));
            player.setGain(-3.0f);
            player.play();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error playing music file!");
            e.printStackTrace();
        }
    }

    /*@Override
    public void run() {
        try (InputStream is = getClass().getResourceAsStream("/bgm.mp3")){
            BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
            Player player = new Player(bufferedInputStream);
            player.play();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error playing music file!");
            e.printStackTrace();
        }
    }*/
}
