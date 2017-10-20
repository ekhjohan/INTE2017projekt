package items;

public class Beer extends Item {
    private final int alcoholContent = 1;

    public int getAlcoholContent() {
        return alcoholContent;
    }
    
    @Override
    public int hashCode() {
        return alcoholContent;
    }
}
