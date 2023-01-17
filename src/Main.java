public class Main {

    public static void main(String[] args) {

        Character war1=new Warrior("Warrior 1");
        Character war2=new Wizard("Wizard 2");

        System.out.println(war1.toString());
        System.out.println(war2.toString());

        battle(war1,war2);

        System.out.println(war1.toString());
        System.out.println(war2.toString());

        war1.restoreParameters();
        war2.restoreParameters();
        System.out.println(war1.toString());
        System.out.println(war2.toString());

    }

    public static void battle(Character character1, Character character2){
        while (character1.isAlive() && character2.isAlive()){
            character1.attack(character2);
            character2.attack(character1);
        }
        if(character1.isAlive()){
            System.out.println(character1.getName()+" has won the battle");
        } else if (character2.isAlive()) {
            System.out.println(character2.getName()+" has won the battle");
        }else{
            System.out.println(character1.getName() +" and " +character2.getName()+" have tied");
            character1.restoreParameters();
            character2.restoreParameters();
            battle(character1,character2);
        }
    }


}
