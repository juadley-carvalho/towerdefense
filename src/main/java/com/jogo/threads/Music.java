package com.jogo.threads;

import javazoom.jl.player.Player;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class Music implements Runnable{

    @Override
    public void run() {
        try (InputStream is = getClass().getResourceAsStream("/bgm.mp3")){
            BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
            Player player = new Player(bufferedInputStream);
            player.play();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error playing music file!");
            e.printStackTrace();
        }
    }
}
