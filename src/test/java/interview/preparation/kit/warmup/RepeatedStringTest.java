package interview.preparation.kit.warmup;

import org.junit.Test;

import static interview.preparation.kit.warmup.RepeatedString.repeatedString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RepeatedStringTest {

    @Test
    public void sample_01() {
        String source = "aba";
        long n = 10L;
        assertThat(repeatedString(source, n), is(7L));
    }

    @Test
    public void sample_02() {
        String source = "aba";
        long n = 2L;
        assertThat(repeatedString(source, n), is(1L));
    }

    @Test
    public void sample_03() {
        String source = "a";
        long n = 1000000000000L;
        assertThat(repeatedString(source, n), is(1000000000000L));
    }

    @Test
    public void sample_04() {
        String source = "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm";
        long n = 736778906400L;
        assertThat(repeatedString(source, n), is(51574523448L));
    }
}
