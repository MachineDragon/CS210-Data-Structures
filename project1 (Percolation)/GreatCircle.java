import edu.princeton.cs.algs4.StdOut;

public class GreatCircle {
    public static void main(String[] args) {
 double x1 = Double.parseDouble(args[0]);
 double y1 = Double.parseDouble(args[1]);
 double x2 = Double.parseDouble(args[2]);
 double y2 = Double.parseDouble(args[3]);     
 // Get angles x1, y1, x2, and y2 from command line as
        // doubles
        // Convert the angles to radians

x1 = Math.toRadians(x1);
y1 = Math.toRadians(y1);
x2 = Math.toRadians(x2);
y2 = Math.toRadians(y2);
        // Calculate great-circle distance d
double d;
d = 111*Math.acos(Math.sin(x1)*Math.sin(x2) 
+ Math.cos(x1)*Math.cos(x2)*Math.cos(y1-y2));
        
// Write d
        
d = Math.toDegrees(d);
StdOut.printf("%f", d);
    }
}
