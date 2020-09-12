package interview.preparation.kit.dictionaries_and_hashmaps;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

/**
 * Medium 50:
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

    static int sherlockAndAnagrams(String str) {
        final List<String> substrings = listSubstrings(str);

        // Sorting substring letters and sorting into a list
        // if it has repetitions they are anagrams.
        final List<String> sortedSubstrings = substrings.stream()
                .map(substring -> {
                    char[] chars = substring.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                })
                .sorted()
                .collect(Collectors.toList());

        // Grouping repetitions (substrings that are repeating)
        final Map<String, List<String>> repetitions = sortedSubstrings.stream()
                .collect(Collectors.groupingBy(o -> o))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .collect(toMap(Entry::getKey, Entry::getValue));

        /*
            k k k k k  =  4 + 3 + 2 + 1
            k k k k    =  3 + 2 + 1
            k k k      =  2 + 1
            k k        =  1 + 0
            K          =  0
         */

        // Do the repetitions summation in order to find the number of anagrams pairs
        return repetitions.values()
                .stream()
                .map(List::size)
                .mapToInt(repetition -> IntStream.range(0, repetition).sum())
                .sum();
    }
}
