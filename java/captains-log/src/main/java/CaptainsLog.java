import com.sun.source.doctree.SeeTree;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class principal{
    private static Random random1;
    private static Random random2;
    private static Random random3;

    private static Random random4;
    private static Random random5;
    private static Random random6;

    private static Random random7;
    private static Random random8;
    private static Random random9;
    public static void main(String[] args) {
        random1 = new Random(47);
        random2 = new Random(474747);
        random3 = new Random(474747474747L);


        CaptainsLog cap1 = new CaptainsLog(random1);
        System.out.println(cap1.randomPlanetClass());

        CaptainsLog cap2 = new CaptainsLog(random2);
        System.out.println(cap2.randomPlanetClass());

        CaptainsLog cap3 = new CaptainsLog(random3);
        System.out.println(cap3.randomPlanetClass());

        CaptainsLog cap4 = new CaptainsLog(new Random());
        Set<Character> CaracteresSet =  new HashSet<>();



        while (CaracteresSet.size() != 10) {
            char caracter = cap4.randomPlanetClass();

            if(CaracteresSet.contains(caracter)){
                continue;
            }else{
                CaracteresSet.add(caracter);

                String mensaje = switch (caracter){
                case 'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y' -> String.format("contiene %s", caracter);
                    default -> "";
                };
                System.out.println(mensaje);

            }
            System.out.println(CaracteresSet);
        }
        random4 = new Random(47);
        random5 = new Random(474747);
        random6 = new Random(474747474747L);
        CaptainsLog cap5 = new CaptainsLog(random4);
        System.out.println(cap5.randomShipRegistryNumber());

        CaptainsLog cap6 = new CaptainsLog(random5);
        System.out.println(cap6.randomShipRegistryNumber());

        CaptainsLog cap7 = new CaptainsLog(random6);
        System.out.println(cap7.randomShipRegistryNumber());

        CaptainsLog cap8 = new CaptainsLog(new Random());
        for (int i = 0; i < 100; i++) {
            var shipRegistryNumber = cap8.randomShipRegistryNumber();
            var number = Integer.parseInt(shipRegistryNumber.substring(4));
            System.out.println(number);
            boolean valor = number >= 1000 && number <= 9999;
            System.out.println(valor);
        }

        random7 = new Random(47);
        random8 = new Random(474747);
        random9 = new Random(474747474747L);

        CaptainsLog cap9 = new CaptainsLog(random7);
        System.out.println(cap9.randomStardate());

        CaptainsLog cap10 = new CaptainsLog(random8);
        System.out.println(cap10.randomStardate());

        CaptainsLog cap11 = new CaptainsLog(random9);
        System.out.println(cap11.randomStardate());

        CaptainsLog cap12 = new CaptainsLog(new Random());
        for (int i = 0; i < 100; i++) {
            var shipRegistryNumber = cap12.randomStardate();

            boolean valor = shipRegistryNumber >= 41000 && shipRegistryNumber <= 42000;

        }



    }


}
class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        int arraySize = PLANET_CLASSES.length;
        int randomIndex = random.nextInt(arraySize); //o - 9, el size es de 10, pero no se cuenta
        return PLANET_CLASSES[randomIndex];
    }

    String randomShipRegistryNumber() {
        int minimo = 1000;
        int maximo = 10000;
        int registryNumber = random.nextInt(minimo, maximo); // 1000 a 9999
        return String.format("NCC-%d", registryNumber);
    }

    double randomStardate() {
        double minimo = 41000;
        return minimo + 1000 * random.nextDouble(); // 41000 - 42000
    }
}
