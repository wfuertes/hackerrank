package interview.preparation.kit.dictionaries_and_hashmaps;

import org.junit.Test;

import static interview.preparation.kit.dictionaries_and_hashmaps.SherlockAndAnagrams.isAnagram;
import static interview.preparation.kit.dictionaries_and_hashmaps.SherlockAndAnagrams.sherlockAndAnagrams;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SherlockAndAnagramsTest {

    @Test
    public void sample_01_0() {
        assertThat(sherlockAndAnagrams("abba"), is(4));
    }

    @Test
    public void sample_01_1() {
        assertThat(sherlockAndAnagrams("abcd"), is(0));
    }

    @Test
    public void sample_02_0() {
        assertThat(sherlockAndAnagrams("ifailuhkqq"), is(3));
    }

    @Test
    public void sample_02_1() {
        assertThat(sherlockAndAnagrams("kkkk"), is(10));
    }

    @Test
    public void sample_03() {
        assertThat(sherlockAndAnagrams("cdcd"), is(5));
    }

    @Test
    public void isAnagram_01_returnsTrue() {
        assertThat(isAnagram("binary", "brainy"), is(true));
    }

    @Test
    public void isAnagram_02_returnsFalse() {
        assertThat(isAnagram("binary", "brainy2"), is(false));
    }

    @Test
    public void isAnagram_03_returnsFalse() {
        assertThat(isAnagram("ifa", "ifai"), is(false));
    }

    @Test
    public void isAnagram_04_returnsFalse() {
        assertThat(isAnagram("ifailuh", "failuhk"), is(false));
    }

}