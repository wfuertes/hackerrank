package interview.preparation.kit.dictionaries_and_hashmaps;

import org.junit.Test;

import static interview.preparation.kit.dictionaries_and_hashmaps.TwoStrings.twoStrings;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TwoStringsTest {

    @Test
    public void sample_01() {
        assertThat(twoStrings("hello", "world"), is("YES"));
        assertThat(twoStrings("hi", "world"), is("NO"));
    }

    @Test
    public void sample_02() {
        assertThat(twoStrings("wouldyoulikefries", "abcabcabcabcabcabc"), is("NO"));
        assertThat(twoStrings("hackerrankcommunity", "cdecdecdecde"), is("YES"));
        assertThat(twoStrings("jackandjill", "wentupthehill"), is("YES"));
        assertThat(twoStrings("writetoyourparents", "fghmqzldbc"), is("NO"));
    }

    @Test
    public void sample_03() {
        assertThat(twoStrings("aardvark", "apple"), is("YES"));
        assertThat(twoStrings("beetroot", "sandals"), is("NO"));
    }
}