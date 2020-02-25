import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public interface PointST<Value> {

    // Is the symbol table empty?
    public boolean isEmpty();
    
    // Number of points in the symbol table.
    public int size();
    
    // Associate the value val with point p.
    public void put(Point2D p, Value value);

    // Value associated with point p.
    public Value get(Point2D p);
    

    // Does the symbol table contain the point p?
    public boolean contains(Point2D p);

    // All points in the symbol table.
    public Iterable<Point2D> points();
    
    // All points in the symbol table that are inside the rectangle rect.
    public Iterable<Point2D> range(RectHV rect);

    // A nearest neighbor to point p; null if the symbol table is empty.
    public Point2D nearest(Point2D p);

    // k points that are closest to point p.
    public Iterable<Point2D> nearest(Point2D p, int k);
}
