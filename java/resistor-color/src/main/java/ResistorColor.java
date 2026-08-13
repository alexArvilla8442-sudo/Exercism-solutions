import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static javax.swing.UIManager.put;

class Principal{
    public static void main(String[] args) {
        var resistorColor = new ResistorColor();

        System.out.println(resistorColor.colorCode("black"));
        System.out.println(resistorColor.colorCode("white"));
        System.out.println(resistorColor.colorCode("orange"));

        resistorColor.colors();
        //System.out.println(arreglo);
    }
}

class ResistorColor {

    Map<String, Integer> colors = new LinkedHashMap<>(
    );
    public ResistorColor() {
        colors.put("black", 0);
        colors.put("brown", 1);
        colors.put("red", 2);
        colors.put("orange", 3);
        colors.put("yellow", 4);
        colors.put("green", 5);
        colors.put("blue", 6);
        colors.put("violet", 7);
        colors.put("grey", 8);
        colors.put("white", 9);

    }

    int colorCode(String color) {
        int colorCodee = colors.getOrDefault(color, -1);

        if(colorCodee == -1) {
            System.out.println("Invalid color");
            return colorCodee;
        }

        return colorCodee;
    }

    String[] colors() {
        String[] arrayColores = this.colors.keySet().toArray(new String[0]);

        System.out.println("Array colores: " + Arrays.toString(arrayColores));
        return arrayColores;


    }
}
