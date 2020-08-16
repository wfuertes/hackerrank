package interview.preparation.kit.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Medium: 40
 *
 * @see <a href="https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays">new-year-chaos</a>
 */
public class NewYearChaos {

    static Optional<Integer> findMinimumBribes(int[] queue) {
        final Map<Integer, Integer> swaps = new HashMap<>();
        /*
            Using improved bubble-sort in order to find the swaps (bribes)
            Reference: http://techieme.in/improving-bubble-sort/
         */
        for (int i = 0; i < queue.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < queue.length - i - 1; j++) {
                if (queue[j] > queue[j + 1]) {
                    int aux = queue[j];
                    queue[j] = queue[j + 1];
                    queue[j + 1] = aux;
                    swap = true;

                    swaps.putIfAbsent(aux, 0);
                    swaps.put(aux, swaps.get(aux) + 1);

                    if (swaps.get(aux) > 2) {
                        return Optional.empty();
                    }
                }
            }

            if (!swap) {
                break;
            }
        }

        return Optional.of(swaps.values().stream().mapToInt(Integer::intValue).sum());
    }

    static void minimumBribes(int[] queue) {
        Optional<Integer> minimumBribes = findMinimumBribes(queue);

        if (minimumBribes.isPresent()) {
            System.out.println(minimumBribes.get());
        } else {
            System.out.println("Too chaotic");
        }
    }
}
