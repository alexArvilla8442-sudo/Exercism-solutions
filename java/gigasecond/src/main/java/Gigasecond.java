import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

class Principal{
    public static void main(String[] args) {

        //If you were born on January 24th, 2015 at 22:00 (10:00:00pm), then you would be a gigasecond old on October 2nd, 2046 at 23:46:40 (11:46:40pm).

        //Gigasecond gigaSecond = new Gigasecond(LocalDateTime.of(2015, Month.JANUARY, 24, 22, 0, 0));
        //System.out.println(gigaSecond.getDateTime());

        Gigasecond gigaSecond2 = new Gigasecond(LocalDate.of(2011, Month.APRIL, 25));
        System.out.println(gigaSecond2.getDateTime());

        Gigasecond gigasecond3 = new Gigasecond(LocalDate.of(1977, Month.JUNE, 13));
        System.out.println(gigasecond3.getDateTime());

        Gigasecond gigaSecond4 = new Gigasecond(LocalDate.of(1959, Month.JULY, 19));
        System.out.println(gigaSecond4.getDateTime());

        Gigasecond gigaSecond5 = new Gigasecond(LocalDateTime.of(2015, Month.JANUARY, 24, 22, 0, 0));
        System.out.println(gigaSecond5.getDateTime());

        Gigasecond gigaSecond6 = new Gigasecond(LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59));
        System.out.println(gigaSecond6.getDateTime());

        LocalDateTime input = LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59);
        new Gigasecond(input).getDateTime();
        System.out.println(input);

    }
}

public class Gigasecond {
    //un gigasegundo son exactamente 11,574 días, 1 hora, 46 minutos y 40 segundos.

    private LocalDateTime tiempo;

    public Gigasecond(LocalDate moment) {
        this.tiempo = moment.atTime(0,0,0);
    }

    public Gigasecond(LocalDateTime moment) {
        this.tiempo = moment;
    }

    public LocalDateTime getDateTime() {

        LocalDateTime nuevaFecha = tiempo.plusSeconds(1000000000);
        return nuevaFecha;
    }

    public int getYear(LocalDate moment) {
        return tiempo.getYear();
    }
    public int getMonth(LocalDate moment) {
        return tiempo.getMonthValue();
    }
    public int getDayOfMonth(LocalDate moment) {
        return tiempo.getDayOfMonth();
    }
}
