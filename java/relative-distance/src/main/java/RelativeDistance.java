import java.util.*;
import java.util.stream.Collectors;

class principal{
    public static void main(String[] args) {

        Map<String, List<String>> familyTree = new HashMap<>() {
            {
                put("Vera", List.of("Tomoko"));
                put("Tomoko", List.of("Aditi"));
            }
        };
        RelativeDistance rd = new RelativeDistance(familyTree);
        System.out.println(rd.degreeOfSeparation("Vera", "Tomoko"));
        //assertThat(rd.degreeOfSeparation("Vera", "Tomoko")).isEqualTo(1);

        Map<String, List<String>> familyTree2 = new HashMap<>() {
            {
                put("Dalia", List.of("Olga", "Yassin"));
            }
        };
        RelativeDistance rd2 = new RelativeDistance(familyTree2);
        System.out.println(rd2.degreeOfSeparation("Olga", "Yassin"));

        Map<String, List<String>> familyTree3 = new HashMap<>() {
            {
                put("Khadija", List.of("Mateo"));
                put("Mateo", List.of("Rami"));
            }
        };
        RelativeDistance rd3 = new RelativeDistance(familyTree3);
        System.out.println(rd3.degreeOfSeparation("Khadija", "Rami"));
        //assertThat(rd.degreeOfSeparation("Khadija", "Rami")).isEqualTo(2);

        Map<String, List<String>> familyTree4 = new HashMap<>() {
            {
                put("Priya", List.of("Rami"));
                put("Kaito", List.of("Elif"));
            }
        };
        RelativeDistance rd4 = new RelativeDistance(familyTree4);
        //rd4.imprimirDescendencia();
        System.out.println(rd4.degreeOfSeparation("Priya", "Kaito"));
        //assertThat(rd.degreeOfSeparation("Priya", "Kaito")).isEqualTo(-1);

        Map<String, List<String>> familyTree5 = new HashMap<>() {
            {
                put("Aiko", List.of("Bao", "Carlos"));
                put("Bao", List.of("Dalia", "Elias"));
                put("Carlos", List.of("Fatima", "Gustavo"));
                put("Dalia", List.of("Hassan", "Isla"));
                put("Elias", List.of("Javier"));
                put("Fatima", List.of("Khadija", "Liam"));
                put("Gustavo", List.of("Mina"));
                put("Hassan", List.of("Noah", "Olga"));
                put("Isla", List.of("Pedro"));
                put("Javier", List.of("Quynh", "Ravi"));
                put("Khadija", List.of("Sofia"));
                put("Liam", List.of("Tariq", "Uma"));
                put("Mina", List.of("Viktor", "Wang"));
                put("Noah", List.of("Xiomara"));
                put("Olga", List.of("Yuki"));
                put("Pedro", List.of("Zane", "Aditi"));
                put("Quynh", List.of("Boris"));
                put("Ravi", List.of("Celine"));
                put("Sofia", List.of("Diego", "Elif"));
                put("Tariq", List.of("Farah"));
                put("Uma", List.of("Giorgio"));
                put("Viktor", List.of("Hana", "Ian"));
                put("Wang", List.of("Jing"));
                put("Xiomara", List.of("Kaito"));
                put("Yuki", List.of("Leila"));
                put("Zane", List.of("Mateo"));
                put("Aditi", List.of("Nia"));
                put("Boris", List.of("Oscar"));
                put("Celine", List.of("Priya"));
                put("Diego", List.of("Qi"));
                put("Elif", List.of("Rami"));
                put("Farah", List.of("Sven"));
                put("Giorgio", List.of("Tomoko"));
                put("Hana", List.of("Umar"));
                put("Ian", List.of("Vera"));
                put("Jing", List.of("Wyatt"));
                put("Kaito", List.of("Xia"));
                put("Leila", List.of("Yassin"));
                put("Mateo", List.of("Zara"));
                put("Nia", List.of("Antonio"));
                put("Oscar", List.of("Bianca"));
                put("Priya", List.of("Cai"));
                put("Qi", List.of("Dimitri"));
                put("Rami", List.of("Ewa"));
                put("Sven", List.of("Fabio"));
                put("Tomoko", List.of("Gabriela"));
                put("Umar", List.of("Helena"));
                put("Vera", List.of("Igor"));
                put("Wyatt", List.of("Jun"));
                put("Xia", List.of("Kim"));
                put("Yassin", List.of("Lucia"));
                put("Zara", List.of("Mohammed"));
            }
        };
        RelativeDistance rd5 = new RelativeDistance(familyTree5);
        //rd5.imprimirDescendencia();
        System.out.println(rd5.degreeOfSeparation("Fabio", "Dimitri"));
        //assertThat(rd5.degreeOfSeparation("Dimitri", "Fabio")).isEqualTo(9);

        Map<String, List<String>> familyTree6 = new HashMap<>() {
            {
                put("Aiko", List.of("Bao", "Carlos"));
                put("Bao", List.of("Dalia", "Elias"));
                put("Carlos", List.of("Fatima", "Gustavo"));
                put("Dalia", List.of("Hassan", "Isla"));
                put("Elias", List.of("Javier"));
                put("Fatima", List.of("Khadija", "Liam"));
                put("Gustavo", List.of("Mina"));
                put("Hassan", List.of("Noah", "Olga"));
                put("Isla", List.of("Pedro"));
                put("Javier", List.of("Quynh", "Ravi"));
                put("Khadija", List.of("Sofia"));
                put("Liam", List.of("Tariq", "Uma"));
                put("Mina", List.of("Viktor", "Wang"));
                put("Noah", List.of("Xiomara"));
                put("Olga", List.of("Yuki"));
                put("Pedro", List.of("Zane", "Aditi"));
                put("Quynh", List.of("Boris"));
                put("Ravi", List.of("Celine"));
                put("Sofia", List.of("Diego", "Elif"));
                put("Tariq", List.of("Farah"));
                put("Uma", List.of("Giorgio"));
                put("Viktor", List.of("Hana", "Ian"));
                put("Wang", List.of("Jing"));
                put("Xiomara", List.of("Kaito"));
                put("Yuki", List.of("Leila"));
                put("Zane", List.of("Mateo"));
                put("Aditi", List.of("Nia"));
                put("Boris", List.of("Oscar"));
                put("Celine", List.of("Priya"));
                put("Diego", List.of("Qi"));
                put("Elif", List.of("Rami"));
                put("Farah", List.of("Sven"));
                put("Giorgio", List.of("Tomoko"));
                put("Hana", List.of("Umar"));
                put("Ian", List.of("Vera"));
                put("Jing", List.of("Wyatt"));
                put("Kaito", List.of("Xia"));
                put("Leila", List.of("Yassin"));
                put("Mateo", List.of("Zara"));
                put("Nia", List.of("Antonio"));
                put("Oscar", List.of("Bianca"));
                put("Priya", List.of("Cai"));
                put("Qi", List.of("Dimitri"));
                put("Rami", List.of("Ewa"));
                put("Sven", List.of("Fabio"));
                put("Tomoko", List.of("Gabriela"));
                put("Umar", List.of("Helena"));
                put("Vera", List.of("Igor"));
                put("Wyatt", List.of("Jun"));
                put("Xia", List.of("Kim"));
                put("Yassin", List.of("Lucia"));
                put("Zara", List.of("Mohammed"));
            }
        };
        RelativeDistance rd6 = new RelativeDistance(familyTree6);
        //rd6.imprimirDescendencia();
        System.out.println(rd6.degreeOfSeparation("Lucia", "Jun"));
        //assertThat(rd6.degreeOfSeparation("Lucia", "Jun")).isEqualTo(14);

        Map<String, List<String>> familyTree7 = new HashMap<>() {
            {
                put("Aiko", List.of("Bao", "Carlos"));
                put("Bao", List.of("Dalia"));
                put("Carlos", List.of("Fatima", "Gustavo"));
                put("Dalia", List.of("Hassan", "Isla"));
                put("Fatima", List.of("Khadija", "Liam"));
                put("Gustavo", List.of("Mina"));
                put("Hassan", List.of("Noah", "Olga"));
                put("Isla", List.of("Pedro"));
                put("Javier", List.of("Quynh", "Ravi"));
                put("Khadija", List.of("Sofia"));
                put("Liam", List.of("Tariq", "Uma"));
                put("Mina", List.of("Viktor", "Wang"));
                put("Noah", List.of("Xiomara"));
                put("Olga", List.of("Yuki"));
                put("Pedro", List.of("Zane", "Aditi"));
                put("Quynh", List.of("Boris"));
                put("Ravi", List.of("Celine"));
                put("Sofia", List.of("Diego", "Elif"));
                put("Tariq", List.of("Farah"));
                put("Uma", List.of("Giorgio"));
                put("Viktor", List.of("Hana", "Ian"));
                put("Wang", List.of("Jing"));
                put("Xiomara", List.of("Kaito"));
                put("Yuki", List.of("Leila"));
                put("Zane", List.of("Mateo"));
                put("Aditi", List.of("Nia"));
                put("Boris", List.of("Oscar"));
                put("Celine", List.of("Priya"));
                put("Diego", List.of("Qi"));
                put("Elif", List.of("Rami"));
                put("Farah", List.of("Sven"));
                put("Giorgio", List.of("Tomoko"));
                put("Hana", List.of("Umar"));
                put("Ian", List.of("Vera"));
                put("Jing", List.of("Wyatt"));
                put("Kaito", List.of("Xia"));
                put("Leila", List.of("Yassin"));
                put("Mateo", List.of("Zara"));
                put("Nia", List.of("Antonio"));
                put("Oscar", List.of("Bianca"));
                put("Priya", List.of("Cai"));
                put("Qi", List.of("Dimitri"));
                put("Rami", List.of("Ewa"));
                put("Sven", List.of("Fabio"));
                put("Tomoko", List.of("Gabriela"));
                put("Umar", List.of("Helena"));
                put("Vera", List.of("Igor"));
                put("Wyatt", List.of("Jun"));
                put("Xia", List.of("Kim"));
                put("Yassin", List.of("Lucia"));
                put("Zara", List.of("Mohammed"));
            }
        };
        RelativeDistance rd7 = new RelativeDistance(familyTree7);
        System.out.println(rd7.degreeOfSeparation("Wyatt", "Xia"));

        //assertThat(rd7.degreeOfSeparation("Wyatt", "Xia")).isEqualTo(12);

        /*Map<String, List<String>> familyTreePrueba = new HashMap<>() {
            {
                put("Helena", List.of("Isla", "Tariq", "Robert"));
                put("Isla", List.of("Uma"));
                put("Tariq", List.of("Morphy", "Elsa"));
                put("Robert", List.of("Ema"));
            }
        };

        RelativeDistance familia1 = new RelativeDistance(familyTreePrueba);
        System.out.println(familia1.degreeOfSeparation("Tariq", "Uma"));*/








    }
}


class RelativeDistance {

    private Map<String, List<String>> familyTree= new HashMap<>();
    private Set<String> familiaSet =  new HashSet<>();

    RelativeDistance(Map<String, List<String>>  familiaTree) {

        for (Map.Entry<String, List<String>> entry : familiaTree.entrySet()) {
            String parent = entry.getKey();
            List<String> children = entry.getValue();

            // 1. Conexión Padre <-> Hijo (como ya lo hacías)
            for (String child : children) {
                this.familyTree.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
                this.familyTree.computeIfAbsent(child, k -> new ArrayList<>()).add(parent);
            }

            // 2. ¡EL TRUCO MÁGICO!: Conectar a los hermanos entre sí directamente
            for (int i = 0; i < children.size(); i++) {
                for (int j = i + 1; j < children.size(); j++) {
                    String hermano1 = children.get(i);
                    String hermano2 = children.get(j);

                    this.familyTree.computeIfAbsent(hermano1, k -> new ArrayList<>()).add(hermano2);
                    this.familyTree.computeIfAbsent(hermano2, k -> new ArrayList<>()).add(hermano1);
                }
            }
        }

        //agregarlo a un Set para buscar hermanos de un nodo
        this.familyTree.forEach((clave, valor) -> {
            this.familiaSet.add(clave);
            this.familiaSet.addAll(valor);
        });
    }

    public int degreeOfSeparation(String personA, String personB) {
            if (personA.equals(personB)) return 0;



            // 2. BFS Estándar sobre el nuevo grafo bidireccional
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            queue.add(personA);
            visited.add(personA);
            int edgesCount = 0;

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    String currentNode = queue.poll();

                    if (currentNode.equals(personB)) {
                        // Si la métrica pide "personas intermedias", restamos 1 a los saltos totales
                        return edgesCount;
                        //return edgesCount - 1;
                    }

                    // Buscamos tanto hacia arriba (padres) como hacia abajo (hijos)
                    for (String neighbor : this.familyTree.getOrDefault(currentNode, new ArrayList<>())) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.add(neighbor);
                        }
                    }
                }
                edgesCount++; // Avanzamos un nivel en el árbol familiar
            }

            return -1; // Retorna -1 si de verdad no están conectados en el mismo árbol
    }

    // 3. imprimir descendencia
    public void imprimirDescendencia() {
        for (String persona : familyTree.keySet()) {
            List<String> hijos = familyTree.get(persona);
            if (!hijos.isEmpty()) {
                System.out.println(persona + " es progenitor de: " + hijos);
            } else {
                System.out.println(persona + " no tiene descendencia registrada.");
            }
        }
    }

    //esta clase era importantisima para ver si habia hermanos del nodo inicial
    public Set<String> imprimirHermanos(String persona) {

        //ArrayList<String> listaHermanos = new ArrayList<>();
        Set<String> listaHermanosSet = new HashSet<>();

        if(!familiaSet.contains(persona)) {
            System.out.println(String.format("%s no esta registrado.", persona));
            return listaHermanosSet;
        }

        // 1. Identificar quiénes son los padres de la persona
        List<String> padres = familyTree.entrySet().stream()
                .filter(entry -> entry.getValue().contains(persona))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        //System.out.println("Padres: " + padres);

        // 2. Buscar todos los hijos de esos padres y agruparlos en un Set para evitar duplicados
        Set<String> hermanos = padres.stream()
                .flatMap(padre -> familyTree.get(padre).stream())
                .collect(Collectors.toSet());

        // 3. Un paso crítico de lógica: tú no puedes ser tu propio hermano
        hermanos.remove(persona);
        //System.out.println("Hermanos: " + hermanos);

        if(hermanos.isEmpty()) {
            System.out.println(String.format("%s no tiene hemanos registrados ", persona));
            //return listaHermanos;
            return listaHermanosSet;
        }

        return hermanos;
    }

    RelativeDistance() {
        this.familyTree = new LinkedHashMap<>();
    }

    //registrar a la persona si no existe en el arbol genealogico
    public void registrarPersona(String nombre){
        this.familyTree.putIfAbsent(nombre, new ArrayList<>());
    }

    // metodo para definir la relacion padre e hijo,
    public void agregarRelacion(String padreOMadre, String hijo) {
        // Aseguramos que ambos nodos existan en nuestro grafo
        registrarPersona(padreOMadre);
        registrarPersona(hijo);

        //agregar al Set
        this.familiaSet.add(padreOMadre);
        this.familiaSet.add(hijo);

        // Solo la lista del progenitor recibe al hijo. No lo hacemos al revés.
        this.familyTree.get(padreOMadre).add(hijo);
        this.familyTree.get(hijo).add(padreOMadre);
    }



}
//System.out.println(found);
//if(found){
//return distance;
//}else{
//System.out.println("hello thereeeee");
//Set<String> listaHermanos = this.imprimirHermanos(start);
//System.out.println(listaHermanos);
//System.out.println(tieneHermanos);


//ultima verificacion son los nodos hermanos
//boolean tieneHermanos = (!this.imprimirHermanos(start).isEmpty());
            /*System.out.println("tiene hermanos");
            if(tieneHermanos){
                Set<String> setHermanos = this.imprimirHermanos(start);

                if(setHermanos.contains(target)) {
                    distance++;
                    return distance;
                }
            }*/
//}



    /*
    int degreeOfSeparation(String start, String target) {
        int targetFound = -1;

        targetFound = degreeSeparationHijosInicio(start, target);

        if(targetFound != -1){
            return targetFound;
        }


        boolean tieneHermanos = (!this.imprimirHermanos(start).isEmpty());

        if(tieneHermanos) {

            ArrayList<String> listaHermanos = new ArrayList<>(this.imprimirHermanos(start));
            int distanciaTotal = 0;
            System.out.println("tiene hermanos");

            for(String hermano : listaHermanos) {
                distanciaTotal++;
                String currentPerson = hermano;

                targetFound = degreeSeparationHijosInicio(currentPerson, target);

                if(targetFound != -1) {
                    return distanciaTotal + targetFound;
                }
            }
        }

        return targetFound;
    }

    public int degreeSeparationHijosInicio(String start, String target) {
        if (start.equals(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        int distance = 0;

        System.out.println(queue);
        System.out.println(visited);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.println("cantidad de nodos a comparar " + levelSize);
            System.out.println("gente fila comparar: " + queue);

            for (int i = 0; i < levelSize; i++) {

                String currentNode = queue.poll();

                System.out.println(currentNode);

                if (currentNode.equals(target)) {
                    System.out.println("se encontro!!!!!!!");
                    return distance;
                }

                for (String neighbor : familyTree.getOrDefault(currentNode, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }

            }
            distance++;
        }
        return -1;
    }*/