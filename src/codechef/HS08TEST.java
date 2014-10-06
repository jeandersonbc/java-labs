import java.lang.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while (in.hasNext()) {
            int w = in.nextInt();
            float bal = in.nextFloat();
            if (w % 5 == 0) {
                bal -= w + 0.5;
                if (bal < 0) bal += w + 0.5;
            }
            out.printf("%.2f\n", bal);
        }
        out.close();
        in.close();
    }
}
