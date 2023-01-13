public class Wizard extends Character implements Attacker {


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
        this.mana = (int) (Math.random() * 41) + 10;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setIntelligence() {
        this.intelligence = (int) (Math.random() * 41) + 10;
    }

    @Override
    public void setHp() {
        super.setHp((int) (Math.random() * 101) + 100);
    }


    @Override
    public void attack(Character character) {

        boolean rollforFireball = Math.random() >0.5 ;

        if (rollforFireball && mana >= 5) {
            //Fireball
            int damage = intelligence;
            character.setHp(character.getHp() - damage);
            setIntelligence(intelligence-5);
        } else if ( mana >0) {
            //Staff hit
            character.setHp(character.getHp() - 2);
            setMana(mana +1);
        }else{
            //can not hit 0 mana
            System.out.println(this.getName() + "no tiene mana para atacar y recupera dos puntos de mana : " );
            setMana(mana + 2);
        }
    }
}

