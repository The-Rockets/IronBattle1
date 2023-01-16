public class Warrior extends Character {
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public Warrior(String name) {
        super(name);
        setHp((int) (Math.random() * 101 + 100));
        setStamina((int) (Math.random() * 41 + 10));
        setStrength((int) (Math.random() * 10 + 1));
    }

    @Override
    public void setHp(int hp) {
        if (hp > 200) {
            super.setHp(200);
        } else {
            super.setHp(hp);
        }
    }

    @Override
    public void setHp() {

    }

    public void setStamina(int stamina) {
        if (stamina < 0) {
            this.stamina = 0;
        } else if (stamina > 50) {
            this.stamina = 50;
        } else {
            this.stamina = stamina;
        }
    }

    public void setStrength(int strength) {
        if (strength < 1) {
            this.strength = 1;
        } else if (strength > 10) {
            this.strength = 10;
        } else {
            this.strength = strength;
        }
    }

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    private void heavyAttack(Character character, boolean rollforCritChance) {
        if (rollforCritChance) {
            character.setHp(character.getHp() - strength * 2);
            this.stamina = stamina - 5;
            System.out.println(this.getName() + " used a Heavy Attack and deal CRITICAL " + strength * 2 + " DAMAGE to " + character.getName());
        } else {
            character.setHp(character.getHp() - strength * 2);
            this.stamina = stamina - 5;
            System.out.println(this.getName() + " used a Heavy Attack and deal " + strength * 2 + " damage to " + character.getName());
        }
    }

    private void weakAttack(Character character) {
        int damage = this.strength / 2;
        character.setHp(character.getHp() - strength);
        this.stamina = stamina + 1;
        System.out.println(this.getName() + " used a Weak Attack and dealt " + damage + " damage to " + character.getName());
    }


    private void outOfStamina() {
        System.out.println("warrior does not have the stamina to do a Weak attack he will not inflict any damage and recover his stamina by 2.");
        this.stamina = stamina + 2;
    }


    @Override
    public void attack(Character character) {
        boolean rollforHeavyAttack = Math.random() > 0.5;
        boolean rollforCritChance = Math.random() > 0.5;

        if (rollforHeavyAttack && stamina >= 5) {
            heavyAttack(character, rollforCritChance);
        } else if (stamina >= 1) {
            weakAttack(character);
        } else {
            outOfStamina();
        }
    }



    @Override
    public String toString() {
        return "Warrior{" +
                "Name: "+super.getName()+
                "Hp: "+super.getHp()+
                "stamina=" + stamina +
                ", strength=" + strength +
                '}';
    }
}

