import items.*;

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
            drunkness=calculateDrunkness();
        }
        drunkness=calculateDrunknessLevel(drunkness);
        return drunkness;
    }

    public int calculateDrunkness() {
        int drunkness=0;
        ListIterator<Item> i = items.listIterator();

        while (i.hasNext()) {
            Item current = i.next();
            Beer b;
            Wine w;
            Shot s;
            Water wa;
            NonAlcoholicDrink nad;
//                System.out.println(current.getClass());
            if (current.getClass().equals(items.Beer.class)) {
                b = (Beer) current;
//                    System.out.println("Beer");
                drunkness += b.getAlcoholContent();
            } else if (current.getClass().equals(items.Wine.class)) {
                w = (Wine) current;
//                    System.out.println("Wine");
                drunkness += w.getAlcoholContent();
            } else if (current.getClass().equals(items.Shot.class)) {
                s = (Shot) current;
//                    System.out.println("Shot");
                drunkness += s.getAlcoholContent();
            } else if (current.getClass().equals(items.Water.class)) {
                wa = (Water) current;
//                    System.out.println("Water");
                if (drunkness<=0){
                    System.out.println("removing water drink, too much water");
                    i.remove();
                }else{
                    drunkness += wa.getAlcoholContent();
                }
            } else if (current.getClass().equals(items.NonAlcoholicDrink.class)) {
                nad = (NonAlcoholicDrink) current;
//                    System.out.println("nonalco");
                if (drunkness<=0){
                    System.out.println("removing nonalcoholic drink, too much water");
                    i.remove();
                }else{
                    drunkness += nad.getAlcoholContent();
                }
            }
        }
        return drunkness;
    }

    private int calculateDrunknessLevel(int drunkness){
        double initialLevel=5.0;
        double multiplicator=1.3;
        double dr=drunkness;
        System.out.println("Initial Drunkness: "+dr);
        int level=0;
        while(dr>0.0){

            double  i = (initialLevel*Math.pow(multiplicator,level));
            dr+=-i;
            level++;
//            System.out.println("Drunkness: "+dr+", DrLevel: "+level+", Current Level Requirement: "+i);


        }
        return level;
    }

}
