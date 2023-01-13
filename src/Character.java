public abstract class Character {

    private static int counter=0;
    private final String id;
    private String name;
    private int hp;

    private boolean isAlive=true;

    public Character(String name, int hp) {
        this.id="character"+counter;
        this.name = name;
        setHp(hp);
        counter++;
    }

    public Character(String name) {
        this.id="character"+counter;
        this.name = name;
        counter++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        if(hp<50){
            this.hp=50;
        }else if(hp>200){
            this.hp=200;
        }else{
            this.hp=hp;
        }
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
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


}
