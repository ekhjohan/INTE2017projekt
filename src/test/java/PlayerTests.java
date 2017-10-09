import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTests {
    @Test
    public void createPlayer() {
        Player player = new Player();
        assertNotNull(player);
    }
    @Test
    public void playerHasHealth() {
        Player player = new Player();
        int health = player.getLife();
        assertEquals(1, health);
    }
    @Test
    public void playerHasSpeed() {
        Player player = new Player();
        int speed = player.getSpeed();
        assertEquals(10, speed);
    }


}
