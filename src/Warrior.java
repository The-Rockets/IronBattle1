

public class Warrior extends Character {

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
        this.strenght = (int) (Math.random()*11)+1;
    }

    @Override
    public void setHp() {
        super.setHp((int) (Math.random()*101)+100);
    }

}
