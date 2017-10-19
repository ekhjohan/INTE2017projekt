package items;

public class Beer extends Item {
    private final int alcoholContent = 1;
    private final int balanceBuff = -1;

    public int getAlcoholContent() {
        return alcoholContent;
    }

    public int getBalanceBuff() {
        return balanceBuff;
    }

    @Override
    public int hashCode() {
        int result = alcoholContent;
        result = 31 * result + balanceBuff;
        return result;
    }
}
