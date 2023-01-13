public abstract class Character {

    private String id;
    private String name;
    private int hp;
    private boolean isAlive = true;



    public Character(String name){
        setName(name);
        setHp(hp);
        setId();
        setAlive(isAlive);
    }

    public String getId() {
        return id;
    }

    public void setId() {
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


    public abstract void setHp();

    @Override
    public String toString() {
        return "Character{" +
                ", name='" + name + '\'' +
                "id='" + id + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive +
                '}';
    }
}

