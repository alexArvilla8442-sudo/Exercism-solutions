import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Principal{
    public static void main(String[] args) {
        //var acronyum = new Acronym("Portable Network Graphics");
        System.out.println(new Acronym("Portable Network Graphics").get());
        System.out.println(new Acronym("Ruby on Rails").get());
        System.out.println(new Acronym("First In, First Out").get());
        System.out.println(new Acronym("GNU Image Manipulation Program").get());
        System.out.println(new Acronym("Complementary metal-oxide semiconductor").get());
        System.out.println(new Acronym("Rolling On The Floor Laughing So Hard That My Dogs Came Over And Licked Me").get());
        System.out.println(new Acronym("Something - I made up from thin air").get());
        System.out.println(new Acronym("Halley's Comet").get());
        System.out.println(new Acronym("The Road _Not_ Taken").get());
    }
}

class Acronym {

    private String frase;
    Acronym(String phrase) {
        this.frase = phrase;
    }

    public String getFrase() {
        return this.frase;
    }

    String get() {
        String acronym = "";
        StringBuilder completeAcronym = new StringBuilder();

        boolean contieneGuionBajo = this.frase.contains("_");
        String acronyumSinGuionBajo = (contieneGuionBajo) ? this.getFrase().replace("_", "") : this.getFrase();

        boolean contieneSigno = this.frase.contains("-");
        //eliminar -
        if(contieneSigno) {
            //String acronymPart1 = acronyumSinGuionBajo;
            acronym = acronyumSinGuionBajo.replace("-", " ");
        }else{
            acronym = acronyumSinGuionBajo;
        }

        List<String> lista = new ArrayList<>(Arrays.asList(acronym.split(" ")));
        lista.removeIf(elemento -> elemento == null || elemento.trim().isEmpty());

        for (int i = 0; i < lista.size(); i++) {
             String primerCaracter =  String.valueOf(lista.get(i).charAt(0)).toUpperCase();
             completeAcronym.append(primerCaracter);
        }

        return completeAcronym.toString();
    }

}
