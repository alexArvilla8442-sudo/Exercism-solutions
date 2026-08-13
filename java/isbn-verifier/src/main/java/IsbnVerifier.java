import java.util.LinkedList;
import java.util.List;

class Principal{
    public static void main(String[] args) {
        var isbnVerifier = new IsbnVerifier();
        System.out.println(isbnVerifier.isValid("3-598-21508-8"));
        System.out.println(isbnVerifier.isValid("3-598-21508-9"));
        System.out.println(isbnVerifier.isValid("3-598-21507-X"));
        System.out.println(isbnVerifier.isValid("ABCDEFG3-598-21507-XQWERTYUI"));
        System.out.println(isbnVerifier.isValid("3-598-21507-A"));
        System.out.println(isbnVerifier.isValid("4-598-21507-B"));
        System.out.println(isbnVerifier.isValid("3-598-P1581-X"));
        System.out.println(isbnVerifier.isValid("3-598-2X507-9"));
        System.out.println(isbnVerifier.isValid("3-598-21508-96"));
        System.out.println(isbnVerifier.isValid("3-598-2X507-5"));
        System.out.println(isbnVerifier.isValid("3598215088"));
        System.out.println(isbnVerifier.isValid("359821507X"));
        System.out.println(isbnVerifier.isValid("359821507"));
        System.out.println(isbnVerifier.isValid("3598215078X"));
        System.out.println(isbnVerifier.isValid("00"));
        System.out.println(isbnVerifier.isValid("3-598-21507"));
        System.out.println(isbnVerifier.isValid("3-598-21515-X"));
        System.out.println(isbnVerifier.isValid(""));
        System.out.println(isbnVerifier.isValid("134456729"));
        System.out.println(isbnVerifier.isValid("3132P34035"));
        System.out.println(isbnVerifier.isValid("3598P215088"));
        System.out.println(isbnVerifier.isValid("98245726788"));
    }
}

class IsbnVerifier {

    //3-598-21507-X
    //3-598-21508-9
    boolean isValid(String stringToVerify) {

        boolean isvalid = false;

        if(stringToVerify.isEmpty()) {
            return false;
        }

        List<Integer> listaDigitos = new LinkedList<>();
        String cadenaVerificar = stringToVerify.toUpperCase();
        boolean containsSimbol = cadenaVerificar.contains("-");
        //boolean containsX =  cadenaVerificar.contains("X");

        cadenaVerificar = containsSimbol ? cadenaVerificar.replaceAll("-", "") : cadenaVerificar;

        int i = 0;
        while(i < cadenaVerificar.length()){
            char caracter = cadenaVerificar.charAt(i);
            boolean isLetter =  Character.isLetter(caracter);
            boolean isDigit = Character.isDigit(caracter);

            if(isDigit){
                int numero = Character.getNumericValue(caracter);
                listaDigitos.add(numero);
            }else if(isLetter){
                if(caracter == 'X' && i == 9){
                    listaDigitos.add(10);
                }else{
                    //System.out.println("texto invalido");
                    return isvalid;
                }
            }
            i++;
        }

        int tamanioLista  = listaDigitos.size();
        if(tamanioLista != 10) {
            //System.out.println("texto invalido");
            return isvalid;
        }

        int multiplicadorLista = 10;
        int sumaDigitos = 0;

        for (int j = 0; j < tamanioLista; j++) {
            int numero =  listaDigitos.get(j);
            int resultado = numero * multiplicadorLista;

            sumaDigitos += resultado;
            multiplicadorLista--;
        }

        isvalid = (sumaDigitos % 11 == 0);

        return isvalid;
    }

}
