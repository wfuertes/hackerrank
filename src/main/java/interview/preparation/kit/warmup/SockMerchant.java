package interview.preparation.kit.warmup;

import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        final Map<Integer, Integer> socks = new HashMap<>();

        for (int color : ar) {
            socks.putIfAbsent(color, 0);

            int qty = socks.get(color) + 1;
            socks.put(color, qty);
        }

        return socks.values()
                .stream()
                .filter(qty -> qty > 1)
                .mapToInt(qty -> qty / 2)
                .sum();
    }
}
