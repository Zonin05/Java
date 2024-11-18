import java.util.Scanner;

public class StaticBlock {

    static int breadth;
    static int height;
    static int area;

    // Static initialization block to check for validity of breadth and height
    static {
        Scanner sc = new Scanner(System.in);
        
        try {
            breadth = sc.nextInt();
            height = sc.nextInt();
            
            if (breadth <= 0 || height <= 0) {
                throw new RuntimeException("Breadth and height must be positive");
            } else {
                area = breadth * height; // Calculate area if valid
            }
        } catch (RuntimeException e) {
            System.out.println("java.lang.Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // If valid input, print the area
        if (area > 0) {
            System.out.println(area);
        }
    }
}
