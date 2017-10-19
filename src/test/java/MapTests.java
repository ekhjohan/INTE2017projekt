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
        HashMap<Coordinate, Tile> expectedMap = new HashMap<Coordinate,Tile>();
        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
                expectedMap.put(new Coordinate(x,y),new NonWalkableTile());
            }
        }
        Map map = new Map(height, width);
        HashMap<Coordinate, Tile> actualMap = map.getMap();
        System.out.println(actualMap.size());
        assertEquals(expectedMap, actualMap);
    }

    @Test
    public void addTileToMap() {
        Map map = new Map(10,5);
        map.addTile(0, 1, new FloorTile());
        Tile tile = map.getTileOnCoordinate(0,1);
        assertTrue(tile.equals(new FloorTile()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinimumMapSize() {
        int height = 2;
        int width = 2;
        Map map = new Map(height, width);
    }



}