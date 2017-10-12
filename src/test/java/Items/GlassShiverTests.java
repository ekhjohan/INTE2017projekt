package Items;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GlassShiverTests {
    @Test
    public void createShiverTest(){
        Item i = new GlassShiver();
        assertNotNull(i);
    }
}
