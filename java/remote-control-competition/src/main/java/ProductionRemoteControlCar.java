class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int distanceTravelled;
    private int numberOfVictories;

    public ProductionRemoteControlCar() {
        this.distanceTravelled = 0;
        this.numberOfVictories = 0;
    }

    public ProductionRemoteControlCar setVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
        return this;
    }

    @Override
    public void drive() {
        this.distanceTravelled += 10;
    }

    @Override
    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar otherCar) {
        //de mayor a menor
        int resultadoVictoriasDescendente = Integer.compare(
                otherCar.getNumberOfVictories(),
                this.getNumberOfVictories()
        );

        return resultadoVictoriasDescendente;
    }

    public int getNumberOfVictories() {
        return this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }
}

/*public void drive() {
        throw new UnsupportedOperationException("Please implement the ProductionRemoteControlCar.drive() method");
    }

    public int getDistanceTravelled() {
        throw new UnsupportedOperationException("Please implement the ProductionRemoteControlCar.getDistanceTravelled() method");
    }
    */
