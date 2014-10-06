import java.io.*;
import java.lang.*;
import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String text = in.next();
            out.println(countHoles(text));
        }
        in.close();
        out.close();
    }
    static int countHoles(String text) {
        int total = 0;   
        for (char c : text.toCharArray()) {
            if (c == 'A' || c == 'Q' || c == 'D' || c == 'R' || c == 'O' || c == 'P') total++;
            else if (c == 'B') total += 2;
        }
        return total;
    }
}
