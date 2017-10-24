
public abstract class Tile {

    private boolean isWalkable, isItemsAllowed;

    public Tile(boolean isWalkable, boolean isItemsAllowed){
        this.isWalkable = isWalkable;
        this.isItemsAllowed = isItemsAllowed;
    }


    public boolean getIsWalkable() {
        return isWalkable;
    }
    public boolean getIsItemsAllowed(){
        return isItemsAllowed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        return isWalkable == tile.isWalkable;
    }
}
