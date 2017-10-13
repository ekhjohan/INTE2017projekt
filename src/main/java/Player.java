import Items.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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
        int drunkness = 0;
        if(items == null)
            return 0;
        else{
            ListIterator<Item> i = items.listIterator();

            while(i.hasNext()) {
                Item current = i.next();
                Beer b;
                Wine w;
                Shot s;
                Water wa;
                NonAlcoholicDrink nad;
                System.out.println(current.getClass());
                if (current.getClass().equals(Items.Beer.class)){
                    b = (Beer) current;
                    System.out.println("Beer");
                    drunkness+=b.getAlcoholContent();
                }
                else if (current.getClass().equals(Items.Wine.class)){
                    w = (Wine) current;
                    System.out.println("Wine");
                    drunkness+=w.getAlcoholContent();
                }
                else if (current.getClass().equals(Items.Shot.class)){
                    s = (Shot) current;
                    System.out.println("Shot");
                    drunkness+=s.getAlcoholContent();
                }
                else if (current.getClass().equals(Items.Water.class)){
                    wa = (Water) current;
                    System.out.println("Water");
                    drunkness+=wa.getAlcoholContent();
                }
                else if (current.getClass().equals(Items.NonAlcoholicDrink.class)){
                    nad = (NonAlcoholicDrink) current;
                    System.out.println("nonalco");
                    drunkness+=nad.getAlcoholContent();
                }
                else System.out.println("nothing");
            }
        }
        if(drunkness < 0)
            drunkness = 0;
        return drunkness;
    }


}
