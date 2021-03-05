package interview.preparation.kit.challenges;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static interview.preparation.kit.challenges.ThrottlingGateway.droppedRequests;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ThrottlingGatewayTest {

    @Test
    public void droppedRequests_test001() {
        List<Integer> requestTimes = Arrays.asList(1, 1, 1, 1, 2);

        assertThat(droppedRequests(requestTimes), is(1));
    }

    @Test
    public void droppedRequests_test002() {
        List<Integer> requestTimes = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11);

        assertThat(droppedRequests(requestTimes), is(7));
    }

    @Test
    public void droppedRequests_test003() {
        List<Integer> requestTimes = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                                                   25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46,
                                                   47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61);

        assertThat(droppedRequests(requestTimes), is(0));
    }

    @Test
    public void droppedRequests_test004() {
        List<Integer> requestTimes = Arrays.asList(1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                                                   25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46,
                                                   47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61);

        assertThat(droppedRequests(requestTimes), is(1));
    }
}