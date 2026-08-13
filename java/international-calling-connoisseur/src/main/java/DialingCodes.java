import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DialingCodes implements IntDialingCodes<Integer, String> {

    private Map<Integer, String> mapCodes = new HashMap<>();
    private Set<String> collectionCountries = new HashSet<>();

    @Override
    public Map<Integer, String> getCodes() {
        return this.mapCodes;
    }

    @Override
    public void setDialingCode(Integer llaves, String valores) {
        this.mapCodes.put(llaves, valores);
    }

    @Override
    public String getCountry(Integer code) {
        String country = this.mapCodes.getOrDefault(code, "no existe Codigo de area");
        return country;
    }

    @Override
    public void addNewDialingCode(Integer code, String country) {
        //evitar que se repita el Pais

        if(this.collectionCountries.contains(country)) {
            return;
        }

        this.collectionCountries.add(country);

        //evita que se repita la llave
        this.mapCodes.computeIfAbsent(code, k -> country);
    }

    @Override
    public Integer findDialingCode(String country) {
        //Set<Integer> myKeySet = mapCodes.keySet();
        Integer codigo = null;
        for( Map.Entry e : mapCodes.entrySet()){

            if(e.getValue().equals(country)){
                codigo = (int) e.getKey();
                break;
            }
            //System.out.println(e.getKey() + " : " + e.getValue());
        }
        //int codigoFinal = (codigo != 0) ? codigo : null;
        return codigo;
    }

    public void printSet(){
        System.out.println(this.collectionCountries);
    }

    @Override
    public void updateCountryDialingCode(Integer code, String country) {

        //this.printSet();
        if(this.collectionCountries.contains(country)) {

            System.out.println("existe");
            Integer codigo = this.findDialingCode(country);

            //eliminar del map y del set
            this.mapCodes.remove(codigo);
            this.collectionCountries.remove(country);

            this.addNewDialingCode(code, country);
        }else{
            System.out.println("no se ha registrado");
        }
    }
}


