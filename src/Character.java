public abstract class Character {
    private String id;
    private String name;
    private int hp;

    private boolean isAlive=true;


    public Character(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }
}
