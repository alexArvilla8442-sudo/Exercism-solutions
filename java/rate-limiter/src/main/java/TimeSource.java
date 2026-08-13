import java.time.Duration;
import java.time.Instant;

/**
 * NOTE: There is no need to change this file and is treated as read only by the Exercism test runners.
 */
//Reloj Controlable
public class TimeSource implements Reloj {
    private Instant tiempoActual;

    public TimeSource(Instant start) {
        this.tiempoActual = start;
    }

    @Override
    public Instant now() {
        return tiempoActual;
    }

    public void advance(Duration d) {
        this.tiempoActual = this.tiempoActual.plus(d);
    }
}
