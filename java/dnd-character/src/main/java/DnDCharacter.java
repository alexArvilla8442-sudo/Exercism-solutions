import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Principal{
    public static void main(String[] args) {
        var dndPlayer = new DnDCharacter();
        System.out.println(dndPlayer.modifier(3));
        System.out.println(dndPlayer.modifier(4));
        System.out.println(dndPlayer.modifier(5));
        System.out.println(dndPlayer.modifier(6));
        System.out.println(dndPlayer.modifier(7));
        System.out.println(dndPlayer.modifier(8));
        System.out.println(dndPlayer.modifier(9));
        System.out.println(dndPlayer.modifier(10));
        System.out.println(dndPlayer.modifier(11));
        System.out.println(dndPlayer.modifier(12));
        System.out.println(dndPlayer.modifier(13));
        System.out.println(dndPlayer.modifier(14));
        System.out.println(dndPlayer.modifier(15));
        System.out.println(dndPlayer.modifier(16));
        System.out.println(dndPlayer.modifier(17));
        System.out.println(dndPlayer.modifier(18));

        System.out.println("segunda parte pruebas");
        //dndPlayer.rollDice();
        System.out.println(dndPlayer.rollDice().size());
        System.out.println(dndPlayer.rollDice().stream().allMatch(d -> d >= 1 && d <= 6));
        System.out.println(dndPlayer.ability(List.of(4, 3, 2, 1)));
        System.out.println(dndPlayer.ability(List.of(1, 2, 3, 4)));
        System.out.println(dndPlayer.ability(List.of(2, 4, 3, 1)));
        System.out.println(dndPlayer.ability(List.of(1, 1, 1, 1)));
        System.out.println(dndPlayer.ability(List.of(6, 6, 6, 6)));
        System.out.println(dndPlayer.ability(List.of(3, 5, 3, 4)));

        var dndCharacter = new DnDCharacter();
        List<Integer> scores1 = List.of(1, 2, 3, 4);
        dndCharacter.ability(scores1);
        System.out.println(scores1.size());
        System.out.println(scores1);

        System.out.println("tercer parte pruebas");

        for (int i = 0; i < 1000; i++) {

            var character = new DnDCharacter();

            int chStrength = character.getStrength();
            boolean isTrue1 = chStrength > 2 && chStrength < 19;
            //System.out.println(isTrue1);

            int chDexterity = character.getDexterity();
            boolean isTrue2 = chDexterity > 2 && chDexterity < 19;
            //System.out.println(isTrue2);

            int chConstitution = character.getConstitution();
            boolean isTrue3 = chConstitution > 2 && chConstitution < 19;
            //System.out.println(isTrue3);

            int chIntelligence = character.getIntelligence();
            boolean isTrue4 = chIntelligence > 2 && chIntelligence < 19;
            //System.out.println(isTrue4);

            int chWisdom = character.getWisdom();
            boolean isTrue5 = chWisdom > 2 && chWisdom < 19;
            //System.out.println(isTrue5);

            int chCharisma = character.getCharisma();
            boolean isTrue6 = chCharisma > 2 && chCharisma < 19;
            //System.out.println(isTrue6);

            int chModifier = character.modifier(chConstitution);
            int chHitpoints = character.getHitpoints();
            //System.out.println(chHitpoints);
            boolean isTrue7 = (chHitpoints == (10 + chModifier));
            //System.out.println(isTrue7);

            if(!isTrue1 || !isTrue2 || !isTrue3 || !isTrue4 || !isTrue5 || !isTrue6 || !isTrue7){
                System.out.println("fallo en el sistema ups en la posicion> " + i);
                System.out.println(isTrue7);
                break;
            }
        }

        System.out.println("************************************************");

        /*
        DnDCharacter character2 = new DnDCharacter();

        System.out.println(character2.getStrength() == character2.getStrength());
        System.out.println(character2.getDexterity() == character2.getDexterity());
        System.out.println(character2.getConstitution() == character2.getConstitution());
        System.out.println(character2.getIntelligence() == character2.getIntelligence());
        System.out.println(character2.getWisdom() == character2.getWisdom());
        System.out.println(character2.getCharisma() == character2.getCharisma());

        for (int i = 0; i < 1000; i++) {
            DnDCharacter character3 = new DnDCharacter();
            boolean diferenteFuerza = character2.getStrength() != character3.getStrength();
            boolean diferenteDexterity = character2.getDexterity() != character3.getDexterity();
            boolean diferenteConstitution = character2.getConstitution() != character3.getConstitution();
            boolean diferentIntelligence = character2.getIntelligence() != character3.getIntelligence();
            boolean differenteWisdom = character2.getWisdom() != character3.getWisdom();
            boolean differentCharisma = character2.getCharisma() != character3.getCharisma();
            boolean differentHitpoints = character2.getHitpoints() != character3.getHitpoints();

            boolean dnDCharactersHaveDifferentAttributes = (diferenteFuerza || diferenteDexterity || diferenteConstitution ||
                    diferentIntelligence || differenteWisdom || differentCharisma || differentHitpoints);

            if(!dnDCharactersHaveDifferentAttributes){
                System.out.println("error en el sistema");
                break;
            }

        }*/

        //assertThat(scores).containsExactly(1, 2, 3, 4);

        //System.out.println(dndPlayer.ability(List.of(1,2,3,4).size()));
    }
}



class DnDCharacter {

    //six abilities; strength, dexterity, constitution, intelligence, wisdom and charisma.
    //character's initial hitpoints are 10 + your character's constitution modifier.
    //constitution modifier by subtracting 10 from your character's constitution, divide by 2 and round down.

    //cada habilidad arrojar 4 dados, sumar los mayores 3. no contar el de menor
    //dado: 6, 5 ..... 1

    private int strength;
    private int dexterity;
    private int constitution = 0;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hitpoints;
    private int constitutionModifier;
    public DnDCharacter(){

        this.strength = this.ability(this.rollDice());
        this.constitution = this.ability(this.rollDice());
        this.dexterity = this.ability(this.rollDice());
        this.intelligence = this.ability(this.rollDice());
        this.wisdom = this.ability(this.rollDice());
        this.charisma = this.ability(this.rollDice());
        this.hitpoints = 10 + this.modifier();

    }

    int ability(List<Integer> scores) {
        //lista inmutable a mutable
        List<Integer> scoresCopy = new ArrayList<>(scores);
        scoresCopy.sort(null);
        int sumaTotal = 0;
        for(int i = 1; i < scoresCopy.size(); i++) {
            sumaTotal += scoresCopy.get(i);
        }
        return sumaTotal;

    }

    List<Integer> rollDice() {
        int numeroTirosDado = 4;
        Random random = new Random();
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < numeroTirosDado; i++) {
            int numeroAleatorio = random.nextInt(1, 6 + 1);
            scores.add(numeroAleatorio);
        }
        return scores;
    }

    int getStrength() {
        //this.strength = ability(this.rollDice());
        return this.strength;
    }

    int getDexterity() {
        //this.dexterity = ability(this.rollDice());
        return this.dexterity;
    }

    int getConstitution() {
        //this.constitution = ability(this.rollDice());
        return this.constitution;
    }

    int getIntelligence() {
        //this.intelligence = ability(this.rollDice());
        return this.intelligence;
    }

    int getWisdom() {
        //this.wisdom = ability(this.rollDice());
        return this.wisdom;
    }

    int getCharisma() {
        //this.charisma = ability(this.rollDice());
        return this.charisma;
    }

    int getHitpoints() {
        //this.hitpoints = 10 + this.modifier(this.constitution);
        return this.hitpoints;
    }

    int modifier(int input) {
        double modifierPart1 = ( (input - 10.0) /2);

        this.constitutionModifier = (int) Math.floor(modifierPart1);
        return this.constitutionModifier;
    }

    int modifier(){
        double modifierPart1;
        modifierPart1 = ( (this.constitution - 10.0) /2);
        this.constitutionModifier = (int) Math.floor(modifierPart1);
        return this.constitutionModifier;
    }

}
