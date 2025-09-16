public class Polygon {
    public static final int MAX_SIDES = 12;
    private int numSides = 0;
    private Point[] points = new Point[MAX_SIDES];

    // Add a point with validation
    public void addPoint(Point point) {
        // Check for duplicates
        for (int i = 0; i < numSides; i++) {
            if (points[i].equals(point)) {
                throw new IllegalArgumentException("Duplicate point: " + point);
            }
        }

        // Check if polygon is full
        if (numSides >= MAX_SIDES) {
            throw new RuntimeException("Polygon is full");
        }

        // Add point
        points[numSides++] = point;
    }

    // Compute perimeter with validation
    public double perimeter() {
        if (numSides < 3) {
            throw new RuntimeException("Polygons required 3+ sides!");
        }

        double total = 0.0;
        for (int i = 0; i < numSides; i++) {
            Point p1 = points[i];
            Point p2 = points[(i + 1) % numSides]; // wrap around
            total += lineLength(p1, p2);
        }
        return total;
    }

    // Private static helper
    private static double lineLength(Point p1, Point p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    // ToString override
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Polygon[");
        for (int i = 0; i < numSides; i++) {
            sb.append(points[i]);
            if (i < numSides - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}