import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Principal{
    public static void main(String[] args) {
        var luhnValidator = new LuhnValidator();
        //System.out.println(luhnValidator.isValid(" 234 567 891 234 "));
        System.out.println(luhnValidator.isValid("1"));
        System.out.println(luhnValidator.isValid("0"));
        System.out.println(luhnValidator.isValid("059"));
        System.out.println(luhnValidator.isValid("59"));
        System.out.println(luhnValidator.isValid("055 444 285"));
        System.out.println(luhnValidator.isValid("055 444 286"));
        System.out.println(luhnValidator.isValid("8273 1232 7352 0569"));
        System.out.println(luhnValidator.isValid("1 2345 6789 1234 5678 9012"));
        System.out.println(luhnValidator.isValid("1 2345 6789 1234 5678 9013"));
        System.out.println(luhnValidator.isValid("095 245 88"));
        System.out.println(luhnValidator.isValid("234 567 891 234"));
        System.out.println(luhnValidator.isValid("059a"));
        System.out.println(luhnValidator.isValid("055-444-285"));
        System.out.println(luhnValidator.isValid("055# 444$ 285"));
        System.out.println(luhnValidator.isValid(" 0"));
        System.out.println(luhnValidator.isValid("0000 0"));
        System.out.println(luhnValidator.isValid("091"));
        System.out.println(luhnValidator.isValid("9999999999 9999999999 9999999999 9999999999"));
        System.out.println(luhnValidator.isValid("109"));
        System.out.println(luhnValidator.isValid("055b 444 285"));
        System.out.println(luhnValidator.isValid(":9"));
        System.out.println(luhnValidator.isValid("59%59"));
        System.out.println(luhnValidator.isValid("85&"));
    }
}


class LuhnValidator {

    boolean isValid(String candidate) {

        String cadenaDigitos = candidate.replace(" ", "").trim();
        boolean isValid = false;

        int tamanio = this.TamanioString(cadenaDigitos);
        boolean onlyDigits = this.ContainsOnlyDigits(cadenaDigitos);
        if(!onlyDigits || tamanio <= 1){
            return false;
        }

        String cadenaInversa = new StringBuilder(cadenaDigitos).reverse().toString();
        List<Integer> listaNumeros = new LinkedList<>();

        for(int i = 0; i < cadenaInversa.length(); i++){
            char caracter = cadenaInversa.charAt(i);
            int numero = Character.getNumericValue(caracter);
            boolean posicionPar = i % 2 == 0;

            if(!posicionPar){
                int dobleNumero = numero * 2;
                dobleNumero = (dobleNumero > 9)? dobleNumero - 9 : dobleNumero;
                listaNumeros.add(dobleNumero);
            }else{
                listaNumeros.add(numero);
            }
        }
        boolean esDivisible10 = this.NumeroDivisible10(listaNumeros);

        return esDivisible10;
    }


    public boolean ContainsOnlyDigits(String candidate) {
        int tamanio = this.TamanioString(candidate);

        for(int i = 0; i < tamanio; i++){
            char caracter = candidate.charAt(i);
            boolean isDigit =  Character.isDigit(caracter);

            if(!isDigit){
                return false;
            }
        }
        return true;
    }

    public boolean NumeroDivisible10(List<Integer> listaNumeros) {
        int sumaTotal = this.SumaTodosNumerosLista(listaNumeros);
        //System.out.println("Suma total: " + sumaTotal);
        return (sumaTotal % 10 == 0);
    }
    public int SumaTodosNumerosLista(List<Integer> listaNumeros) {
        int tamanio = listaNumeros.size();
        int sumaTotal = 0;

        for(int i = 0; i < tamanio; i++){
            int numero = listaNumeros.get(i);
            sumaTotal += numero;
        }

        return sumaTotal;
    }

    public int TamanioString(String cadena){
        return cadena.length();
    }

}
