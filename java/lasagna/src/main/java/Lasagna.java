class Main {
    public static void main(String[] args) {
        // Your code goes here
        Lasagna lasagna = new Lasagna();
        lasagna.expectedMinutesInOven();
        lasagna.remainingMinutesInOven(25);
        lasagna.preparationTimeInMinutes(1);
        lasagna.preparationTimeInMinutes(4);
        lasagna.totalTimeInMinutes(1, 30);
        lasagna.totalTimeInMinutes(4, 8);
    }
}




public class Lasagna {
    // TODO: define the 'expectedMinutesInOven()' method
    private int expectedTimeLasagnaInOven = 40;
    public int expectedMinutesInOven(){
        /*
         does not take any parameters and returns how many minutes the lasagna
         should be in the oven.
         According to the cooking book, the expected oven time in minutes is 40
        * */
        return expectedTimeLasagnaInOven;
    }

    // TODO: define the 'remainingMinutesInOven()' method
    /*
    *takes the actual minutes the lasagna has been in the oven as a parameter and returns how many
    * minutes the lasagna still has to remain in the ove
    * */
    public int remainingMinutesInOven(int MinutesLasagnaHasBeenInOven){

        return expectedTimeLasagnaInOven - MinutesLasagnaHasBeenInOven;
    }

    // TODO: define the 'preparationTimeInMinutes()' method
    /*
    takes the number of layers you added to the lasagna as a parameter and returns how many minutes you spent preparing the lasagna,
    assuming each layer takes you 2 minutes to prepare
    * */
    public int preparationTimeInMinutes(int numerOfLayers){
        return numerOfLayers * 2;
    }

    // TODO: define the 'totalTimeInMinutes()' method
    /*
     that takes two parameters: the first parameter is the number of layers you added to the lasagna, and the second parameter is the
     number of minutes the lasagna has been in the oven. The function should return how many minutes in total you've worked on cooking
     the lasagna, which is the sum of the preparation time in minutes, and the time in minutes the lasagna has spent in the oven at the moment.
    * */
    public int totalTimeInMinutes(int numberOfLayers, int minutesLasagnaHasBeenOven){
        numberOfLayers *= 2;
        return numberOfLayers + minutesLasagnaHasBeenOven;
    }
}
