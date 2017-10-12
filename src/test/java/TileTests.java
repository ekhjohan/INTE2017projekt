import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import org.junit.Test;

import static org.junit.Assert.*;

public class TileTests {

    @Test
    public void createNonWalkAbleTileWithFalse(){
        NonWalkAbleTile newTile = new NonWalkAbleTile();
        assertNotNull(newTile);

    }

    @Test
    public void isNonWalkAbleTileWalkAble(){
        NonWalkAbleTile newTile = new NonWalkAbleTile();
        assertFalse(newTile.walkAble);
    }

    @Test
    public void createFloorTile(){
        FloorTile newTile = new FloorTile("Öl");
        assertNotNull(newTile);

    }

    @Test
    public void isFloorTileWalkAble(){
        FloorTile newTile = new FloorTile("Öl");
        assertTrue(newTile.walkAble);
    }

    @Test
    public void testObjectOnFloorTile(){
        FloorTile newTile = new FloorTile("Shot");
        assertEquals("Shot", newTile.objectToBePlaced);
    }

    @Test
    public void createDoorTile(){
        DoorTile newTile = new DoorTile();
        assertNotNull(newTile);

    }

    @Test
    public void isDoorTileWalkAble(){
        DoorTile newTile = new DoorTile();
        assertTrue(newTile.walkAble);
    }











}
