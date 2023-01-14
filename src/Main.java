import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hola esto es un juego RGP:");

/*        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe el nombre de tu Guerrero :");
        String nombre1 = scanner.nextLine();
        System.out.println("Escribe el nombre de tu Mago :");
        String nombre2 = scanner.nextLine();*/

       Warrior warrior1 = new Warrior("Thor ");
       Wizard wizard1 = new Wizard("jaina ");
//Warrior warrior1 = new Warrior(nombre1);
//Wizard wizard1 = new Wizard(nombre2);

        int hpWarrior = warrior1.getHp();
        int hpWizzard = wizard1.getHp();
        int round = 0;
        boolean segundabatalla = false;

/*        FileWriter battleLog = new FileWriter("battleLog.txt", true);
        battleLog.write("test");
        battleLog.close();*/

/*        File file = new File("battleLog.txt");
        PrintStream printStream = new PrintStream(file);
        System.setOut(printStream);*/

        intro(warrior1, wizard1 ,segundabatalla);
        battle(warrior1, wizard1, round,segundabatalla);
        resultado(warrior1, wizard1, segundabatalla,hpWarrior,hpWizzard);
    }

    private static void intro(Warrior warrior1, Wizard wizard1,boolean segundabatalla) {
        if(segundabatalla) {
            System.out.println(" ESTA ES LA INTRO DEL DESEMPATE ");
            System.out.println("desempate enre: " + warrior1.getName()+" y "+wizard1.getName());
        }else {
            System.out.println("_____________INTRO_____________");
            System.out.println(warrior1);
            System.out.println( warrior1.getClass());
            System.out.println("stamina: " + warrior1.getStamina());
            System.out.println("Strenght: " + warrior1.getStrenght());

            System.out.println(wizard1);
            System.out.println(wizard1.getClass());
            System.out.println("Inelligence : " + wizard1.getIntelligence());
            System.out.println("Mana: : " + wizard1.getMana());
        }


    }

    private static void resultado(Warrior warrior1, Wizard wizard1, boolean segundabatalla,int hpWarrior,int hpWizzard) {
        if (warrior1.getHp()>0 && wizard1.getHp()<=0) {
            //operador de negacion "!".
            if (segundabatalla){System.err.println(" Warrior wins en doble combate");}
            else {System.err.println(" Warrior wins! ");}
        }else if(warrior1.getHp()<=0 && wizard1.getHp()>0) {
            if (segundabatalla){System.err.println(" Wizard wins en doble combate");}
            else {System.err.println(" Wizard wins! ");}
        }else if(warrior1.getHp()<=0 && wizard1.getHp()<=0){
            //deberia empezar la segunda batalla
            segundabatalla = true;
            System.out.println("========================>EMPATE<============================== ");
            int round = 0;
            warrior1.setHp(hpWarrior);
            wizard1.setHp(hpWizzard);
            intro(warrior1, wizard1,segundabatalla);
            battle(warrior1,wizard1,round,segundabatalla);
            resultado(warrior1, wizard1, segundabatalla,hpWarrior,hpWizzard);
        }

    }

    private static void battle(Warrior warrior1, Wizard wizard1, int round,Boolean segundabatalla) {
        while (warrior1.getHp()>0 && wizard1.getHp()>0) {
            if (segundabatalla) {
                System.out.println("----------------------DESEMPATE-------------------");
            }
            round++;
            System.out.println("----------------------ROUND" + round + "------------------");
            wizard1.attack(warrior1);
            warrior1.attack(wizard1);
            System.out.println(" Warrior HP: " + warrior1.getHp());
            System.out.println(" Wizard HP: " + wizard1.getHp());
        }
    }

}