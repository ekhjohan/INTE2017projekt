import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.*;

public class MapTests {

    @Test
    public void createMap() {
        Map map = new Map(10,5);
        assertNotNull(map);
    }
    @Test
    public void mapHasHeight() {
        Map map = new Map(10,5);
        int height = map.getHeight();
        assertEquals(10, height);
    }
    @Test
    public void mapHasWidth() {
        Map map = new Map(10,5);
        int width = map.getWidth();
        assertEquals(5, width);
    }
    @Test
    public void initMap() {
        int height = 10;
        int width = 5;
        HashMap expectedMap = new HashMap<Coordinate,Tile>();
        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
                expectedMap.put(new Coordinate(x,y),Tile.EMPTY);
            }
        }
        Map map = new Map(height, width);
        HashMap actualMap = map.getMap();
        assertTrue(expectedMap.equals(actualMap));
    }

    @Test
    public void addTileToMap() {
        Map map = new Map(10,5);
        map.addTile(0, 1, Tile.GRASS);
        Tile tile = map.getTileOnCoordinate(0,1);
        assertEquals(Tile.GRASS, tile);
    }

}
