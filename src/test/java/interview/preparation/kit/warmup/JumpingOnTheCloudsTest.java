package interview.preparation.kit.warmup;

import org.junit.Test;

import static interview.preparation.kit.warmup.JumpingOnTheClouds.jumpingOnClouds;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JumpingOnTheCloudsTest {

    @Test
    public void sample_01() {
        int[] clouds = new int[]{0, 0, 1, 0, 0, 1, 0};
        assertThat(jumpingOnClouds(clouds), is(4));
    }

    @Test
    public void sample_02() {
        int[] clouds = new int[]{0, 0, 0, 1, 0, 0};
        assertThat(jumpingOnClouds(clouds), is(3));
    }
}
