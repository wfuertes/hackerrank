package interview.preparation.kit.warmup;

import org.junit.Test;

import static interview.preparation.kit.warmup.CountingValleys.countingValleys;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CountingValleysTest {

    @Test
    public void sample_01() {
        final String steps = "UDDDUDUU";
        assertThat(countingValleys(steps.length(), steps), is(1));
    }

    @Test
    public void sample_02() {
        final String steps = "DDUUUUDD";
        assertThat(countingValleys(steps.length(), steps), is(1));
    }
}
