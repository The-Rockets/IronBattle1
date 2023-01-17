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
        setIntelligence((int)(Math.random()*10+1));
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


    public void fireball(Character character){
        if(mana >=5) {
            character.setHp(character.getHp() - intelligence);
            setMana(mana -= 5);
            System.out.println(getName() +" with hp "+getHp()+" and mana "+ getMana()+" has made a fireball");
        }else{
            staffHit(character);
        }
    }

    public void staffHit(Character character){
        if(mana >=1) {
            character.setHp(character.getHp() - 2);
            setMana(mana += 1);
            System.out.println(getName() +" with hp "+getHp()+" and mana "+ getMana()+" has made a staff hit");
        }else{
            setMana(mana += 2);
            System.out.println(getName() +" with hp "+getHp()+" and mana "+ getMana()+" has not made any attack");
        }
    }


    @Override
    public void attack(Character character) {
        double r=Math.random();
        if(r>0.5){
            fireball(character);
        }else{
            staffHit(character);
        }
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
