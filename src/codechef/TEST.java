import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n == 42) break;
            out.println(n);
        }
        out.close();
        in.close();
    }
}
