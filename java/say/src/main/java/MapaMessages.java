import java.util.Map;

public class MapaMessages{
     private static Map<Integer, String> zeroToNine = Map.of(
            0, "zero",
            1, "one",
            2, "two",
            3, "three",
            4, "four",
            5, "five",
            6, "six",
            7, "seven",
            8, "eight",
            9, "nine"
    );

    private static Map<Integer, String> dosDigitos = Map.of(
            10, "ten",
            11, "eleven",
            12, "twelve",
            13, "thirteen",
            14, "fourteen",
            15, "fifteen",
            16, "sixteen",
            17, "seventeen",
            18, "eighteen",
            19, "nineteen"
    );

    private static Map<Integer, String> mapDecenas = Map.of(
            20, "twenty",
            30, "thirty",
            40, "forty",
            50, "fifty",
            60, "sixty",
            70, "seventy",
            80, "eighty",
            90, "ninety"
    );

    private static Map<Integer, String> mapCentenas = Map.of(
            100, "one hundred",
            200, "two hundred",
            300, "three hundred",
            400, "four hundred",
            500, "five hundred",
            600, "six hundred",
            700, "seven hundred",
            800, "eight hundred",
            900, "nine hundred"
    );

    public static Map<Integer, String> getZeroToNine() {
        return zeroToNine;
    }

    public static Map<Integer, String> getDosDigitos() {
        return dosDigitos;
    }

    public static Map<Integer, String> getMapDecenas() {
        return mapDecenas;
    }

    public static Map<Integer, String> getMapCentenas() {return mapCentenas;}

    public static String buscarMapa(Map<Integer, String> mapa, int numeroBuscar){
        String descripcionNumero = "";
        for (Map.Entry<Integer, String> entry : mapa.entrySet()) {
            Integer numero = entry.getKey();
            String mensaje = entry.getValue();
            if (numero == numeroBuscar) {
                descripcionNumero = mensaje;
                break;
            }
        }
        return descripcionNumero;
    }
}
