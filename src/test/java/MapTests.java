import items.Item;
import org.junit.Test;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.*;

public class MapTests {


    @Test
    public void createMap() {
        Map map = new Map(10,5, 1);
        assertNotNull(map);
    }
    @Test
    public void mapHasHeight() {
        Map map = new Map(10,5, 1);
        int height = map.getHeight();
        assertEquals(10, height);
    }
    @Test
    public void mapHasWidth() {
        Map map = new Map(10,5,1 );
        int width = map.getWidth();
        assertEquals(5, width);
    }
    @Test
    public void testMapStructure(){
        Map map = new Map(10, 5, 1);
        for(int x = 0; x < map.getWidth(); x++) {
            for(int y = 0; y < map.getHeight(); y++) {
                if(x==0){ // Vänstra sidan
                    assertEquals(NonWalkableTile.class, map.getTileOnCoordinate(x,y).getClass());
                }else if(y==0){ //Norra sidan
                    assertEquals(NonWalkableTile.class, map.getTileOnCoordinate(x,y).getClass());
                }else if(y == map.getHeight() - 1){ //Högra sidan
                    assertEquals(NonWalkableTile.class, map.getTileOnCoordinate(x,y).getClass());
                }else if (x==map.getWidth() - 1){ //Södra sidan
                    assertEquals(NonWalkableTile.class, map.getTileOnCoordinate(x,y).getClass());
                }else{ //Gåbar yta
                    assertEquals(FloorTile.class, map.getTileOnCoordinate(x,y).getClass());
                }
            }
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinimumMapSize() {
        int height = 2;
        int width = 1;
        Map map = new Map(height, width, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void numberOfItemsTooLow() {
        int height = 10;
        int width = 20;
        int numberOfItems = 0;
        Map map = new Map(height, width, numberOfItems);
    }
    @Test
    public void addItemsToMapTiles(){
        Map map = new Map(10,10, 100);
        map.addRandomItemsToMap();
        assertEquals(10,map.getItemsOnMapList().size());
    }

    @Test
    public void itemPickedUpAndNewItemAdded(){
        Map map = new Map(10,10, 100);
        map.addRandomItemsToMap();
        map.getItemsOnMapList().remove(0);
        assertEquals(9, map.getItemsOnMapList().size());
        map.addRandomItemsToMap();
        assertEquals(10, map.getItemsOnMapList().size());
    }


    @Test
    public void getRandomOption(){
        Map map = new Map(10,10, 1);
        int[] results = {0,1,2,3,4,5};
        for(int i = 0; i<10000; i++) {
            int option = map.getRandomOption();
            results[(option)] += 1;
        }
        int roundedPercent = (((results[0] + 99) / 1000 ) * 1000)/100;

            assertEquals(10, roundedPercent);
    }

    @Test
    public void maxItemsOnMap() {
        Map map = new Map(10, 10, 100);
        assertEquals(10, map.getMaxAmountOfItems());
    }

    @Test
    public void mapHashCode(){
        Map map1 = new Map(10,5,3);
        Map map2 = new Map(10,5,3);
        assertEquals(map1.hashCode(), map2.hashCode());
    }
    @Test
    public void mapDifferentHashCode(){
        Map map1 = new Map(10,5,3);
        Map map2 = new Map(10,6,3);
        assertNotEquals(map1.hashCode(), map2.hashCode());
    }


    @Test
    public void mapEquals(){
        Map map1 = new Map(10,5,3);
        Map map2 = new Map(10,5,3);
        assertTrue(map1.equals(map2));
    }
    @Test
    public void mapNotEqual(){
        Map map1 = new Map(10,6,3);
        Map map2 = new Map(10,5,3);
        assertFalse(map1.equals(map2));
    }

}