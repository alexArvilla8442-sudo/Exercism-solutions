
class Principal{
    public static void main(String[] args) {
        System.out.println(new Scrabble("a").getScore());
        System.out.println(new Scrabble("A").getScore());
        System.out.println(new Scrabble("f").getScore());
        System.out.println(new Scrabble("at").getScore());
        System.out.println(new Scrabble("zoo").getScore());
        System.out.println(new Scrabble("street").getScore());
        System.out.println(new Scrabble("quirky").getScore());
        System.out.println(new Scrabble("OxyphenButazone").getScore());
        System.out.println(new Scrabble("pinata").getScore());
        System.out.println(new Scrabble("").getScore());
        System.out.println(new Scrabble("abcdefghijklmnopqrstuvwxyz").getScore());
    }
}


class Scrabble {

    private String word;

    Scrabble(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    int getScore() {
        int score = 0;
        String palabra = this.getWord().toUpperCase();
        if(palabra.isEmpty()){
            return 0;
        }

        int tamanio = palabra.length();

        for (int i = 0; i < tamanio; i++) {
            char letra = palabra.charAt(i);
            int valorLetra = this.getValueOfLetter(letra);
            score += valorLetra;
        }

        return score;
    }

    public int getValueOfLetter(char letra){
        /*
    *   A, E, I, O, U, L, N, R, S, T	1
        D, G	                        2
        B, C, M, P	                    3
        F, H, V, W, Y	                4
        K	                            5
        J, X	                        8
        Q, Z	                        10
    * */

        int valor = switch(letra){
            case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1;
            case 'D', 'G' -> 2;
            case 'B', 'C', 'M', 'P' -> 3;
            case 'F', 'H', 'V', 'W', 'Y' -> 4;
            case 'K' -> 5;
            case 'J', 'X' -> 8;
            case 'Q', 'Z' -> 10;
            default -> 0;
        };

        return valor;
    }

}
