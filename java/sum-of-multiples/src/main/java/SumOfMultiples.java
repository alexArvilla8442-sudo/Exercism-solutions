import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Principal{
    public static void main(String[] args) {

        int[] set = {
                3,
                5
        };
        int[] set2 = {
                3
        };
        int[] set3 = {
                7,
                13,
                17
        };
        int[] set4 = {
                4,
                6
        };
        int[] set5 = {
                5,
                6,
                8
        };
        int[] set6 = {
                5,
                25
        };
        int[] set7 = {
                43,
                47
        };
        int[] set8 = {
                1
        };
        System.out.println(new SumOfMultiples(1, set).getSum());
        System.out.println(new SumOfMultiples(4, set).getSum());
        System.out.println(new SumOfMultiples(7, set2).getSum());
        System.out.println(new SumOfMultiples(10, set).getSum());
        System.out.println(new SumOfMultiples(100, set).getSum());
        System.out.println(new SumOfMultiples(1000, set).getSum());
        System.out.println(new SumOfMultiples(20, set3).getSum());
        System.out.println(new SumOfMultiples(15, set4).getSum());
        System.out.println(new SumOfMultiples(150, set5).getSum());
        System.out.println(new SumOfMultiples(51, set6).getSum());
        System.out.println(new SumOfMultiples(10000, set7).getSum());
        System.out.println(new SumOfMultiples(100, set8).getSum());
        System.out.println(new SumOfMultiples(10000, new int[] {}).getSum());
        System.out.println(new SumOfMultiples(1, new int[] {0}).getSum());
        System.out.println(new SumOfMultiples(4, new int[] {
                3,
                0
        }).getSum());
        System.out.println(new SumOfMultiples(10000, new int[] {
                2,
                3,
                5,
                7,
                11
        }).getSum());
    }
}


class SumOfMultiples {

    private int playerLevel;
    private int[] itemsPlayerFound;
    SumOfMultiples(int number, int[] set) {
        this.playerLevel = number;
        this.itemsPlayerFound = set;
    }

    int getSum() {
        int[] itemsEncontrados = itemsPlayerFound;
        int cantidadItems = itemsEncontrados.length;

        Set<Set<Integer>> multiplosItemsEncontrados = new LinkedHashSet<>();

        for (int i = 0; i < cantidadItems; i++) {
            int nivelItem = itemsEncontrados[i];
            if(nivelItem == 0){
                continue;
            }
            Set<Integer> multiplosItem = this.getMultiplos(nivelItem);
            multiplosItemsEncontrados.add(multiplosItem);
        }

        Set<Integer> multiplosItemsUnicos = this.getUniqueMultiples(multiplosItemsEncontrados);

        return this.getSumaMultiplos(multiplosItemsUnicos);
    }

    private Set<Integer> getMultiplos(int item){
        int nivelJugador = playerLevel;
        //Set<Integer> multiplos = new LinkedHashSet<>();
        int multiplo = item;
        int inicio = item;

        Set<Integer> multiplos = IntStream.range(inicio, nivelJugador)
                .filter(numeroComprobar -> numeroComprobar % multiplo == 0)
                .boxed()
                .collect(Collectors.toSet());

        return multiplos;
    }

    private Set<Integer> getUniqueMultiples(Set<Set<Integer>> multiplosItemsSet){
        List<List<Integer>> multiplosItems = multiplosItemsSet.stream().map(List::copyOf).collect(Collectors.toList());
        int cantidadItems = multiplosItems.size();
        if(cantidadItems == 1){
            return multiplosItemsSet.stream().findFirst().get();
        }

        Set<Integer> setMultiplosUnicos = new HashSet<>();
        for (int i = 0; i < cantidadItems-1; i++) {

            List<Integer> primerElemento =  multiplosItems.get(i);
            List<Integer> segundoElemento =  multiplosItems.get(i+1);

            Set<Integer> union = new LinkedHashSet<>(primerElemento);
            union.addAll(segundoElemento);

            setMultiplosUnicos.addAll(union);
        }

        return setMultiplosUnicos;
    }

    private int getSumaMultiplos(Set<Integer> multiplosUnicos){
        int total = multiplosUnicos.stream().mapToInt(Integer::intValue).sum();
        return total;
    }

}
