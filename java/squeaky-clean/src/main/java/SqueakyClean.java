import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class SqueakyClean {

    public static void main(String[] args) {

        System.out.println(SqueakyClean.clean(""));
        System.out.println(SqueakyClean.clean("A"));
        System.out.println(SqueakyClean.clean("abc"));
        System.out.println(SqueakyClean.clean("my   Id"));
        System.out.println(SqueakyClean.clean(" myId "));
        System.out.println(SqueakyClean.clean("a-bc"));
        System.out.println(SqueakyClean.clean("a-C "));
        System.out.println(SqueakyClean.clean(" hello-world "));
        System.out.println(SqueakyClean.clean("H3ll0 W0rld"));
        System.out.println(SqueakyClean.clean("¡1337sp34k is fun!"));
        System.out.println(SqueakyClean.clean("a$#.b"));
        System.out.println(SqueakyClean.clean("¡hello world!. "));

    }

    public static String clean(String identifier) {
        String cadenaNoTengaEspacios = SqueakyClean.NoWhiteSpaces(identifier);
        String digitsToLetters = SqueakyClean.convertString(cadenaNoTengaEspacios);
        String stringCamelCase = SqueakyClean.ConvertCamelCase(digitsToLetters);
        return SqueakyClean.useOnlyLetters(stringCamelCase);
    }

    private static String NoWhiteSpaces(String identifier) {
        String noWhiteSpaces = identifier.replace(" ", "_");
        return noWhiteSpaces;
    }

    private static String ConvertCamelCase(String identifier) {
        boolean contieneCaracter = (identifier.contains("-")) ? true : false;

        if(!contieneCaracter) {
            return identifier;
        }

        //1convertir cadena en una lista
        List<String> lista = Arrays.asList(identifier.split("-"));
        //2. lista todos esten en minusculas
        List<String> listaMinusculas = lista.stream()
                .map(s -> s.toLowerCase())
                .collect(Collectors.toList());

        StringBuilder resultadoCamelCase = new StringBuilder();
        resultadoCamelCase.append(listaMinusculas.get(0));
        for (int i = 1; i < listaMinusculas.size(); i++) {    //se omite el primero
            String cadenaCamelCase = listaMinusculas.get(i);
            resultadoCamelCase.append(cadenaCamelCase.substring(0, 1).toUpperCase() + cadenaCamelCase.substring(1));
        }

        return resultadoCamelCase.toString();
    }

    private static String convertString(String identifier){
        //4, 3, 0, 1 and 7 with a, e, o, l, and t
        char[] cadenaCaracteres =  identifier.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char caracter : cadenaCaracteres) {
            sb = switch (caracter){
                case '4' -> sb.append('a');
                case '3' -> sb.append('e');
                case '0' -> sb.append('o');
                case '1' -> sb.append('l');
                case '7' -> sb.append('t');
                default -> sb.append(caracter);
            };
        }
        return sb.toString();
    }

    private static String useOnlyLetters(String cadena){

        char[] arrayCaracteres = cadena.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char caracter : arrayCaracteres) {
            if(!Character.isLetter(caracter)) {
                if(caracter == '_'){
                    sb.append(caracter);
                }
                continue;
            }
            sb.append(caracter);

        }

        return sb.toString();
    }

}
