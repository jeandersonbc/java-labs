import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;
class Main {
    static Map<BigInteger, BigInteger> cache = new HashMap<BigInteger, BigInteger>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        while (n-- > 0) {
            int v = in.nextInt();
            out.println(factorialOf(new BigInteger(v + "")));
        }
        out.close();
        in.close();
    }
    static BigInteger factorialOf(BigInteger n) {
        if (n.equals(BigInteger.ONE))
            return BigInteger.ONE;
        if (cache.get(n) != null)
            return cache.get(n);
        BigInteger result = n.multiply(
            factorialOf(n.subtract(BigInteger.ONE))
        );
        cache.put(n, result);
        return result;
    }
}
