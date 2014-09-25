/*
 * javac Equality.java
 *
 * Unix:    "java Equality < input"
 * Windows: "get-content input | java Equality"
 */
import java.io.BufferedInputStream;
import java.util.Scanner;
/*
 * Do you know how to compare 2 integers without the equality operator?
 */
class Equality {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.printf("%10d == %10d => %s\n", a, b, areEquals(a, b) ? "equals" : "not equals");
        }
        sc.close();
    }
    /*
     * Using bitwise operators, it would be a !(a ^ b > 0). However,
     * because of the integer representation, considering signed values,
     * the operations fails to check the signal bit. Bitwise won't work here
     */
    private static boolean areEquals(int a, int b) {
        int max = a > b ? a : b;
        int min = a < b ? a : b;
        return !((max - min) > 0);
    }
}
