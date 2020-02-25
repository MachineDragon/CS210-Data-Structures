import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

// A data type representing a text editor buffer.
public class Buffer {
    private Stack<Character> left;  // chars left of cursor
    private Stack<Character> right; // chars right of cursor

    // Create an empty buffer.
    public Buffer() {
        left = new Stack<Character>();
        right = new Stack<Character>();
    }

    // Insert c at the cursor position.
    public void insert(char c) {
        left.push(c);
    }
    
    // Delete and return the character at the cursor.
    public char delete() {
        if (!right.isEmpty()) {
        return right.pop();
        }
        else {
        return 0;
    }
    }

    // Move the cursor k positions to the left.
    public void left(int k) {
        while (!left.isEmpty() && --k >= 0) {
        right.push(left.pop());
    }
    }

    // Move the cursor k positions to the right.
    public void right(int k) {
        while (!right.isEmpty() && --k >= 0) {
         if (!left.isEmpty()) {
        left.push(right.pop());
    }
    }
    }

    // Return the number of characters in the buffer.
    public int size() {
        return left.size() + right.size();
    }

    // Return a string representation of the buffer with
    // a "|" character (not part of the buffer) at the
    // cursor position.
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Push chars from left into a temporary stack.
       Stack<Character> temporaryBuffer = new Stack<Character>();
       while (!left.isEmpty() && left.size() >= 0) {
       temporaryBuffer.push(left.pop());
       }
            
        // Append chars from temporary stack to sb.
            while (!temporaryBuffer.isEmpty() && left.size() >= 0) {
            temporaryBuffer.push(left.pop());
            }
        // Append "|" to sb.
        sb.append("|");

        // Append chars from right to sb.
       while (!right.isEmpty() && right.size() >= 0) {
        temporaryBuffer.push(right.pop());
        }
            
        // Return the string from sb.
        return sb.toString();
    }
    
    
    // Test client (DO NOT EDIT).
    public static void main(String[] args) {
        Buffer buf = new Buffer();
        String s = "There is grandeur in this view of life, with its " 
            + "several powers, having been originally breathed into a few " 
            + "forms or into one; and that, whilst this planet has gone " 
            + "cycling on according to the fixed law of gravity, from so " 
            + "simple a beginning endless forms most beautiful and most " 
            + "wonderful have been, and are being, evolved. ~ " 
            + "Charles Darwin, The Origin of Species";
        for (int i = 0; i < s.length(); i++) {
            buf.insert(s.charAt(i));
        }
        buf.left(buf.size());
        buf.right(97);
        s = "by the Creator ";
        for (int i = 0; i < s.length(); i++) {
            buf.insert(s.charAt(i));
        }
        buf.right(228);
        buf.delete();
        buf.insert('-');
        buf.insert('-');
        buf.left(342);
        StdOut.println(buf);
    }
}
