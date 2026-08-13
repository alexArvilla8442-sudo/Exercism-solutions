
class Principal{
    public static void main(String[] args) {
        var collatzCalculator = new CollatzCalculator();

        System.out.println(collatzCalculator.computeStepCount(1));
        System.out.println(collatzCalculator.computeStepCount(16));
        System.out.println(collatzCalculator.computeStepCount(12));
        System.out.println(collatzCalculator.computeStepCount(1000000));
        System.out.println(collatzCalculator.computeStepCount(0));
        System.out.println(collatzCalculator.computeStepCount(-15));
    }
}


class CollatzCalculator {

    /*
    * The rules were deceptively simple. Pick any positive integer.

        If it's even, divide it by 2.
        If it's odd, multiply it by 3 and add 1.
        *
        *
        * Given a positive integer, return the number of steps it takes to reach 1 according to the rules of the Collatz Conjecture.
    * */

    int computeStepCount(int start) {

        boolean isLessOne = start < 1;
        if(isLessOne) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }

        int stepsReach1 = 0;
        boolean isGreaterThan1 = start > 1;
        if(!isGreaterThan1) {
            return stepsReach1;
        }


        do{
            boolean isNumberEven = start % 2 == 0;
            start = (isNumberEven) ? start / 2 : (start * 3) + 1;
            stepsReach1++;

        }while(start != 1);

        return stepsReach1;
    }

}
