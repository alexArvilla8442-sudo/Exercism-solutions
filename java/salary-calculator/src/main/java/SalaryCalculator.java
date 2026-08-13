



public class SalaryCalculator {
    public static void main(String[] args) {

        int daysSkipped = 4;
        salaryMultiplier(daysSkipped);
        daysSkipped = 5;
        salaryMultiplier(daysSkipped);
        daysSkipped = 6;
        salaryMultiplier(daysSkipped);

        int productsSold = 19;
        bonusMultiplier(productsSold);
        productsSold = 20;
        bonusMultiplier(productsSold);
        productsSold = 21;
        bonusMultiplier(productsSold);

        productsSold = 5;
        bonusForProductsSold(productsSold);

        int daysSkippedd = 0;
        int productsSoldd = 0;
        finalSalary(daysSkippedd, productsSoldd);

        daysSkippedd = 7;
        productsSoldd = 0;
        finalSalary(daysSkippedd, productsSoldd);

        daysSkippedd = 2;
        productsSoldd = 5;
        finalSalary(daysSkippedd, productsSoldd);

        daysSkippedd = 0;
        productsSoldd = 77;
        finalSalary(daysSkippedd, productsSoldd);

    }
//calculating the total salary of an employee in a month

    public static double salaryMultiplier(int daysSkipped) {
        /*
        returns the salary multiplier based on the number of days an employee skipped work.
        Apply a 15% penalty if the employee skipped at least five days.

            int daysSkipped = 3;
            salaryMultiplier(daysSkipped);
            // => 1.0

            daysSkipped = 7;
            salaryMultiplier(daysSkipped);
            // => 0.85
        * */
        double getSalaryMultiplier = (daysSkipped >= 5) ? 0.85 : 1.0;
        return getSalaryMultiplier;
    }

    public static int bonusMultiplier(int productsSold) {
        int bonus = (productsSold >= 20) ? 13 : 10;
        return bonus;
    }

    public static double bonusForProductsSold(int productsSold) {
        int getBonus =  bonusMultiplier(productsSold);
        return getBonus * productsSold;
    }

    public static double finalSalary(int daysSkipped, int productsSold) {
        double salarioBase = 1000.0;
        double getBonusForProductsSold = bonusForProductsSold(productsSold);
        double porcentajePagoDiasFaltoTrabajo = salaryMultiplier(daysSkipped);

        double getFinalSalaryPart1 = (salarioBase + getBonusForProductsSold) * porcentajePagoDiasFaltoTrabajo;

        double getFinalSalaryPart2 = (getFinalSalaryPart1 > 2000.0) ? 2000 : getFinalSalaryPart1;
        return getFinalSalaryPart2;
    } 
}
