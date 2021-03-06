package interview.preparation.kit.challenges;

import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;


public class ThrottlingGateway {

    public static int droppedRequests(List<Integer> requestTimes) {
        final Map<Integer, Integer> numberOfRequests = requestTimes.stream().collect(toMap(identity(), value -> 1, Math::addExact));

        int dropped = 0;
        int last10Sec = 0;
        int last60Sec = 0;

        for (int time = requestTimes.get(0); time <= requestTimes.get(requestTimes.size() - 1); time++) {
            int currentRequests = numberOfRequests.getOrDefault(time, 0);

            last10Sec += currentRequests - numberOfRequests.getOrDefault(time - 10, 0);
            last60Sec += currentRequests - numberOfRequests.getOrDefault(time - 60, 0);

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

            dropped += Math.max(drop3, Math.max(drop10, drop60));
        }

        return dropped;
    }
}
