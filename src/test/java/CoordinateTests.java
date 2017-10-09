import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CoordinateTests {

    @Test
    public void createCoordinate() {
        Coordinate coordinate = new Coordinate(2,3);
        assertNotNull(coordinate);
    }
    @Test
    public void coordinateX() {
        Coordinate coordinate = new Coordinate(3,2);
        int x = coordinate.getX();
        assertEquals(3, x);
    }
    @Test
    public void coordinateY() {
        Coordinate coordinate = new Coordinate(1,4);
        int y = coordinate.getY();
        assertEquals(4, y);
    }
    @Test
    public void equals() {
        Coordinate coordinate1 = new Coordinate(5,10);
        Coordinate coordinate2 = new Coordinate(5,10);
        assertTrue(coordinate1.equals(coordinate2));
    }
    @Test
    public void hashcode() {
        Coordinate coordinate1 = new Coordinate(1,2);
        Coordinate coordinate2 = new Coordinate(1,2);
        assertTrue(coordinate1.hashCode() == coordinate2.hashCode());
    }
}
