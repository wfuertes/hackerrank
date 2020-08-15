package interview.preparation.kit.warmup;

import org.junit.Test;

import static interview.preparation.kit.warmup.SockMerchant.sockMerchant;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SockMerchantTest {

    @Test
    public void sample_01() {
        final int[] socks = new int[]{1, 2, 1, 2, 3, 2};
        assertThat(sockMerchant(socks.length, socks), is(2));
    }

    @Test
    public void sample_02() {
        final int[] socks = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
        assertThat(sockMerchant(socks.length, socks), is(3));
    }
}
