import java.util.*;

class Principal{
    public static void main(String[] args) {
        //var number = new NaturalNumber(33550336);

        //System.out.println(number.getFactores());

        System.out.println(new NaturalNumber(6).getClassification());
        System.out.println(new NaturalNumber(28).getClassification());
        System.out.println(new NaturalNumber(33550336).getClassification());
        System.out.println(new NaturalNumber(12).getClassification());
        System.out.println(new NaturalNumber(30).getClassification());
        System.out.println(new NaturalNumber(33550335).getClassification());
        System.out.println(new NaturalNumber(196).getClassification());
        System.out.println(new NaturalNumber(2).getClassification());
        System.out.println(new NaturalNumber(4).getClassification());
        System.out.println(new NaturalNumber(32).getClassification());
        System.out.println(new NaturalNumber(33550337).getClassification());
        System.out.println(new NaturalNumber(1).getClassification());
        System.out.println(new NaturalNumber(0));
        System.out.println(new NaturalNumber(-1));

    }
}


class NaturalNumber {

    private int number;

    NaturalNumber(int number) {
        this.number = number;

        boolean isHigherOfEqualTo1 = this.number >= 1;

        if(!isHigherOfEqualTo1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }

    }

    Classification getClassification() {

        Classification classification;

        int numeroComparar = this.number;

        //aqui es la revision si el numero es 1, 2 o 3 y que sea mayor a 3
        if(numeroComparar == 1 || numeroComparar == 2 || numeroComparar == 3) {
            classification = Classification.DEFICIENT;
            return classification;
        }

        //si es mayor o igual a 4 en adelante
        int sumaFactores = this.getSumaFactores();

        System.out.println("Suma factores: " + sumaFactores);

        if(sumaFactores == numeroComparar) {
            classification = Classification.PERFECT;
        }else if(sumaFactores > numeroComparar) {
            classification = Classification.ABUNDANT;
        }else{
            classification = Classification.DEFICIENT;
        }

        return classification;
    }

    public int getSumaFactores(){
        List<Integer> factores = this.getFactores();
        int total = 0;

        for(int i = 0; i < factores.size(); i++){
            total += factores.get(i);
        }
        return total;
    }

    public List<Integer> getFactores() {
        int numeroDescomponer = this.number;

        //obtener divisores los primos y los que no son num primos
        List<Integer> todosDivisoresNumero = this.getDivisoresNumero();
        //System.out.println(todosDivisoresNumero);

        //obtener los factoresPrimos
        List<Integer> divisoresPrimos = this.getDivisoresPrimos(todosDivisoresNumero);
        //System.out.println(divisoresPrimos);

        //factores primos
        Map<Integer, Integer> mapaFactoresPrimos = this.getFactoresPrimos(divisoresPrimos);
        //System.out.println(mapaFactoresPrimos);

        //potencias de los factores Primos
        Map<Integer, List<Integer>> factoresElevadosA = this.getPotenciasFactores(mapaFactoresPrimos);
        //System.out.println(factoresElevadosA);

        //multiplicacion todos vs todos
        List<Integer> lista = this.getTodosFactores(factoresElevadosA);
        //System.out.println(lista);

        if(lista.contains(numeroDescomponer)) {
            int indice = lista.indexOf(numeroDescomponer);
            lista.remove(indice);
        }

        return lista;
    }

    public List<Integer> getDivisoresNumero(){

        int numeroDescomponer = this.number;

        Set<Integer> divisores = new HashSet<>();
        int dividendo = 1;
        while(true) {
            if(numeroDescomponer % dividendo == 0) {
                divisores.add(dividendo);
                int division = numeroDescomponer / dividendo;

                if(divisores.contains(division)) {
                    break;
                }
            }
            dividendo += 1;
        }
        return divisores.stream().toList();
    }

    public List<Integer> getDivisoresPrimos(List<Integer> divisores){
        List<Integer> divisoresPrimos = new ArrayList<>();

        for(int i = 0; i < divisores.size(); i++){
            int divisor = divisores.get(i);
            boolean esPrimo = this.esNumeroPrimo(divisor);

            if(esPrimo) {
                divisoresPrimos.add(divisor);
            }
        }

        return divisoresPrimos;

    }

    public boolean esNumeroPrimo(int numero){
        if(numero <= 1) return false;
        if(numero <= 3) return true;
        if (numero % 2 == 0 || numero % 3 == 0) return false;

        int i = 5;
        while((i * i) <= numero){
            if(numero % i == 0  || numero % (i + 2) == 0){
                return false;
            }
            i += 6;
        }
        return true;
    }

    public Map<Integer, Integer> getFactoresPrimos(List<Integer> divisoresPrimos){
        int numeroDescomponer2 = this.number;
        //  factorPrimo, cantidadVecesRepite
        Map<Integer, Integer> mapaFactoresPrimos = new HashMap<>();
        int i = 0;
        while(numeroDescomponer2 != 1) {
            int factorPrimo = divisoresPrimos.get(i);

            if(numeroDescomponer2 % factorPrimo == 0){
                numeroDescomponer2 /= factorPrimo;

                //agregandolo al map
                if(!mapaFactoresPrimos.containsKey(factorPrimo)) {
                    mapaFactoresPrimos.put(factorPrimo, 1);
                }else{
                    mapaFactoresPrimos.compute(factorPrimo, (k, getValue) -> getValue + 1);
                }

            }else{
                i++;
            }
        }
        return mapaFactoresPrimos;
    }

    public Map<Integer, List<Integer>> getPotenciasFactores(Map<Integer, Integer> mapaFactoresPrimos){
        Map<Integer, List<Integer>> factoresElevadosA = new HashMap<>();
        mapaFactoresPrimos.forEach((key, value) -> {
            //System.out.println("Key: " + key + ", Value: " + value);
            int factorPrimo = key;
            int numeroVecesRepite = value;

            for(int j = 0; j <= numeroVecesRepite; j++) {
                int potencia = j;
                int factorElevadoA = (int) Math.pow(factorPrimo, potencia);
                factoresElevadosA.computeIfAbsent(factorPrimo, k -> new ArrayList<>()).add(factorElevadoA);
            }
        });
        return factoresElevadosA;
    }



    public List<Integer> getTodosFactores(Map<Integer, List<Integer>> mapa){
        // 1. Iniciamos nuestra lista acumuladora con el valor neutro (1)
        List<Integer> acumulado = new ArrayList<>();
        acumulado.add(1);

        // 2. Iteramos solo sobre los valores del mapa (las listas de potencias)
        for (List<Integer> listaPotencias : mapa.values()) {
            List<Integer> temporal = new ArrayList<>();

            // 3. Multiplicamos lo que llevamos acumulado por la nueva lista
            for (Integer factorAcumulado : acumulado) {
                for (Integer potencia : listaPotencias) {
                    temporal.add(factorAcumulado * potencia);
                }
            }

            // 4. Actualizamos nuestro acumulado para la siguiente iteración
            acumulado = temporal;
        }

        // Opcional: Ordenar la lista final de menor a mayor para mejor presentación
        Collections.sort(acumulado);
        return acumulado;
    }

}
