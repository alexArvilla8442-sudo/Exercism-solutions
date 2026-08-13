class Principal{
    public static void main(String[] args) {
        var leapYear1 = new Leap();

        System.out.println(leapYear1.isLeapYear(2015));
        System.out.println(leapYear1.isLeapYear(1970));
        System.out.println(leapYear1.isLeapYear(1996));
        System.out.println(leapYear1.isLeapYear(1960));
        System.out.println(leapYear1.isLeapYear(2100));
        System.out.println(leapYear1.isLeapYear(1900));
        System.out.println(leapYear1.isLeapYear(2000));
        System.out.println(leapYear1.isLeapYear(2400));
        System.out.println(leapYear1.isLeapYear(1800));
    }
}

class Leap {
    boolean isLeapYear(int year) {
        boolean leapYear = false;
        boolean isYearDivisibleBy100 = (year % 100 == 0);

        if(isYearDivisibleBy100) {
            leapYear = (year % 400 == 0);
        }else{
            leapYear = (year % 4 == 0);
        }
        return leapYear;
    }
}
