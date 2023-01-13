public class Main {
    public static void main(String[] args) {

        Warrior warrior1 = new Warrior("Arthas");
        Wizard wizard1 = new Wizard("Jaina");

        System.out.println(warrior1);
        System.out.println("stamina: " + warrior1.getStamina());
        System.out.println("Strenght: " + warrior1.getStrenght());
        System.out.println(wizard1);
        System.out.println("Inelligence : " + wizard1.getIntelligence());
        System.out.println("Mana: : " + wizard1.getMana());


        wizard1.attack(warrior1);


    }
}