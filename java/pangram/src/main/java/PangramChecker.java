import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Principal{
    public static void main(String[] args) {
        var pangramChecker = new PangramChecker();
        System.out.println(pangramChecker.isPangram(""));
        System.out.println(pangramChecker.isPangram("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(pangramChecker.isPangram("the quick brown fox jumps over the lazy dog"));
        System.out.println(pangramChecker.isPangram("a quick movement of the enemy will jeopardize five gunboats"));
        System.out.println(pangramChecker.isPangram("five boxing wizards jump quickly at it"));
        System.out.println(pangramChecker.isPangram("the_quick_brown_fox_jumps_over_the_lazy_dog"));
        System.out.println(pangramChecker.isPangram("the 1 quick brown fox jumps over the 2 lazy dogs"));
        System.out.println(pangramChecker.isPangram("7h3 qu1ck brown fox jumps ov3r 7h3 lazy dog"));
        System.out.println(pangramChecker.isPangram("\"Five quacking Zephyrs jolt my wax bed.\""));
        System.out.println(pangramChecker.isPangram("abcdefghijklm ABCDEFGHIJKLM"));

    }
}

public class PangramChecker {

    public boolean isPangram(String input) {

        int totalLetrasAbecedario = 26;
        boolean isPangram = false;
        String cadenaComparar = (input.contains(" ")) ? input.replace(" ", "").toLowerCase() : input;
        Set<Character> pangram = new LinkedHashSet<>();

        StringBuilder cadenaSoloLetras = new StringBuilder();

        for (int i = 0; i < cadenaComparar.length(); i++) {
            char caracter = cadenaComparar.charAt(i);
            boolean isLetter =  Character.isLetter(caracter);

            if (isLetter) {
                cadenaSoloLetras.append(caracter);
            }
        }

        pangram = (cadenaSoloLetras.toString()).chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        isPangram = (pangram.size() == totalLetrasAbecedario);

        return isPangram;
    }

}
