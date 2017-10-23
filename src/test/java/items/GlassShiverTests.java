package items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GlassShiverTests {
    @Test
    public void createShiverTest(){
        Item i = new GlassShiver();
        assertNotNull(i);
    }
    @Test
    public void getDamage(){
        GlassShiver glassShiver = new GlassShiver();
        int damage = glassShiver.getDamage();
        assertEquals(1, damage);
    }


}
