import java.lang.StringBuilder;

class Main {

    public static void main(String[] args) {
        int[] values = {-1 , 1, 2, -2};
        String binRep;
        for (int v : values) {
            binRep = toBinary32bits(v);
            System.out.printf("(%s)\t", isNegative(v) ? "neg" : "pos");
            System.out.printf("(mod: %2d)\t", extractModule(v));
            System.out.printf("%2d -> %32s (%d bits)\n", v, binRep, binRep.length());
        }
        System.out.println();
        for (int a : values) {
            for (int b : values) {
                System.out.printf("%2d == %2d ? %s\n", a, b, equals(a, b) ? "same" : "not same");
            }
        }
        System.out.println("Comparing >> and >>> operators");
        int a = 0xABCD1941;
        int b = 0xABCD1941;
        for (int i = 0; i < 32; i++) {
            b >>>= i;
            a >>= i;
            System.out.printf("%11d >>  %2d = %s\t", a, i, Integer.toBinaryString(a));
            System.out.printf("%11d >>> %2d = %s\n", b, i, Integer.toBinaryString(b));
        }
    }
    /** returns true if n is a negative value. Shifts the signal bit
    to the 0-th index and performs a bitwise AND to check if it's negative */
    private static boolean isNegative(int n) {
        return ((n >> 31) & 1) > 0;
    }
    /** extracts the module of the integer value. One's complement */
    private static int extractModule(int n) {
        if (n >= 0) return n;

        int module = ~n + 1;
        return module;
    }
    private static boolean equals(int a, int b) {
        return (a ^ b) == 0;
    }
    private static String toBinary32bits(int n) {
        StringBuilder str = new StringBuilder();
        for (int ithBit = 31; ithBit >= 0; ithBit--) {
            str.append((n >> ithBit) & 1);
        }
        return str.toString();
    }
}
