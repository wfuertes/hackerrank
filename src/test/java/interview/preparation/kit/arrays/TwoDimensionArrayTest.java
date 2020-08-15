package interview.preparation.kit.arrays;

import org.junit.Test;

import static interview.preparation.kit.arrays.TwoDimensionArray.hourglassSum;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TwoDimensionArrayTest {

    @Test
    public void sample_01() {
        int[][] array = new int[][]{
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        assertThat(hourglassSum(array), is(28));
    }

    @Test
    public void sample_02() {
        int[][] array = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

        assertThat(hourglassSum(array), is(19));
    }

    @Test
    public void sample_03() {
        int[][] array = new int[][]{
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 9, 2, -4, -4, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, -1, -2, -4, 0}
        };

        assertThat(hourglassSum(array), is(13));
    }
}
