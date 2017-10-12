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
        if(item != null){
            return true;
        }

        return false;
    }

    public Item getItem(){
        return item;
    }
}
