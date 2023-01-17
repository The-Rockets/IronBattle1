import java.io.*;
import java.util.List;
import java.util.Random;

public class Main {

    public Main() {
    }

    public static void main(String[] args) throws FileNotFoundException {

        //Warrior warrior = new Warrior("Thor ");
        //Wizard wizard1 = new Wizard("jaina ");

        List<String> warriors = CsvReader.readWarriors("./src/warriors.csv");
        List<String> wizards = CsvReader.readWarriors("./src/wizards.csv");
        Random rand = new Random();
        int randomIndex1 = rand.nextInt(warriors.size());
        int randomIndex2 = rand.nextInt(wizards.size());

        Character warrior = new Warrior(warriors.get(randomIndex1).trim());
        Character wizard = new Warrior(wizards.get(randomIndex2).trim());
        System.out.println("Warrior 1 selected randomly: " + warrior);
        System.out.println("Warrior 2 selected randomly: " + wizard);


        //System.out.println(warrior);
        //System.out.println(wizard1);

        battle(warrior,wizard,round);

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
