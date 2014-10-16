import java.lang.IllegalArgumentException;

class Main {

    /** Implements the Maximum-Subarray Problem */
    interface MaxSubArrayProblemIF {

        /** Returns the maximum sum of the maxium-subarray within values */
        int maxSum(int[] values);
    }
    static class DivideAndConquer implements MaxSubArrayProblemIF {
        @Override
        public int maxSum(int[] values) {
            return maxSum(values, 0, values.length - 1);
        }
        private int maxSum(int[] values, int left, int right) {
            // base case
            if (left >= right)
                return values[left];

            // crossing-point
            int mid = (right + left) / 2;

            int maxSumLeft = maxSum(values, left, mid);
            int maxSumRight = maxSum(values, mid+1, right);
            int maxSumCrossing = maxSum(values, left, mid, right);

            int result = maxSumLeft > maxSumRight ? maxSumLeft : maxSumRight;
            result = maxSumCrossing > result ? maxSumCrossing : result;

            return result;
        }
        private int maxSum(int[] values, int low, int mid, int high) {
            int sum = values[mid];
            int sumTmp = sum;
            for (int i = mid - 1; i >= 0; i--) {
                sumTmp += values[i];
                if (sumTmp > sum)
                    sum = sumTmp;
            }
            sumTmp = sum;
            for (int j = mid + 1; j < values.length; j++) {
                sumTmp += values[j];
                if (sumTmp > sum)
                    sum = sumTmp;
            }
            return sum;
        }
    }
    /** Naive implementation of the Maximum-Subarray Problem. Given an array A of N elements,
    check for all possible sequences with different lenghts L and update the maximum sum.
    It requires O(n^2) * O(n) steps to find the solution (therefore, O(n^3)). Extra memory not required */
    static class Naive implements MaxSubArrayProblemIF {
        @Override
        public int maxSum(int[] values) {
            if (values == null || values.length == 0)
                throw new IllegalArgumentException();

            // Assuming the maximum sum as the trivial subarray A[0]
            int max = values[0];

            // Checking all possible starting points from the max-subarray
            for (int i = 0; i < values.length; i++) {
                // Checking all possible ending points from the max-subarray
                // started by i
                for (int j = i; j < values.length; j++) {

                    // Sum the current interval
                    int tmp = sum(values, i, j);

                    // Update solution
                    if (tmp > max)
                        max = tmp;
                }
            }
            return max;
        }
        private int sum(int[] A, int i, int j) {
            int total = 0;
            for (int k = i; k <= j; k++)
                total += A[k];
            return total;
        }
    }

    // Test driver
    public static void main(String[] args) {
        int[] values = {13, -3, -25, 20, -3, -16, -23,
                18, 20, -7, 12, -5, -22, 15, 7};

        MaxSubArrayProblemIF[] algs = {
            new Naive(),
            new DivideAndConquer()
        };
        for (MaxSubArrayProblemIF alg : algs) {
            System.out.println("Should be 43: " + alg.maxSum(values));
        }
    }
}
