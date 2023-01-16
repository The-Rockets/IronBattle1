public class Main {

    public static void main(String[] args) {

        Warrior warrior1 = new Warrior("Thor ");
        Wizard wizard1 = new Wizard("jaina ");

        int hpWarrior = warrior1.getHp();
        int hpWizzard = wizard1.getHp();
        int round = 1;
        boolean segundabatalla = false;


        System.out.println(warrior1);
        System.out.println(wizard1);

        battle(warrior1,wizard1,round);

    }

    public static void battle(Character warrior1, Character wizard1,int round){
        while (warrior1.isAlive() && wizard1.isAlive()) {
            System.out.println("--------"+"ROUND: "+round+"--------");
            warrior1.attack(wizard1);
            wizard1.attack(warrior1);
            round++;
            System.out.println("------------------------------------");
            System.out.println(" Warrior HP: " + warrior1.getHp());
            System.out.println(" Wizard HP: " + wizard1.getHp());
        }
        if(warrior1.isAlive()){
            System.out.println(warrior1.getName()+" has won the battle");
        } else if (wizard1.isAlive()) {
            System.out.println(wizard1.getName()+" has won the battle");
        }else{//aqui deberia empezar el desempate
            round=0;
            battle(warrior1,wizard1,round);
        }
    }


}
