public class Warrior extends Character{

    private int originalStamina;
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
        setOriginalStamina(getStamina());
    }

    public Warrior(String name) {
        super(name);
        setHp((int)(Math.random()*101+100));
        setStamina((int)(Math.random()*41+10));
        setStrength((int)(Math.random()*10+1));
        setOriginalHp(getHp());
        setOriginalStamina(getStamina());
    }

    @Override
    public void setHp(int hp) {
        if(hp>200){
            super.setHp(200);
        }else{
            super.setHp(hp);
        }
    }

    public void setStamina(int stamina) {
        if(stamina<0){
            this.stamina = 0;
        }else if(stamina>50){
            this.stamina = 50;
        }else{
            this.stamina = stamina;
        }
    }

    public void setOriginalStamina(int originalStamina) {
        this.originalStamina = originalStamina;
    }

    public void setStrength(int strength) {
        if(strength<1){
            this.strength = 1;
        }else if(strength>10){
            this.strength = 10;
        }else{
            this.strength = strength;
        }
    }


    public int getStamina() {
        return stamina;
    }

    public int getOriginalStamina() {
        return originalStamina;
    }

    public int getStrength() {
        return strength;
    }


    @Override
    public void attack(Character character) {
        boolean rollforHeavyAttack = Math.random() >0.5 ;
        boolean rollforCritChance = Math.random() >0.5;

        if (rollforHeavyAttack && stamina >= 5) {
            heavyAttack(character,rollforCritChance);
        } else if (stamina >= 1) {
            weakAttack(character);
        } else {
            outOfStamina();
        }

    }

    private void outOfStamina() {
        System.out.println("warrior does not have the stamina to do a Weak attack he will not inflict any damage and recover his stamina by 2.");
        this.stamina = stamina + 2;
    }

    private void weakAttack(Character character) {
        int damage = this.strength / 2;
        character.setHp(character.getHp() - strength);
        this.stamina = stamina + 1;
        System.out.println(this.getName() + " used a Weak Attack and dealt " + damage + " damage to " + character.getName());
    }

    private void heavyAttack(Character character, boolean rollforCritChance) {
        if(rollforCritChance){
            character.setHp(character.getHp() - strength*2);
            this.stamina = stamina - 5;
            System.out.println(this.getName() + " used a Heavy Attack and deal: " + strength*2 + " CRITICAL DAMAGE to " + character.getName());
        }else {
            character.setHp(character.getHp() - strength*2);
            this.stamina = stamina - 5;
            System.out.println(this.getName() + " used a Heavy Attack and deal: " + strength*2 + " damage to " + character.getName());
        }
    }

    @Override
    public void restoreParameters() {
        super.restoreParameters();
        setStamina(getOriginalStamina());
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", hp=" + getHp() +
                ", isAlive=" + isAlive() +
                ", stamina=" + stamina +
                ", strength=" + strength +
                '}';
    }
}
