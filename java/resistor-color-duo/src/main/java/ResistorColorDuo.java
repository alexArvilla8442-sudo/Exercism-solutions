import java.util.*;

class Principal{
    public static void main(String[] args) {
        var resistorColorDuo = new ResistorColorDuo();

        System.out.println(resistorColorDuo.value(new String[]{"brown", "black"}));
        System.out.println(resistorColorDuo.value(new String[]{"blue", "grey"}));
        System.out.println(resistorColorDuo.value(new String[]{ "yellow", "violet" }));
        System.out.println(resistorColorDuo.value(new String[]{ "orange", "orange" }));
        System.out.println(resistorColorDuo.value(new String[]{ "white", "red" }));
        System.out.println(resistorColorDuo.value(new String[]{ "black", "brown" }));
        System.out.println(resistorColorDuo.value(new String[]{ "green", "brown", "orange" }));
    }
}

class ResistorColorDuo {

    Map<String, Integer> colores = new LinkedHashMap<>();

    public ResistorColorDuo() {
        colores.put("black", 0);
        colores.put("brown", 1);
        colores.put("red", 2);
        colores.put("orange", 3);
        colores.put("yellow", 4);
        colores.put("green", 5);
        colores.put("blue", 6);
        colores.put("violet", 7);
        colores.put("grey", 8);
        colores.put("white", 9);
    }

    int value(String[] colors) {
        List<String> colorList = new LinkedList<>(Arrays.asList(colors));
        int numeroColoresConsiderar = 2;
        StringBuilder imprimirColor =  new StringBuilder();

        for (int i = 0; i < numeroColoresConsiderar ; i++) {
            int valorColor = getValueFromColor(colorList.get(i));
            imprimirColor.append(valorColor);
        }

        int valorImprimir = Integer.parseInt(imprimirColor.toString());
        return valorImprimir;
    }

    int getValueFromColor(String color) {
        int valor = colores.getOrDefault(color, -1);

        if(valor == -1){
            System.out.println("No color found");
            return -1;
        }
        return valor;
    }
}
