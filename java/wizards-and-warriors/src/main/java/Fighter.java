class principal{
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior();
        warrior1.toString();
        warrior1.isVulnerable();
        Wizard wizard  = new Wizard();
        System.out.println(wizard.isVulnerable());
        System.out.println(warrior1.getDamagePoints(wizard));
        System.out.println(warrior1.getDamagePoints(new Warrior()));

    }
}

class Fighter {
    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

// TODO: define the Warrior class
class Warrior extends Fighter {
    private boolean vulnerable;

    public Warrior() {
        this.vulnerable = false;
    }

    public boolean isVulnerable() {
        return this.vulnerable;
    }

    public String toString() {
        return "Fighter is a Warrior";
    }

    public int getDamagePoints(Fighter fighter) {

        int damagePoints;
        damagePoints = (fighter.isVulnerable()) ?  10 : 6;
        return damagePoints;
    }

}

// TODO: define the Wizard class
class Wizard extends Fighter {

    private boolean vulnerable;

    public Wizard() {
        this.vulnerable = true;
    }

    public void prepareSpell(){
        this.vulnerable = false;
    }

    public boolean isVulnerable() {
        return this.vulnerable;
    }

    public String toString() {
        return "Fighter is a Wizard";
    }

    public int getDamagePoints(Fighter fighter) {

        int damagePoints;
        damagePoints = (this.isVulnerable()) ?  3 : 12;
        return damagePoints;
    }
}

/*
* /*System.out.println(warrior1.getDamagePoints(new Warrior()));

        Wizard wizard2 = new Wizard();
        System.out.println(wizard2.isVulnerable());
        System.out.println(wizard2.getDamagePoints(warrior1));
        wizard2.prepareSpell();
        System.out.println(wizard2.isVulnerable());
        System.out.println(wizard2.getDamagePoints(warrior1));*/
