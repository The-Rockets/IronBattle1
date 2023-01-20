

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {


 

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        //int hp = statsFilter(100,200);

        System.out.println(" Welcome To Iron Battle");
        TimeUnit.SECONDS.sleep(1);


        List<Character>characterList = Menu.characterChoiseMenu();
// Menu de inicio

        Character userCharacter = characterList.get(0);
        Character rndCharacter = characterList.get(1);


        Menu.startBattleMenu(userCharacter, rndCharacter);

        //battleLogTXT();





        /*

        List<String> warriors = CsvReader.readWarriors("./src/warriors.csv");
        List<String> wizards = CsvReader.readWarriors("./src/wizards.csv");
        Random rand = new Random();
        int randomIndex1 = rand.nextInt(warriors.size());
        int randomIndex2 = rand.nextInt(wizards.size());

        Character warrior = new Warrior(warriors.get(randomIndex1).trim());
        Character wizard = new Wizard(wizards.get(randomIndex2).trim());
        System.out.println("Character 1 selected randomly: " + warrior);
        System.out.println("Character 2 selected randomly: " + wizard);

        TimeUnit.SECONDS.sleep(2);

        System.out.println("PREPARE FOR BATTLE");

         */

        //System.out.println(warrior);
        //System.out.println(wizard1);

        //battle(warrior,wizard);

        //
        //
    }


}
