public class CarsAssemble {

    public static void main(String[] args) {
        productionRatePerHour(0);
        productionRatePerHour(1);
        productionRatePerHour(4);
        productionRatePerHour(7);
        productionRatePerHour(9);
        productionRatePerHour(10);

        workingItemsPerMinute(0);
        workingItemsPerMinute(1);
        workingItemsPerMinute(5);
        workingItemsPerMinute(8);
        workingItemsPerMinute(9);
        workingItemsPerMinute(10);
    }
    /*
    *
    In this exercise you'll be writing code to analyze the production of an assembly line in a car factory.
    * The assembly line's speed can range from 0 (off) to 10 (maximum).

    At its lowest speed (1), 221 cars are produced each hour. The production increases linearly with the speed.
    * So with the speed set to 4, it should produce 4 * 221 = 884 cars per hour. However, higher speeds increase the likelihood
    * that faulty cars are produced, which then have to be discarded. The following table shows how speed influences the success rate:

    1 to 4: 100% success rate.
    5 to 8: 90% success rate.
    9: 80% success rate.
    10: 77% success rate.
    * */

    public static double productionRatePerHour(int speed) {

        int carsProducedEachHour = 221;
        double assemblyLineProduction = carsProducedEachHour * speed;
        //si velocidad 1 a 4 =  exito 100%
            if(speed >= 5 && speed <= 8){
                //exito es del 90%
                assemblyLineProduction *= .90;
            }else if(speed == 9){
                //exito 80%
                assemblyLineProduction *= .80;
            }else if(speed == 10){
                //exito del 77%
                assemblyLineProduction *= .77;
            }

        return assemblyLineProduction;
    }

    public static int workingItemsPerMinute(int speed) {
        //how many working cars are produced per minute:
        /*
        At its lowest speed (1), 221 cars are produced each hour.
        1 hora tiene 60 minutos
        1- 4 = 100%
        5 - 8 = exito  90%
        9 =  80%
        10 = 77%
        velocidad 6 = 19 carros por minuto
        * */

        double getProductionRatePerHour = productionRatePerHour(speed);

        int workingCarsPerMinute = (int) (getProductionRatePerHour / 60);

        return workingCarsPerMinute;
    }
}
