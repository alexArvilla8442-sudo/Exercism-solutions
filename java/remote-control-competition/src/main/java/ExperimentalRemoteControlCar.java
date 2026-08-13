public class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int distanceTravelled;
    private int numberOfVictories;

    public ExperimentalRemoteControlCar() {
        this.distanceTravelled = 0;
        this.numberOfVictories = 0;
    }

    @Override
    public void drive() {
        this.distanceTravelled += 20;
    }
    @Override
    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }
}
/*public void drive() {
        throw new UnsupportedOperationException("Please implement the ExperimentalRemoteControlCar.drive() method");
    }

    public int getDistanceTravelled() {
        throw new UnsupportedOperationException("Please implement the ExperimentalRemoteControlCar.getDistanceTravelled() method");
    }*/
