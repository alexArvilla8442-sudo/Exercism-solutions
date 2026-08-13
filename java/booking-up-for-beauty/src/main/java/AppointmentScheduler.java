import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
class principal {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        //first method
        var expected2 = LocalDateTime.of(2019, 7, 25, 13, 45, 0);
        AppointmentScheduler scheduler = new AppointmentScheduler();
        expected2.isEqual(scheduler.schedule("07/25/2019 13:45:00"));

        //appointmentDate before of now
        AppointmentScheduler oneYearAgo = new AppointmentScheduler();
        oneYearAgo.hasPassed(now.minusYears(1).plusHours(2));

        AppointmentScheduler monthsAgo = new AppointmentScheduler();
        monthsAgo.hasPassed(now.minusMonths(8));

        AppointmentScheduler daysAgo = new AppointmentScheduler();
        daysAgo.hasPassed(now.minusDays(23));

        AppointmentScheduler hoursAgo = new AppointmentScheduler();
        hoursAgo.hasPassed(now.minusHours(12));

        AppointmentScheduler minutesAgo = new AppointmentScheduler();
        minutesAgo.hasPassed(now.minusDays(55));

        AppointmentScheduler oneMinuteAgo = new AppointmentScheduler();
        oneMinuteAgo.hasPassed(now.minusDays(1));

        AppointmentScheduler plusMinutes = new AppointmentScheduler();
        plusMinutes.hasPassed(now.plusMinutes(5));

        AppointmentScheduler plusHours = new AppointmentScheduler();
        plusHours.hasPassed(now.plusHours(3));

        AppointmentScheduler plusDays = new AppointmentScheduler();
        plusDays.hasPassed(now.plusDays(19));

        AppointmentScheduler plusMonths = new AppointmentScheduler();
        plusMonths.hasPassed(now.plusMinutes(10));

        AppointmentScheduler plusYMD = new AppointmentScheduler();
        plusYMD.hasPassed(now.plusYears(2).plusMonths(3).plusDays(6));

        //is in the afternoon

        AppointmentScheduler isAfternoon = new AppointmentScheduler();
        isAfternoon.isAfternoonAppointment(LocalDateTime.of(2019, 6, 17, 8, 15, 0));

        AppointmentScheduler isAfternoon2 = new AppointmentScheduler();
        isAfternoon2.isAfternoonAppointment(LocalDateTime.of(2019, 2, 23, 11, 59, 59));

        AppointmentScheduler isAfternoon3 = new AppointmentScheduler();
        isAfternoon3.isAfternoonAppointment(LocalDateTime.of(2019, 8, 9, 12, 0, 0));

        AppointmentScheduler isAfternoon4 = new AppointmentScheduler();
        isAfternoon4.isAfternoonAppointment(LocalDateTime.of(2019, 8, 9, 12, 0, 1));

        AppointmentScheduler isAfternoon5 = new AppointmentScheduler();
        isAfternoon5.isAfternoonAppointment(LocalDateTime.of(2019, 9, 1, 17, 59, 59));

        AppointmentScheduler isAfternoon6 = new AppointmentScheduler();
        isAfternoon6.isAfternoonAppointment(LocalDateTime.of(2019, 9, 1, 18, 0, 0));

        AppointmentScheduler isAfternoon7 = new AppointmentScheduler();
        isAfternoon7.isAfternoonAppointment(LocalDateTime.of(2019, 9, 1, 23, 59, 59));

        //descripcion
        AppointmentScheduler descriptionAppointment = new AppointmentScheduler();
        descriptionAppointment.getDescription(LocalDateTime.of(2019, 3, 29, 15, 0, 0));

        AppointmentScheduler descriptionAppointment2 = new AppointmentScheduler();
        descriptionAppointment2.getDescription(LocalDateTime.of(2019, 7, 25, 13, 45, 0));

        AppointmentScheduler descriptionAppointment3 = new AppointmentScheduler();
        descriptionAppointment3.getDescription(LocalDateTime.of(2020, 9, 9, 9, 9, 9));

        //anniversary day

        var expected = LocalDate.of(now.getYear(), Month.SEPTEMBER, 15);
        AppointmentScheduler scheduler3 = new AppointmentScheduler();
        expected.isEqual(scheduler3.getAnniversaryDate());

    }
}
class AppointmentScheduler {
    // you'll be working on an appointment scheduler for a beauty salon in New York that opened on September 15th in 2012, 15 /sep / 2012
    public LocalDateTime schedule(String appointmentDateDescription) {
        /*
        return
        parse a textual representation of an appointment date into the corresponding LocalDateTime:

        AppointmentScheduler scheduler = new AppointmentScheduler();
        scheduler.schedule("7/25/2019 13:45:00");
        // => LocalDateTime.of(2019, 7, 25, 13, 45, 0)

        LocalDateTime datetime = LocalDateTime.of(2007, 12, 3, 10, 15, 30);
        LocalDateTime parsed = LocalDateTime.parse("2007-12-03T10:15:30");

        datetime.isEqual(parsed);
        // => true


        * */

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(appointmentDateDescription, formatter);
        LocalDateTime dateTime = LocalDateTime.parse(appointmentDateDescription, formatter);
        return dateTime;

    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        /*
        takes an appointment date and checks if the appointment was somewhere in the past:

        AppointmentScheduler scheduler = new AppointmentScheduler();
        scheduler.hasPassed(LocalDateTime.of(1999, 12, 31, 9, 0, 0));
        // => true
        * */

        LocalDateTime now = LocalDateTime.now();

        boolean appointmentHasPassed = (appointmentDate.isBefore(now)) ? true : false;

        return appointmentHasPassed;
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        /*
        AppointmentScheduler scheduler = new AppointmentScheduler();
        scheduler.isAfternoonAppointment(LocalDateTime.of(2019, 03, 29, 15, 0, 0))
        // => true
        * */
        int getHour = (int) appointmentDate.getHour();

        boolean isHourAfternoon = (getHour >= 12 && getHour <= 17) ? true : false;
        return isHourAfternoon;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        /*
        AppointmentScheduler scheduler = new AppointmentScheduler();
        scheduler.getDescription(LocalDateTime.of(2019, 03, 29, 15, 0, 0))
        // => "You have an appointment on Friday, March 29, 2019, at 3:00 PM."
        * */

        String getYear = appointmentDate.getYear() + "";
        String getMonth = appointmentDate.getMonth() + "";
        getMonth = getMonth.substring(0, 1) + getMonth.substring(1).toLowerCase();
        String getDayWeek = appointmentDate.getDayOfWeek() + ""; //monday, friday
        getDayWeek = getDayWeek.substring(0, 1) + getDayWeek.substring(1).toLowerCase();
        String getDayOfMonth = appointmentDate.getDayOfMonth() + ""; //1 - 30 del dia
        int getHourPart1 =  (int) appointmentDate.getHour(); //hora formato 24hr
        int printHour2 = setHourDescription(getHourPart1);
        String getMinute = appointmentDate.getMinute() + "";
        String printMinute = setMinute(getMinute);
        //String getSecond = appointmentDate.getSecond() + "";
        String isAM_or_Pm = (getHourPart1 < 12) ? "AM" : "PM"; //el am 00 - 11 y el pm 12 a 23

        String printMessage = String.format("You have an appointment on %s, %s %s, %s, at %d:%s %s.",
                getDayWeek,
                getMonth,
                getDayOfMonth,
                getYear,
                printHour2,
                printMinute,
                isAM_or_Pm);
        //System.out.println(printMessage);
        return printMessage;
    }

    public int setHourDescription(int getHour){

        int setHour = 0;
        if(getHour >= 12 && getHour <= 23){
            switch(getHour){
                case 12: setHour =  12;break;
                case 13: setHour = 1;break;
                case 14: setHour = 2;break;
                case 15: setHour = 3;break;
                case 16: setHour = 4;break;
                case 17: setHour = 5;break;
                case 18: setHour = 6;break;
                case 19: setHour = 7;break;
                case 20: setHour = 8;break;
                case 21: setHour = 9;break;
                case 22: setHour = 10;break;
                case 23: setHour = 11;break;
            }
            return setHour;
        }else{
            return getHour;
        }
    }

    public String setMinute(String MinuteSTR){
        //(getMinute.equals("0")) ? "00" : getMinute;
        int minuteINT = Integer.parseInt(MinuteSTR);
        String printMinute = (minuteINT < 10)? "0" + MinuteSTR : MinuteSTR;
        return printMinute;
    }

    public LocalDate getAnniversaryDate() {
        /*
        * AppointmentScheduler scheduler = new AppointmentScheduler();
        scheduler.getAnniversaryDate()
        // => LocalDate.of(<current year>, 9, 15)
        * */
        LocalDate today = LocalDate.now();
        return LocalDate.of(today.getYear(), Month.SEPTEMBER, 15);
    }
}
