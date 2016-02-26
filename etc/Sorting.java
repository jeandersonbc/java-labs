import java.util.Arrays;
import java.util.Random;

class Main {

    interface SorterIF { void sort(int[] A); }

    static class InsertionSort implements SorterIF {
        @Override
        public void sort(int[] A) {
            for (int i = 1; i < A.length; i++) {
                int k = A[i];
                int j = i - 1;
                while (j >= 0 && k < A[j]) {
                    A[j + 1] = A[j];
                    j = j - 1;
                }
                A[j + 1] = k;
            }
        }
        @Override
        public String toString() { return "Insertion sort"; }
    }
    static class MergeSort implements SorterIF {
        private int[] buffer;

        @Override
        public void sort(int[] A) {
            this.buffer = new int[A.length];
            sort(A, 0, A.length - 1);
        }
        private void sort(int[] A, int min, int max) {
            if (max <= min) return;
            int mid = (min + max) >> 1;
            sort(A, min, mid);
            sort(A, mid+1, max);
            merge(A, min, mid, max);
        }
        private void merge(int[] A, int min, int mid, int max) {
            if (A[mid] <= A[mid+1]) return;
            for (int i = min; i <= max; i++)
                this.buffer[i] = A[i];
            int i = min;
            int j = mid + 1;
            for (int k = min; k <= max; k++) {
                if (i > mid)
                    A[k] = this.buffer[j++];
                else if (j > max)
                    A[k] = this.buffer[i++];
                else
                    A[k] = (this.buffer[i] < this.buffer[j])
                        ? this.buffer[i++]
                        : this.buffer[j++];
            }
        }
        @Override
        public String toString() { return "Merge sort"; }
    }

    public static void main(String[] args) {
        SorterIF[] sorters = {
            new MergeSort(),
            new InsertionSort(),
        };
        for (SorterIF alg : sorters) {
            System.out.printf("%s:\t", alg);
            for (int n = 10; n < (int)1e7; n *= 10) {
                System.out.printf("[%7d: ", n);
                int[] values1 = build(n);
                alg.sort(values1);
                if (!isSorted(values1)) {
                    System.err.printf("Array not sorted: %s\n", Arrays.toString(values1));
                    break;
                }
                System.out.printf("ok]");
            }
            System.out.println();
        }
    }
    /** Generates a random array of size n */
    static int[] build(int n) {
        Random rand = new Random(1234L);
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = rand.nextInt();
        }
        return values;
    }
    /** Returns true if values are sorted */
    static boolean isSorted(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] > values[i+1])
                return false;
        }
        return true;
    }

}
