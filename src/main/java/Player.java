
public class Player extends Character {

    private String name;
    private int life;

    public Player(String name){
        super(10);
        this.name = name;
        this.life = 1;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return life;
    }
}