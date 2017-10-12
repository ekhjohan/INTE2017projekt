package Items;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class WineTests {
    @Test
    public void createWineTest() {
        Item i = new Wine();
        assertNotNull(i);
    }
}
