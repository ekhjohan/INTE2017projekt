
public abstract class Tile {

    boolean walkAble;

    public Tile(Boolean walkAble){
        this.walkAble = walkAble;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        return walkAble == tile.walkAble;
    }

    @Override
    public int hashCode() {
        return (walkAble ? 1 : 0);
    }
}
