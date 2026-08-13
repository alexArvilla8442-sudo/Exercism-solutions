

class principal{
    public static void main(String[] args) {

        JedliksToyCar car = JedliksToyCar.buy();
        System.out.println(car != null);

        JedliksToyCar car1 = JedliksToyCar.buy();
        JedliksToyCar car2 = JedliksToyCar.buy();
        System.out.println(car1.equals(car2));

        car = null;
        car = new JedliksToyCar();
        car.distanceDisplay();
        car.batteryDisplay();
        car.drive();
        car.distanceDisplay();

        car = null;
        car = new JedliksToyCar();
        for (int i = 0; i < 17; i++) {
            car.drive();
        }
        car.distanceDisplay();

        car = null;
        car = new JedliksToyCar();
        car.drive();
        car.batteryDisplay();

        car = null;
        car = new JedliksToyCar();
        for (int i = 0; i < 23; i++) {
            car.drive();
        }
        car.batteryDisplay();

        car = null;
        car = new JedliksToyCar();
        // Drain the battery
        for (int i = 0; i < 100; i++) {
            car.drive();
        }
        // Attempt to drive one more time (should not work)
        car.drive();
        car.batteryDisplay();

        car = null;
        car = new JedliksToyCar();
        // Drain the battery
        for (int i = 0; i < 100; i++) {
            car.drive();
        }
        // Attempt to drive one more time (should not work)
        car.drive();
        car.distanceDisplay();



    }
}

class JedliksToyCar {

    private int metersDriven;
    private int batteryPercent;
    //factory method
    public static JedliksToyCar buy(){
        return new JedliksToyCar();
    }

    public JedliksToyCar() {
        this.metersDriven = 0;
        this.batteryPercent = 100;
    }

    public String distanceDisplay() {

        return "Driven " + metersDriven + " meters";
    }

    public String batteryDisplay() {

        String updateBattery = (batteryPercent > 0) ? "Battery at " +  batteryPercent + "%" : "Battery empty" ;

        return updateBattery;
    }

    public void drive() {

        if (batteryPercent > 0) {
            int updateMetersDriven = 20;
            int updateBatteryPercent = 1;

            batteryPercent -= updateBatteryPercent;
            metersDriven += updateMetersDriven;
            System.out.println("Driven " + metersDriven + " meters");
            //System.out.println("Battery at: " +  batteryPercent + "%");
        }else{
            System.out.println("Battery empty");
        }
    }
}
