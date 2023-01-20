

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public Main() {
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        //int hp = statsFilter(100,200);

        System.out.println(" Welcome To Iron Battle");
        TimeUnit.SECONDS.sleep(1);


        List<Character>characterList = characterChoiseMenu();
        // Menu de inicio

        Character userCharacter = characterList.get(0);
        Character rndCharacter = characterList.get(1);


        startBattleMenu(userCharacter, rndCharacter);




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

        // battleLogTXT();
        //
    }

    private static void startBattleMenu(Character userCharacter, Character rndCharacter) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 'C' --to  begin the battle"+"\n" +
                 "Press 'E' -- to exit the game."+"\n"+
                "Press 'B' -- back to START MENU.");
        String choice = scanner.next().toLowerCase();

        while (!choice.equals("c") && !choice.equals("e")&&!choice.equals("b")) {
            System.out.println("Invalid input. Please enter 'C' to continue, 'E' to exit the game or 'B' to start menu");
            choice = scanner.next().toLowerCase();
        }
        switch (choice) {
            case ("c"):
                battle(userCharacter, rndCharacter);
                break;
            case("e"):
                break;
            case ("b"):
                characterChoiseMenu();
                startBattleMenu(userCharacter, rndCharacter);
                break;
        }
    }

    public static void battle(Character character1, Character character2) throws InterruptedException {
        int round = 1;
        while (character1.isAlive() && character2.isAlive()) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("======== Round " + round + " ========");
            character1.attack(character2);
            character2.attack(character1);
            System.out.println("--------------------------------");
            System.out.println(character1.getName() + " HP: " + character1.getHp() + " | " + character2.getName() + " HP: " + character2.getHp());
            round++;
        }
        System.out.println("================================");
        TimeUnit.SECONDS.sleep(2);
        if (character1.isAlive()) {
            System.err.println(character1.getName() + " has won the battle");
            System.err.println("CONGRATULATIONS!!!" + character1.getName());
        } else if (character2.isAlive()) {
            System.err.println(character2.getName() + " has won the battle");
            System.err.println("CONGRATULATIONS!!!" + character2.getName());
        } else {
            System.err.println(character1.getName() + " and " + character2.getName() + " have tied");
            character1.restoreParameters();
            character2.restoreParameters();
            battle(character1, character2);
        }
        TimeUnit.SECONDS.sleep(2);
    }

    private static void battleLogTXT() throws FileNotFoundException {
        File file = new File("battleLog.txt");
        PrintStream printStream = new PrintStream(file);
        System.setOut(printStream);
    }

    public static Character randomCharacter() {
        List<String> warriors = CsvReader.readWarriors("./src/warriors.csv");
        List<String> wizards = CsvReader.readWarriors("./src/wizards.csv");
        Random rand = new Random();

        if (Math.random() > 0.5) {
            int randomIndex1 = rand.nextInt(warriors.size());
            Character warrior = new Warrior(warriors.get(randomIndex1).trim());
            return warrior;
        } else {
            int randomIndex2 = rand.nextInt(wizards.size());
            Character wizard = new Wizard(wizards.get(randomIndex2).trim());
            return wizard;
        }
    }

    public static List<Character> characterChoiseMenu() {
        Character userCharacter = null;
        Character rndCharacter = null;

        List<Character> characterList = new ArrayList<>();

        System.out.println("Do you want to create your own Character? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next().toLowerCase();


        while (!choice.equals("y") && !choice.equals("n")) {
            System.out.println("Invalid input. Please enter Y for Yes or N for No.");
            choice = scanner.next().toLowerCase();
        }
        switch (choice) {
            case ("y"):
                System.out.println("Press: "+"\n"+"1 - for Warrior"+"\n" + "2 - for Wizard");
                String choseCharacter = scanner.next();
                while (!choseCharacter.equals("1") && !choseCharacter.equals("2")) {
                    System.err.println("Invalid input. Please type:"+"\n"+"1 - for Warrior"+"\n" + "2 - for Wizard");
                    choseCharacter = scanner.next();
                }

                System.out.println("Name for your Character");
                String name = scanner.next();

                switch (choseCharacter) {
                    case ("1"):
                        int hp1 = statsFilter(100,200,"HP");
                        int stamina = statsFilter(10,50,"Stamina");
                        int strength = statsFilter(1,10,"Strength");
                        userCharacter = new Warrior(name,hp1,stamina,strength);
                        break;
                    case ("2"):
                        int hp2 = statsFilter(50,100,"HP");
                        int mana = statsFilter(10,50,"Mana");
                        int intelligence = statsFilter(1,50,"Intelligence");
                        userCharacter = new Wizard(name,hp2,mana,intelligence);
                        break;
                }
                rndCharacter = randomCharacter();
                if (userCharacter instanceof Warrior){
                System.out.println("============================================" + "\n" +
                        userCharacter.getName() + " " + userCharacter.getClass() + "  with HP:" + userCharacter.getHp()
                        + " || stamina: "+ ((Warrior) userCharacter).getStamina()+ " || Strength: "+ ((Warrior) userCharacter).getStrength()+"\n" +
                        "============= will fight against ================");
                }else if(userCharacter instanceof Wizard) {
                    System.out.println("============================================" + "\n" +
                            userCharacter.getName() + " " + userCharacter.getClass() + "  with HP:" + userCharacter.getHp()
                            + "| mana: " + ((Wizard) userCharacter).getMana() + " | intelligence: " + ((Wizard) userCharacter).getIntelligence() + "\n" +
                            "============= will fight against ================");
                }

                if (rndCharacter instanceof Warrior){
                    System.out.println(rndCharacter.getName() + " " + rndCharacter.getClass() + "  with HP:" + rndCharacter.getHp()
                            + " || stamina: "+ ((Warrior) rndCharacter).getStamina()+ " || Strength: "+ ((Warrior) rndCharacter).getStrength()
                            + "\n"+ "============================================");
                }else if(rndCharacter instanceof Wizard) {
                    System.out.println(rndCharacter.getName() + " " + rndCharacter.getClass() + "  with HP:" + rndCharacter.getHp()
                            + "| mana: " + ((Wizard) rndCharacter).getMana() + " | intelligence: " + ((Wizard) rndCharacter).getIntelligence()
                            + "\n"+ "============================================");
                }


                break;
            case ("n"):
                userCharacter = randomCharacter();
                rndCharacter = randomCharacter();
                if (userCharacter instanceof Warrior){
                    System.out.println("============================================" + "\n" +
                            userCharacter.getName() + " " + userCharacter.getClass() + "  with HP:" + userCharacter.getHp()
                            + " || stamina: "+ ((Warrior) userCharacter).getStamina()+ " || Strength: "+ ((Warrior) userCharacter).getStrength()+"\n" +
                            "============= will fight against ================");
                }else if(userCharacter instanceof Wizard) {
                    System.out.println("============================================" + "\n" +
                            userCharacter.getName() + " " + userCharacter.getClass() + "  with HP:" + userCharacter.getHp()
                            + "| mana: " + ((Wizard) userCharacter).getMana() + " | intelligence: " + ((Wizard) userCharacter).getIntelligence() + "\n" +
                            "============= will fight against ================");
                }

                if (rndCharacter instanceof Warrior){
                    System.out.println(rndCharacter.getName() + " " + rndCharacter.getClass() + "  with HP:" + rndCharacter.getHp()
                            + " || stamina: "+ ((Warrior) rndCharacter).getStamina()+ " || Strength: "+ ((Warrior) rndCharacter).getStrength()
                                    + "\n"+ "============================================");
                }else if(rndCharacter instanceof Wizard) {
                    System.out.println(rndCharacter.getName() + " " + rndCharacter.getClass() + "  with HP:" + rndCharacter.getHp()
                            + "| mana: " + ((Wizard) rndCharacter).getMana() + " | intelligence: " + ((Wizard) rndCharacter).getIntelligence()
                            + "\n"+ "============================================");
                }
                break;
        }
        characterList.add(userCharacter);
        characterList.add(rndCharacter);

        return characterList;

    }

    public static int statsFilter(int min, int max, String statName) {
        Scanner scanner = new Scanner(System.in);
        boolean invalitHP = false;
        int stat =0 ;

        while (!invalitHP) {
            try {
                System.out.println("Enter an integer value of " +statName +" between "+min+" and "+max);
                stat = scanner.nextInt();
                if (stat >= min && stat <= max) {
                    invalitHP = true;
                }
            } catch (InputMismatchException e) {
                System.err.println("The value of "+statName+" must be an integer between "+min+" and "+max);
                scanner.nextLine();
            }
        }
        return stat;
    }
}
