class principal{
    public static void main(String[] args) {
        var car1 = new NeedForSpeed(10,2);
        System.out.println(car1.distanceDriven());

        var car = new NeedForSpeed(5, 1);
        car.drive();
        System.out.println(car.distanceDriven());

        int speed = 9;
        int batteryDrain = 50;
        var car2 = new NeedForSpeed(speed, batteryDrain);

        car2.drive();
        car2.drive();
        car2.drive();
        System.out.println(car2.distanceDriven());

        int speed2 = 15;
        int batteryDrain2 = 3;
        var car3 = new NeedForSpeed(speed2, batteryDrain2);
        System.out.println(car3.batteryDrained());

        var car4 = new NeedForSpeed(1, 99);
        car4.drive();
        System.out.println(car4.getBatteryPercent());
        System.out.println(car4.batteryDrained());
        // Ensure that the car was driven once
        System.out.println(car4.distanceDriven());

        var car5 = new NeedForSpeed(2, 1);
        // Almost drain the battery
        for (var i = 0; i < 99; i++) {
            car5.drive();
        }
        System.out.println(car5.batteryDrained());

        var car6 = new NeedForSpeed(2, 1);
        // Almost drain the battery
        for (var i = 0; i < 100; i++) {
            car6.drive();
        }
        System.out.println(car6.batteryDrained());

        var car7 = NeedForSpeed.nitro();
        System.out.println(car7.distanceDriven());

        var car8 = NeedForSpeed.nitro();
        System.out.println(car8.batteryDrained());

        var car9 = NeedForSpeed.nitro();
        car9.drive();
        System.out.println(car9.distanceDriven());

        var car10 = NeedForSpeed.nitro();
        // The battery is almost drained
        for (var i = 0; i < 24; i++) {
            car10.drive();
        }
        System.out.println(car10.batteryDrained());

        var car11 = NeedForSpeed.nitro();
        // The battery is almost drained
        for (var i = 0; i < 25; i++) {
            car11.drive();
        }
        System.out.println(car11.batteryDrained());

        var car12 = new NeedForSpeed(10, 2);
        int distance = 100;
        var race = new RaceTrack(distance);
        System.out.println(race.canFinishRace(car12));

        var car13 = new NeedForSpeed(2, 10);
        int distance2 = 20;
        var race2 = new RaceTrack(distance2);
        System.out.println(race2.canFinishRace(car13));

        var car14 = new NeedForSpeed(3, 20);
        int distance3 = 16;
        var race3 = new RaceTrack(distance3);
        System.out.println(race3.canFinishRace(car14));

        var car15 = new NeedForSpeed(1, 20);
        int distance4 = 678;
        var race4 = new RaceTrack(distance4);
        System.out.println(race4.canFinishRace(car15));






    }
}


//Cars start with full (100%) batteries.

//each time you drive

//If a car's battery is below its battery drain percentage, you can't drive the car anymore.

//Each race track has its own distance. Cars are tested by checking if they can finish the track without running out of battery.

class NeedForSpeed {
    private int speed;
    private int batteryDrain;

    private int batteryPercent;
    private int distanceDriven;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.distanceDriven = 0;
        this.batteryPercent = 100;
    }

    public int getSpeed() {
        return speed;
    }

    public int getBatteryDrain() {
        return batteryDrain;
    }
    public int getBatteryPercent() {return batteryPercent;}

    //factory method
    public static NeedForSpeed nitro() {
        int speedMeters = 50;
        int batteryDrainPercent = 4;
        return new NeedForSpeed(speedMeters, batteryDrainPercent);
    }

    private boolean reviewBattery(){
        int updateBatteryPercent = batteryPercent - batteryDrain;
        return updateBatteryPercent >= 0;
    }

    public boolean batteryDrained() {
        boolean isBatteryDrained;
        if (distanceDriven == 0){
            isBatteryDrained = false;
        } else if (reviewBattery()) {
            isBatteryDrained = false;
        }else{
            isBatteryDrained = true;
        }
        return isBatteryDrained;
    }

    /*
    *  method that updates the number of meters driven based on the car's speed.
    * Also, implement the NeedForSpeed.distanceDriven() method to return the number of meters driven by the car:

        int speed = 5;
        int batteryDrain = 2;
        var car = new NeedForSpeed(speed, batteryDrain);
        car.drive();

        car.distanceDriven();
        // => 5
    * */

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {

        boolean isCarWithBattery = reviewBattery();
        if (isCarWithBattery) {
            distanceDriven += speed;
            batteryPercent -= batteryDrain;
        }else{
            System.out.println("battery Drained");
        }
    }


}

class RaceTrack {

    private int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {

        int carSpeed = car.getSpeed();
        int carBatteryDrained = car.getBatteryDrain();
        int battery100 = 100;


        //car.drive() ? cuantas veces
        double distanciaTotal = distance;
        double howMuchDriveCompleteRace = Math.ceil( distanciaTotal/ carSpeed);  //si da decimal tipo 5.3, se sube a 6,
        //si velocidad es 3 y la distancia es 16, son 6 vueltas
        int canCompleteRace = battery100 - (carBatteryDrained * (int) howMuchDriveCompleteRace);

        return canCompleteRace >= 0;

    }
}
