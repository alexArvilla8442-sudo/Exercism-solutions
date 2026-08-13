import java.util.Arrays;

class principal{
    public static void main(String[] args) {
        BirdWatcher.getLastWeek();

        int[] birdsPerDay = { 8, 8, 9, 5, 4, 7, 10 };
        BirdWatcher birdCount = new BirdWatcher(birdsPerDay);
        birdCount.getToday();

        int[] count =  new int[] {8, 8, 9, 2, 1, 6, 4};
        BirdWatcher birdWatcher2 = new BirdWatcher(count);
        birdWatcher2.incrementTodaysCount();
        birdWatcher2.getToday();

        int[] count2 = {5, 5, 4, 0, 7, 6, 7};
        BirdWatcher birdWatcher3 = new BirdWatcher(count2);
        birdWatcher3.hasDayWithoutBirds();

        int[] count3 = {4, 5, 9, 10, 9, 4, 3};
        BirdWatcher birdWatcher4 = new BirdWatcher(count3);
        birdWatcher4.hasDayWithoutBirds();

        int[] count4 = {1, 2, 5, 3, 7, 8, 0};
        BirdWatcher birdWatcher5 = new BirdWatcher(count4);
        birdWatcher5.hasDayWithoutBirds();

        int[] count5 = {5, 9, 12, 6, 8, 8, 17};
        BirdWatcher birdWatcher6 = new BirdWatcher(count5);
        birdWatcher6.getCountForFirstDays(4);

        int[] count6 = {5, 9, 12, 6, 8, 8, 17};
        BirdWatcher birdWatcher7 = new BirdWatcher(count6);
        birdWatcher7.getCountForFirstDays(10);

        int[] count7 = {5, 1, 0, 4, 2, 3, 0};
        BirdWatcher birdWatcher8 = new BirdWatcher(count7);
        birdWatcher8.getCountForFirstDays(7);
        birdWatcher8.incrementTodaysCount();
        birdWatcher8.getCountForFirstDays(7);

        int[] count8 = {4, 9, 5, 7, 8, 8, 2};
        BirdWatcher birdWatcher9 = new BirdWatcher(count8);
        birdWatcher9.getBusyDays();

        int[] count9 = {1, 2, 3, 3, 2, 1, 4};
        BirdWatcher birdWatcher10 = new BirdWatcher(count9);
        birdWatcher10.getBusyDays();

    }
}
class BirdWatcher {
    //keep track of how many birds have visited your garden in the last seven days.

    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public static int[] getLastWeek() {
        int[] birdsLastWeek = {0, 2, 5, 3, 7, 8, 4};
        return birdsLastWeek;
    }

    public int getToday() {
        //return how many birds visited your garden today. The bird counts are ordered by day,
        // with the first element being the count of the oldest day, and the last element being today's count.

        int indexBirdToday = birdsPerDay.length - 1;
        int numberBirdsToday = birdsPerDay[indexBirdToday];
        return numberBirdsToday;
    }

    public void incrementTodaysCount() {
        int lastOne = birdsPerDay.length - 1;
        birdsPerDay[lastOne] += 1;
    }

    public boolean hasDayWithoutBirds() {
        boolean hasAdayWithoutBirds = false;
        for (int i = 0; i < birdsPerDay.length; i++) {
            if (birdsPerDay[i] == 0){
                hasAdayWithoutBirds = true;
                break;
            }
        }
        return hasAdayWithoutBirds;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int cantidadElementosArray = birdsPerDay.length;
        int numberDays = (numberOfDays > cantidadElementosArray) ? cantidadElementosArray : numberOfDays;

        int numberBirds = 0;
        for (int i = 0; i < numberDays; i++) {
            numberBirds += birdsPerDay[i];
        }
        return numberBirds;
    }

    public int getBusyDays() {
        int busyDays = 0;
        for (int i = 0; i < birdsPerDay.length; i++) {
            if (birdsPerDay[i] < 5){
                continue;
            }
            busyDays++;
        }
        return busyDays;
    }
}
