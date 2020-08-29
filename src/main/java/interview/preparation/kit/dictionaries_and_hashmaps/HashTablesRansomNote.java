package interview.preparation.kit.dictionaries_and_hashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashTablesRansomNote {

    static boolean hasEnoughWords(String[] magazine, String[] note) {
        final Map<String, Integer> magazineWords = new HashMap<>();
        for (String mWord : magazine) {
            final Integer count = magazineWords.getOrDefault(mWord, 0);
            magazineWords.put(mWord, count + 1);
        }

        final Map<String, Integer> noteWords = new HashMap<>();
        for (String nWord : note) {
            final Integer count = noteWords.getOrDefault(nWord, 0);
            noteWords.put(nWord, count + 1);
        }

        for (Entry<String, Integer> entry : noteWords.entrySet()) {
            if (magazineWords.get(entry.getKey()) == null) {
                return false;
            }

            if (entry.getValue() > magazineWords.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    static void checkMagazine(String[] magazine, String[] note) {
        if (hasEnoughWords(magazine, note)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
