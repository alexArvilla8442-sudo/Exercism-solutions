import java.util.ArrayList;
import java.util.List;

class Principal{
    public static void main(String[] args) {

        //System.out.println(new LargestSeriesProductCalculator("63915").calculateLargestProductForSeriesLength(3));
        System.out.println(new LargestSeriesProductCalculator("29").calculateLargestProductForSeriesLength(2));
        System.out.println(new LargestSeriesProductCalculator("0123456789").calculateLargestProductForSeriesLength(2));
        System.out.println(new LargestSeriesProductCalculator("576802143").calculateLargestProductForSeriesLength(2));
        System.out.println(new LargestSeriesProductCalculator("0123456789").calculateLargestProductForSeriesLength(3));
        System.out.println(new LargestSeriesProductCalculator("1027839564").calculateLargestProductForSeriesLength(3));
        System.out.println(new LargestSeriesProductCalculator("0123456789").calculateLargestProductForSeriesLength(5));
        System.out.println(new LargestSeriesProductCalculator("73167176531330624919225119674426574742355349194934").calculateLargestProductForSeriesLength(6));
        System.out.println(new LargestSeriesProductCalculator("0000").calculateLargestProductForSeriesLength(2));
        System.out.println(new LargestSeriesProductCalculator("99099").calculateLargestProductForSeriesLength(3));
        System.out.println(new LargestSeriesProductCalculator("123").calculateLargestProductForSeriesLength(4));
        System.out.println(new LargestSeriesProductCalculator("1234a5"));
        System.out.println(new LargestSeriesProductCalculator("9999999999").calculateLargestProductForSeriesLength(10));

    }
}


class LargestSeriesProductCalculator {

    private String inputNumber;

    LargestSeriesProductCalculator(String inputNumber) {
        this.inputNumber = inputNumber;

        boolean contieneSoloDigitos = this.StringContainsOnlyDigits();
        if (!contieneSoloDigitos) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        //longitud excepcion
        String cadenaDigitos = this.getInputNumber();
        int tamanio = this.TamanioCadena();

        if(numberOfDigits > tamanio) {
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }

        long largestProduct = 0;
        List<Long> listaMultiplicaciones = new ArrayList<>();
        int limiteComprobar = 0;

        int soloUnaVuelta = 0;
        limiteComprobar = (tamanio > numberOfDigits) ? tamanio - numberOfDigits : soloUnaVuelta;

        int contadorMultiplicacionesZero = 0;

        boolean containsZero = cadenaDigitos.contains("0");
        if(containsZero) {
            boolean everyDigitZero = this.StringContainsOnlyZeroDigits();

            if(everyDigitZero) {
                return largestProduct;
            }
        }

        String numerosComprobarSTR = "";
        for(int i = 0; i < tamanio; i++) {

            if(i <= limiteComprobar) {
                int cortarCadena = numberOfDigits + i;

                if(cortarCadena < tamanio){
                    numerosComprobarSTR = cadenaDigitos.substring(i, cortarCadena);
                }else{
                    numerosComprobarSTR = cadenaDigitos.substring(i);
                }

                long multiplicacionTodosDigitos = this.getMultiplicacion(numerosComprobarSTR);

                if(multiplicacionTodosDigitos == 0){
                    contadorMultiplicacionesZero++;
                }
                listaMultiplicaciones.add(multiplicacionTodosDigitos);

            }else{
                break;
            }
        }

        int tamanioListaMultiplaciones = listaMultiplicaciones.size();
        //todas multiplaciones cero
        if(contadorMultiplicacionesZero == tamanioListaMultiplaciones) {
            return largestProduct;
        }

        largestProduct = listaMultiplicaciones.stream().max(Long::compareTo).get();

        return largestProduct;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public int TamanioCadena(){
        return inputNumber.length();
    }

    public boolean StringContainsOnlyDigits() {
        int longitudTexto = this.TamanioCadena();
        String cadena = this.getInputNumber();
        for (int i = 0; i < longitudTexto; i++) {
            char caracter =  cadena.charAt(i);
            boolean isDigit = Character.isDigit(caracter);

            if(!isDigit){
                return false;
            }
        }
        return true;
    }

    public boolean StringContainsOnlyZeroDigits() {

        String cadena = this.getInputNumber();
        int contador = 0;
        int tamanio = this.TamanioCadena();
        for (int i = 0; i < tamanio; i++) {
            char caracter = cadena.charAt(i);
            int numero = Character.getNumericValue(caracter);

            if(numero == 0){
                contador++;
            }
        }

        return (contador == tamanio);
    }

    public long getMultiplicacion(String cadenaNumeros){

        List<Integer> listaNumeros = new ArrayList<>();
        long multiplicacion = 1;

        for (int i = 0; i < cadenaNumeros.length(); i++) {
            char caracter =  cadenaNumeros.charAt(i);
            int numero =  Character.getNumericValue(caracter);

            listaNumeros.add(numero);
        }

        int tamanioLista = listaNumeros.size();

        for (int i = 0; i < tamanioLista; i++) {
            int numero = listaNumeros.get(i);
            multiplicacion *= numero;
        }
        return multiplicacion;
    }

}
