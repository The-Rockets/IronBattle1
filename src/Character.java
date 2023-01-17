<<<<<<< HEAD
=======

>>>>>>> origin
public abstract class Character {
    private String id;
    private String name;
    private int hp;
<<<<<<< HEAD

    private boolean isAlive;

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
=======
    private boolean isAlive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
>>>>>>> origin
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
    public int getHp() {
        return hp;
    }
=======
    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;

    }
>>>>>>> origin
}
