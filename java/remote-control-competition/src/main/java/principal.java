import java.util.ArrayList;
import java.util.List;

public class principal{
    public static void main(String[] args) {
        ProductionRemoteControlCar productionCar = new ProductionRemoteControlCar();
        System.out.println(productionCar instanceof RemoteControlCar);

        ExperimentalRemoteControlCar experimentalCar = new ExperimentalRemoteControlCar();
        System.out.println(experimentalCar instanceof RemoteControlCar);

        ProductionRemoteControlCar car = new ProductionRemoteControlCar();
        System.out.println(car.getDistanceTravelled());
        car.drive();
        System.out.println(car.getDistanceTravelled());

        ExperimentalRemoteControlCar experimentalCar1 = new ExperimentalRemoteControlCar();
        System.out.println(experimentalCar1.getDistanceTravelled());
        experimentalCar1.drive();
        System.out.println(experimentalCar1.getDistanceTravelled());

        ProductionRemoteControlCar productionCar2 = new ProductionRemoteControlCar();
        ExperimentalRemoteControlCar experimentalCar2 = new ExperimentalRemoteControlCar();
        TestTrack.race(productionCar2);
        TestTrack.race(productionCar2);
        TestTrack.race(experimentalCar2);
        TestTrack.race(experimentalCar2);
        System.out.println( experimentalCar2.getDistanceTravelled() - productionCar2.getDistanceTravelled());

        //System.out.println(productionCar instanceof Comparable.class);

        ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
        prc1.setNumberOfVictories(3);
        System.out.println(prc1.getNumberOfVictories());

        ProductionRemoteControlCar prc2 = new ProductionRemoteControlCar();
        ProductionRemoteControlCar prc3 = new ProductionRemoteControlCar();
        prc2.setNumberOfVictories(2);
        prc3.setNumberOfVictories(3);
        List<ProductionRemoteControlCar> unsortedCars = new ArrayList<>() {
            {
                add(prc2);
                add(prc3);
            }
        };
        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(unsortedCars);
        for (int i = 0; i < rankings.size(); i++) {
            System.out.println(rankings.get(i).getNumberOfVictories());
        }
        //System.out.println(rankings.get(1).getNumberOfVictories());

        System.out.println("---------------");
        List<ProductionRemoteControlCar> unsortedCars2 = new ArrayList<>() {
            {
                add(new ProductionRemoteControlCar().setVictories(0)); //0
                add(new ProductionRemoteControlCar().setVictories(3)); //3
                add(new ProductionRemoteControlCar().setVictories(5)); //5
                add(new ProductionRemoteControlCar().setVictories(7));  //7
                add(new ProductionRemoteControlCar().setVictories(2)); //2
                add(new ProductionRemoteControlCar().setVictories(1)); //1
            }
        };
        List<ProductionRemoteControlCar> rankings2 = TestTrack.getRankedCars(unsortedCars2);
        for(ProductionRemoteControlCar prc : rankings2) {
            System.out.println(prc.getNumberOfVictories());
        }
    }
}
