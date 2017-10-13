import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CharacterTests {
    private Character newCharacter;

    @Before
    public void createCharacter(){
        newCharacter = new Player("Test");
    }

    @Test
    public void testSpeed(){
       assertEquals(10, newCharacter.getSpeed());
    }

    @Test
    public void testSetCoordinate(){
        newCharacter.setCoordinate(0,0);
        Coordinate coord = new Coordinate(0,0);
        assertEquals(coord, newCharacter.getCoordinate());
    }

    @Test
    public void testUpdateCoordinate(){
        Coordinate newCoord = new Coordinate(0, 1);
        newCharacter.setCoordinate(0,0);
        newCharacter.updateCoordinate(0,1);

        assertEquals(newCoord, newCharacter.getCoordinate());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testTooBigYCoordinateUpdate(){
        newCharacter.setCoordinate(0,0);
        newCharacter.updateCoordinate(0,2);

    }
  @Test (expected = IndexOutOfBoundsException.class)
    public void testTooBigXCoordinateUpdate(){
        newCharacter.setCoordinate(0,0);
        newCharacter.updateCoordinate(2,0);

    }



}
