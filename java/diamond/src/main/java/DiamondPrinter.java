import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Principal {
    public static void main(String[] args) {
        var diamondPrinter = new DiamondPrinter();
        System.out.println(diamondPrinter.printToList('A'));
        System.out.println(diamondPrinter.printToList('B'));
        System.out.println(diamondPrinter.printToList('C'));
        System.out.println(diamondPrinter.printToList('D'));
        System.out.println(diamondPrinter.printToList('Z'));
    }
}


class DiamondPrinter {

    private String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    List<String> printToList(char a) {

        String letra = String.valueOf(a).toUpperCase();
        if("A".equals(letra)) {
            return new ArrayList<>(List.of(letra));
        }

        StringBuilder abecedarioAscAndDesc = new StringBuilder();

        int indiceLetraAbecedario = abecedario.indexOf(letra);


        String primeraParteCadena =  abecedario.substring(0, indiceLetraAbecedario + 1);
        String segundaParteCadenaPart1 =  abecedario.substring(0, indiceLetraAbecedario);
        String segundaParteCadenaPart2 = new StringBuilder(segundaParteCadenaPart1).reverse().toString();

        abecedarioAscAndDesc.append(primeraParteCadena);
        abecedarioAscAndDesc.append(segundaParteCadenaPart2);

        String cadenaFinal =  abecedarioAscAndDesc.toString();
        int tamanioCadena = cadenaFinal.length();
        int indiceUltimaLetra = tamanioCadena - 1;

        String[] arregloDiamante = new  String[tamanioCadena];
        int contador = 0;

        /*
        * ··A··
·B·B·
C···C
·B·B·
··A··
        * */

        for (int i = 0; i < primeraParteCadena.length(); i++) {

            //[0 y 4], [1 y 3], [2 y 2]
            char letter = primeraParteCadena.charAt(i);
            int primerIndiceArreglo = i;
            int segundoIndiceArreglo = indiceUltimaLetra - contador;

            int indiceImprimirLetra1 = indiceLetraAbecedario + contador;
            int indiceImprimirLetra2 = indiceLetraAbecedario - contador;

            boolean isLetterA = letter == 'A';
            boolean indicesArregloIguales = primerIndiceArreglo == segundoIndiceArreglo;
            StringBuilder cadenaLetra = new StringBuilder();

            for (int j = 0; j < tamanioCadena; j++) {
                cadenaLetra.append(" ");
            }

            if (isLetterA) {
                cadenaLetra.setCharAt(indiceImprimirLetra1, letter);
            }else{
                cadenaLetra.setCharAt(indiceImprimirLetra1, letter);
                cadenaLetra.setCharAt(indiceImprimirLetra2, letter);
            }

            String cadenaDiamante = cadenaLetra.toString();
            if(indicesArregloIguales) {
                arregloDiamante[primerIndiceArreglo] = cadenaDiamante;
            }else{
                arregloDiamante[primerIndiceArreglo] = cadenaDiamante;
                arregloDiamante[segundoIndiceArreglo] = cadenaDiamante;
            }

            contador++;
        }

        return Arrays.stream(arregloDiamante).toList();
    }

}
