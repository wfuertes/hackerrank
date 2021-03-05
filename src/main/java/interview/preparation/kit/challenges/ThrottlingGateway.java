package interview.preparation.kit.challenges;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://algo.monster/problems/throttling_gateway
 */
public class ThrottlingGateway {

    public static int droppedRequests(List<Integer> requestTimes) {
        final Map<Integer, Integer> timesAndRequests = new TreeMap<>();
        final AtomicInteger dropped = new AtomicInteger(0);

        for (int i = 0; i < requestTimes.size(); i++) {
            int requestTime = requestTimes.get(i);
            timesAndRequests.putIfAbsent(requestTime, 0);
            timesAndRequests.put(requestTime, timesAndRequests.get(requestTime) + 1);

            if (timesAndRequests.get(requestTime) > 3) {
                dropped.incrementAndGet();
                System.out.printf("Dropped[%d]: %d\n", requestTime, (i + 1));
                continue;
            }

            int reqLast10Seconds = timesAndRequests.keySet()
                                                   .stream()
                                                   .filter(time -> time >= Math.max(1, requestTime - 9) && time <= requestTime)
                                                   .mapToInt(timesAndRequests::get)
                                                   .sum();

            if (reqLast10Seconds > 20) {
                dropped.incrementAndGet();
                System.out.printf("Dropped[%d]: %d\n", requestTime, (i + 1));
                continue;
            }

            int reqLast60Seconds = timesAndRequests.keySet()
                                                   .stream()
                                                   .filter(time -> time >= Math.max(1, requestTime - 59) && time <= requestTime)
                                                   .mapToInt(timesAndRequests::get)
                                                   .sum();

            if (reqLast60Seconds > 60) {
                dropped.incrementAndGet();
                System.out.printf("Dropped[%d]: %d\n", requestTime, (i + 1));
                continue;
            }

            System.out.printf("Not Dropped[%d]: %d\n", requestTime, (i + 1));
        }

        return dropped.get();
    }
}
