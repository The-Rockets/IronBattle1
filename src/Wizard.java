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
        super.setHp((int) (Math.random() * 101) + 50);
    }


    @Override
    public void attack(Character character) {
        boolean rollforFireball = Math.random() >0.5 ;

            if (rollforFireball && mana >= 5) {
                fireball(character);
            } else if ( mana >0) {
                staffHit(character);
            }else{
                outOfMana();
            }

    }

    private void outOfMana() {
        System.out.println(this.getName() + " no tiene mana para atacar y recupera dos puntos de mana " );
        setMana(mana + 2);
    }

    private void staffHit(Character character) {
        character.setHp(character.getHp() - 2);
        setMana(mana -1);
        System.out.println(this.getName() + " use staffHit and dealt " + 2 + " damage to " + character.getName());
    }

    private void fireball(Character character) {

        character.setHp(character.getHp() - intelligence);
        setIntelligence(mana+5);
        System.out.println(this.getName() + " use fireball and deal " + intelligence + " damage to " + character.getName());
    }
}

