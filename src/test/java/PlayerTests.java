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
        int drunk = player.getDrunknessLevel();
        assertEquals(0, drunk);

    }

    @Test
    public void testGetDrunkessOneItem() {
        player.addItem(new Shot());

        assertEquals(0, player.getDrunknessLevel());
    }

    @Test
    public void testNegativeDrunkness() {
        player.addItem(new Water());

        assertEquals(0, player.getDrunknessLevel());
    }

    @Test
    public void testGetDrunknessLevel() {
        for (int i = 0; i < 45; i++)
            player.addItem(new Shot());
        player.addItem(new NonAlcoholicDrink());
        assertEquals(6, player.getDrunknessLevel());
    }

    @Test
    public void testStateTransitions() {
        player.setCoordinate(0, 0);
        assertEquals(0, player.getDrunknessLevel());
        doX(1, new Beer(), 'w');
        assertEquals(0, player.getDrunknessLevel());
        doX(2, new Shot(), 'w');
        assertEquals(1, player.getDrunknessLevel());
        doX(1, new Beer(), 'w');
        assertEquals(6, player.getDrunknessPoints());
        doX(1, new Water(), 'w');
        assertEquals(5, player.getDrunknessPoints());
        doX(1, new Water(), 'w');
        assertEquals(0, player.getDrunknessLevel());
        doX(1, new Beer(), 'w');
        assertEquals(1, player.getDrunknessLevel());
        doX(7, new Beer(), 'w');
        assertEquals(12, player.getDrunknessPoints());
        doX(1, new Beer(), 'w');
        assertEquals(2, player.getDrunknessLevel());
        doX(1, new Beer(), 'w');
        assertEquals(14, player.getDrunknessPoints());
        doX(1, new Water(), 'w');
        assertEquals(13, player.getDrunknessPoints());
        doX(1, new Water(), 'w');
        assertEquals(12, player.getDrunknessPoints());
        doX(1, new Water(), 'w');
        assertEquals(11, player.getDrunknessPoints());
        assertEquals(1, player.getDrunknessLevel());
    }

    private void doX(int times, Item item, char direction) {
        for (int i = 0; i < times; i++) {
            player.addItem(item);
            player.movePlayer(direction);
        }
    }

    @Test
    public void testTooManyWater() {
        player.addItem(new Beer());
        player.addItem(new Water());
        player.addItem(new NonAlcoholicDrink());

        player.getDrunknessLevel();
        assertEquals(0, player.getDrunknessLevel());
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
            player.movePlayer('d');
            if (player.getCoordinate().getX() == 1) moveRight++;
        }
        for (int i = 0; i < 2500; i++) {
            player.setCoordinate(0, 0);
            player.movePlayer('a');
            if (player.getCoordinate().getX() == -1) moveRight++;
        }
        for (int i = 0; i < 2500; i++) {
            player.setCoordinate(0, 0);
            player.movePlayer('s');
            if (player.getCoordinate().getY() == 1) moveRight++;
        }
        for (int i = 0; i < 2500; i++) {
            player.setCoordinate(0, 0);
            player.movePlayer('w');
            if (player.getCoordinate().getY() == -1) moveRight++;
        }
        assertTrue(moveRight < 9000 && moveRight > 8000);
    }
}
