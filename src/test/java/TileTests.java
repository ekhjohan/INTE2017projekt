import Items.Beer;
import Items.Item;
import Items.Water;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import org.junit.Test;

import static org.junit.Assert.*;

public class TileTests {

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
    public void testHasItem(){
        FloorTile newTile = new FloorTile();
        Item waterItem = new Water();
        newTile.addItem(waterItem);
        assertTrue(newTile.hasItem());

    }

    @Test
    public void testObjectOnFloorTile(){

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











}
