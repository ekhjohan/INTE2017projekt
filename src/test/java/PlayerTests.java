import items.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTests {
    private Player player;

    @Before
    public void player() {
        player = new Player("Test");
    }

    @Test
    public void createPlayer() {
        assertNotNull(player);
    }

    @Test
    public void playerHasName() {
        String name = "Test";
        assertEquals(name, player.getName());
    }

    @Test
    public void playerHasHealth() {
        int life = player.getLife();
        assertEquals(1, life);
    }

    @Test
    public void playerHasSpeed() {
        int speed = player.getSpeed();
        assertEquals(10, speed);
    }

    @Test
    public void getPlayerCoordinate() {
        player.setCoordinate(0,0);
        Coordinate coord = new Coordinate(0,0);

        assertEquals(coord, player.getCoordinate());
    }

    @Test
    public void testItemListIsNull(){

        assertNull(player.getItemList());
    }

    @Test
    public void addItem(){
        player.addItem(new Water());

        assertFalse(player.getItemList().isEmpty());
    }

    @Test
    public void testGetDrunknessNoItems(){
        int drunk = player.getDrunkness();
        assertEquals(0, drunk);

        }

    @Test
    public void testGetDrunkessOneItem(){
        player.addItem(new Shot());

        assertEquals(1, player.getDrunkness());
    }
    @Test
    public void testNegativeDrunkness(){
        player.addItem(new Water());

        assertEquals(0, player.getDrunkness());
    }
    @Test
    public void getDrunknessLevel(){
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
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());
        player.addItem(new Shot());


        assertEquals(8 , player.getDrunkness());
    }
    @Test
    public void testTooManyWater(){
        player.addItem(new Beer());
        player.addItem(new Water());
        player.addItem(new Water());

        player.getDrunkness();
        assertEquals(0, player.getDrunkness());
    }

    @Test
    public void testMove(){
        player.setCoordinate(0,0);
        player.move(1);

        assertEquals(new Coordinate(1,0), player.getCoordinate());
    }

    @Test
    public void testMoveLonger(){
        player.setCoordinate(0,0);
        player.move(1);
        player.move(3);
        player.move(1);
        player.move(4);
        player.move(2);

        assertTrue(player.getCoordinate().equals(new Coordinate(1,0)));
    }


    @Test
    public void calculateMissMove(){
        player.setCoordinate(0,0);
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
        player.addItem(new Shot());

        player.calcMove(1);
        assertTrue(player.getCoordinate().equals(new Coordinate(1,0)));

    }

}
