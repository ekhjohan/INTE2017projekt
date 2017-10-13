import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTests {
    @Test
    public void createPlayer() {
        Player player = new Player("Test");
        assertNotNull(player);
    }

    @Test
    public void playerHasName() {
        Player player = new Player("Test");
        String name = "Test";
        assertEquals(name, player.getName());
    }

    @Test
    public void playerHasHealth() {
        Player player = new Player("Test");
        int life = player.getLife();
        assertEquals(1, life);
    }

    @Test
    public void playerHasSpeed() {
        Player player = new Player("Test");
        int speed = player.getSpeed();
        assertEquals(10, speed);
    }

    @Test
    public void getPlayerCoordinate() {
        // Vi får (temporärt) implementera en setCoordinate eller liknande
        // så att vi kan testa detta. Inte hunnit än.
        Player player = new Player("Test");
        int speed = player.getSpeed();
        assertEquals(10, speed);
    }
}
