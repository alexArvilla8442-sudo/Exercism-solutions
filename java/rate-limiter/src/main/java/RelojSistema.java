import java.time.Instant;

public class RelojSistema implements Reloj{
    @Override
    public Instant now() {
        return Instant.now();
    }
}
