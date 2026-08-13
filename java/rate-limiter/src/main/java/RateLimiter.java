import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class Principal{
    public static void main(String[] args) {
        TimeSource clock1 = new TimeSource(Instant.EPOCH);
        RateLimiter<String> limiter1 = new RateLimiter<>(3, Duration.ofNanos(10_000L), clock1);
        System.out.println(limiter1.allow("A"));
        clock1.advance(Duration.ofNanos(1L));
        System.out.println(limiter1.allow("A"));
        System.out.println(limiter1.allow("A"));
        System.out.println(limiter1.allow("A"));

        System.out.println("*********************************************************************");
        TimeSource clock2 = new TimeSource(Instant.EPOCH);
        RateLimiter<String> limiter2 = new RateLimiter<>(2, Duration.ofNanos(10_000L), clock2);
        System.out.println(limiter2.allow("A"));
        System.out.println(limiter2.allow("A"));
        System.out.println(limiter2.allow("A"));
        clock2.advance(Duration.ofNanos(9_999L));
        System.out.println(limiter2.allow("A"));

        System.out.println("*********************************************************************");
        TimeSource clock3 = new TimeSource(Instant.EPOCH);
        RateLimiter<String> limiter3 = new RateLimiter<>(2, Duration.ofNanos(10_000L), clock3);
        System.out.println(limiter3.allow("A"));
        System.out.println(limiter3.allow("A"));
        System.out.println(limiter3.allow("A"));
        clock3.advance(Duration.ofNanos(10_000L));
        System.out.println(limiter3.allow("A"));

        System.out.println("*********************************************************************");
        TimeSource clock4 = new TimeSource(Instant.EPOCH);
        RateLimiter<String> limiter4 = new RateLimiter<>(2, Duration.ofNanos(5_000L), clock4);
        System.out.println(limiter4.allow("key"));
        clock4.advance(Duration.ofNanos(1L));
        System.out.println(limiter4.allow("key"));
        System.out.println(limiter4.allow("key"));

        clock4.advance(Duration.ofNanos(5_000L));
        System.out.println(limiter4.allow("key"));
        System.out.println(limiter4.allow("key"));
        System.out.println(limiter4.allow("key"));

        System.out.println("*********************************************************************");
        TimeSource clock5 = new TimeSource(Instant.EPOCH.plusNanos(42L));
        RateLimiter<String> limiter5 = new RateLimiter<>(1, Duration.ofNanos(100L), clock5);

        System.out.println(limiter5.allow("A"));
        clock5.advance(Duration.ofNanos(1L));
        System.out.println(limiter5.allow("A"));

        System.out.println(limiter5.allow("B"));
        System.out.println(limiter5.allow("B"));

        clock5.advance(Duration.ofNanos(100L));
        System.out.println(limiter5.allow("A"));
        System.out.println(limiter5.allow("B"));

        System.out.println("*********************************************************************");
        TimeSource clock6 = new TimeSource(Instant.EPOCH.plusNanos(1_000L));
        RateLimiter<String> limiter6 = new RateLimiter<>(2, Duration.ofNanos(50L), clock6);

        System.out.println(limiter6.allow("X"));
        clock6.advance(Duration.ofNanos(1L));
        System.out.println(limiter6.allow("X"));
        System.out.println(limiter6.allow("X"));

        clock6.advance(Duration.ofNanos(1_000L));
        System.out.println(limiter6.allow("X"));
        System.out.println(limiter6.allow("X"));
        System.out.println(limiter6.allow("X"));

        System.out.println("*********************************************************************");
        TimeSource clock7 = new TimeSource(Instant.EPOCH);
        RateLimiter<String> limiter7 = new RateLimiter<>(1, Duration.ofNanos(10L), clock7);

        System.out.println(limiter7.allow("k"));
        System.out.println(limiter7.allow("k"));

        for (int i = 0; i < 5; i++) {
            clock7.advance(Duration.ofNanos(10L));
            System.out.println(limiter7.allow("k"));
            System.out.println(limiter7.allow("k"));
        }

        System.out.println("*********************************************************************");
        TimeSource clock8 = new TimeSource(Instant.EPOCH);
        RateLimiter<UUID> limiter8 = new RateLimiter<>(1, Duration.ofSeconds(1L), clock8);

        UUID a = UUID.fromString("00000000-0000-0000-0000-000000000001");
        UUID b = UUID.fromString("00000000-0000-0000-0000-000000000002");

        System.out.println(limiter8.allow(a));
        System.out.println(limiter8.allow(a));
        clock8.advance(Duration.ofMillis(1L));

        System.out.println(limiter8.allow(b));
        System.out.println(limiter8.allow(b));
        clock8.advance(Duration.ofSeconds(1L));

        System.out.println(limiter8.allow(a));
        System.out.println(limiter8.allow(a));

        System.out.println("*********************************************************************");
        TimeSource clock = new TimeSource(Instant.EPOCH);
        RateLimiter<Integer> limiter = new RateLimiter<>(1, Duration.ofNanos(100L), clock);
        System.out.println(limiter.allow(42));
        System.out.println(limiter.allow(42));
        clock.advance(Duration.ofNanos(1L));
        System.out.println(limiter.allow(84));
        System.out.println(limiter.allow(84));
        clock.advance(Duration.ofNanos(100L));
        System.out.println(limiter.allow(42));
        System.out.println(limiter.allow(84));

        System.out.println("*********************************************************************");
        TimeSource clock9 = new TimeSource(Instant.EPOCH);
        RateLimiter<Long> limiter9 = new RateLimiter<>(2, Duration.ofNanos(50L), clock9);

        System.out.println(limiter9.allow(1L));
        System.out.println(limiter9.allow(1L));
        System.out.println(limiter9.allow(1L));

        clock9.advance(Duration.ofNanos(1L));
        System.out.println(limiter9.allow(2L));
        System.out.println(limiter9.allow(2L));
        System.out.println(limiter9.allow(2L));

        clock9.advance(Duration.ofNanos(50L));
        System.out.println(limiter9.allow(1L));
        System.out.println(limiter9.allow(2L));

    }
}

//Validador de Operaciones
public class RateLimiter<K> {

    private int limiteIntentosPorUsuario;
    private Duration segundosEsperaAlAlcanzarLimite;
    private TimeSource relojControlable;
    private Instant primerLogIN;

    // K-> Usuario,  Integer -> num Sesiones antes de llegar al tiempo de espera
    Map<K, Integer> mapNumeroSesionesUsuario =  new HashMap<>();
    Map<K, Instant> mapPrimerLoginUsuario = new HashMap<>();

    public RateLimiter(int limit, Duration windowSize, TimeSource timeSource) {
        this.limiteIntentosPorUsuario = limit;
        this.segundosEsperaAlAlcanzarLimite = windowSize;
        this.relojControlable = timeSource;
        this.primerLogIN = this.getTiempoActual();
    }

    public boolean allow(K clientId) {
        System.out.println();
        Duration tiempoEspera = this.getTiempoEspera();
        boolean allowUserLogIn;

        //control de log in por cada usuario
        boolean userHasNotReachedLimit = this.UsuarioHasReachedLimitLogs(clientId);
        if (userHasNotReachedLimit) {
            System.out.println("Welcome");
            this.updateSesionUsuario(clientId);

            allowUserLogIn = true;
        }else{
            Duration cuantoTiempoHaPasado = this.HowMuchTimeHasPassed(clientId);
            boolean userCanLogInAgain = this.TiempoEsperaHaPasado(cuantoTiempoHaPasado);

            if(userCanLogInAgain){
                System.out.println("Ya paso el tiempo  de espera, bienvenido  otra vez");
                System.out.println("Tiempo transcurrido: " + cuantoTiempoHaPasado);
                this.updateInicioOperacionUsuario(clientId);
                this.updateSesionUsuario(clientId, 0);
                this.updateSesionUsuario(clientId);

            }else{
                System.out.println("LIMITE ALCANZADO, POR FAVOR ESPERA: " + tiempoEspera);
                System.out.println("Tiempo transcurrido: " + cuantoTiempoHaPasado);

            }
            allowUserLogIn = userCanLogInAgain;
        }

        System.out.println("Numero Sesiones por Usuario: " + mapNumeroSesionesUsuario);
        System.out.println("Primer Login por Usuario: " + mapPrimerLoginUsuario);

        return allowUserLogIn;
    }

    private boolean UsuarioHasReachedLimitLogs(K clientId) {
        int limiteIntentosPorUsuario = this.getLimiteTiempo();
        int numeroSesionesActualUsuario = this.getNumeroSesionesIniciadas(clientId);
        System.out.println("Numero de sesiones actuales: " + numeroSesionesActualUsuario);

        return numeroSesionesActualUsuario < limiteIntentosPorUsuario;
    }

    private int getNumeroSesionesIniciadas(K clientId){
        int numeroSesionesIniciadas = 0;
        boolean existeUsuario = mapNumeroSesionesUsuario.containsKey(clientId);
        if (!existeUsuario) {
            System.out.println("Creando usuario, bienvenido: " + clientId);
            mapNumeroSesionesUsuario.computeIfAbsent(clientId, k -> 0);
            mapPrimerLoginUsuario.computeIfAbsent(clientId, k -> primerLogIN);

        }
        numeroSesionesIniciadas = (existeUsuario) ? this.getTotalSesionesUsuario(clientId) : 0;
        return numeroSesionesIniciadas;
    }

    private int getTotalSesionesUsuario(K clientId){
        int numeroSesiones = mapNumeroSesionesUsuario.get(clientId);
        return numeroSesiones;
    }

    private int updateSesionUsuario(K clientId){
        int numeroSesiones = this.getTotalSesionesUsuario(clientId);
        numeroSesiones++;
        System.out.println("Numero de sesion actualizada: " + numeroSesiones);
        //actualizar el mapSesiones
        mapNumeroSesionesUsuario.put(clientId, numeroSesiones);
        return numeroSesiones;
    }

    private void updateSesionUsuario(K clientId, int numeroSesiones){
        mapNumeroSesionesUsuario.put(clientId, numeroSesiones);
    }

    private Duration HowMuchTimeHasPassed(K clientId){
        Instant loginTime = this.getInicioOperacionUsuario(clientId);
        Instant ahora = this.getTiempoActual();
        Duration cuantoTiempoHaPasado = Duration.between(loginTime, ahora);
        return cuantoTiempoHaPasado;
    }

    private boolean TiempoEsperaHaPasado(Duration tiempoTranscurrido){
        Duration Limite = this.getTiempoEspera();
        boolean tiempoTranscurridoMayorLimite = tiempoTranscurrido.compareTo(Limite) > 0;
        boolean tiempoTranscurridoIgualLimite = tiempoTranscurrido.equals(Limite);

        return tiempoTranscurridoMayorLimite || tiempoTranscurridoIgualLimite;
    }

    private int getLimiteTiempo(){
        return limiteIntentosPorUsuario;
    }

    private Duration getTiempoEspera(){
        return segundosEsperaAlAlcanzarLimite;
    }

    private  TimeSource getManagableClock(){
        return relojControlable;
    }

    private Instant getTiempoActual(){
        TimeSource time = this.getManagableClock();
        Instant loginTime = time.now();
        return loginTime;
    }

    private Instant getInicioOperacionUsuario(K clientId){
        Instant inicioLogInUser = mapPrimerLoginUsuario.get(clientId);
        return inicioLogInUser;
    }

    private void updateInicioOperacionUsuario(K clientId){
        Instant tiempoActual = this.getTiempoActual();
        mapPrimerLoginUsuario.put(clientId, tiempoActual);
        primerLogIN = tiempoActual;
    }
}
