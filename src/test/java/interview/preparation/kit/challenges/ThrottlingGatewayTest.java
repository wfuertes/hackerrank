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

    @Test
    public void test005() {
        List<Integer> requestTimes = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9,
                                                   9, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12, 12, 13, 13, 13, 13, 14, 14,
                                                   14, 14, 14, 16, 16, 16, 16, 16, 16, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19,
                                                   19, 19, 19, 19, 19, 20, 20, 20, 20, 20);

        assertThat(droppedRequests(requestTimes), is(67));
    }

    @Test
    public void test006() {
        List<Integer> requestTimes = Arrays.asList(100, 100, 101, 102, 102, 103, 103, 105, 105, 106, 106, 106, 107, 107, 109, 109, 109, 109,
                                                   110, 110, 110, 111, 111, 112, 114, 115, 115, 116, 116, 116, 117, 118, 118, 120, 120, 121,
                                                   121, 122, 122, 123, 123, 124, 124, 125, 127, 128, 128, 129, 131, 133, 134, 135, 135, 135,
                                                   136, 137, 137, 137, 138, 138, 140, 140, 140, 141, 141, 143, 144, 145, 146, 149, 149, 149,
                                                   149, 149, 151, 151, 152, 152, 154, 154, 155, 156, 156, 157, 158, 158, 159, 159, 160, 160,
                                                   160, 162, 162, 162, 164, 166, 167, 167, 169, 169, 172, 172, 172, 172, 174, 175, 175, 175,
                                                   176, 177, 177, 177, 179, 179, 180, 180, 180, 180, 181, 181, 181, 182, 182, 183, 183, 183,
                                                   184, 184, 187, 187, 188, 188, 188, 188, 189, 189, 189, 190, 191, 191, 192, 192, 193, 195,
                                                   195, 195, 195, 197, 198, 198, 199, 199, 200, 200, 200);

        assertThat(droppedRequests(requestTimes), is(96));
    }
}