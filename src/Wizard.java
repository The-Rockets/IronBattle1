public class Wizard extends Character{

    private int originalMana;
    private int mana;
    private int intelligence;

    public Wizard(String name, int hp, int stamina, int intelligence) {
        super(name, hp);
        setMana(stamina);
        setIntelligence(intelligence);
        setOriginalMana(getMana());
    }

    public Wizard(String name) {
        super(name);
        setHp((int)(Math.random()*51+50));
        setMana((int)(Math.random()*41+10));
        setIntelligence((int)(Math.random()*50+1));
        setOriginalHp(getHp());
        setOriginalMana(getMana());
    }

    @Override
    public void setHp(int hp) {
        if(hp>100){
            super.setHp(100);
        }else{
            super.setHp(hp);
        }
    }

    public void setMana(int mana) {
        if(mana <0){
            this.mana = 0;
        }else if(mana >50){
            this.mana = 50;
        }else{
            this.mana = mana;
        }
    }

    public void setOriginalMana(int originalMana) {
        this.originalMana = originalMana;
    }

    public void setIntelligence(int intelligence) {
        if(intelligence <1){
            this.intelligence = 1;
        }else if(intelligence >50){
            this.intelligence = 50;
        }else{
            this.intelligence = intelligence;
        }
    }


    public int getMana() {
        return mana;
    }

    public int getOriginalMana() {
        return originalMana;
    }

    public int getIntelligence() {
        return intelligence;
    }


    @Override
    public void attack(Character character) {
        boolean rollforFireball = Math.random() >0.5 ;
        boolean rollforCritChance = Math.random() >0.5;

        if (rollforFireball && mana >= 5) {
            fireball(character,rollforCritChance);
        } else if ( mana >0) {
            staffHit(character);
        }else{
            outOfMana();
        }

    }

    private void outOfMana() {
        System.out.println(this.getName() + " wizard does not have the mana to cast a Staff hit he will not inflict any damage and recover his mana by 2." );
        setMana(mana + 5);
    }

    private void staffHit(Character character) {
        character.setHp(character.getHp() - 2);
        setMana(mana - 1);
        System.out.println(this.getName() + " use staffHit and deal: " + 2 + " damage to " + character.getName());
    }

    private void fireball(Character character,boolean rollforCritChance) {
        if(rollforCritChance) {
            character.setHp(character.getHp() - intelligence *2);
            System.out.println(this.getName() + " use fireball and deal CRITICAL: " + (intelligence *2) + " DAMAGE to " + character.getName());
        }else{
            character.setHp(character.getHp() - intelligence );
            System.out.println(this.getName() + " use fireball and deal: " + intelligence + " damage to " + character.getName());
        }
        setMana(mana - 5);
    }



    @Override
    public void restoreParameters() {
        super.restoreParameters();
        setMana(getOriginalMana());
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", hp=" + getHp() +
                ", isAlive=" + isAlive() +
                ", mana=" + mana +
                ", intelligence=" + intelligence +
                '}';
    }
}
