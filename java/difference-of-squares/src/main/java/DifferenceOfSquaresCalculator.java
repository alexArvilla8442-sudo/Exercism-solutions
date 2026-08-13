class Principal{
    public static void main(String[] args) {
        var calculator = new DifferenceOfSquaresCalculator();
        System.out.println(calculator.computeSquareOfSumTo(1));
        System.out.println(calculator.computeSquareOfSumTo(5));
        System.out.println(calculator.computeSquareOfSumTo(100));

        System.out.println(calculator.computeSumOfSquaresTo(1));
        System.out.println(calculator.computeSumOfSquaresTo(5));
        System.out.println(calculator.computeSumOfSquaresTo(100));

        System.out.println(calculator.computeDifferenceOfSquares(1));
        System.out.println(calculator.computeDifferenceOfSquares(5));
        System.out.println(calculator.computeDifferenceOfSquares(100));
    }
}


class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int N = input;
        int Nplus1 = (N + 1);
        int resultadoPart1 = (N * Nplus1) / 2;

        return (int) Math.pow(resultadoPart1, 2);

    }

    int computeSumOfSquaresTo(int input) {

        int N = input;
        int Nplus1 = (N + 1);
        int twoMultiplyNplusOne = (2 * N + 1);

        int resultado = (N * Nplus1 * twoMultiplyNplusOne) / 6;
        return resultado;
    }

    int computeDifferenceOfSquares(int input) {

        int squareOfSumTo = this.computeSquareOfSumTo(input);
        int sumOfSquaresTo = this.computeSumOfSquaresTo(input);

        int diferencia = squareOfSumTo - sumOfSquaresTo;
        return diferencia;
    }

}
