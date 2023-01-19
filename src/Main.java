import java.io.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public Main() {
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        //Warrior warrior = new Warrior("Thor ");
        //Wizard wizard1 = new Wizard("jaina ");

        System.out.println(" Welcome To Iron Battle");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Do you want to create your own Character? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);

        Character userCharacter = null;
        Character rndCharacter = null;

        Boolean iligal =false;

        //while (!iligal){}

        while (choice != 'Y' && choice != 'N') {
            System.out.println("Invalid input. Please enter Y for Yes or N for No.");
            choice = scanner.next().charAt(0);
        }
        try {
            if (choice == 'Y') {
                System.out.println("Press 1 for Warrior or 2 for Wizard");
                Scanner scanner1 = new Scanner(System.in);
                int chose = scanner1.nextInt();
                while (chose != 1 && chose != 2) {
                    System.out.println("Invalid input. Please enter 1 for Warrior or 2 for Wizard.");
                    chose = scanner.nextInt();
                }
                if (chose == 1)

                {System.out.println("Name for your Warrior");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    userCharacter = new Warrior(name);
                } else if (chose == 2) {
                    System.out.println("Name for your Wizard");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    userCharacter = new Wizard(name);
                }
                rndCharacter = randomCharacter();
                System.out.println(" Your " + userCharacter.getName() + " " + userCharacter.getClass() + "  with " + userCharacter.getHp() + " hp " + " will fight against " +
                        rndCharacter.getName() + " " + rndCharacter.getClass() + " with " + rndCharacter.getHp() + " hp ");
                battle(userCharacter, rndCharacter);

            }else if(choice == 'N'){
                userCharacter = randomCharacter();
                rndCharacter = randomCharacter();
                battle(userCharacter, rndCharacter);
            }else{
                throw new IllegalArgumentException();
            }

        }catch(IllegalArgumentException e ){
            System.out.println(e);
            System.err.println("please  chose 'Y' or 'N' :");
        }

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




        //System.out.println(warrior);
        //System.out.println(wizard1);

        //battle(warrior,wizard);

        // battleLogTXT();
        //
    }

    public static void battle(Character character1, Character character2) throws InterruptedException {
        int round=1;
        while (character1.isAlive() && character2.isAlive()){
            TimeUnit.SECONDS.sleep(2);
            System.out.println("======== Round "+round+" ========");
            character1.attack(character2);
            character2.attack(character1);
            System.out.println("--------------------------------");
            System.out.println(character1.getName()+" HP: "+character1.getHp()+ " | " +character2.getName()+" HP: "+ character2.getHp());
            round++;
        }
        System.out.println("================================");
        TimeUnit.SECONDS.sleep(5);
        if(character1.isAlive()){
            System.err.println(character1.getName()+" has won the battle");
            System.err.println("CONGRATULATIONS!!!"+character1.getName());
        } else if (character2.isAlive()) {
            System.err.println(character2.getName()+" has won the battle");
            System.err.println("CONGRATULATIONS!!!"+character2.getName());
        }else{
            System.err.println(character1.getName() +" and " +character2.getName()+" have tied");
            character1.restoreParameters();
            character2.restoreParameters();
            battle(character1,character2);
        }
        TimeUnit.SECONDS.sleep(2);
    }

    private static void battleLogTXT() throws FileNotFoundException {
        File file = new File("battleLog.txt");
        PrintStream printStream = new PrintStream(file);
        System.setOut(printStream);
    }

    public static Character randomCharacter(){
        List<String> warriors = CsvReader.readWarriors("./src/warriors.csv");
        List<String> wizards = CsvReader.readWarriors("./src/wizards.csv");
        Random rand = new Random();

        if(Math.random()>0.5){
            int randomIndex1 = rand.nextInt(warriors.size());
            Character warrior = new Warrior(warriors.get(randomIndex1).trim());
            return warrior;
        }else{
            int randomIndex2 = rand.nextInt(wizards.size());
            Character wizard = new Wizard(wizards.get(randomIndex2).trim());
            return wizard;
        }
    }





}
