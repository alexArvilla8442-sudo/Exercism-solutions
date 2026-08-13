class Principal{
    public static void main(String[] args) {
        //var spaceage = new SpaceAge(1000000000);
        System.out.println(new SpaceAge(1000000000).onEarth());
        System.out.println(new SpaceAge(2134835688).onMercury());
        System.out.println(new SpaceAge(189839836).onVenus());
        System.out.println(new SpaceAge(2129871239L).onMars());
        System.out.println(new SpaceAge(901876382).onJupiter());
        System.out.println(new SpaceAge(2000000000L).onSaturn());
        System.out.println(new SpaceAge(1210123456L).onUranus());
        System.out.println(new SpaceAge(1821023456L).onNeptune());
    }
}


class SpaceAge {

    /*
    One Earth year equals 365.25 Earth days, or 31,557,600 seconds.
    If you were told someone was 1,000,000,000 seconds old, their age would be 31.69 Earth-years.

    * Planet	Orbital period in Earth Years
        Mercury	0.2408467
        Venus	0.61519726
        Earth	1.0
        Mars	1.8808158
        Jupiter	11.862615
        Saturn	29.447498
        Uranus	84.016846
        Neptune	164.79132
    * */
    private double seconds;
    private double segundosTierra = 31_557_600;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return seconds;
    }

    double onEarth() {
        double segundos = getSeconds();
        double secondsONEyear = 31_557_600;

        return this.edadPlaneta(segundos, secondsONEyear);
    }

    double onMercury() {
        double segundos = getSeconds();
        double tiempoOrbitar = 0.2408467;
        double segundosONEyear = this.getSegundosPlaneta(tiempoOrbitar);

        return this.edadPlaneta(segundos, segundosONEyear);
    }

    double onVenus() {
        double segundos = getSeconds();
        double tiempoOrbitar = 0.61519726;
        double segundosONEyear = this.getSegundosPlaneta(tiempoOrbitar);

        return this.edadPlaneta(segundos, segundosONEyear);
    }

    double onMars() {
        double segundos = getSeconds();
        double tiempoOrbitar = 1.8808158;
        double segundosONEyear = this.getSegundosPlaneta(tiempoOrbitar);

        return this.edadPlaneta(segundos, segundosONEyear);
    }

    double onJupiter() {
        double segundos = getSeconds();
        double tiempoOrbitar = 11.862615;
        double segundosONEyear = this.getSegundosPlaneta(tiempoOrbitar);

        return this.edadPlaneta(segundos, segundosONEyear);
    }

    double onSaturn() {
        double segundos = getSeconds();
        double tiempoOrbitar = 29.447498;
        double segundosONEyear = this.getSegundosPlaneta(tiempoOrbitar);

        return this.edadPlaneta(segundos, segundosONEyear);
    }

    double onUranus() {
        double segundos = getSeconds();
        double tiempoOrbitar = 84.016846;
        double segundosONEyear = this.getSegundosPlaneta(tiempoOrbitar);

        return this.edadPlaneta(segundos, segundosONEyear);
    }

    double onNeptune() {
        double segundos = getSeconds();
        double tiempoOrbitar = 164.79132;
        double segundosONEyear = this.getSegundosPlaneta(tiempoOrbitar);

        return this.edadPlaneta(segundos, segundosONEyear);
    }

    public double NumeroDosDecimales(double numero){
        String numeroDosDecimales = String.format("%.2f", (numero));
        return Double.parseDouble(numeroDosDecimales);
    }

    private double getSegundosPlaneta(double tiempoOrbitar){
        return segundosTierra * tiempoOrbitar;
    }
    private double edadPlaneta(double segundos, double segundosONEyear){
        double edadPlaneta = segundos / segundosONEyear;
        return this.NumeroDosDecimales(edadPlaneta);
    }

}
