package Items;

public class Beer extends Item {
    private final int alcoholContent = 1;
    private final int balanceBuff = -1;

    public int getAlcoholContent() {
        return alcoholContent;
    }

    public int getBalanceBuff() {
        return balanceBuff;
    }
}
