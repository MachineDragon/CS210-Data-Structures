import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Josephus {
    public static void main(String[] args) {
        // Get M and N from command line as ints.
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        
        // Create a queue q and enqueue integers
        // 0, 1, ... N - 1.
        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < N; i++) {
        q.enqueue(i);
        }
        int i = 0;
        // As long as q is not empty: increment i;
        // dequeue an element pos; if M divides i,
        // write pos, otherwise enqueue pos.
        while (q.size() > 1) {
        i++;
        if (i % M == 0) {
        StdOut.print(q.dequeue() + " ");
        }
        else {
        q.enqueue(q.dequeue());
        }
    }
            
        // Dequeue and write the remaining element
        // from q.

        StdOut.println(q.dequeue());
    }
}


