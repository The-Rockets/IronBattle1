public class Warrior extends Character implements Attacker{
    private int hp=(int)(Math.random()*100+100);
    private int stamina=(int)(Math.random()*40+10);

    private int strength=(int)(Math.random()*9+1);


    public Warrior(String name) {
        super(name);
        super.setHp(hp);
        setStamina(stamina);
        setStrength(strength);
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void attack(Character character) {

    }

}
