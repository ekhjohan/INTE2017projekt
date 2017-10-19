
public abstract class Tile {

    boolean isWalkAble;
    boolean isItemsAllowed;

    public Tile(boolean isWalkable, boolean isItemsAllowed){
        this.isWalkAble = isWalkable;
        this.isItemsAllowed = isItemsAllowed;
    }


    public boolean getIsWalkable() {
        return isWalkAble;
    }
    public boolean getIsItemsAllowed(){
        return isItemsAllowed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        return isWalkAble == tile.isWalkAble;
    }
}
