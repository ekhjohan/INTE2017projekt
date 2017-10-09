import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTests {
    @Test
    public void testNothing() {

    }

    @Test
    public void testX(){
        Player x = new Player();
        assertEquals(0,x.x);
    }

}
