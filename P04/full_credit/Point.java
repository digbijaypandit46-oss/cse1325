import java.util.Objects;

public class Point {
    private double x;
    private double y;

    // Constructor with parameters
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Default constructor using constructor chaining
    public Point() {
        this(0.0, 0.0);
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Equals override (with epsilon tolerance)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        double eps = 0.000001;
        return Math.abs(this.x - p.x) < eps && Math.abs(this.y - p.y) < eps;
    }

    // HashCode override
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // ToString override
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
