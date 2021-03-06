package path.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Material {
    public static final String MATERIAL_WATER       = "~";
    public static final String MATERIAL_FLAT_LAND_1 = ".";
    public static final String MATERIAL_FLAT_LAND_2 = "@";
    public static final String MATERIAL_FLAT_LAND_3 = "X";
    public static final String MATERIAL_FOREST      = "*";
    public static final String MATERIAL_MOUNTAIN    = "^";

    public static final String TEMP_MAP = "@*^^^\n" +
                                          "~~*~.\n" +
                                          "**...\n" +
                                          "^..*~\n" +
                                          "~~*~X\n";

    private static ArrayList<String> materialList;
    private static HashMap<String, Integer> materialScore;

    public Material(){

    }

    public static boolean isWater(String material){
        return material.equals(MATERIAL_WATER);
    }

    // Singleton pattern
    public ArrayList<String> getMaterialList(){
        if (materialList == null){
            materialList = new ArrayList<>();
            materialList.add(MATERIAL_FLAT_LAND_1);
            materialList.add(MATERIAL_FLAT_LAND_2);
            materialList.add(MATERIAL_FLAT_LAND_3);
            materialList.add(MATERIAL_FOREST);
            materialList.add(MATERIAL_MOUNTAIN);

        }
        return materialList;
    }

    // Singleton pattern
    public static HashMap<String, Integer> getMaterialWeight(){
        if (materialList == null){
            materialScore = new HashMap<>();

            materialScore.put(MATERIAL_FLAT_LAND_1, 1);
            materialScore.put(MATERIAL_FLAT_LAND_2, 1);
            materialScore.put(MATERIAL_FLAT_LAND_3, 1);
            materialScore.put(MATERIAL_FOREST, 2);
            materialScore.put(MATERIAL_MOUNTAIN, 3);
        }
        return materialScore;
    }
}
