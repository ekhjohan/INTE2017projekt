public class Coordinate implements Cloneable {

    private final int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }
    @Override public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public Coordinate clone() {
        try {
            return (Coordinate) super.clone();
        } catch (final CloneNotSupportedException ex) {
            throw new AssertionError(); // Finns inget test för denna Exception än...
        }
    }

    @Override
    public String toString() {
        return "Coordinate{" + "x=" + x + ", y=" + y +"}";
    }
}
