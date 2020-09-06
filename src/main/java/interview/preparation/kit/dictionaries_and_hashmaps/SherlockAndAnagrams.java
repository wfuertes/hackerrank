package interview.preparation.kit.dictionaries_and_hashmaps;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Medium 40:
 *
 * @see <a href="https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps">sherlock-and-anagrams</a>
 */
public class SherlockAndAnagrams {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        char[] sourceChars = a.toCharArray();
        Arrays.sort(sourceChars);

        char[] targetChars = b.toCharArray();
        Arrays.sort(targetChars);

        return Arrays.equals(sourceChars, targetChars);
    }

    static List<String> listSubstrings(String str) {
        final List<String> substrings = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                substrings.add(str.substring(i, j));
            }
        }
        return substrings;
    }

    // TODO: needs improvements
    static int sherlockAndAnagrams(String str) {
        final List<String> substrings = listSubstrings(str);
        final AtomicInteger counter = new AtomicInteger(0);

        for (int i = 0; i < substrings.size() - 1; i++) {
            for (int j = i + 1; j < substrings.size(); j++) {
                if (isAnagram(substrings.get(i), substrings.get(j))) {
                    counter.incrementAndGet();
                }
            }
        }

        return counter.get();
    }
}
