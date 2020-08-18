package interview.preparation.kit.arrays;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static interview.preparation.kit.arrays.MinimumSwaps2.minimumSwaps;
import static interview.preparation.kit.arrays.MinimumSwaps2.minimumSwapsImproved;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MinimumSwaps2Test {

    @Test
    public void sample_01() {
        int[] array = new int[]{4, 3, 1, 2};
        int swaps = minimumSwapsImproved(array);
        assertThat(swaps, is(3));
    }

    @Test
    public void sample_02() {
        int[] array = new int[]{2, 3, 4, 1, 5};
        int swaps = minimumSwapsImproved(array);
        assertThat(swaps, is(3));
    }

    @Test
    public void sample_03() {
        int[] array = new int[]{1, 3, 5, 2, 4, 6, 7};
        int swaps = minimumSwaps(array);
        assertThat(swaps, is(3));
    }

    @Test
    public void sample_04() throws URISyntaxException, IOException {
        List<String> allLines = Files.readAllLines(Paths.get(MinimumSwaps2Test.class.getResource("/minimum-swaps_10.txt").toURI()));
        int[] array = Arrays.stream(allLines.get(1).split(" ")).mapToInt(Integer::parseInt).toArray();
        int swaps = minimumSwapsImproved(array);
        assertThat(swaps, is(99984));
    }
}