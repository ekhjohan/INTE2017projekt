package Items;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class NonAlcoholicTests {
    @Test
    public void createNonAlcoholicDrinkTest() {
        Item i = new NonAlcoholicDrink();
        assertNotNull(i);
    }
}
