import items.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTests {
    private Player player;

    @Before
    public void initPlayer() {
        player = new Player("Test");
    }

    @Test
    public void testCreatePlayer() {
        assertNotNull(player);
    }

    @Test
    public void testPlayerHasName() {
        String name = "Test";
        assertEquals(name, player.getName());
    }

    @Test
    public void testPlayerHasHealth() {
        int life = player.getLife();
        assertEquals(1, life);
    }

    @Test
    public void testPlayerHasSpeed() {
        int speed = player.getSpeed();
        assertEquals(10, speed);
    }

    @Test
    public void testGetPlayerCoordinate() {
        player.setCoordinate(0, 0);
        Coordinate coord = new Coordinate(0, 0);

        assertEquals(coord, player.getCoordinate());
    }

    @Test
    public void testItemListIsNull() {

        assertNull(player.getItemList());
    }

    @Test
    public void addItem() {
        player.addItem(new Water());

        assertFalse(player.getItemList().isEmpty());
    }

    @Test
    public void testGetDrunknessNoItems() {
        int drunk = player.getDrunkness();
        assertEquals(0, drunk);

    }

    @Test
    public void testGetDrunkessOneItem() {
        player.addItem(new Shot());

        assertEquals(1, player.getDrunkness());
    }

    @Test
    public void testNegativeDrunkness() {
        player.addItem(new Water());

        assertEquals(0, player.getDrunkness());
    }

    @Test
    public void testGetDrunknessLevel() {
        for (int i = 0; i < 45; i++)
            player.addItem(new Shot());
        player.addItem(new NonAlcoholicDrink());

        assertEquals(8, player.getDrunkness());
    }

    @Test
    public void testTooManyWater() {
        player.addItem(new Beer());
        player.addItem(new Water());
        player.addItem(new NonAlcoholicDrink());

        player.getDrunkness();
        assertEquals(0, player.getDrunkness());
    }

    @Test
    public void testMove() {
        player.setCoordinate(0, 0);
        player.moveCharacter('d');

        assertEquals(new Coordinate(1, 0), player.getCoordinate());
    }

    @Test
    public void testMoveLonger() {
        player.setCoordinate(0, 0);
        player.moveCharacter('d');
        player.moveCharacter('s');
        player.moveCharacter('d');
        player.moveCharacter('w');
        player.moveCharacter('a');

        assertTrue(player.getCoordinate().equals(new Coordinate(1, 0)));
    }


    @Test
    public void calculateMissMove() {
        player.setCoordinate(0, 0);
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Wine());
        player.addItem(new Wine());
        int moveRight = 0;
        for (int i = 0; i < 2500; i++) {
            player.setCoordinate(0, 0);
            player.calculateMove('d');
            if (player.getCoordinate().getX() == 1) moveRight++;
        }
        for (int i = 0; i < 2500; i++) {
            player.setCoordinate(0, 0);
            player.calculateMove('a');
            if (player.getCoordinate().getX() == -1) moveRight++;
        }
        for (int i = 0; i < 2500; i++) {
            player.setCoordinate(0, 0);
            player.calculateMove('s');
            if (player.getCoordinate().getY() == 1) moveRight++;
        }
        for (int i = 0; i < 2500; i++) {
            player.setCoordinate(0, 0);
            player.calculateMove('w');
            if (player.getCoordinate().getY() == -1) moveRight++;
        }
        assertTrue(moveRight < 8500 && moveRight > 7500);
    }
}
