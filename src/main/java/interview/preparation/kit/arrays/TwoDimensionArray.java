package interview.preparation.kit.arrays;

import java.util.ArrayList;
import java.util.List;

public class TwoDimensionArray {

    static int hourglassSum(int[][] arr) {
        final List<Integer> hoursGlassSums = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 2; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                                    + arr[i + 1][j + 1] +
                          arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                hoursGlassSums.add(sum);
            }
        }
        return hoursGlassSums.stream().max(Integer::compareTo).orElseThrow(IllegalStateException::new);
    }
}
