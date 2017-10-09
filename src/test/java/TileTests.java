import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TileTests {

    @Test
    public void tileExist() {
        assertEquals("EMPTY", Tile.EMPTY.name());
    }
}
