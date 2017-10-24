import items.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Player extends Character {

    private static final double XP_TO_REACH_LVL_ONE = 5.0;
    private static final double XP_MULTIPLICATOR_PER_LVL = 1.3;
    private static final int DEFAULT_SPEED = 10;
    private String name;
    private static final int LIFE = 1;
    private List<Item> items;

    public Player(String name) {
        super(DEFAULT_SPEED);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLife() {
        return LIFE;
    }

    public List<Item> getItemList() {
        return items;
    }

    public void addItem(Item item) {
        if (items == null)
            items = new LinkedList<Item>();
        items.add(item);
    }

    public int getDrunkness() {
        int drunkness = 0;
        if (items == null)
            return 0;
        else {
            drunkness = calculateDrunkness();
        }
        drunkness = calculateDrunknessLevel(drunkness);
        return drunkness;
    }

    private int calculateDrunkness() {
        int drunkness = 0;

        for (Item item : items) {
            if (item instanceof Beer) {
                drunkness += ((Beer) item).getAlcoholContent();
            } else if (item instanceof Wine) {
                drunkness += ((Wine) item).getAlcoholContent();
            } else if (item instanceof Shot) {
                drunkness += ((Shot) item).getAlcoholContent();
            } else if (item instanceof Water) {
                if (drunkness > 0) {
                    drunkness += ((Water) item).getAlcoholContent();
                }
            } else if (item instanceof NonAlcoholicDrink) {
                if (drunkness > 0) {
                    drunkness += ((NonAlcoholicDrink) item).getAlcoholContent();
                }
            }
        }
        return drunkness;
    }

    private int calculateDrunknessLevel(int drunkness) {
        double dr = drunkness;

        int level = 0;
        while (dr > 0.0) {
            double i = (XP_TO_REACH_LVL_ONE * Math.pow(XP_MULTIPLICATOR_PER_LVL, level));
            dr += -i;
            level++;
        }
        return level;
    }

    public void calculateMove(char direction) {
        double oddsOfWrongStep = ((double) getDrunkness()) * .05;
        int i = calculateMisstep(oddsOfWrongStep);
        switch (i) {
            case 0:
                if (direction != 'd')
                    super.moveCharacter('d');
                else super.moveCharacter('w');
                break;
            case 1:
                if (direction != 'a')
                    super.moveCharacter('a');
                else super.moveCharacter('w');
                break;
            case 2:
                if (direction != 's')
                    super.moveCharacter('s');
                else super.moveCharacter('w');
                break;
            case 3:
                super.moveCharacter(direction);
                break;
            default:
                break;
        }
    }

    private int calculateMisstep(double odds) {
        Random random = new Random();
        double[] probabilities = {odds / 3.0, odds / 3.0, odds / 3.0, 1.0 - odds};
        int[] results = {0, 1, 2, 3};

        double num = random.nextDouble();
        double s = 0;
        int lastIndex = probabilities.length - 1;
        for (int i = 0; i < lastIndex; ++i) {
            s += probabilities[i];
            if (num < s) {
                return results[i];
            }
        }
        return results[lastIndex];
    }
}