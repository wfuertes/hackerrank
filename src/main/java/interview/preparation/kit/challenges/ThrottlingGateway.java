package interview.preparation.kit.challenges;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * https://algo.monster/problems/throttling_gateway
 */
public class ThrottlingGateway {

    public static int droppedRequests(List<Integer> requestTimes) {
        final Map<Integer, Integer> requestNumbers = new TreeMap<>();

        for (int request : requestTimes) {
            requestNumbers.putIfAbsent(request, 0);
            requestNumbers.put(request, requestNumbers.get(request) + 1);
        }

        int dropped = 0;
        int last10Sec = 0;
        int last60Sec = 0;

        for (int instant : requestNumbers.keySet()) {
            int currentRequests = requestNumbers.get(instant);

            last10Sec += currentRequests;
            last60Sec += currentRequests;

            if (requestNumbers.containsKey(instant - 10)) {
                last10Sec -= requestNumbers.get(instant - 10);
            }

            if (requestNumbers.containsKey(instant - 60)) {
                last60Sec -= requestNumbers.get(instant - 60);
            }

            int drop3 = 0;
            int drop10 = 0;
            int drop60 = 0;

            if (currentRequests > 3) {
                drop3 = currentRequests - 3;
            }

            if (last10Sec > 20) {
                drop10 = last10Sec - 20;
            }

            if (last60Sec > 60) {
                drop60 = last60Sec - 60;
            }

            dropped += IntStream.of(drop3, drop10, drop60).max().getAsInt();
        }

        return dropped;
    }
}
