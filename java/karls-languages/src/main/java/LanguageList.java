import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class principale{
    public static void main(String[] args) {

        LanguageList languageList = new LanguageList();
        languageList.isEmpty();

        languageList.addLanguage("Java");
        languageList.isEmpty();

        languageList.removeLanguage("Java");
        languageList.isEmpty();

        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        languageList.firstLanguage();
        System.out.println("Java".equals(languageList.firstLanguage()));

        languageList.count();
        System.out.println(languageList.count() == 3);

        languageList.deleteList();
        System.out.println(languageList.count() == 0);

        languageList.addLanguage("Java");
        languageList.containsLanguage("Java");

        languageList.removeLanguage("Java");
        languageList.addLanguage("Kotlin");
        languageList.containsLanguage("Java");

        languageList.removeLanguage("Kotlin");
        languageList.addLanguage("Java");
        languageList.isExciting();

        languageList.removeLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Kotlin");
        languageList.isExciting();

        languageList.removeLanguage("Kotlin");
        languageList.addLanguage("Ruby");
        languageList.addLanguage("C++");
        languageList.isExciting();


        System.out.println(languageList.getLanguages());



    }
}

public class LanguageList {
    private List<String> languages = new ArrayList<>();

    /*private LanguageList(List<String> languages) {
        this.languages = languages;
    }

    public static LanguageList getLanguageList(List<String> languages){
        return new LanguageList(languages);
    }*/

    public List<String> getLanguages() {
        return languages;
    }

    public void deleteList(){
        languages.clear();
    }

    public boolean isEmpty() {
        return languages.isEmpty();
    }

    public void addLanguage(String language) {
        languages.add(language);
    }

    public void removeLanguage(String language) {
        boolean existe = containsLanguage(language);

        if(existe){
            languages.remove(language);
        }else{
            System.out.println("Elemento a eliminar no existe en la lista");
        }
    }

    public String firstLanguage() {
        int primerPosicion = 0;
        String primerElementoLista = languages.get(primerPosicion);
        return primerElementoLista;
    }

    public int count() {
        return languages.size();
    }

    public boolean containsLanguage(String language) {
        Set<String> verificarExista = new HashSet<>(languages);
        return verificarExista.contains(language);
    }

    public boolean isExciting() {
        boolean isJavaInList = containsLanguage("Java");
        boolean isKotlinInList = containsLanguage("Kotlin");

        return (isJavaInList || isKotlinInList);
    }
}
