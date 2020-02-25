import edu.princeton.cs.algs4.StdOut;

public class Ramanujan1 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]); // command line
        for (int a = 1; a*a*a <= N; a++) {
        int cubeA = a*a*a;
        for (int b = a; b * b * b <= N - a * a * a; b++) {
        int cubeB = b * b * b;
        for (int c = a + 1; c * c * c <= N; c++) {
        int cubeC = c * c * c;
        for (int d = c; d * d * d <=  N - c * c * c; d++) {
        int cubeD = d * d * d;
        if (a * a * a + b * b * b == c * c * c + d * d * d) {
        StdOut.printf("%d = %d^3 + %d^3 = %d^3 + %d^3\n", 
        a * a * a + b * b * b, a, b, c, d);
    }
}
}
}
}
}
}
