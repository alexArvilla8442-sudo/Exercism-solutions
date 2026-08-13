import java.util.*;

import static javax.swing.UIManager.put;

class Principal{
    public static void main(String[] args) {



        System.out.println(new KindergartenGarden("RC\nGG").getPlantsOfStudent("Alice"));
        System.out.println(new KindergartenGarden("VC\nRC").getPlantsOfStudent("Alice"));
        System.out.println(new KindergartenGarden("VVCG\nVVRC").getPlantsOfStudent("Bob"));
        System.out.println(new KindergartenGarden("VVCCGG\nVVCCGG").getPlantsOfStudent("Bob"));
        System.out.println(new KindergartenGarden("VVCCGG\nVVCCGG").getPlantsOfStudent("Charlie"));
        System.out.println(new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Alice"));
        System.out.println(new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Bob"));
        System.out.println(new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Charlie"));
        System.out.println(new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("David"));
        System.out.println(new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Eve"));
        System.out.println(new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Fred"));
        System.out.println(new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Ginny"));
        System.out.println(new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Harriet"));
        System.out.println(new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Ileana"));
        System.out.println(new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Joseph"));
        System.out.println(new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Kincaid"));
        System.out.println(new KindergartenGarden("VRCGVVRVCGGCCGVRGCVCGCGV\nVRCCCGCRRGVCGCRVVCVGCGCV").getPlantsOfStudent("Larry"));

        //assertThat(new KindergartenGarden(garden).getPlantsOfStudent(student)).containsExactly(Plant.GRASS, Plant.VIOLETS, Plant.CLOVER, Plant.VIOLETS);
    }
}



class KindergartenGarden {

    /*
    Alice, Bob, Charlie, David, Eve, Fred, Ginny, Harriet, Ileana, Joseph, Kincaid, and Larry

    * Plant	Diagram encoding
        Grass	G
        Clover	C
        Radish	R
        Violet	V

        "Alice", List.of(0,1),
                    "Bob", List.of(2,3),
                    "Charlie", List.of(4,5),
                    "David", List.of(6,7),
                    "Eve", List.of(8,9),
                    "Fred", List.of(10, 11),
                    "Ginny", List.of(12,13),
                    "Harriet", List.of(14,15),
                    "Ileana", List.of(16,17),
                    "Joseph", List.of(18,19),
                    "Kincaid", List.of(20,21),
                    "Larry", List.of(22,23)
    * */
    private String garden;

    Map<String, List<Integer>> MapAlumnos = new HashMap<>(
            Map.ofEntries(
                    Map.entry("Alice", List.of(0,1)),
                    Map.entry("Bob", List.of(2,3)),
                    Map.entry("Charlie", List.of(4,5)),
                    Map.entry("David", List.of(6,7)),
                    Map.entry("Eve", List.of(8,9)),
                    Map.entry("Fred", List.of(10, 11)),
                    Map.entry("Ginny", List.of(12,13)),
                    Map.entry("Harriet", List.of(14,15)),
                    Map.entry("Ileana", List.of(16,17)),
                    Map.entry("Joseph", List.of(18,19)),
                    Map.entry("Kincaid", List.of(20,21)),
                    Map.entry("Larry", List.of(22,23))
            )
    );


    KindergartenGarden(String garden) {
        this.garden = garden;
    }

    public String getGarden() {
        return garden;
    }

    List<Plant> getPlantsOfStudent(String student) {
        List<Plant> plants = new ArrayList<>();
        String jardin = getGarden().replaceAll("(\r\n|\n|\r)", "").trim();

        List<Integer> listaPosicionALumno = MapAlumnos.get(student);
        int posicion1 = listaPosicionALumno.get(0);
        int posicion2 = listaPosicionALumno.get(1);

        int longitudCadena = jardin.length();
        int mitadCadena = longitudCadena / 2;

        String primeraParteLista = jardin.substring(0, mitadCadena);
        String segundaParteLista = jardin.substring(mitadCadena);

        String plantasALumnoPart1 = primeraParteLista.substring(posicion1, posicion2 + 1);
        String plantasALumnoPart2 = segundaParteLista.substring(posicion1, posicion2 + 1);

        plants.addAll(this.getPlantas(plantasALumnoPart1));
        plants.addAll(this.getPlantas(plantasALumnoPart2));

        return plants;
    }

    public List<Plant> getPlantas(String codigoPlanta) {
        List<Plant> plants = new ArrayList<>();

        for (int i = 0; i < codigoPlanta.length(); i++) {
            char caracterPlanta1 = codigoPlanta.charAt(i);
            Plant planta1 = Plant.getPlant(caracterPlanta1);

            plants.add(planta1);
        }
        return plants;
    }

}
