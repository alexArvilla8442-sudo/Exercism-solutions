import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Principal{
    public static void main(String[] args) {
        var numeroGranos  = new Grains();
        /*System.out.println(numeroGranos.grainsOnSquare(1));
        System.out.println(numeroGranos.grainsOnSquare(2));
        System.out.println(numeroGranos.grainsOnSquare(3));
        System.out.println(numeroGranos.grainsOnSquare(4));
        System.out.println(numeroGranos.grainsOnSquare(16));
        System.out.println(numeroGranos.grainsOnSquare(32));
        System.out.println(numeroGranos.grainsOnSquare(64));*/

        //System.out.println(numeroGranos.grainsOnSquare(0));
        //System.out.println(numeroGranos.grainsOnSquare(-1));
        //System.out.println(numeroGranos.grainsOnSquare(65));

        System.out.println(numeroGranos.grainsOnBoard());
    }
}


class Grains {

    BigInteger grainsOnSquare(final int square) {

        BigInteger numberGrains = BigInteger.ZERO;

        boolean estaRango = square <= 64 && square >= 1;
        if(!estaRango) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        int potenciaAelevarlo = square - 1;
        return BigInteger.ONE.shiftLeft(potenciaAelevarlo);
    }
    BigInteger grainsOnBoard() {

        BigInteger acumulador = BigInteger.ZERO;
        for (int i = 1; i <= 64; i++) {
            // Es el equivalente exacto a: acumulador = acumulador + otroBigInt;
            acumulador = acumulador.add(grainsOnSquare(i));
        }
        return acumulador;
    }

}
