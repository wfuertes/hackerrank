package interview.preparation.kit.arrays;

import org.junit.Test;

import static interview.preparation.kit.arrays.ArraysLeftRotation.rotLeft;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArraysLeftRotationTest {

    @Test
    public void sample_01() {
        int d = 4;
        int[] array = new int[]{1, 2, 3, 4, 5};

        int[] expected = new int[]{5, 1, 2, 3, 4};
        assertThat(rotLeft(array, d), is(expected));
    }

    @Test
    public void sample_02() {
        int d = 10;
        int[] array = new int[]{41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51};

        int[] expected = new int[]{77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77};
        assertThat(rotLeft(array, d), is(expected));
    }

    @Test
    public void sample_03() {
        int d = 13;
        int[] array = new int[]{33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97};

        int[] expected = new int[]{87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60};
        assertThat(rotLeft(array, d), is(expected));
    }
}
