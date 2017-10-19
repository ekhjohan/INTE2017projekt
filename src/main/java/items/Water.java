package items;

public class Water extends Item {
    private final int alcoholContent = -2;
    private final int balanceBuff = 2;

    public int getAlcoholContent() {
        return alcoholContent;
    }

    public int getBalanceBuff() {
        return balanceBuff;
    }
}
