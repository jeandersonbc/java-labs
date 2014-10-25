import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedInputStream;

/**
 * Testing performance of different pivots on QuickSort
 */
public class QuickSort {

    abstract static class ClassicQuickSort {

        private long comparisons;

        // Wrapper function
        List<Integer> sort(List<Integer> values) {
            if (values == null) {
                throw new java.lang.IllegalArgumentException();
            }
            this.comparisons = 0;
            List<Integer> clonned = new ArrayList<Integer>(values);
            sort(clonned, 0, clonned.size() - 1);
            return clonned;
        }
        // QuickSort
        private final void sort(List<Integer> values, int left, int right) {
            if (left < right) {
                this.comparisons += (right - left);
                int p = partition(values, left, right);
                sort(values, left, p - 1);
                sort(values, p + 1, right);
            }
        }
        protected abstract int partition(List<Integer> values, int left, int right);

        long getNumberOfComparisons() {
            return this.comparisons;
        }
    }
    /**
     * First element as the pivot.
     */
    static class QuickSort1 extends ClassicQuickSort {
        @Override
        protected int partition(List<Integer> values, int left, int right) {
            Integer pivot = values.get(left);
            int i = left;
            for (int j = left + 1; j <= right; j++) {
                if (values.get(j) < pivot) {
                    Integer temp = values.get(++i);
                    values.set(i, values.get(j));
                    values.set(j , temp);
                }
            }
            Integer temp = values.get(i);
            values.set(i, pivot);
            values.set(left, temp);

            return i;
        }
        @Override
        public String toString() {
            return "QuickSort ver1 [first-pivot]";
        }
    }
    /**
     * Last element as the pivot.
     */
    static class QuickSort2 extends ClassicQuickSort {
        protected int partition(List<Integer> values, int left, int right) {
            Integer pivot = values.get(right);

            Integer temp = values.get(left);
            values.set(left, pivot);
            values.set(right, temp);

            int i = left;
            for (int j = left + 1; j <= right; j++) {
                if (values.get(j) < pivot) {
                    temp = values.get(++i);
                    values.set(i, values.get(j));
                    values.set(j , temp);
                }
            }
            temp = values.get(i);
            values.set(i, pivot);
            values.set(left, temp);

            return i;
        }
        @Override
        public String toString() {
            return "QuickSort ver2 [last-pivot]";
        }
    }
    /**
     * Median-of-3 as the pivot.
     */
    static class QuickSort3 extends ClassicQuickSort {
        protected int partition(List<Integer> values, int left, int right) {
            int pivotIndex = getMedian(values, left, right);
            Integer pivot = values.get(pivotIndex);

            Integer temp = values.get(left);
            values.set(left, pivot);
            values.set(pivotIndex, temp);

            int i = left;
            for (int j = left + 1; j <= right; j++) {
                if (values.get(j) < pivot) {
                    temp = values.get(++i);
                    values.set(i, values.get(j));
                    values.set(j , temp);
                }
            }
            temp = values.get(i);
            values.set(i, pivot);
            values.set(left, temp);

            return i;
        }
        private int getMedian(List<Integer> values, int min, int max) {
            return max;
        }
        @Override
        public String toString() {
            return "QuickSort ver3 [median-pivot]";
        }
    }
    // Driver
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        List<Integer> data = new ArrayList<Integer>();

        System.out.println("Loading test data");
        while (in.hasNext()) {
            data.add(in.nextInt());
        }
        ClassicQuickSort[] impls = {
            new QuickSort1(),
            new QuickSort2(),
            new QuickSort3(),
        };
        for (ClassicQuickSort impl : impls) {
            System.out.println(String.format("Running \"%s\" algorithm", impl));
            List<Integer> result = impl.sort(data);
            if (!isSorted(result)) {
                throw new java.lang.RuntimeException(
                    String.format("Algorithm \"%s\" should have sorted the values:%s",
                        impl, result
                    )
                );
            }
            System.out.println(String.format("Number of Comparisons: %d\n",
                impl.getNumberOfComparisons())
            );
        }
        in.close();
    }
    // Helper function
    static boolean isSorted(List<Integer> values) {
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i + 1))
                return false;
        }
        return true;
    }
}
