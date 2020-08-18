package interview.preparation.kit.arrays;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * Medium: 40
 *
 * @see <a href="https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays">minimum-swaps-2</a>
 * Used a SelectionSort in order to calculate the number of swaps needed.
 */
public class MinimumSwaps2 {

    /**
     * Selection Sort solution O(N^2)
     *
     * @param array of integer
     * @return minimumSwaps
     */
    static int minimumSwaps(int[] array) {
        int swaps = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int aux = array[i];
                array[i] = array[minIndex];
                array[minIndex] = aux;
                swaps++;
            }
        }
        return swaps;
    }

    /**
     * Solution only counting swapped elements from the sorted by a better algorithm
     *
     * @param array of integer
     * @return minimumSwaps
     */
    static int minimumSwapsImproved(int[] array) {
        final List<Entry<Integer, Integer>> entries = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            entries.add(new SimpleEntry<>(array[i], i));
        }

        // Sorting using TimSort O(n log n)
        entries.sort(Entry.comparingByKey());

        boolean[] visited = new boolean[array.length];

        int swaps = 0;

        for (int i = 0; i < array.length; i++) {
            if (visited[i] || entries.get(i).getValue() == i) {
                continue;
            }

            int innerSwaps = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = entries.get(j).getValue();
                innerSwaps++;
            }

            if (innerSwaps > 0) {
                swaps += innerSwaps - 1;
            }
        }
        return swaps;
    }
}
