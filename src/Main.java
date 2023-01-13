public class Main {
    public static void main(String[] args) {

        Warrior warrior1 = new Warrior("Arthas");
        Wizard wizard1 = new Wizard("Jaina");
        int hpWarrior = warrior1.getHp();
        int hpWizzard = wizard1.getHp();
        int round = 0;
        boolean segundabatalla = false;

        intro(warrior1, wizard1);
        battle(warrior1, wizard1, round,segundabatalla);
        resultado(warrior1, wizard1, segundabatalla,hpWarrior,hpWizzard);
    }

    private static void intro(Warrior warrior1, Wizard wizard1) {
        System.out.println(warrior1);
        System.out.println("stamina: " + warrior1.getStamina());
        System.out.println("Strenght: " + warrior1.getStrenght());
        System.out.println(wizard1);
        System.out.println("Inelligence : " + wizard1.getIntelligence());
        System.out.println("Mana: : " + wizard1.getMana());

    }

    private static void resultado(Warrior warrior1, Wizard wizard1, boolean segundabatalla,int hpWarrior,int hpWizzard) {
        if (warrior1.getHp()>0 && wizard1.getHp()<0) {
            //operador de negacion "!".
            if (segundabatalla){System.err.println(" Warrior wins en doble combate");}
            else {System.err.println(" Warrior wins! ");}
        }else if(warrior1.getHp()<0 && wizard1.getHp()>0) {
            if (segundabatalla){System.err.println(" Wizard wins en doble combate");}
            else {System.err.println(" Wizard wins! ");}
        }else if(warrior1.getHp()<0 && wizard1.getHp()<0){
            //deberia empezar la segunda batalla
            segundabatalla = true;
            System.err.println("  Empate  ");
            int round = 0;
            warrior1.setHp(hpWarrior);
            wizard1.setHp(hpWizzard);
            battle(warrior1,wizard1,round,segundabatalla);
        }

    }

    private static void battle(Warrior warrior1, Wizard wizard1, int round,Boolean segundabatalla) {
        while (warrior1.getHp()>0 && wizard1.getHp()>0) {
            if (segundabatalla) {
                System.out.println("-------------------------Empieza el desempate-------------------");
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