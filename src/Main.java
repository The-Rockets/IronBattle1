public class Main {

    public static void main(String[] args) {

        Character char1=new Warrior("Warrior");
        Character char2=new Wizard("Wizard");

        System.out.println(char1.toString());
        System.out.println(char2.toString());

        battle(char1,char2);

        System.out.println(char1.toString());
        System.out.println(char2.toString());

        char1.restoreParameters();
        char2.restoreParameters();
        System.out.println(char1.toString());
        System.out.println(char2.toString());

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
