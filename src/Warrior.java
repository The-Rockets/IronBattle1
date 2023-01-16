public class Warrior extends Character{
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public Warrior(String name) {
        super(name);
        setHp((int)(Math.random()*101+100));
        setStamina((int)(Math.random()*41+10));
        setStrength((int)(Math.random()*10+1));
    }

    @Override
    public void setHp(int hp) {
        if(hp>200){
            super.setHp(200);
        }else{
            super.setHp(hp);
        }
    }

    @Override
    public void setHp() {

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

    public int getStrength() {
        return strength;
    }

    public void heavyAttack(Character character){
        if(stamina>=5) {
            character.setHp(character.getHp() - strength);
            setStamina(stamina -= 5);
            System.out.println(getName() +" with hp "+getHp()+" and stamina "+getStamina()+" has made a heavy attack");
        }else{
            weakAttack(character);
        }
    }

    public void weakAttack(Character character){
        if(stamina>=1) {
            character.setHp(character.getHp() - strength/2);
            setStamina(stamina += 1);
            System.out.println(getName() +" with hp "+getHp()+" and stamina "+getStamina()+" has made a weak attack");
        }else{
            setStamina(stamina += 2);
            System.out.println(getName() +" with hp "+getHp()+" and stamina "+getStamina()+" has not made any attack");
        }
    }


    @Override
    public void attack(Character character) {
        double r=Math.random();
        if(r>0.5){
            heavyAttack(character);
        }else{
            weakAttack(character);
        }
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
