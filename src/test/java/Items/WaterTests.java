package Items;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class WaterTests {
    @Test
    public void createWaterTest() {
        Item i = new Water();
        assertNotNull(i);
    }
}
