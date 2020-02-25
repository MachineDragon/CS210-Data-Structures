import edu.princeton.cs.algs4.StdOut;

public class PrimeCounter {
    // Is x prime?
    private static boolean isPrime(int x) {
   //prime number can be divided evenly into another number
   
    if (x < 2) {
    return false;
    }
    else if (x == 2) {
    return true;
    }
    //if you divide it by 2 and get a whole number, it cant be prime
    else if (x % 2 == 0) {
    return false;
    }
    int i;
    for (i = 3; i <= (int) Math.sqrt(x); i += 2)
    if (x % i == 0) {
    return false;
    }
    return true;
    }
    
    
    
        // For each 2 <= i <= sqrt(x), if x is divisible by
        // i, then x is not a prime; If no such i exists,
        // x is a prime


    // The number of primes <= N.
    private static int primes(int N) {
          // For each 2 <= i <= N, use isPrime() to test if
        // i is prime, and if so increment a count; At the
        // end return count
        int count = 0;
        int i;
        for (i = 1; i <= N; i++)
        if (isPrime(i)) {
        count++;
        }
        return count;
        }

    // Entry point. [DO NOT EDIT]
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdOut.println(primes(N));
    }
}
