import edu.princeton.cs.algs4.StdOut;

public class Harmonic {
    public static void main(String[] args) {
        // Get n from command line as integer
        int n = Integer.parseInt(args[0]);

        // Set total to the rational number 0
        Rational total = new Rational(0);

        // For each 1 <= i <= n, add the rational term
        // 1 / i to total
        for (int i = 1; i <= n; i++) {
            Rational term = new Rational(1, i);
            total = total.add(term);
        }

        // Write total
        StdOut.println(total);
    }
}
