package Items;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BeerTests {
    @Test
    public void testCreateBeer(){
        Beer b = new Beer();
        assertNotNull(b);
    }

}

