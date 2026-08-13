import java.util.*;

class Principal{
    public static void main(String[] args) {
        System.out.println(new Matrix(Arrays.asList(
                Arrays.asList(9, 8, 7),
                Arrays.asList(5, 3, 2),
                Arrays.asList(6, 6, 7)
        )).getSaddlePoints());

        System.out.println(new Matrix(new ArrayList<>()).getSaddlePoints());

        System.out.println( new Matrix(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 1, 2),
                Arrays.asList(2, 3, 1)
        )).getSaddlePoints());

        System.out.println(new Matrix(Arrays.asList(
                Arrays.asList(4, 5, 4),
                Arrays.asList(3, 5, 5),
                Arrays.asList(1, 5, 4)
        )).getSaddlePoints());

        System.out.println(new Matrix(Arrays.asList(
                Arrays.asList(6, 7, 8),
                Arrays.asList(5, 5, 5),
                Arrays.asList(7, 5, 6)
        )).getSaddlePoints());

        System.out.println(new Matrix(Arrays.asList(
                Arrays.asList(8, 7, 9),
                Arrays.asList(6, 7, 6),
                Arrays.asList(3, 2, 5)
        )).getSaddlePoints());

        System.out.println(new Matrix(Arrays.asList(
                Arrays.asList(3, 1, 3),
                Arrays.asList(3, 2, 4)
        )).getSaddlePoints());

        System.out.println(new Matrix(Arrays.asList(
                Collections.singletonList(2),
                Collections.singletonList(1),
                Collections.singletonList(4),
                Collections.singletonList(1)
        )).getSaddlePoints());

        System.out.println(new Matrix(Arrays.asList(
                Arrays.asList(2, 5, 3, 5)
        )).getSaddlePoints());

    }
}

class Matrix {

    private List<List<Integer>> lista = new LinkedList<>();
    private int numRows;
    private int numColums;

    private List<List<Integer>> listaInversa = new LinkedList<>();
    private int numRowsMatrizInv;
    private int numColsMatrizInv;

    Matrix(List<List<Integer>> values) {
        boolean listaVacia = values == null || values.isEmpty();

        if (!listaVacia) {
            this.lista = values;
            this.numRows = this.NumeroFilas(lista);
            this.numColums = this.NumeroColumnas(lista);

            this.listaInversa = this.getListForInverseMatriz();
            this.numRowsMatrizInv = this.NumeroFilas(listaInversa);
            this.numColsMatrizInv = this.NumeroColumnas(listaInversa);
        }else{
            this.lista = values;
            this.listaInversa = lista;
        }
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new LinkedHashSet<>();
        boolean listaVacia = lista == null || lista.isEmpty();
        if (listaVacia) {
            System.out.println("Lista vacia, no hubo elementos a comparar");
            return saddlePoints;
        }

        int[][] matriz = this.getMatriz();
        List<Integer> rowList = this.getRowsBiggestNumbers();
        List<Integer> columnList = this.getColumnsLowestNumbers();
        for (int fila = 0; fila < numRows; fila++) {
            int filaComparar = rowList.get(fila);

            for (int columna = 0; columna < numColums; columna++) {
                int columnaComparar = columnList.get(columna);
                int numero = matriz[fila][columna];

                boolean numberBiggestRow = numero == filaComparar;
                boolean numberLowestColumn = numero == columnaComparar;

                if(numberBiggestRow && numberLowestColumn){
                    int filaEncontro = fila + 1;
                    int columnaEncontro = columna + 1;
                    MatrixCoordinate coordenadasArbolIdeal = new MatrixCoordinate(filaEncontro, columnaEncontro);
                    saddlePoints.add(coordenadasArbolIdeal);
                }
            }
        }
        boolean noHuboCoincidencias = saddlePoints.isEmpty();
        if(noHuboCoincidencias){
            System.out.println("No hubo coincidencias");
        }
        return saddlePoints;
    }

    //*********************************************************************************************************************************

    private List<List<Integer>> getListForInverseMatriz() {
        List<List<Integer>> listaMatrizOriginal  = new LinkedList<>(lista);
        int numFilas = this.NumeroFilas(listaMatrizOriginal);
        int numColumnas = this.NumeroColumnas(listaMatrizOriginal);

        int[][] matrizOriginal = this.getMatriz();
        List<List<Integer>> listaMatrizInversa = new  LinkedList<>();

        //crear una lista para las columnas
        for (int i = 0; i < numColumnas; i++) {
            List<Integer> filaList = new LinkedList<>();
            for (int j = 0; j < numFilas; j++) {
                int numero = matrizOriginal[j][i];
                filaList.add(numero);
            }
            listaMatrizInversa.add(filaList);
        }
        return listaMatrizInversa;
    }

    private List<Integer> getRowsBiggestNumbers(){
        int totalFilas = this.NumeroFilas(this.lista);
        int columnas = this.NumeroColumnas(this.lista);

        List<Integer> lista = new LinkedList<>();

        for (int fila = 1; fila <= totalFilas ; fila++) {
            int[] row = this.getRow(fila);
            Arrays.sort(row);

            int ultimaPosicionArray = columnas - 1;
            int biggestNumber = row[ultimaPosicionArray];
            lista.add(biggestNumber);
        }
        return lista;
    }

    private List<Integer> getColumnsLowestNumbers(){
        int totalFilas = this.NumeroFilas(this.listaInversa);
        List<Integer> lista = new LinkedList<>();

        for (int fila = 1; fila <= totalFilas ; fila++) {
            int[] column = this.getColumn(fila);
            Arrays.sort(column);

            int lowestNumber = column[0];
            lista.add(lowestNumber);
        }
        return lista;
    }

    private int[] getRow(int rowNumber) {
        int[][] matriz = this.getMatriz();
        return this.getFilaOrColumn(numRows, numColums, rowNumber, matriz);
    }

    private int[] getColumn(int columnNumber) {
        int[][] matriz = this.getMatrixInverse();
        return this.getFilaOrColumn(numRowsMatrizInv, numColsMatrizInv, columnNumber, matriz);
    }

    private int[] getFilaOrColumn(int numeroFilasMatriz, int numeroColumnasMatriz, int rowOrColumnNumber, int[][] matriz) {

        int posicion = rowOrColumnNumber - 1;

        boolean rowGreaterThanNumberRows = (rowOrColumnNumber > numeroFilasMatriz);
        if (rowGreaterThanNumberRows) {
            throw new IllegalArgumentException("la fila a buscar es mayor al tamaño de la matriz");
        }
        int[] rowOrColumn = new int[numeroColumnasMatriz];

        for (int i = 0; i < numeroColumnasMatriz; i++) {
            rowOrColumn[i] = matriz[posicion][i];
        }
        return rowOrColumn;
    }

    //Imprimir  Matriz
    private int[][] CreateMatrix(int numeroFilas, int numeroColumnas, List<List<Integer>> tipoLista) {
        int[][] arreglo = new int[numeroFilas][numeroColumnas];

        for (int i = 0; i < numeroFilas; i++) {
            List<Integer> filaList = tipoLista.get(i);
            for (int j = 0; j < numeroColumnas; j++) {
                int numero = filaList.get(j);
                arreglo[i][j] = numero;
            }
        }
        return arreglo;
    }

    private int[][] getMatriz(){
        return this.CreateMatrix(numRows, numColums, lista);
    }

    private int[][] getMatrixInverse(){
        return this.CreateMatrix(numRowsMatrizInv, numColsMatrizInv, listaInversa);
    }

    public void ImprimirMatriz() {
        boolean listaVacia = lista.isEmpty();
        if (!listaVacia) {
            int[][] matriz = this.getMatriz();
            this.printMatrix(numRows,numColums, matriz);
        }else{
            System.out.println("No se ha enviado ningun valor para crear la matriz");
        }

    }

    public void ImprimirMatrizInversa() {
        boolean listaVacia = listaInversa.isEmpty();
        if (!listaVacia) {
            int[][] matriz = this.getMatrixInverse();
            this.printMatrix(numRowsMatrizInv,numColsMatrizInv, matriz);
        }else{
            System.out.println("No se ha enviado ningun valor para crear la matriz");
        }

    }

    private void printMatrix(int numeroFilasMatriz, int numeroColumnasMatriz, int[][] arreglo){

        for (int i = 0; i < numeroFilasMatriz; i++) {
            for (int j = 0; j < numeroColumnasMatriz; j++) {
                System.out.print("[" + arreglo[i][j] + "]");
            }
            System.out.println();
        }
    }

    private int NumeroColumnas(List<List<Integer>> lista) {
        return lista.get(0).size();
    }

    private  int NumeroFilas(List<List<Integer>> lista) {
        return lista.size();
    }

    private void getGoodTreesHouse(){
        int[][] matriz = this.getMatriz();
        List<Integer> rowList = this.getRowsBiggestNumbers();
        List<Integer> columnList = this.getColumnsLowestNumbers();
        int numeroCoincidencias = 0;
        for (int fila = 0; fila < numRows; fila++) {
            int filaComparar = rowList.get(fila);

            for (int columna = 0; columna < numColums; columna++) {
                int columnaComparar = columnList.get(columna);
                int numero = matriz[fila][columna];

                boolean numberBiggestRow = numero == filaComparar;
                boolean numberLowestColumn = numero == columnaComparar;

                if(numberBiggestRow && numberLowestColumn){
                    numeroCoincidencias++;
                    int filaEncontro = fila + 1;
                    int columnaEncontro = columna + 1;
                    System.out.println(String.format("Bingo se encontro una coincidencia, el numero es %d, fila = %d, columna = %d", numero, filaEncontro, columnaEncontro));
                }
            }
        }
        boolean noHuboCoincidencias = numeroCoincidencias == 0;
        if(noHuboCoincidencias){
            System.out.println("No se encontro ningun arbol.");
        }

    }



}
