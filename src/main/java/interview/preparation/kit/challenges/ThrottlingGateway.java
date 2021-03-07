package interview.preparation.kit.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;


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

        final List<Integer> instants = new ArrayList<>(requestNumbers.keySet());

        for (int i = instants.get(0); i <= instants.get(instants.size() - 1); i++) {
            int currentRequests = requestNumbers.getOrDefault(i, 0);

            last10Sec += currentRequests - requestNumbers.getOrDefault(i - 10, 0);
            last60Sec += currentRequests - requestNumbers.getOrDefault(i - 60, 0);

            int drop3 = 0;
            int drop10 = 0;
            int drop60 = 0;

            if (currentRequests > 3) {
                drop3 = currentRequests - 3;
            }

            if (last10Sec > 20) {
                drop10 = Math.min(last10Sec - 20, currentRequests);
            }

            if (last60Sec > 60) {
                drop60 = Math.min(last60Sec - 60, currentRequests);
            }

            dropped += IntStream.of(drop3, drop10, drop60).max().getAsInt();
        }

        return dropped;
    }
}
