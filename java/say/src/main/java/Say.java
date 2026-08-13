import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Principal{
    public static void main(String[] args) {
        System.out.println(new Say().say(0));
        System.out.println(new Say().say(1));
        System.out.println(new Say().say(14));
        System.out.println(new Say().say(20));
        System.out.println(new Say().say(22));
        System.out.println(new Say().say(30));
        System.out.println(new Say().say(99));
        System.out.println(new Say().say(100));
        System.out.println(new Say().say(123));
        System.out.println(new Say().say(200));
        System.out.println(new Say().say(999));
        System.out.println(new Say().say(1_000));
        System.out.println(new Say().say(1_234));
        System.out.println(new Say().say(1_000_000));
        System.out.println(new Say().say(1_002_345));
        System.out.println(new Say().say(1_000_000_000));
        System.out.println(new Say().say(987_654_321_123L));
        System.out.println(new Say().say(-1));
        System.out.println(new Say().say(1_000_000_000_000L));
    }
}

public class Say {

    public String say(long number) {
        boolean isLessThanZero = number < 0;

        if (isLessThanZero) {
            throw new IllegalArgumentException("numbers below zero are out of range");
        }

        String numberAsString = String.valueOf(number);
        int longitudNumero = numberAsString.length();
        String mensajeFinal="";

        int num = (int) number;
        mensajeFinal = switch(longitudNumero) {
            case 1 -> this.numeroMenorDiez(num);
            case 2 -> this.NumeroDosDigitos(numberAsString);
            case 3 -> this.NumeroTresDigitos(numberAsString);
            case 4, 5, 6 -> this.NumeroMayorMil(numberAsString, longitudNumero);
            case 7, 8, 9 -> this.NumeroMayorMillon(numberAsString, longitudNumero);
            case 10, 11, 12 -> this.NumeroMayorBILLON(numberAsString, longitudNumero);
            default -> throw new IllegalArgumentException("numbers above 999,999,999,999 are out of range");
        };

        return mensajeFinal;
    }

    public String numeroMenorDiez(int number){
        //Map<Integer, String> zeroToNine = MapaMessages.getZeroToNine();
        return this.buscarMapa(zeroToNine, number);
    }

    public String NumeroDosDigitos(String numeroSTRING){
        int numero = Integer.parseInt(numeroSTRING);

        StringBuilder decenasMensaje = new StringBuilder();
        String decenasStr = this.getPartNumber(numeroSTRING, 1);
        String unidadesSTR = this.getOtherPartNumber(numeroSTRING, 1);
        int decenas =  Integer.parseInt(decenasStr) * 10;
        int unidades = Integer.parseInt(unidadesSTR);

        //01 a 09
        if(decenas == 0){
            return decenasMensaje.append(this.numeroMenorDiez(unidades)).toString();
        }

        //10 a 19
        if(numero >= 10 && numero <= 19){

            //Map<Integer, String> dosDigitos = MapaMessages.getDosDigitos();
            return this.buscarMapa(dosDigitos, numero);
        }

        //20 y 90
        //Map<Integer, String> mapDecenas = MapaMessages.getMapDecenas();
        decenasMensaje.append(this.buscarMapa(mapDecenas, decenas));
        if(unidades == 0){
            return decenasMensaje.toString();
        }
        decenasMensaje.append("-");
        decenasMensaje.append(this.numeroMenorDiez(unidades));

        return decenasMensaje.toString();
    }

    public String NumeroTresDigitos(String numeroSTR){
        int numero = Integer.parseInt(numeroSTR);
        StringBuilder centenasMensaje = new StringBuilder();

        //100 y 90
        String centenasStr = this.getPartNumber(numeroSTR, 1);
        int centenas =  Integer.parseInt(centenasStr) * 100;
        String unidadesSTR = this.getOtherPartNumber(numeroSTR, 1);
        int unidades = Integer.parseInt(unidadesSTR);

        //Map<Integer, String> mapCentenas = MapaMessages.getMapCentenas();
        centenasMensaje.append(this.buscarMapa(mapCentenas, centenas));
        if(unidades == 0){
            return centenasMensaje.toString();
        }
        centenasMensaje.append(" " + this.NumeroDosDigitos(unidadesSTR));

        return centenasMensaje.toString();
    }

    public String NumeroMayorMil(String numeroStr, int tamanioNumero){
        int[] rangoNumeros = {4,5,6};
        String tipoNumero = "thousand";
        return this.getTypeOfNumber(numeroStr, tamanioNumero,  rangoNumeros, tipoNumero);
    }

    public String NumeroMayorMillon(String numeroStr, int tamanioNumero){
        int[] rangoNumeros = {7,8,9};
        String tipoNumero = "million";
        return this.getTypeOfNumber(numeroStr, tamanioNumero,  rangoNumeros, tipoNumero);
    }
    public String NumeroMayorBILLON(String numeroStr, int tamanioNumero){
        int[] rangoNumeros = {10, 11, 12};
        String tipoNumero = "billion";
        return this.getTypeOfNumber(numeroStr, tamanioNumero,  rangoNumeros, tipoNumero);
    }

    public String getPartNumber(String numeroTEXTO, int limite){
        return numeroTEXTO.substring(0,limite);
    }
    public String getOtherPartNumber(String numeroTEXTO, int inicio){
        return numeroTEXTO.substring(inicio);
    }

    //mil, millon y billon
    public String getTypeOfNumber(String numeroStr, int tamanioNumero, int[] rangoNumeros, String tipoNumero){
        int limite = 0;
        String numeroTexto = "";
        String restoNumeroTexto = "";
        String primeraParteNumero = "";
        String segundaParteNumero = "";
        StringBuilder mensajePantalla = new StringBuilder();

            int primerTamanioNumero = rangoNumeros[0];
            int segundoTamanioNumero = rangoNumeros[1];
            int tercerTamanioNumero = rangoNumeros[2];

            if(tamanioNumero == primerTamanioNumero){
                limite = 1;
                numeroTexto = this.getPartNumber(numeroStr, limite);
                restoNumeroTexto = this.getOtherPartNumber(numeroStr, limite);

            }else if(tamanioNumero == segundoTamanioNumero){
                limite = 2;
                numeroTexto = this.getPartNumber(numeroStr, limite);
                restoNumeroTexto = this.getOtherPartNumber(numeroStr, limite);

            }else if(tamanioNumero == tercerTamanioNumero){
                limite = 3;
                numeroTexto = this.getPartNumber(numeroStr, limite);
                restoNumeroTexto = this.getOtherPartNumber(numeroStr, limite);
            }

        primeraParteNumero = this.imprimirNumero(numeroTexto, numeroTexto.length(),  String.format(" %s ", tipoNumero));

        if(Integer.parseInt(restoNumeroTexto) == 0){
            return primeraParteNumero.replaceAll("\\s+", " ").trim();
        }
        int tamanioRestoNum = restoNumeroTexto.length();
        if("thousand".equals(tipoNumero)){
            segundaParteNumero = this.imprimirNumero(restoNumeroTexto, tamanioRestoNum, "");
        }else if("million".equals(tipoNumero)){
            segundaParteNumero = this.NumeroMayorMil(restoNumeroTexto, tamanioRestoNum);
        }else if("billion".equals(tipoNumero)){
            segundaParteNumero = this.NumeroMayorMillon(restoNumeroTexto, tamanioRestoNum);
        }

        mensajePantalla.append(primeraParteNumero);
        mensajePantalla.append(segundaParteNumero);

        //eliminar espacios en blanco que sobren
        String mensajeFinal = mensajePantalla.toString().replaceAll("\\s+", " ").trim();

        return mensajeFinal;
    }

    public String imprimirNumero(String numeroStr, int tamanioNumero, String lastPartString){
        int numero = Integer.parseInt(numeroStr);
        StringBuilder mensajeFinal = new StringBuilder();
        int numeroUNdigito = 1;
        int numeroDOSdigitos = 2;
        int numeroTRESdigitos = 3;

        if(tamanioNumero == numeroUNdigito){
            mensajeFinal.append(this.numeroMenorDiez(Integer.parseInt(numeroStr)));
        }else if(tamanioNumero == numeroDOSdigitos){
            mensajeFinal.append(this.NumeroDosDigitos(numeroStr));
        }else if(tamanioNumero == numeroTRESdigitos){
            mensajeFinal.append(this.NumeroTresDigitos(numeroStr));
        }

        if(lastPartString.isEmpty()){
            return mensajeFinal.toString();
        }
        mensajeFinal.append(lastPartString);

        return mensajeFinal.toString();
    }



    //Maps y metodos Maps
    Map<Integer, String> zeroToNine = Map.of(
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
    Map<Integer, String> dosDigitos = Map.of(
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
    Map<Integer, String> mapDecenas = Map.of(
            20, "twenty",
            30, "thirty",
            40, "forty",
            50, "fifty",
            60, "sixty",
            70, "seventy",
            80, "eighty",
            90, "ninety"
    );
    Map<Integer, String> mapCentenas = Map.of(
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
    public String buscarMapa(Map<Integer, String> mapa, int numeroBuscar){
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
