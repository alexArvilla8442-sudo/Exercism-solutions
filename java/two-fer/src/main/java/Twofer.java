import java.util.Objects;

class Principal{
    public static void main(String[] args) {
        var mensajeCompartir = new Twofer();

        System.out.println(mensajeCompartir.twofer(null));
        System.out.println(mensajeCompartir.twofer("Alice"));
        System.out.println(mensajeCompartir.twofer("Bob"));
    }
}

public class Twofer {
    public String twofer(String name) {
        if(name==null){
            return "One for you, one for me.";
        }

        boolean isStringEmpty = name.isBlank();
        String message = (isStringEmpty) ? "One for you, one for me." : String.format("One for %s, one for me.", name);
        return message;
    }
}
