import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Principal{
    public static void main(String[] args) {
        HighScores highScores = new HighScores(Arrays.asList(30, 50, 20, 70));
        System.out.println(highScores.scores());

        HighScores highScores2 = new HighScores(Arrays.asList(100, 0, 90, 30));
        System.out.println(highScores2.latest());

        HighScores highScores3 = new HighScores(Arrays.asList(40, 100, 70));
        System.out.println(highScores3.personalBest());

        HighScores highScores4 = new HighScores(Arrays.asList(10, 30, 90, 30, 100, 20, 10, 0, 30, 40, 40, 70, 70));
        System.out.println(highScores4.personalTopThree());

        HighScores highScores5 = new HighScores(Arrays.asList(20, 10, 30));
        System.out.println(highScores5.personalTopThree());

        HighScores highScores6 = new HighScores(Arrays.asList(40, 20, 40, 30));
        System.out.println(highScores6.personalTopThree());

        HighScores highScores7 = new HighScores(Arrays.asList(30, 70));
        System.out.println(highScores7.personalTopThree());

        HighScores highScores8 = new HighScores(Arrays.asList(40));
        System.out.println(highScores8.personalTopThree());

        HighScores highScores9 = new HighScores(Arrays.asList(70, 50, 20, 30));
        highScores9.personalTopThree();
        System.out.println(highScores9.latest());
        //assertThat(highScores.latest()).isEqualTo(30);

        HighScores highScores10 = new HighScores(Arrays.asList(30, 50, 20, 70));
        highScores10.personalTopThree();
        System.out.println(highScores10.scores());
        //assertThat(highScores.scores()).isEqualTo(Arrays.asList(30, 50, 20, 70));

        HighScores highScores11 = new HighScores(Arrays.asList(20, 70, 15, 25, 30));
        highScores11.personalBest();
        System.out.println(highScores11.latest());
        //assertThat(highScores.latest()).isEqualTo(30);

        HighScores highScores12 = new HighScores(Arrays.asList(20, 70, 15, 25, 30));
        highScores12.personalBest();
        System.out.println(highScores12.scores());
        //assertThat(highScores.scores()).isEqualTo(Arrays.asList(20, 70, 15, 25, 30));

    }
}

class HighScores {

    private List<Integer> highScores;
    public HighScores(List<Integer> highScores) {
        this.highScores = new ArrayList<>(highScores);
    }

    List<Integer> scores() {
        return this.highScores;
    }

    List<Integer> listaOrdenada(){
        List<Integer> scoresOrdenAscendente = new ArrayList<>(this.highScores);
        scoresOrdenAscendente.sort(null);

        return scoresOrdenAscendente;
    }

    Integer latest() {
        int indiceUltimaPosicion = this.highScores.size() - 1;
        return highScores.get(indiceUltimaPosicion);
    }

    Integer latest(List<Integer> scores) {
        int indiceUltimaPosicion = scores.size() - 1;
        return scores.get(indiceUltimaPosicion);
    }

    Integer personalBest() {
        //List<Integer> scoresOrdenAscendente = new ArrayList<>(this.highScores);
        //scoresOrdenAscendente.sort(null);
        List<Integer> scoresOrdenAscendente = listaOrdenada();

        return latest(scoresOrdenAscendente);
    }

    List<Integer> personalTopThree() {

        int sizeListaOriginal = this.highScores.size();

        if(sizeListaOriginal == 1){
            return this.highScores;
        }

        List<Integer> listaAscendente = listaOrdenada();

        List<Integer> newReversedList = listaAscendente.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        lst -> { Collections.reverse(lst); return lst; }
                ));

        int sizeLista = newReversedList.size();

        if(sizeLista < 3){
            return newReversedList;
        }

        List<Integer> topThree = newReversedList.stream()
                .limit(3)
                .toList();

        return topThree;
    }

}
