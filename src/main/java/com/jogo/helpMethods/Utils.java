package com.jogo.helpMethods;

import java.util.ArrayList;

public class Utils {
    public static int[][] arrayTo2D(ArrayList<Integer> idArray, int ySize, int xSize){
        int[][] newArray = new int[ySize][xSize];
        int index = 0;
        for (int y = 0; y < newArray.length; y++){
            for (int x = 0; x < newArray[y].length; x++){
                index = y*ySize * x;
                newArray[y][x] = index;
            }
        }

        return newArray;
    }
}
