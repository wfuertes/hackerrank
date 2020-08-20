package interview.preparation.kit.arrays;

/**
 * Hard: 60
 *
 * @see <a href="https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays">ArrayManipulation</a>
 */
public class ArrayManipulation {

    private static final int LEFT_INDEX = 0;
    private static final int RIGHT_INDEX = 1;
    private static final int SUMMAND = 2;

    /**
     * Solution using traditional way to think about arrays. But O(n*q)
     */
    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n];
        long maximum = Long.MIN_VALUE;

        for (int[] query : queries) {
            for (int i = query[LEFT_INDEX] - 1; i <= query[RIGHT_INDEX] - 1; i++) {
                array[i] += query[SUMMAND];

                if (array[i] > maximum) {
                    maximum = array[i];
                }
            }
        }
        return maximum;
    }

    /**
     * <pre>
     * Resolving using O(n) with run over all query ranges operating only the edges.
     * 10 3
     * 1 5 3
     * 4 8 7
     * 6 9 1
     *
     * arr = [0 0 0 0 0 0 0 0 0 0]
     * q1(1 5 3) -> [3 0 0 0 -3 0 0  0  0 0]
     * q2(4 8 7) -> [3 0 0 7 -3 0 0 -7  0 0]
     * q3(6 9 1) -> [3 0 0 7 -3 1 0 -7 -1 0]
     *
     * i = 0..arr.length
     * 0 -> 3                       = 3
     * 1 -> 3 + 0                   = 3
     * 2 -> 3 + 0 + 0               = 3
     * 3 -> 3 + 0 + 0 + 7           = 10
     * ...
     * 9 -> 3 0 0 7 -3 1 0 -7 -1 0  = 0
     *
     * Where the max is 10.
     * </pre>
     */
    static long arrayManipulationImproved(int n, int[][] queries) {
        final long[] array = new long[n];

        for (int[] query : queries) {
            array[query[LEFT_INDEX] - 1] += query[SUMMAND];

            if (query[RIGHT_INDEX] + 1 <= array.length) {
                array[query[RIGHT_INDEX]] -= query[SUMMAND];
            }
        }

        long max = 0;
        long sum = 0;

        for (long value : array) {
            sum += value;
            max = Math.max(max, sum);
        }

        return max;
    }
}
