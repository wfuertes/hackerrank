package pratice.data_structures.arrays;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static pratice.data_structures.arrays.ArraysDS.reverseArray;

public class ArraysDSTest {

    @Test
    public void sample_01() {
        assertThat(reverseArray(new int[]{1}), is(new int[]{1}));
    }

    @Test
    public void sample_02() {
        assertThat(reverseArray(new int[]{1, 2, 3}), is(new int[]{3, 2, 1}));
    }
}