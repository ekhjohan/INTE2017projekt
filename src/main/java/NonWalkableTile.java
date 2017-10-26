public class NonWalkableTile extends Tile {

    public NonWalkableTile() {
        super(false, false);
    }

    @Override
    public int hashCode() {
        int result = 1;
        return result;
    }

}