package interview.preparation.kit.dictionaries_and_hashmaps;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        final Set<String> a = Arrays.stream(s1.split("")).collect(Collectors.toSet());
        final Set<String> b = Arrays.stream(s2.split("")).collect(Collectors.toSet());

        // A intersection B
        a.retainAll(b);

        return a.size() > 0 ? "YES" : "NO";
    }
}
