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

    public void testSetCoordinate(){
        newCharacter.setCoordinate(0,0);
        Coordinate coord = new Coordinate(0,0);
        assertEquals(coord, newCharacter.getCoordinate());
    }

}
