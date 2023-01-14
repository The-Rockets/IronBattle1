public abstract class Character {

    private static int counter=0;
    private final String id;
    private String name;
    private int hp;

    private boolean isAlive=true;

    public Character(String name, int hp) {
        this.id="Character"+counter;
        this.name = name;
        setHp(hp);
        counter++;
    }

    public Character(String name) {
        this.id="Character"+counter;
        this.name = name;
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

    public boolean isAlive() {
        return isAlive;
    }


    public abstract void attack(Character character);
}
