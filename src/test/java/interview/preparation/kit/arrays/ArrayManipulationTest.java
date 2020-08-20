package interview.preparation.kit.arrays;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static interview.preparation.kit.arrays.ArrayManipulation.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArrayManipulationTest {

    @Test
    public void sample_01() {
        int n = 10;
        int[][] queries = new int[][]{{1, 5, 3}, {4, 8, 7}, {6, 9, 1}};

        long maximum = arrayManipulationImproved(n, queries);
        assertThat(maximum, is(10L));
    }

    @Test
    public void sample_02() {
        int n = 5;
        int[][] queries = new int[][]{{1, 2, 100}, {2, 5, 100}, {3, 4, 100}};

        long maximum = arrayManipulation(n, queries);
        assertThat(maximum, is(200L));
    }

    @Test
    public void sample_03() {
        int n = 10;
        int[][] queries = new int[][]{{2, 6, 8}, {3, 5, 7}, {1, 8, 1}, {5, 9, 15}};

        long maximum = arrayManipulation(n, queries);
        assertThat(maximum, is(31L));
    }

    @Test
    public void sample_04() throws URISyntaxException, IOException {
        List<String> content = Files.readAllLines(Paths.get(ArrayManipulationTest.class.getResource("/array_manipulation_07.txt").toURI()));

        int n = Integer.parseInt(content.get(0).split(" ")[0]);
        int numOfQueries = Integer.parseInt(content.get(0).split(" ")[1]);
        int[][] queries = new int[numOfQueries][3];

        List<String> queriesAsString = content.subList(1, content.size());

        for (int i = 0; i < numOfQueries; i++) {
            int[] query = Arrays.stream(queriesAsString.get(i).split(" ")).mapToInt(Integer::parseInt).toArray();
            queries[i] = query;
        }

        long maximum = arrayManipulationImproved(n, queries);
        assertThat(maximum, is(2497169732L));
    }
}