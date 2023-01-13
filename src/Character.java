public class Character {

    private String id;
    private String name;
    private int hp;
    private boolean isAlive = true;

    public Character(String name, int hp) {
        setName(name);
        setHp(hp);
        setId(id);
        setAlive(isAlive);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = (Integer.toString((int)(Math.random()*10000)));
    }

    public String getName() {
        return name;
    }

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


}

