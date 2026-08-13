import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
class principal{
    public static void main(String[] args) {

        System.out.println(GottaSnatchEmAll.newCollection(new LinkedList<>()));
        System.out.println(GottaSnatchEmAll.newCollection(List.of("Bleakachu")));
        System.out.println(GottaSnatchEmAll.newCollection(List.of("Bleakachu", "Bleakachu")));
        System.out.println(GottaSnatchEmAll.newCollection(List.of("Bleakachu", "Newthree")));

        Set<String> collection = new HashSet<>();
        System.out.println(GottaSnatchEmAll.addCard("Veevee", collection));
        System.out.println(GottaSnatchEmAll.addCard("Veevee", collection));

        Set<String> collection2 = new HashSet<>();
        Set<String> expected2 = Set.of("Veevee");
        System.out.println(GottaSnatchEmAll.addCard("Veevee", collection2));
        System.out.println(collection2.containsAll(expected2));

        Set<String> collection3 = new HashSet<>(Set.of("Veevee"));
        Set<String> expected3 = Set.of("Veevee");
        System.out.println(GottaSnatchEmAll.addCard("Veevee", collection3));
        System.out.println(collection3.containsAll(expected3));

        Set<String> collection4 = new HashSet<>();
        Set<String> expected4 = new HashSet<>();
        System.out.println(GottaSnatchEmAll.canTrade(collection4, expected4));

        Set<String> myCollection5 = new HashSet<>();
        Set<String> theirCollection5 = new HashSet<>(Set.of("Bleakachu"));
        System.out.println(GottaSnatchEmAll.canTrade(myCollection5, theirCollection5));

        Set<String> myCollection6 = new HashSet<>(Set.of("Bleakachu"));
        Set<String> theirCollection6 = new HashSet<>();
        System.out.println(GottaSnatchEmAll.canTrade(myCollection6, theirCollection6));

        Set<String> myCollection7 = new HashSet<>(Set.of("Gyros", "Garilord"));
        Set<String> theirCollection7 = new HashSet<>(Set.of("Garilord", "Gyros"));
        System.out.println(GottaSnatchEmAll.canTrade(myCollection7, theirCollection7));

        Set<String> myCollection8 = new HashSet<>(Set.of("Gyros"));
        Set<String> theirCollection8 = new HashSet<>(Set.of("Garilord"));
        System.out.println(GottaSnatchEmAll.canTrade(myCollection8, theirCollection8));

        Set<String> myCollection9 = new HashSet<>(Set.of("Gyros", "Garilord", "Bleakachu"));
        Set<String> theirCollection9 = new HashSet<>(Set.of("Garilord", "Veevee", "Gyros"));
        System.out.println(GottaSnatchEmAll.canTrade(myCollection9, theirCollection9));

        Set<String> myCollection10 = new HashSet<>(Set.of("Gyros", "Garilord"));
        Set<String> theirCollection10 = new HashSet<>(Set.of("Garilord", "Veevee", "Gyros"));
        System.out.println(GottaSnatchEmAll.canTrade(myCollection10, theirCollection10));

        Set<String> myCollection11 = new HashSet<>(Set.of("Garilord", "Veevee", "Gyros"));
        Set<String> theirCollection11 = new HashSet<>(Set.of("Gyros", "Garilord"));
        System.out.println(GottaSnatchEmAll.canTrade(myCollection11, theirCollection11));

        List<Set<String>> collections = List.of(
                Set.of("Veevee"),
                Set.of("Bleakachu"),
                Set.of("Wigglycream")
        );
        System.out.println(GottaSnatchEmAll.commonCards(collections));

        List<Set<String>> collections2 = List.of(
                Set.of("Veevee", "Wigglycream", "Mayofried")
        );
        System.out.println(GottaSnatchEmAll.commonCards(collections2));

        List<Set<String>> collections3 = List.of(
                Set.of("Veevee", "Wigglycream", "Mayofried"),
                Set.of("Cooltentbro", "Mayofried", "Wigglycream"),
                Set.of("Gyros", "Wigglycream", "Shazam")
        );
        System.out.println(GottaSnatchEmAll.commonCards(collections3));

        List<Set<String>> collections4 = List.of(
                Set.of("Veevee", "Wigglycream", "Mayofried")
        );
        System.out.println(GottaSnatchEmAll.allCards(collections4));

        List<Set<String>> collections5 = List.of(
                Set.of("Veevee", "Wigglycream", "Mayofried"),
                Set.of("Gyros", "Wigglycream", "Shazam"),
                Set.of("Cooltentbro", "Mayofried", "Wigglycream")
        );
        System.out.println(GottaSnatchEmAll.allCards(collections5));
    }
}
class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        Set<String> set = new HashSet<>(cards);
        return set;
    }

    static boolean addCard(String card, Set<String> collection) {
        boolean isCardInSet = collection.contains(card);
        boolean cardAddedSet;

        if(!isCardInSet) {
            collection.add(card);
            cardAddedSet = true;
        }else{
            System.out.println("Ya existe carta en el set");
            cardAddedSet = false;
        }
        return cardAddedSet;
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {

        if(myCollection.isEmpty() || theirCollection.isEmpty()) {
            System.out.println("al menos uno de las colecciones estan vacios");
            return false;
        }

        Set<String> copyMyySet = new HashSet<>(myCollection);
        Set<String> copyTheirSet = new HashSet<>(theirCollection);

        boolean setOneContainsNewCard = false;
        boolean setTwoContainsNewCard = false;

        for(String card : copyMyySet) {
            if(!copyTheirSet.contains(card)) {
                setOneContainsNewCard = true;
            }
        }
        for(String card : copyTheirSet) {
            if(!copyMyySet.contains(card)) {
                setTwoContainsNewCard = true;
            }
        }
        return setOneContainsNewCard && setTwoContainsNewCard;

    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> getCommonCards = GottaSnatchEmAll.compararCartas(collections, "getCommonCards");
        return getCommonCards;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> getAllCards = GottaSnatchEmAll.compararCartas(collections, "getAllCards");
        return getAllCards;
    }

    static Set<String> compararCartas(List<Set<String>> collections, String accion){
        //verificar si el set tiene al menos dos colecciones
        int listSize = collections.size();
        Set<String> getCards;

        if(listSize < 2) {
            //si la lista esta vacia
            if(collections.isEmpty()) {
                System.out.println("set esta vacio");
                getCards = new HashSet<>();
                return getCards;
            }
            getCards = new HashSet<>(collections.get(0));
            return getCards;

        }else{
            //si hay almenos dos colecciones en la lista
            getCards = new HashSet<>(collections.get(0));

            for(int i = 1; i < listSize; i++){
                Set<String> setComparar = new HashSet<>(collections.get(i));
                if("getCommonCards".equals(accion)){
                    getCards.retainAll(setComparar);
                }else if("getAllCards".equals(accion)){
                    getCards.addAll(setComparar);
                }
            }
        }
        return getCards;
    }
}
