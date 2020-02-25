import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;

public class Distance {
    // The Euclidean distance between the position vectors x and y
    private static double distance(double[] x, double[] y) {
    double total = 0;
        // For each 0 <= i < x.length, add the square of
        int size = x.length;
        // (x[i] - y[i]) to distance; at the end return statement
        for (int i = 0; i < size; i++) {
        total += (x[i]-y[i]) * (x[i]-y[i]);
        // sqrt(total distance)
    }
    total = Math.sqrt(total);
    return total;
    }

    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        double[] x = StdArrayIO.readDouble1D();
        double[] y = StdArrayIO.readDouble1D();
        StdOut.println(distance(x, y));
    }
}
