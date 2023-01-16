public class Main {

    public static void main(String[] args) {

        Warrior char1 = new Warrior("Andres");
        System.out.println(char1.getHp());
        System.out.println(char1.getStamina());
        System.out.println(char1.getStrength());
        System.out.println("===");
        Warrior char2 = new Warrior("Ant");
        System.out.println(char2.getHp());
        System.out.println(char2.getStamina());
        System.out.println(char2.getStrength());
        System.out.println("===");

        char1.weakAttack(char2);

        System.out.println(char1.getHp());
        System.out.println(char1.getStamina());
        System.out.println(char1.getStrength());
        System.out.println("===");
        System.out.println(char2.getHp());
        System.out.println(char2.getStamina());
        System.out.println(char2.getStrength());




    }


}