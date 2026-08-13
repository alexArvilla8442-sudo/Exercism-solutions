class Principal{
    public static void main(String[] args) {
        var juegoDardos = new Darts();
        System.out.println(juegoDardos.score(-9, 9));
        System.out.println(juegoDardos.score(0, 10));
        System.out.println(juegoDardos.score(-5, 0));
        System.out.println(juegoDardos.score(0, -1));
        System.out.println(juegoDardos.score(0, 0));
        System.out.println(juegoDardos.score(-0.1, -0.1));
        System.out.println(juegoDardos.score(0.7, 0.7));
        System.out.println(juegoDardos.score(0.8, -0.8));
        System.out.println(juegoDardos.score(-3.5, 3.5));
        System.out.println(juegoDardos.score(-3.6, -3.6));
        System.out.println(juegoDardos.score(-7.0, 7.0));
        System.out.println(juegoDardos.score(7.1, -7.1));
        System.out.println(juegoDardos.score(0.5, -4));
    }

}

class Darts {
    int score(double xOfDart, double yOfDart) {

        int limiteRadio = 10;
        int puntosJuego = 0;

        double primerPotencia = getPotencia(xOfDart);
        double segundaPotencia = getPotencia(yOfDart);

        /*System.out.println(primerPotencia);
        System.out.println(segundaPotencia);*/

        double raizCuadrada = Math.sqrt(primerPotencia + segundaPotencia);

        //System.out.println("raiz> " +  raizCuadrada);
        //int raiz = Math.round(raizCuadrada);

        //System.out.println("prueba: " + raizCuadrada);

        if(raizCuadrada > limiteRadio){
            return 0;
        }

        if(raizCuadrada <= 1){
            puntosJuego = 10;
        }else if(raizCuadrada <= 5 && raizCuadrada >= 1.01){
            puntosJuego = 5;
        }else if(raizCuadrada <= 10 && raizCuadrada >= 5.01){
            puntosJuego = 1;
        }

        return puntosJuego;
    }

    private double getPotencia(double xOrYDart) {
        double diferencia = xOrYDart - 0;
        return Math.pow(diferencia, 2);
    }
}
