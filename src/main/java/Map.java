import java.util.HashMap;

public class Map {

    private int height, width;
    private HashMap<Coordinate,Tile> map;

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
        initMap();
    }
    public void initMap(){
        map = new HashMap<Coordinate,Tile>();
        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
               // map.put(new Coordinate(x,y),);
            }
        }
    }
    public void addTile(int x, int y, Tile tile){
        map.put(new Coordinate(x,y), tile);
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public Tile getTileOnCoordinate(int x, int y){
        Tile tile = map.get(new Coordinate(x,y));
        return tile;
    }
    public HashMap<Coordinate, Tile> getMap() {
        return map;
    }
}
