package items;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BeerTests {
    @Test
    public void testCreateBeer(){
        Item i = new Beer();
        assertNotNull(i);
    }

}

