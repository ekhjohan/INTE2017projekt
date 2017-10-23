import java.util.*;

public class Visitor extends Character {
    private int life;
    private int hotness;

    public Visitor() {
        super(0);
        this.life = 1;
        this.hotness=determineHotness();
    }

    private int determineHotness(){
        Random r = new Random();
        return r.nextInt(10)+1;
    }

    public int getHotness(){
        return hotness;
    }
    public int getLife(){
        return life;
    }

}
