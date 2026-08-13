import java.util.Set;
import java.util.stream.Collectors;

class Principal{
    public static void main(String[] args) {
        var isogramChecker = new IsogramChecker();

        System.out.println(isogramChecker.isIsogram(""));
        System.out.println(isogramChecker.isIsogram("isogram"));
        System.out.println(isogramChecker.isIsogram("eleven"));
        System.out.println(isogramChecker.isIsogram("zzyzx"));
        System.out.println(isogramChecker.isIsogram("subdermatoglyphic"));
        System.out.println(isogramChecker.isIsogram("Alphabet"));
        System.out.println(isogramChecker.isIsogram("alphAbet"));
        System.out.println(isogramChecker.isIsogram("thumbscrew-japingly"));
        System.out.println(isogramChecker.isIsogram("thumbscrew-jappingly"));
        System.out.println(isogramChecker.isIsogram("six-year-old"));
        System.out.println(isogramChecker.isIsogram("Emily Jung Schwartzkopf"));
        System.out.println(isogramChecker.isIsogram("accentor"));

        System.out.println(new IsogramChecker().isIsogram("angola"));
        System.out.println(new IsogramChecker().isIsogram("up-to-date"));
    }
}

class IsogramChecker {

    boolean isIsogram(String phrase) {
        if(phrase.isEmpty()) return true;

        String frase = phrase.toLowerCase().replace(" ", "").trim();

        frase = (frase.contains("-"))? frase.replaceAll("-", ""): frase;
        int tamanioFrase = frase.length();

        Set<Character> charSet = frase.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        int tamanioSet = charSet.size();

        boolean esIsograma = (tamanioFrase == tamanioSet);
        return esIsograma;
    }

}
