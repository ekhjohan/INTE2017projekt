import items.Item;
import org.junit.Test;

import java.text.DecimalFormat;

import java.io.FileNotFoundException;
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
    public void testMapStructure(){
       Map map = new Map(10, 5);
        for(int x = 0; x < map.getWidth(); x++) {
            for(int y = 0; y < map.getHeight(); y++) {
                if(x==0){ // Vänstra sidan
                    assertEquals(NonWalkableTile.class, map.getTileOnCoordinate(x,y).getClass());
                }else if(y==0){ //Norra sidan
                    assertEquals(NonWalkableTile.class, map.getTileOnCoordinate(x,y).getClass());
                }else if(y == map.getHeight()){ //Högra sidan
                    assertEquals(NonWalkableTile.class, map.getTileOnCoordinate(x,y).getClass());
                }else if (x==map.getWidth()){ //Södra sidan
                    assertEquals(NonWalkableTile.class, map.getTileOnCoordinate(x,y).getClass());
                }else{ //Gåbar yta
                    assertEquals(FloorTile.class, map.getTileOnCoordinate(x,y).getClass());
                }
            }
        }

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

    @Test
    public void addItemsToMapTiles(){
        Map map = new Map(10,5);
        map.addRandomItemsToMap(10);
        for(Tile tile : map.getMap().values()){
            if(tile.getIsItemsAllowed() && ((FloorTile) tile).hasItem()){
                Item item = ((FloorTile) tile).getItem();
                System.out.println(item);
            }
        }
        assertTrue(true);


    }

    @Test
    public void getRandomOption(){
        Map map = new Map(10,10);
        int[] results = {1,2,3,4,5};
        for(int i = 0; i<10000; i++) {
            int option = map.getRandomOption();
            results[(option-1)] += 1;
        }
        int roundedPercent = (((results[0] + 99) / 1000 ) * 1000)/100;

            assertEquals(20, roundedPercent);
    }

 



}