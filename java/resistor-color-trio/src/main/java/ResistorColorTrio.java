import java.lang.reflect.Array;
import java.util.*;

class Principal{
    public static void main(String[] args) {
        var resistorColorTrio = new ResistorColorTrio();
        System.out.println(resistorColorTrio.label(new String[]{"orange", "orange", "black"}));
        System.out.println(resistorColorTrio.label(new String[]{"blue", "grey", "brown"}));
        System.out.println(resistorColorTrio.label(new String[]{"red", "black", "red"}));
        System.out.println(resistorColorTrio.label(new String[]{"green", "brown", "orange"}));
        System.out.println(resistorColorTrio.label(new String[]{"yellow", "violet", "yellow"}));
        System.out.println(resistorColorTrio.label(new String[]{"blue", "violet", "blue"}));
        System.out.println(resistorColorTrio.label(new String[]{"black", "black", "black"}));
        System.out.println(resistorColorTrio.label(new String[]{"white", "white", "white"}));
        System.out.println(resistorColorTrio.label(new String[]{"black", "grey", "black"}));
        System.out.println( resistorColorTrio.label(new String[]{"blue", "green", "yellow", "orange"}));
    }
}

class ResistorColorTrio {

    Map<String, Integer> colores = new LinkedHashMap<>();
    /*
    * black: 0
brown: 1
red: 2
orange: 3
yellow: 4
green: 5
blue: 6
violet: 7
grey: 8
white: 9

    * */
    public ResistorColorTrio() {
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

    String label(String[] colors) {
        List<String> listaColores = new LinkedList<>(Arrays.asList(colors));
        int numeroValores = 2;
        int tercerValor = 2;
        StringBuilder imprimirValores = new StringBuilder();

        for (int i = 0; i < 2; i++) {
             int valorColor = this.getValue(listaColores.get(i));
             if(valorColor == -1 ){
                 return "Error, ingresa un color valido";
             }
             imprimirValores.append(valorColor);
        }

        int dosValoresLista = Integer.parseInt(imprimirValores.toString());
        int tercerValorLista = getValue(listaColores.get(tercerValor));

        return this.getValorFinal(dosValoresLista, tercerValorLista);

    }

    public int getValue(String color) {
        int valor = colores.getOrDefault(color, -1);

        if(valor == -1){
            System.out.println("No existe el color " + color);
            return -1;
        }
        return valor;
    }

    public String getValorFinal(int valorColores, int tercerValorLista){
        if(tercerValorLista == 0){
            return valorColores+" ohms";
        }

        int diezElevadoA = (int) Math.pow(10, tercerValorLista);

        String mensaje="";
        //si es un gigaohms
        long valorFinalInt = (long) valorColores * diezElevadoA;

        //si es ohms
        if(valorFinalInt < 1000){
            mensaje = valorFinalInt + " ohms";
        }else if(valorFinalInt < 999999 && valorFinalInt > 1000){
            int kiloohmsValor = (int) valorFinalInt / 1000;
            mensaje = kiloohmsValor + " kiloohms";
        }else if(valorFinalInt < 999999999 && valorFinalInt > 1000000){
            int megaohmsValor = (int) valorFinalInt / 1000000;
            mensaje = megaohmsValor + " megaohms";
        }else if(valorFinalInt >= 999999999){
            long gigaohmsValor = valorFinalInt / 1000000000;
            mensaje = gigaohmsValor + " gigaohms";
        }

        return mensaje;
    }

}
