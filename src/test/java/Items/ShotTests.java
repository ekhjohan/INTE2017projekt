package Items;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ShotTests {
    @Test
    public void createShotTest(){
        Item i = new Shot();
        assertNotNull(i);
    }
}
