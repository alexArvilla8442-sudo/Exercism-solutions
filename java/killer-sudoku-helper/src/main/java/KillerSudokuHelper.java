import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Principal{
    public static void main(String[] args) {
        var helper = new KillerSudokuHelper();
        for (int n = 1; n <= 9; n++) {
            List<List<Integer>> expected = List.of(List.of(n));
            System.out.println(helper.combinationsInCage(n, 1));
        }

        System.out.println(helper.combinationsInCage(45, 9));
        System.out.println(helper.combinationsInCage(7, 3));
        System.out.println(helper.combinationsInCage(10, 2));
        System.out.println(helper.combinationsInCage(10, 2, List.of(1, 4)));

    }
}

public class KillerSudokuHelper {

    private Map<Integer, List<List<Integer>>> mapConvinacionesPosibles = new LinkedHashMap<>(
            Map.of(
                    9, List.of(List.of(1,2,3,4,5,6,7,8,9)),
                    3, List.of(List.of(1,2,4)),
                    2, List.of(List.of(1,9), List.of(2,8), List.of(3,7), List.of(4,6))
            )
    );

    public List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        int tamanioLista = cageSize;
        int sumaDigitos = cageSum;

        List<List<Integer>> lista = this.CrearListaDigitos(sumaDigitos, tamanioLista, exclude);

        return lista;
    }

    public List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        int tamanioLista = cageSize;
        int sumaDigitos = cageSum;

        if(tamanioLista == 1){
            List<List<Integer>> lista = List.of(List.of(sumaDigitos));
            return lista;
        }

        List<List<Integer>> lista = this.CrearListaDigitos(sumaDigitos, tamanioLista);

        return lista;


    }

    public List<List<Integer>> CrearListaDigitos (int sumaDigitos, int tamanioLista){
        List<List<Integer>> lista = new ArrayList<>();
        int keyMap=0;

        //System.out.println(mapConvinacionesPosibles);

        for (Map.Entry<Integer, List<List<Integer>>> entry : mapConvinacionesPosibles.entrySet()) {
            Integer key = entry.getKey();
            List<List<Integer>> list = entry.getValue();
            boolean foundit = false;

            externo:
            for (List<Integer> sublista : list) {
                int sumaTotal = 0;
                for (Integer elemento : sublista) {
                    sumaTotal += elemento;
                }
                if (sumaTotal == sumaDigitos) {
                    foundit = true;
                    keyMap = key;
                    break externo;
                }
            }
            if (foundit) {
                break;
            }
        }

        lista = mapConvinacionesPosibles.get(keyMap);
        return lista;
    }

    public List<List<Integer>> CrearListaDigitos (int sumaDigitos, int tamanioLista, List<Integer> exclude){
        List<List<Integer>> lista = this.CrearListaDigitos(sumaDigitos, tamanioLista);
        Set<Integer> setDigitosExcluir = new HashSet<>(exclude);


        List<List<Integer>> listaExclusion = new ArrayList<>();
        externo:
        for (List<Integer> sublista : lista) {
            boolean foundit = false;
            for (Integer elemento : sublista) {
                if(setDigitosExcluir.contains(elemento)){
                    foundit = true;
                    break;
                }
            }
            if (!foundit) {
                listaExclusion.add(sublista);
            }
        }

        return listaExclusion;
    }

}
