/*
 * Inversions.java
 *
 * Compiling:
 *      javac Inversions.java
 * Running:
 *      WindowsPowerShell>  Get-Content <input-file> | java Main
 */
import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.Scanner;
class Main {

    interface InversionProbIF {
        /**
         * @param values Array of values to be analyzed
         * @return Number of existing inversions inside values.
         */
        long inversions(int[] values);
    }

    static class DivideAndConquerApproach implements InversionProbIF {
        private int[] buffer;

        @Override
        public long inversions(int[] values) {
            this.buffer = new int[values.length];
            return inversions(values, 0, values.length - 1);
        }
        private long inversions(int[] values, int i, int j) {
            long total = 0;
            if (i >= j)
                return total;

            int mid = (i + j) >> 1;

            total += inversions(values, mid + 1, j);
            total += inversions(values, i, mid);
            total += inversions(values, i, mid, j);

            return total;
        }
        private long inversions(int[] values, int i, int m, int j) {
            long total = 0;
            if (values[m] <= values[m + 1])
                return total;

            for (int k = i; k <= j; k++)
                buffer[k] = values[k];

            int lo = i;
            int hi = m + 1;
            for (int k = i; k <= j; k++) {
                if (lo > m)
                    values[k] = buffer[hi++];
                else if (hi > j)
                    values[k] = buffer[lo++];
                else if (buffer[lo] <= buffer[hi])
                    values[k] = buffer[lo++];
                else {
                    total += m - lo + 1;
                    values[k] = buffer[hi++];
                }
            }
            return total;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(System.out);

        // testing
        InversionProbIF alg = new DivideAndConquerApproach();
        int[] dummy = {3, 2, 1, 0};
        out.println(alg.inversions(dummy));

        // Real-problem
        int[] values = new int[(int)1e5];
        for (int i = 0; i < values.length; i++) {
            values[i] = in.nextInt();
        }
        out.println(alg.inversions(values));

        in.close();
        out.close();
    }
}
