package interview.preparation.kit.dictionaries_and_hashmaps;

import java.util.*;

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
        // TODO: implement pairs check
        return 0;
    }
}
