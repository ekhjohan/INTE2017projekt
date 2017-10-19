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

    public void updateCoordinate(int x , int y) throws IndexOutOfBoundsException{
            int xDiff = Math.abs(this.coordinate.getX() - x);
            int yDiff = Math.abs(this.coordinate.getY() - y);

            if ((xDiff + yDiff) > 1)throw new IndexOutOfBoundsException("Too big update");


            this.coordinate = new Coordinate(x, y);
    }

    public void move(int direction){

        switch (direction){
            case 1:
                this.coordinate = new Coordinate(this.coordinate.getX()+1, this.coordinate.getY());
                break;
            case 2:
                this.coordinate = new Coordinate(this.coordinate.getX()-1, this.coordinate.getY());
                break;
            case 3:
                this.coordinate = new Coordinate(this.coordinate.getX(), this.coordinate.getY()+1);
                break;
            case 4:
                this.coordinate = new Coordinate(this.coordinate.getX(), this.coordinate.getY()-1);
                break;
            default:
                break;
        }
    }

}



