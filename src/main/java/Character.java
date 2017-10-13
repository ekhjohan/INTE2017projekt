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

}
