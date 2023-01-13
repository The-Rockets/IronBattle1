

public class Warrior extends Character implements Attacker{

    private int stamina;
    private int strenght;



    public Warrior(String name) {
        super(name);
        setStamina();
        setStrenght();
        setHp();
        setId();

    }
    public int getStamina() {
        return stamina;
    }

    public void setStamina() {
        this.stamina = (int) (Math.random()*41)+10;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght() {
        this.strenght = (int) (Math.random()*10)+1;
    }

    @Override
    public void setHp() {
        super.setHp((int) (Math.random()*201)+100);
    }


    @Override
    public void attack(Character character) {
        boolean rollforHeavyAttack = Math.random() >0.5 ;

            if (rollforHeavyAttack && stamina >= 5) {
                heavyAttack(character);
            } else if (stamina >= 1) {
                weakAttack(character);
            } else {
                outOfStamina();
            }

    }

    private void outOfStamina() {
        System.out.println(" warrior does not have the stamina to do a Weak attack he will not inflict any damage and recover his stamina by 2.");
        this.stamina = stamina + 2;
        System.out.println(" warrior stamina is: " + stamina);
    }

    private void weakAttack(Character character) {
        int damage = this.strenght / 2;
        character.setHp(character.getHp() - damage);
        this.stamina = stamina + 1;
        System.out.println(this.getName() + " used a Weak Attack and dealt " + damage + " damage to " + character.getName());
    }

    private void heavyAttack(Character character) {
        int damage = this.strenght;
        character.setHp(character.getHp() - damage);
        this.stamina = stamina - 5;
        System.out.println(this.getName() + " used a Heavy Attack and deal " + damage + " damage to " + character.getName());
    }
}

