package com.jogo.helpMethods;

import java.util.ArrayList;

public class Utils {
    public static int[][] arrayTo2D(ArrayList<Integer> idArray, int ySize, int xSize){
        int[][] newArray = new int[ySize][xSize];
        int index = 0;
        for (int y = 0; y < newArray.length; y++){
            for (int x = 0; x < newArray[y].length; x++){
                index = y*ySize + x;
                newArray[y][x] = idArray.get(index);
            }
        }

        return newArray;
    }

    public static int[] arrayTo1D(int[][] idArray){
        int[] newArray = new int[idArray.length * idArray[0].length];

        int index = 0;

        for (int y = 0; y < idArray.length; y++){
            for (int x = 0; x < idArray[y].length; x++){
                index = y * idArray.length + x;
                newArray[index] = idArray[y][x];
            }
        }

        return newArray;
    }
}
