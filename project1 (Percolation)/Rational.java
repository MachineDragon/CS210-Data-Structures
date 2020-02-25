import edu.princeton.cs.algs4.StdOut;

// A data type representing a rational number.
public class Rational {
    private long x; // numerator
    private long y; // denominator

    // Construct a rational number whose numerator is x and
    // denominator is 1.
    public Rational(long x) {
        // Set this.x to x and this.y to 1
        this.x = x;
        this.y = 1;
    }

    // Construct a rational number given its numerator and
    // denominator.
    public Rational(long x, long y) {
        // Set this.x to x / gcd(x, y) and this.y to
        // y / gcd(x, y)
        this.x = x / gcd(x, y);
        this.y = y / gcd(x, y);
    }

    // The sum of this and that rational number.
    public Rational add(Rational that) {
        // Sum of rationals a/b and c/d is the rational
        // (ad + bc) / bd
        long num = (this.x * that.y) + (this.y * that.x);
        long den = (this.y * that.y);
        return new Rational(num, den);
        
    }

    // The product of this and that rational number.
    public Rational multiply(Rational that) {
        // Product of rationals a/b and c/d is the rational
        // ac / bd
        return new Rational(this.x * that.x, this.y * that.y);
    }

    // Is this rational number the same as that?
    public boolean equals(Rational that) {
        // Rationals a/b and c/d are equal iff a == c
        // and b == d
        if ((this.x == that.x) && (this.y == that.y)) {
          return true;
        }
        return false;
    }
    // A string representation of the rational number
    public String toString() {
        long a = x, b = y;
        if (a == 0 || b == 1) {
            return a + "";
        }
        if (b < 0) {
            a *= -1;
            b *= -1;
        }
        return a + "/" + b;
    }

    // gcd(p, q), computed using Euclid's algorithm.
    private static long gcd(long p, long q) {
        return q == 0 ? p : gcd(q, p % q);
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Rational total = new Rational(0);
        Rational term = new Rational(1);
        for (int i = 1; i <= n; i++) {
            total = total.add(term);
            term = term.multiply(new Rational(1, 2));
        }
        Rational expected = new Rational((long) Math.pow(2, n) - 1,
                                         (long) Math.pow(2, n - 1));
        StdOut.println(total.equals(expected));
    }
} 
