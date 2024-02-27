package com.jogo.helpMethods;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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

    public static File createFile(String name){
        File file = new File("src//main//levels//" + name +".txt");

        if (!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException error){
                System.out.println("Error while creating file!");
                error.printStackTrace();
            }
        }
        return file;
    }

    private static void writeToFile(File file, int[] idArray){
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (int i : idArray){
                printWriter.println(i);
            }
        }catch (FileNotFoundException exp){
            JOptionPane.showMessageDialog(null, "Error inputting text!");
            exp.printStackTrace();
        }
    }

    public static ArrayList<Integer> readFromFile(File file){
        ArrayList<Integer> idArray = new ArrayList<>();

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                idArray.add(scanner.nextInt());
            }
        }catch(IOException error){
            System.out.println("Error reading file!");
            error.printStackTrace();
        }
        return idArray;
    }

    public static void createLevel(String name, int[] idArray){
        File newLevel = new File("src//main//levels//" + name +".txt");
        if (newLevel.exists()){
            System.out.println("File " + name + ".txt already exists!");
        }else{
            createFile(name);
        }
        writeToFile(newLevel, idArray);
    }

    public static int[][] getLevelData(String name){
        File level = new File("src//main//levels//" + name + ".txt");
        if (level.exists()){
            ArrayList<Integer> idArray = readFromFile(level);
            return Utils.arrayTo2D(idArray, 20, 20);
        }else{
            System.out.println("File " + name + ".txt does not exist!");
            return null;
        }
    }

    public static void createDefaultLevel() {
        int[] idArray = new int[400];
        for (int i = 0; i < idArray.length; i ++){
            idArray[i] = 0;
        }
        LoadSave.createLevel("newTestLevel", idArray);
    }
}
