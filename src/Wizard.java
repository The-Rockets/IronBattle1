public class Wizard extends Character{


    private int mana;
    private int intelligence;


    public Wizard(String name) {
        super(name);
        setHp();
        setId();
        setIntelligence();
        setMana();

    }

    public int getMana() {
        return mana;
    }

    public void setMana() {
        this.mana = (int) (Math.random()*41)+10;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence() {
        this.intelligence = (int) (Math.random()*41)+10;
    }

    @Override
    public void setHp() {
        super.setHp((int) (Math.random()*101)+100);
    }
}

