import java.io.*;

public class Main {

    public Main() {
    }

    public static void main(String[] args) throws FileNotFoundException {

        Warrior warrior1 = new Warrior("Thor ");
        Wizard wizard1 = new Wizard("jaina ");

        int round = 1;

        System.out.println(warrior1);
        System.out.println(wizard1);

        battle(warrior1,wizard1,round);

       // battleLogTXT();
        //
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
            System.err.println(warrior1.getName()+" has won the battle");
        } else if (wizard1.isAlive()) {
            System.err.println(wizard1.getName()+" has won the battle");
        }else{
            //aqui deberia empezar el desempate
            round=0;
            battle(warrior1,wizard1,round);
        }
    }


    private static void battleLogTXT() throws FileNotFoundException {
        File file = new File("battleLog.txt");
        PrintStream printStream = new PrintStream(file);
        System.setOut(printStream);
    }





}
