public abstract class Character implements Attacker{

    private static int counter=0;
    private final String id;
    private String name;
    private int originalHp;
    private int hp;
    private boolean isAlive=true;

    public Character(String name, int hp) {
        this.id="Character"+counter;
        setName(name);
        setHp(hp);
        setOriginalHp(getHp());
        counter++;
    }


    public Character(String name) {
        this.id="Character"+counter;
        setName(name);
        counter++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        if(hp<=0){
            this.hp=0;
            setAlive(false);
        }else{
            this.hp=hp;
        }
    }

    public void setOriginalHp(int originalHp) {
        this.originalHp = originalHp;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getOriginalHp() {
        return originalHp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void restoreParameters(){
        setHp(getOriginalHp());
        setAlive(true);
    }


}

