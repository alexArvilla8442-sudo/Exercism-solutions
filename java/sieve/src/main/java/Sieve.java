import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class Principal{
    public static void main(String[] args) {
        System.out.println(new Sieve(1).getPrimes());
        System.out.println(new Sieve(2).getPrimes());
        System.out.println(new Sieve(10).getPrimes());
        System.out.println(new Sieve(13).getPrimes());
        System.out.println(new Sieve(1000).getPrimes());

    }
}

class Sieve {
    private int maxPrime;
    private Set<ClasificacionNumeros> setNumeros = new TreeSet<>();

    Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    public List<Integer> getPrimes() {
        int numeroMaximo = this.getMaxPrime();
        boolean isGreaterOne = numeroMaximo > 1;
        if (!isGreaterOne) {
            return new LinkedList<>();
        }

        List<Integer> numerosPrimos = this.getListaNumerosPrimos();

        return numerosPrimos;
    }

    private List<Integer> getListaNumerosPrimos(){
        this.LlenarSetNumerosPrimosYNoPrimos();

        List<Integer> listaNumerosPrimos = setNumeros.stream()
                .filter(evaluacion -> evaluacion.getTipoNumero())
                .map(evaluacion -> evaluacion.getNumero())
                .collect(Collectors.toList());
        return listaNumerosPrimos;
    }

    private void LlenarSetNumerosPrimosYNoPrimos(){
        List<Integer> listaNumeros = this.getListaNumeros(this.getMaxPrime());
        int tamanioLista = listaNumeros.size();

        for (int i = 0; i < tamanioLista; i++) {
            int numero =  listaNumeros.get(i);
            ClasificacionNumeros numeroBuscar = new ClasificacionNumeros(numero);
            boolean existeSet = setNumeros.contains(numeroBuscar);
            if (!existeSet) {
                this.updateSet(numero);
            }
        }
    }

    private List<Integer> getListaNumeros(int numeroMaximo) {
        int inicio = 2;
        List<Integer> listaNumeros = IntStream.rangeClosed(inicio, numeroMaximo)
                .boxed()
                .collect(Collectors.toList());
        return listaNumeros;
    }

    private void updateSet(int numero){
        int numeroMaximo = this.getMaxPrime();
        int multiplo = numero;

        for (int i = numero; i <= numeroMaximo; i++) {
            int actualNumber = i;
            boolean esMultiplo = actualNumber % multiplo == 0;
            if (esMultiplo) {
                setNumeros.add(new ClasificacionNumeros(actualNumber));
            }
        }
    }

    private int getMaxPrime(){
        return maxPrime;
    }

    public Set<ClasificacionNumeros> getSetNumeros() {
        return setNumeros;
    }
}


//****************************     clase para  clasificar los numeros       **************************************************

class ClasificacionNumeros implements Comparable<ClasificacionNumeros>{
    private boolean esPrimo;
    private int numero;

    ClasificacionNumeros(int numero){
        this.esPrimo = this.EsPrimo(numero);
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Numero: " + this.numero + ", es Primo? " + this.esPrimo;
    }

    private boolean EsPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean getTipoNumero(){
        return this.esPrimo;
    }

    public int getNumero() {
        return this.numero;
    }

    @Override
    public boolean equals(final Object objetoDesconocido) {
        // 1. ¿Es literalmente el mismo pedazo de papel? (Misma memoria)
        if (this == objetoDesconocido) {
            return true;
        }

        // 2. ¿Es un fantasma (null) o es un boleto de otro evento (otra clase)?
        if (objetoDesconocido == null || this.getClass() != objetoDesconocido.getClass()) {
            return false; // Si me comparas con una manzana, no somos iguales.
        }

        //Lo convertimos (cast) con seguridad.
        final ClasificacionNumeros tipoNumero = (ClasificacionNumeros) objetoDesconocido;

        // 4. La prueba de fuego: ¿Apuntamos al mismo asiento?
        return this.numero == tipoNumero.numero;
    }

    /*
     * fórmula matemática que toma la fila y la columna y las aplasta para generar un único número entero (un código postal).
     *  El HashSet usa este número para saber en qué "cajón" de memoria guardar y buscar tu coordenada a una velocidad absurda.
     * */
    @Override
    public int hashCode() {
        // 1. Empezamos la fórmula con el primer número
        int getNumero = this.numero;

        int valorBooleano = Boolean.hashCode(this.esPrimo);

        // 3. Aplicamos la misma magia del 31 que ya conoces
        getNumero = 31 * getNumero + valorBooleano;
        return getNumero;
    }

    @Override
    public int compareTo(ClasificacionNumeros otroNumero) {
        // 1. Primero, comparamos en qué fila estamos.
        // Esto devuelve:
        // - Un número negativo si mi fila va ANTES.
        // - Un número positivo si mi fila va DESPUÉS.
        // - Un CERO (0) si estamos empatados en la misma fila.
        int organizandoSet = Integer.compare(this.numero, otroNumero.numero);
        return organizandoSet;
    }




}
