package items;

public abstract class Item {

    @Override
    public String toString() {
        return "Item: " + this.getClass();
    }
}
