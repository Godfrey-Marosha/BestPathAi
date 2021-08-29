package path.controller;

import path.model.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainController {

    public static void main(String[] args) {
        HashMap<String, Integer> materialCostMap =  Material.getMaterialWeight();



        Map<Integer, ArrayList<String>>  map = printAll();

        workOutPath(materialCostMap, map);

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

    public static void workOutPath(HashMap<String, Integer> materialCostMap, Map<Integer, ArrayList<String>>  map){
        int rowSize = map.size();
        int colSize = map.get(1).size();

        ArrayList<String> currentRow = null;
        ArrayList<String> nextRow = null;

        int totalCost = 0;
        int score = 0;

        int cursorCol = 0;
        int cursorRow = 0;

        int nextCursor = 0;
        int cursorX = 0;
        int cursorY = 0;

        int nextCost = 0;
        int adjacentCost = 0;

        int rowCursor = 0;
        int colCursor = 0;
        String previousCell = "";
        String currentCell = "";
        String nextCell = "";
        String adjacentCell = "";

        for (int row = 0; row < rowSize; row++) {
            currentRow = map.get(row);

            for (int col = 0; col < currentRow.size(); col++) {
                if (row == 0 && col == 0){
                    cursorCol = col;
                    cursorRow = row;

                    currentCell = map.get(cursorRow).get(cursorCol);
                }

                // Get Previous cell
                if (cursorCol - 1 < 0){
                    previousCell = map.get(cursorRow).get(cursorCol);
                }
                else{
                    previousCell = map.get(cursorRow).get(cursorCol - 1);
                }

                // Get next row
                if (cursorRow + 1 == rowSize){
                    nextRow = map.get(cursorRow);
                }
                else{
                    nextRow = map.get(cursorRow + 1);
                }

                // Get next cell
                if (cursorCol + 1 == currentRow.size()){
                    nextCell = currentRow.get(cursorCol);
                }
                else{
                    nextCell = currentRow.get(cursorCol + 1);
                }

                // Get adjacent cell
                adjacentCell = nextRow.get(cursorCol);

                nextCost     = (!Material.isWater(nextCell)) ? getMaterialWeight(materialCostMap, nextCell) : 0;
                adjacentCost = (!Material.isWater(adjacentCell)) ? getMaterialWeight(materialCostMap, adjacentCell) : 0;

                if (!(Material.isWater(nextCell) && Material.isWater(adjacentCell))){
                    if (nextCost < adjacentCost){
                        totalCost += nextCost;

                        cursorX = nextCursor;
                    }
                    else if (nextCost > adjacentCost){
                        totalCost += adjacentCost;
                        cursorX = col;
                    }
                    else{
                        totalCost += adjacentCost;
                    }
                }




        if (!nextCell.equals(Material.MATERIAL_WATER)){
            System.out.println("Previous: " + previousCell + " {"  + getMaterialWeight(materialCostMap,previousCell ) + "} " +
                    "Current: "  + currentCell + " {"  + getMaterialWeight(materialCostMap,currentCell) + "} " +
                    " Next: "    + nextCell    + " {"  + getMaterialWeight(materialCostMap,nextCell) + "} " +
                    " Adjacent: "  + adjacentCell + " {"  + getMaterialWeight(materialCostMap,adjacentCell) + "} " +
                    "=> (" + cursorX + ";" + cursorY + ") ### " + totalCost);
        }

    }



    //System.out.println(nextRow);
}

    }


    public static int getMaterialWeight(HashMap<String, Integer> materialCostMap, String materialSymbol){
        if (materialCostMap.containsKey(materialSymbol))
            return materialCostMap.get(materialSymbol.trim());
        else
            return 0;
    }

    public static Map<Integer, ArrayList<String>> printAll(){
        String rawMapText = extractMapData().trim();

        int colSize = rawMapText.indexOf("\n");

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

            if ((i + 1) % colSize == 0){
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
