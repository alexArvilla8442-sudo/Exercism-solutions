class MatrixCoordinate implements Comparable<MatrixCoordinate> {
    private final int row;
    private final int col;

    MatrixCoordinate(final int row, final int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Row: " + row + ", Column: " + col;
    }

    // Generated equals and hashcode.

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

        // 3. Ya comprobamos que es una Coordenada. Lo convertimos (cast) con seguridad.
        final MatrixCoordinate otraCoordenada = (MatrixCoordinate) objetoDesconocido;

        // 4. La prueba de fuego: ¿Apuntamos al mismo asiento?
        return this.row == otraCoordenada.row && this.col == otraCoordenada.col;
    }

    /*
    * fórmula matemática que toma la fila y la columna y las aplasta para generar un único número entero (un código postal).
    *  El HashSet usa este número para saber en qué "cajón" de memoria guardar y buscar tu coordenada a una velocidad absurda.
    * */
    @Override
    public int hashCode() {
        int resultado = this.row;
        // Multiplicamos por 31 y sumamos la columna, porque 31? Es pura magia matemática para que el cartero no se confunda.
        resultado = 31 * resultado + this.col;
        return resultado;
    }

    @Override
    public int compareTo(MatrixCoordinate otraCoordenada) {
        // 1. Primero, comparamos en qué fila estamos.
        // Esto devuelve:
        // - Un número negativo si mi fila va ANTES.
        // - Un número positivo si mi fila va DESPUÉS.
        // - Un CERO (0) si estamos empatados en la misma fila.
        int comparacionDeFilas = Integer.compare(this.row, otraCoordenada.row);

        // 2. Aquí usamos el operador ternario (? :) para desempatar:
        // ¿Hubo empate en la fila? (comparacionDeFilas == 0)
        if (comparacionDeFilas == 0) {
            // SÍ hubo empate: Desempatamos comparando las columnas.
            return Integer.compare(this.col, otraCoordenada.col);
        } else {
            // NO hubo empate: El resultado de la fila es definitivo.
            return comparacionDeFilas;
        }
    }
/*
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final MatrixCoordinate that = (MatrixCoordinate) o;

        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public int compareTo(MatrixCoordinate o) {
        int rowComparison = Integer.compare(row, o.row);
        return (rowComparison == 0) ? Integer.compare(col, o.col) : rowComparison;
    }*/
}
