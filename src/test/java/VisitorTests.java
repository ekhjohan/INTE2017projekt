import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VisitorTests {
    @Test
    public void createVisitor() {
        Visitor visitor = new Visitor();
        assertNotNull(visitor);
    }

    @Test
    public void visitorHasSpeed() {
        Visitor visitor = new Visitor();
        int speed = visitor.getSpeed();
        assertEquals(0, speed);
    }

    @Test
    public void getHotness(){
        Visitor v = new Visitor();
        assertNotNull(v.getHotness());
    }
    @Test
    public void getLife(){
        Visitor v = new Visitor();
        assertEquals(1, v.getLife());
    }
}