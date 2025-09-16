import java.util.Scanner;
import java.util.Random;

public class TestPolygon {
    private static Scanner in = new Scanner(System.in);
    private static Random rand = new Random(); // optional

    public static void main(String[] args) {
        boolean errorOccurred = false;

        try {
            // Test vector #1
            Polygon p1 = new Polygon();
            p1.addPoint(new Point()); // (0,0) using default constructor
            p1.addPoint(new Point(3,0));
            p1.addPoint(new Point(3,4));
            double perimeter = p1.perimeter();
            if (Math.abs(perimeter - 12.0) > 0.000001) {
                System.err.println("Test #1 failed: expected perimeter 12, got " + perimeter);
                errorOccurred = true;
            }

            // Test vector #2
            try {
                Polygon p2 = new Polygon();
                p2.addPoint(new Point());
                p2.addPoint(new Point(3,0));
                p2.addPoint(new Point(0,0)); // duplicate
                System.err.println("Test #2 failed: expected IllegalArgumentException not thrown");
                errorOccurred = true;
            } catch (IllegalArgumentException e) {
                // expected
            }

            // Test vector #3
            try {
                Polygon p3 = new Polygon();
                p3.addPoint(new Point());
                p3.addPoint(new Point(3,0));
                p3.perimeter(); // should throw
                System.err.println("Test #3 failed: expected RuntimeException not thrown");
                errorOccurred = true;
            } catch (RuntimeException e) {
                // expected
            }

            // Test vector #4
            try {
                Polygon p4 = new Polygon();
                for (int i = 0; i < 13; i++) {
                    p4.addPoint(new Point(rand.nextDouble(), rand.nextDouble()));
                }
                System.err.println("Test #4 failed: expected RuntimeException not thrown");
                errorOccurred = true;
            } catch (RuntimeException e) {
                // expected
            }

        } catch (Exception e) {
            System.err.println("Unexpected exception: " + e);
            errorOccurred = true;
        }

        if (errorOccurred) {
            System.err.println("One or more tests failed.");
            System.exit(1); // non-zero result
        } else {
            System.out.println("All tests passed!");
        }
    }
}
