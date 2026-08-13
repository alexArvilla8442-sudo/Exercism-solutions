import java.util.Arrays;

class Principal{
    public static void main(String[] args) {

        System.out.println(new Proverb(new String[0]).recite());
        System.out.println(new Proverb(new String[]{"nail"}).recite());
        System.out.println(new Proverb(new String[]{"nail", "shoe"}).recite());
        System.out.println(new Proverb(new String[]{"nail", "shoe", "horse"}).recite());
        System.out.println(new Proverb(new String[]{"nail", "shoe", "horse", "rider", "message", "battle", "kingdom"}).recite());
        System.out.println(new Proverb(new String[]{"pin", "gun", "soldier", "battle"}).recite());
    }
}


class Proverb {

    private String[] words;
    Proverb(String[] words) {
        this.words = words;
    }

    private String[] getWords(){
        return this.words;
    }
    private int getTamanioCadena(){
        return this.words.length;
    }

    String recite() {
        String proverb = "";
        String[] cadena = this.getWords();
        //System.out.println(Arrays.toString(cadena));
        int tamanioCadena  = this.getTamanioCadena();
        boolean cadenaVacia = tamanioCadena == 0;
        boolean cadenaMayorUno = tamanioCadena > 1;
        if(cadenaVacia){
            System.out.println("cadena vacia");
            return proverb;
        }
        
        if(!cadenaMayorUno){
            String unicoValor = cadena[0];
            proverb =  String.format("And all for the want of a %s.", unicoValor);
        }

        proverb = getFraseFinal(tamanioCadena, cadena);
        return proverb;
    }

    private static String getFraseFinal(int tamanioCadena, String[] cadena) {
        StringBuilder formarFrase = new StringBuilder();
        int ultimaPosicion = tamanioCadena -1;
        String primerPalabra = cadena[0];
        for (int i = 0; i < tamanioCadena; i++) {
            String frase = "";
            String palabra = cadena[i];
            int posicion = i;
            if(posicion < ultimaPosicion){
                String siguientePalabra = cadena[i+1];
                frase = String.format("For want of a %s the %s was lost.\n",  palabra, siguientePalabra);
            }else{//igual
                frase = String.format("And all for the want of a %s.", primerPalabra);
            }
            formarFrase.append(frase);
        }

        return formarFrase.toString();
    }

}
