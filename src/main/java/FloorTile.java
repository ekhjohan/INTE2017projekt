import items.Item;

public class FloorTile extends Tile{

    private Item item = null;


    public FloorTile(){
        super(true, true);
    }

    public void addItem(Item newItem){
        if(item == null){
            this.item = newItem;
        }

    }

    public void removeItem(){
        this.item = null;

    }

    public boolean hasItem(){
        return (item != null);

    }

    public Item getItem(){
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FloorTile)) return false;
        if (!super.equals(o)) return false;

        FloorTile floorTile = (FloorTile) o;

        return item != null ? item.equals(floorTile.item) : floorTile.item == null;
    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }
}
