public class Warrior extends Character implements Attacker{
    private int stamina;
    private int strength;

    public Warrior(String name, int hp, int stamina, int strength) {
        super(name, hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public Warrior(String name) {
        super(name);
        setHp((int)(Math.random()*100+100));
        setStamina((int)(Math.random()*40+10));
        setStrength((int)(Math.random()*9+1));
    }

    public void setStamina(int stamina) {
        if(stamina<10){
            this.stamina = 10;
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

    @Override
    public void attack(Character character) {

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
