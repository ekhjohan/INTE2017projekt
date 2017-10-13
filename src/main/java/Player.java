import Items.Item;

import java.util.LinkedList;
import java.util.List;

public class Player extends Character {

    private String name;
    private int life;
    private List<Item> items;

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

    public List<Item> getItemList(){
        return items;
    }

    public void addItem(Item item){
        if(items == null)
            items = new LinkedList<Item>();
        items.add(item);
    }

    public int getDrunkness(){
        if(items == null)
            return 0;
        return -1;
    }

}
