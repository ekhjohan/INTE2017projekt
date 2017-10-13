import Items.Item;

public class FloorTile extends Tile{

    private Item item = null;


    public FloorTile(){
        super(true);
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
        if (o == null || getClass() != o.getClass()) return false;

        FloorTile floorTile = (FloorTile) o;
        return this.item == null && floorTile.getItem() == null || item.equals(floorTile.getItem());

    }

    //Can't compare tiles with item==null
    @Override
    public int hashCode() {
        if (this.item==null) return -1;
        return item.hashCode();
    }
}
