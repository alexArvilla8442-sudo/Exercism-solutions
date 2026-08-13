import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Principal{
    public static void main(String[] args) {
        //System.out.println("Fila: " + Arrays.toString(new Matrix("89 1903 3\n18 3 1\n9 4 800").getRow(2)));
        //System.out.println("Columna: " + Arrays.toString(new Matrix("89 1903 3\n18 3 1\n9 4 800").getColumn(4)));
        System.out.println(Arrays.toString(new Matrix("1").getRow(1)));
        System.out.println(Arrays.toString(new Matrix("1 2\n3 4").getRow(2)));
        System.out.println(Arrays.toString(new Matrix("1 2\n10 20").getRow(2)));
        System.out.println(Arrays.toString(new Matrix("1 2 3\n4 5 6\n7 8 9\n8 7 6").getRow(4)));

        System.out.println(Arrays.toString(new Matrix("1").getColumn(1)));
        System.out.println(Arrays.toString(new Matrix("1 2 3\n4 5 6\n7 8 9").getColumn(3)));

        System.out.println(Arrays.toString(new Matrix("1 2 3 4\n5 6 7 8\n9 8 7 6").getColumn(4)));
        System.out.println(Arrays.toString(new Matrix("89 1903 3\n18 3 1\n9 4 800").getColumn(2)));



        //assertThat(matrix.getColumn(columnIndex)).isEqualTo(expectedColumn);
    }
}

class Matrix {
    private String matrixAsString;

    private List<List<Integer>> lista = new LinkedList<>();
    private int numRows;
    private int numColums;

    private List<List<Integer>> listaInversa = new LinkedList<>();
    private int numRowsMatrizInv;
    private int numColsMatrizInv;

    Matrix(String matrixAsString) {
        this.matrixAsString = matrixAsString;

        this.lista = this.getListMatriz();
        this.numRows = this.NumeroFilas(lista);
        this.numColums = this.NumeroColumnas(lista);

        this.listaInversa = this.getListForInverseMatriz();
        this.numRowsMatrizInv = this.NumeroFilas(listaInversa);
        this.numColsMatrizInv = this.NumeroColumnas(listaInversa);

    }

    private List<List<Integer>> getListMatriz() {
        List<List<Integer>> lista = new LinkedList<>();
        String cadenaTexto = this.getMatrixAsString();

        String nuevoNumero = "_";
        char nuevoNumeroCH = '_';

        String nuevaFila = "*";
        char nuevaFilaCH = '*';

        //al final se agrego el simbolo *, para la ultima fila de otro modo no se guardaria en la lista
        String nuevaCadena = cadenaTexto.replace(" ", nuevoNumero).replaceAll("\\s+", nuevaFila).trim() + nuevaFila;

        int tamanioCadena = this.TamanioString(nuevaCadena);

        List<Integer> fila = new LinkedList<>();
        StringBuilder formarNumero = new StringBuilder();
        for (int i = 0; i < tamanioCadena; i++) {

            char caracter = nuevaCadena.charAt(i);
            boolean isDigit = Character.isDigit(caracter);

            if (isDigit) {
                formarNumero.append(caracter);
            }else{
                String numeroStr =  formarNumero.toString();
                int numero = Integer.parseInt(numeroStr);
                fila.add(numero);

                formarNumero.setLength(0);

                if(caracter == nuevaFilaCH){
                    List<Integer> filaListCopia = new LinkedList<>(fila);
                    lista.add(filaListCopia);
                    fila.clear();
                }
            }
        }
        return lista;
    }

    private List<List<Integer>> getListForInverseMatriz() {
        List<List<Integer>> listaMatrizOriginal  = this.getListMatriz();
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

    public int[][] getMatriz(){
        return this.CreateMatrix(numRows, numColums, lista);
    }

    public int[][] getMatrixInverse(){
        return this.CreateMatrix(numRowsMatrizInv, numColsMatrizInv, listaInversa);
    }

    int[] getRow(int rowNumber) {
        int[][] matriz = this.getMatriz();
        return this.getFilaOrColumn(numRows, numColums, rowNumber, matriz);
    }

    int[] getColumn(int columnNumber) {
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

    public void ImprimirMatriz() {
        int[][] matriz = this.getMatriz();
        this.printMatrix(numRows,numColums, matriz);
    }

    public void ImprimirMatrizInversa() {
        int[][] matriz = this.getMatrixInverse();
        this.printMatrix(numRowsMatrizInv,numColsMatrizInv, matriz);
    }

    private void printMatrix(int numeroFilasMatriz, int numeroColumnasMatriz, int[][] arreglo){

        for (int i = 0; i < numeroFilasMatriz; i++) {
            for (int j = 0; j < numeroColumnasMatriz; j++) {
                System.out.print("[" + arreglo[i][j] + "]");
            }
            System.out.println();
        }
    }

    public String getMatrixAsString() {
        return matrixAsString;
    }

    public int TamanioString(String cadena){
        return cadena.length();
    }

    public int NumeroColumnas(List<List<Integer>> lista) {
        return lista.get(0).size();
    }

    public  int NumeroFilas(List<List<Integer>> lista) {
        return lista.size();
    }
}
