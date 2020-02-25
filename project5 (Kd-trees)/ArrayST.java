import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ArrayST<Key, Value> {
    private static final int INIT_CAPACITY = 8;
    private Key[] keys;
    private Value[] values;
    private int N = 0;

    // Create a symbol table with INIT_CAPACITY.
    public ArrayST() {
    keys = (Key[]) new Object[INIT_CAPACITY];
    values = (Value[]) new Object[INIT_CAPACITY]; 
    }

    // Create a symbol table with given capacity.
    public ArrayST(int capacity) {
        keys = (Key[]) new Object[capacity];
    values = (Value[]) new Object[capacity];
    }

    // Return the number of key-value pairs in the table.
    public int size() {
        return N;
    }

    // Return true if the table is empty and false otherwise.
    public boolean isEmpty() {
        return size() == 0;
    }

    // Return true if the table contains key and false otherwise.
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // Return the value associated with key, or null.
    public Value get(Key key) {
        for (int i = 0; i < N; i++) {
        if (keys[i].equals(key)) {
        return values[i];
        }
        }
        return null;
        
    }

    // Put the kev-value pair into the table; remove key from table 
    // if value is null.
    public void put(Key key, Value value) {
        if (value == null) {
        delete(key);
        return;
        }
        for (int i = 0; i < N; i++) {
        if (key.equals(keys[i])) {
        values[i] = value;
        return;
        }
        }
        if (N == keys.length) { 
        resize(2 * keys.length); }
        keys[N] = key;
        values[N] = value;
        N++;
        }

    // Remove key (and its value) from table.
    public void delete(Key key) {
    int i, j;
        for (i = 0; i < N; i++) {
        if (keys[i].equals(key)) {
        break;
    }
    }
    if (i == N) {
    return;
    }
    for (j = i; j < N; j++) {
    keys[i] = keys[j + 1];
    values[i] = values[j + 1];
    }
    N--; 
    keys[N] = null;
    values[N] = null;
    if (N == keys.length / 4) resize(keys.length / 2);
    }

    // Return all the keys in the table.
    public Iterable<Key> keys()  {
        Queue<Key> q = new Queue<Key>();
        for (int i = 0; i < N; i++) {
        q.enqueue(keys[i]);
    }
    return q;
    }

    // Resize the internal arrays to capacity.
    private void resize(int capacity) {
        Key[] tempk = (Key[]) new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        ArrayST<String, Integer> st = new ArrayST<String, Integer>();
        int count = 0;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            st.put(s, ++count);
        }
        for (String s : args) {
            st.delete(s);
        }
        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
