class Principal{
    public static void main(String[] args) {

        Character character = new Character();
        character.setCharacterClass("Warrior");
        character.setLevel(16);
        character.setHitPoints(89);
        System.out.println(new GameMaster().describe(character));

        Character character2 = new Character();
        character2.setCharacterClass("Wizard");
        character2.setLevel(7);
        character2.setHitPoints(33);
        System.out.println(new GameMaster().describe(character2));

        Destination destination = new Destination();
        destination.setName("Tol Honeth");
        destination.setInhabitants(41);
        System.out.println(new GameMaster().describe(destination));

        Destination destination2 = new Destination();
        destination2.setName("Ashaba");
        destination2.setInhabitants(1500);
        System.out.println(new GameMaster().describe(destination2));

        System.out.println(new GameMaster().describe(TravelMethod.WALKING));
        System.out.println(new GameMaster().describe(TravelMethod.HORSEBACK));

        Character character3 = new Character();
        character3.setCharacterClass("Wizard");
        character3.setLevel(20);
        character3.setHitPoints(120);
        Destination destination3 = new Destination();
        destination3.setName("Camaar");
        destination3.setInhabitants(999);
        System.out.println(new GameMaster().describe(character3, destination3, TravelMethod.HORSEBACK));

        Character character4 = new Character();
        character4.setCharacterClass("Warrior");
        character4.setLevel(1);
        character4.setHitPoints(30);
        Destination destination4 = new Destination();
        destination4.setName("Vo Mimbre");
        destination4.setInhabitants(332);
        System.out.println(new GameMaster().describe(character4, destination4));




        /*Character character = new Character();
        character.setCharacterClass("Wizard");
        character.setLevel(4);
        character.setHitPoints(28);
        System.out.println(new GameMaster().describe(character));

        Destination destination = new Destination();
        destination.setName("Muros");
        destination.setInhabitants(732);
        System.out.println(new GameMaster().describe(destination));

        System.out.println(new GameMaster().describe(TravelMethod.HORSEBACK));

        System.out.println(new GameMaster().describe(character, destination, TravelMethod.WALKING));

        System.out.println(new GameMaster().describe(character, destination));*/

    }
}


public class GameMaster {

    public String describe(Character personaje){
        String clasePersonaje = personaje.getCharacterClass();
        int nivelPersonaje = personaje.getLevel();
        int hitPointsPersonaje = personaje.getHitPoints();

        return String.format("You're a level %d %s with %d hit points.",
                            nivelPersonaje,
                            clasePersonaje,
                            hitPointsPersonaje);
    }

    public String describe(Destination destino){
        String nombreDestino = destino.getName();
        int inhabitantsNumber = destino.getInhabitants();

        return String.format("You've arrived at %s, which has %d inhabitants.",
                                    nombreDestino,
                                    inhabitantsNumber);
    }

    public String describe(TravelMethod metodoViaje){
        String descripcionViaje = (metodoViaje == TravelMethod.HORSEBACK)
                ? "You're traveling to your destination on horseback."
                : "You're traveling to your destination by walking.";

        return descripcionViaje;
    }

    public String describe(Character personaje, Destination destino, TravelMethod metodoViaje){
        String descripcionPersonaje = this.describe(personaje);
        String descripcionDestino = this.describe(destino);
        String descripcionTravel = this.describe(metodoViaje);

        return String.format("%s %s %s",
                descripcionPersonaje, descripcionTravel, descripcionDestino);
    }

    public String describe(Character personaje, Destination destino){
        String descripcionPersonaje = this.describe(personaje);
        String descripcionDestino = this.describe(destino);
        //por default si no se menciona el metodo de viaje es caminando
        String formaViaje = this.describe(TravelMethod.WALKING);

        return String.format("%s %s %s",
                descripcionPersonaje, formaViaje, descripcionDestino);
    }

    // TODO: define a 'describe' method that returns a description of a Character

    // TODO: define a 'describe' method that returns a description of a Destination

    // TODO: define a 'describe' method that returns a description of a TravelMethod

    // TODO: define a 'describe' method that returns a description of a Character, Destination and TravelMethod

    // TODO: define a 'describe' method that returns a description of a Character and Destination
}
