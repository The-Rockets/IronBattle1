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

    public void heavyAttack(Character character){
        stamina-=5;
        character.setHp(character.getHp()-strength);

    }

    public void weakAttack(Character character){
        stamina+=1;

    }

    @Override
    public void attack(Character character) {

    }

}
