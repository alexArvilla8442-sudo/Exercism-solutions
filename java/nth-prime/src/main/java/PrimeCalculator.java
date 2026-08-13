class Principal{
    public static void main(String[] args) {
        //2, 3, 5, 7, 11, 13, 17, 19, 23, 29
        PrimeCalculator primeCalculator = new PrimeCalculator();
        System.out.println(primeCalculator.nth(1));
        System.out.println(primeCalculator.nth(2));
        System.out.println(primeCalculator.nth(6));
        System.out.println(primeCalculator.nth(10001));
        System.out.println(primeCalculator.nth(0));
    }
}


class PrimeCalculator {
    int nth(int nth) {
        int cantidadNumerosPrimos = nth;
        int contador = 0;
        boolean numberFound = false;
        int numeroPrimo = 0;
        if(cantidadNumerosPrimos < 1){
            throw new IllegalArgumentException("there is no zeroth prime");
        }

        int i = 2;
        do{
            boolean esPrimo = this.EsPrimo(i);
            if(esPrimo){
                contador++;

                if(contador == cantidadNumerosPrimos){
                    numeroPrimo = i;
                    numberFound = true;

                }
            }
            i++;

        }while(!numberFound);

        return numeroPrimo;
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

}
