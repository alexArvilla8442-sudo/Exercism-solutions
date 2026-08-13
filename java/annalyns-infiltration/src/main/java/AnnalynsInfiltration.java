import java.nio.file.FileAlreadyExistsException;

class AnnalynsInfiltration {

    public static void main(String[] args) {
        canFastAttack(true);
        canFastAttack(false);
        canSpy(false, false, false);
        canSpy(true, false, false);
        canSpy(false, true, false);
        canSpy(false, false, true);
        canSpy(false, true, true);
        canSpy(true, false, true);
        canSpy(true, true, false);
        canSpy(true, true, true);
        canSignalPrisoner(false, true);
        canSignalPrisoner(true, false);
        canSignalPrisoner(false, false);
        canSignalPrisoner(true, true);

        canFreePrisoner(true, true, true, true);
        canFreePrisoner(true, true, true, false);
        canFreePrisoner(false, false, false, true);
        canFreePrisoner(false, false, false, false);
        canFreePrisoner(false, false, true, true);
        canFreePrisoner(false, false, true, false);
        canFreePrisoner(false, true, false, true);
        canFreePrisoner(false, true, false, false);
        canFreePrisoner(true, false, false, true);
        canFreePrisoner(true, false, false, false);
        canFreePrisoner(false, true, true, true);
        canFreePrisoner(false, true, true, false);
        canFreePrisoner(true, false, true, true);
        canFreePrisoner(true, false, true, false);
        canFreePrisoner(true, true, false, true);
        canFreePrisoner(true, true, false, false);
    }

    public static boolean canFastAttack(boolean knightIsAwake) {
        boolean fastAttack = (!knightIsAwake) ? true: false;

        return fastAttack;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        /*
       Implement the (static) AnnalynsInfiltration.canSpy() method, which takes three boolean values indicating whether the knight,
       archer, and prisoner, respectively, are awake. The method returns true if the group can be spied upon based on the state of the
       three characters. Otherwise, it returns false:
        * */
        boolean canSpy = (knightIsAwake ||  archerIsAwake || prisonerIsAwake) ? true : false;
        return canSpy;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        /*
        mplement the (static) AnnalynsInfiltration.canSignalPrisoner() method, which takes two boolean values indicating
        whether the archer and the prisoner, respectively, are awake. The method returns true if the prisoner can be signaled based
        on the state of the two characters. Otherwise, it returns false:
        * */

        boolean canSignalPrisoner =  (!archerIsAwake && prisonerIsAwake) ? true : false;
        return canSignalPrisoner;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {

        boolean freePrisoner=false;

        if (petDogIsPresent) {
            if((prisonerIsAwake && knightIsAwake && !archerIsAwake) || (!prisonerIsAwake && knightIsAwake && !archerIsAwake)){
                freePrisoner = true;
            }else if(!prisonerIsAwake && !knightIsAwake && !archerIsAwake){
                freePrisoner = true;
            }else if(prisonerIsAwake && !knightIsAwake && !archerIsAwake){
                freePrisoner = true;
            }
        }else{
            freePrisoner = (prisonerIsAwake && !knightIsAwake && !archerIsAwake) ? true : false;
        }

        if (freePrisoner){
            return true;
        }else{
            return false;
        }
    }

}
