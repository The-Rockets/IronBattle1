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
        Character wizard = new Wizard(wizards.get(randomIndex2).trim());
        System.out.println("Warrior 1 selected randomly: " + warrior);
        System.out.println("Warrior 2 selected randomly: " + wizard);


        //System.out.println(warrior);
        //System.out.println(wizard1);

        battle(warrior,wizard);

       // battleLogTXT();
        //
    }

    public static void battle(Character character1, Character character2){
        int round=1;
        while (character1.isAlive() && character2.isAlive()){
            System.out.println("======= Round "+round+" =======");
            character1.attack(character2);
            character2.attack(character1);
            round++;
        }
        System.out.println("===========================");
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


    private static void battleLogTXT() throws FileNotFoundException {
        File file = new File("battleLog.txt");
        PrintStream printStream = new PrintStream(file);
        System.setOut(printStream);
    }





}
