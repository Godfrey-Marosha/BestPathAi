package path.controller;

import path.model.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainController {

    public static void main(String[] args) {
        Map<Integer, ArrayList<String>>  map = printAll();

        workOutPath(map);
        /*String[][] rawMap = getMap();

        if (rawMap == null){
            System.err.println("Map data could not be extracted!");
            System.exit(0);
        }

        for (int row = 0; row < 50;row++){
            for (int col = 0; col < 50;col++){
                //System.out.print(rawMap[row][col]);
            }
            //System.out.println();
        }*/
    }

    public static void workOutPath(Map<Integer, ArrayList<String>>  map){
        for (int key : map.keySet()) {
            System.out.println(key);
        }
    }

    public static Map<Integer, ArrayList<String>> printAll(){
        String rawMapText = extractMapData();

        rawMapText = rawMapText.replace("\n", "");

        char[] charArr = rawMapText.toCharArray();

        Map<Integer, ArrayList<String>> rowList = new HashMap<>();
        ArrayList<String> colList = new ArrayList();

        int rowCount = 0;

        for (int i = 0;i < charArr.length;i++){
            colList.add((charArr[i] + "").trim());

            if (Character.isWhitespace(charArr[i])){
                //System.out.println();
            }

            if ((i + 1) % 50 == 0){
                rowList.put(rowCount, colList);
                colList = new ArrayList();
                //System.out.println();
                rowCount++;
            }
        }

        return rowList;
    }

/*
    public static String[][] getMap(){
        String[][] finalMap = new String[50][50];
        String rawMapText = extractMapData();

        if (rawMapText.isEmpty()){
            return null;
        }
        else{
            char[] charArr = rawMapText.toCharArray();

            int row = 0;
            int col = 0;

            for (int i = 0; i  < charArr.length; i ++){
                col++;
                //row++;

                if ((i + 1) % 50 == 0){
                    col = 0;
                    row++;
                    System.out.println();
                }

                if (row != 50){
                    //finalMap[row][col] = charArr[i] + "";
                    System.out.print("[ " + row + " ; " + col + " " + charArr[i] + " ] _ ");
                }

            }
            return finalMap;
            *//*for (char c: charArr){
                System.out.print(c);
            }*//*
        }
    }
    */

    public static String extractMapData(){
        return Material.TEMP_MAP;
    }
}
