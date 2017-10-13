abstract public class Character {
    private int speed;
    private Coordinate coordinate;

    public Character(int speed){
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public Coordinate getCoordinate() {
        return coordinate.clone();
    }

    public void setCoordinate(int x, int y){
        this.coordinate = new Coordinate(x,y);
    }

}


//int xDiff = Math.abs(startCoord.getX() - newCoord.getX());
//int yDiff = Math.abs(startCoord.getY() - newCoord.getY());
//
//    assertTrue(xDiff);