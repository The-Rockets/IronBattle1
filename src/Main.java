public class Main {

    public static void main(String[] args) {

        Warrior warrior1 = new Warrior("Thor ");
        Wizard wizard1 = new Wizard("jaina ");

        int hpWarrior = warrior1.getHp();
        int hpWizzard = wizard1.getHp();
        int round = 0;
        boolean segundabatalla = false;


        System.out.println(warrior1.toString());
        System.out.println(wizard1.toString());

        battle(warrior1,wizard1);

    }

    public static void battle(Character warrior1, Character wizard1){
        while (warrior1.getHp()>0 && wizard1.getHp()>0) {
            warrior1.attack(wizard1);
            wizard1.attack(warrior1);
        }
        if(warrior1.isAlive()){
            System.out.println(warrior1.getName()+" has won the battle");
        } else if (wizard1.isAlive()) {
            System.out.println(wizard1.getName()+" has won the battle");
        }else{
            battle(warrior1,wizard1);
        }
    }


}
