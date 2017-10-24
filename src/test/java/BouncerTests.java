import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BouncerTests {
    @Test
    public void createBouncer() {
        Bouncer bouncer = new Bouncer();
        assertNotNull(bouncer);
    }

    @Test
    public void bouncerHasSpeed() {
        Bouncer bouncer = new Bouncer();
        int speed = bouncer.getSpeed();
        assertEquals(1, speed);
    }
}
