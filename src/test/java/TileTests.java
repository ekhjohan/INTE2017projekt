import Items.Beer;
import Items.Item;
import Items.Water;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import org.junit.Test;

import static org.junit.Assert.*;

public class TileTests {

    @Test
    public void testCreateTile(){
        Tile tile = new FloorTile();
        assertNotNull(tile);
    }

    @Test
    public void testCreateNonWalkAbleTileWithFalse(){
        NonWalkAbleTile newTile = new NonWalkAbleTile();
        assertNotNull(newTile);

    }

    @Test
    public void testIsNonWalkAbleTileWalkAble(){
        NonWalkAbleTile newTile = new NonWalkAbleTile();
        assertFalse(newTile.walkAble);
    }

    @Test
    public void testCreateFloorTile(){
        FloorTile newTile = new FloorTile();
        assertNotNull(newTile);

    }

    @Test
    public void testIsFloorTileWalkAble(){
        FloorTile newTile = new FloorTile();
        assertTrue(newTile.walkAble);
    }


    @Test
    public void testAddItemToTile(){
        FloorTile newTile = new FloorTile();
        Item waterItem = new Water();
        newTile.addItem(waterItem);

        assertNotNull(newTile.getItem());
    }

    @Test
    public void testRemoveItem(){
        FloorTile newTile = new FloorTile();
        Item waterItem = new Water();
        newTile.addItem(waterItem);

        newTile.removeItem();
        assertNull(newTile.getItem());


    }

    @Test
    public void testAddItemToTileWithItem(){
        FloorTile newTile = new FloorTile();
        Item beerItem = new Beer();
        newTile.addItem(beerItem);
        Item waterItem = new Water();

        assertEquals(beerItem, newTile.getItem());
    }

    @Test
    public void testGetItem(){
        Item item = new Water();
        FloorTile floortile = new FloorTile();
        floortile.addItem(item);

        assertEquals(item, floortile.getItem());
    }
    @Test
    public void testHasItem(){
        FloorTile newTile = new FloorTile();
        Item waterItem = new Water();
        newTile.addItem(waterItem);
        assertTrue(newTile.hasItem());

    }

    @Test
    public void testCreateDoorTile(){
        DoorTile newTile = new DoorTile();
        assertNotNull(newTile);

    }

    @Test
    public void testIsDoorTileWalkAble(){
        DoorTile newTile = new DoorTile();
        assertTrue(newTile.walkAble);
    }

    @Test
    public void testTileEquals(){
        Tile tile1 = new FloorTile();
        Tile tile2 = new FloorTile();

        assertTrue(tile1.equals(tile2));
    }
    @Test
    public void testFloorTileEquals(){
        FloorTile tile1 = new FloorTile();
        FloorTile tile2 = new FloorTile();

        assertTrue(tile1.equals(tile2));
    }

    @Test
    public void testTileNotEqual(){
        Tile tile1 = new NonWalkAbleTile();
        Tile tile2 = new FloorTile();

        assertFalse(tile1.equals(tile2));
    }

    @Test
    public void testTileHashCode(){
        Tile tile1 = new FloorTile();
        Tile tile2 = new FloorTile();

        assertEquals(tile1.hashCode(), tile2.hashCode());
    }

    @Test
    public void testTileHashCodeItem(){
        FloorTile tile1 = new FloorTile();
        tile1.addItem(new Beer());

        FloorTile tile2 = new FloorTile();
        tile2.addItem(new Beer());

        assertEquals(tile1.hashCode(), tile2.hashCode());
    }

    @Test
    public void testFloorTileHashCode(){
        FloorTile tile1 = new FloorTile();
        FloorTile tile2 = new FloorTile();

        assertEquals(tile1.hashCode(), tile2.hashCode());
    }







}
