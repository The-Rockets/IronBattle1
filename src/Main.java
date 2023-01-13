public class Main {
    public static void main(String[] args) {

        Warrior warrior = new Warrior("Arthas");
        Wizard wizard = new Wizard("Jaina");

        System.out.println(warrior);
        System.out.println("stamina: " + warrior.getStamina());
        System.out.println("Strenght: " + warrior.getStrenght());
        System.out.println(wizard);
        System.out.println("Inelligence : " + wizard.getIntelligence());
        System.out.println("Mana: : " + wizard.getMana());


    }
}