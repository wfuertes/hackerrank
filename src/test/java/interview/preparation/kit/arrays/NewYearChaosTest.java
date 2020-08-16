package interview.preparation.kit.arrays;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

import static interview.preparation.kit.arrays.NewYearChaos.findMinimumBribes;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class NewYearChaosTest {

    @Test
    public void sample_01() {
        final int[] queue = new int[]{2, 1, 5, 3, 4};
        final Optional<Integer> minimumBribes = findMinimumBribes(queue);

        assertTrue(minimumBribes.isPresent());
        assertThat(minimumBribes.get(), is(3));
    }

    @Test
    public void sample_02() {
        final int[] queue = new int[]{2, 5, 1, 3, 4};
        final Optional<Integer> minimumBribes = findMinimumBribes(queue);

        assertFalse(minimumBribes.isPresent());
    }

    @Test
    public void sample_03() {
        final int[] queue = new int[]{5, 1, 2, 3, 7, 8, 6, 4};
        final Optional<Integer> minimumBribes = findMinimumBribes(queue);

        assertFalse(minimumBribes.isPresent());
    }

    @Test
    public void sample_04() {
        final int[] queue = new int[]{1, 2, 5, 3, 7, 8, 6, 4};
        final Optional<Integer> minimumBribes = findMinimumBribes(queue);

        assertTrue(minimumBribes.isPresent());
        assertThat(minimumBribes.get(), is(7));
    }

    @Test
    public void sample_05() {
        final int[] queue = new int[]{1, 2, 5, 3, 4, 7, 8, 6};
        final Optional<Integer> minimumBribes = findMinimumBribes(queue);

        assertTrue(minimumBribes.isPresent());
        assertThat(minimumBribes.get(), is(4));
    }

    @Test
    public void sample_06() {
        List<Integer[]> queues = loadTestData("/new-year-chaos_06.txt");

        final Optional<Integer> minimumBribes1 = findMinimumBribes(Stream.of(queues.get(0)).mapToInt(Integer::intValue).toArray());
        assertTrue(minimumBribes1.isPresent());
        assertThat(minimumBribes1.get(), is(96110));

        final Optional<Integer> minimumBribes2 = findMinimumBribes(Stream.of(queues.get(1)).mapToInt(Integer::intValue).toArray());
        assertFalse(minimumBribes2.isPresent());

        final Optional<Integer> minimumBribes3 = findMinimumBribes(Stream.of(queues.get(2)).mapToInt(Integer::intValue).toArray());
        assertFalse(minimumBribes3.isPresent());

        final Optional<Integer> minimumBribes4 = findMinimumBribes(Stream.of(queues.get(3)).mapToInt(Integer::intValue).toArray());
        assertTrue(minimumBribes4.isPresent());
        assertThat(minimumBribes4.get(), is(96319));

        final Optional<Integer> minimumBribes5 = findMinimumBribes(Stream.of(queues.get(4)).mapToInt(Integer::intValue).toArray());
        assertTrue(minimumBribes5.isPresent());
        assertThat(minimumBribes5.get(), is(96323));

        final Optional<Integer> minimumBribes6 = findMinimumBribes(Stream.of(queues.get(5)).mapToInt(Integer::intValue).toArray());
        assertTrue(minimumBribes6.isPresent());
        assertThat(minimumBribes6.get(), is(96058));
    }

    static List<Integer[]> loadTestData(String file) {
        try {
            List<String> content = Files.readAllLines(Paths.get(NewYearChaosTest.class.getResource(file).toURI()));

            List<Integer[]> queues = new ArrayList<>();

            for (int i = 2; i < content.size(); i += 2) {
                String queueAsString = content.get(i);
                queues.add(Stream.of(queueAsString.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new));
            }

            return queues;
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("Error when loading test data: " + file);
        }
    }

    @Test
    public void minimumBribes_success() throws IOException {
        final PrintStream defaultOutput = System.out;

        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             PrintStream printStream = new PrintStream(output)) {

            System.setOut(printStream);

            final int[] queue = new int[]{2, 1, 5, 3, 4};
            NewYearChaos.minimumBribes(queue);

            try (Scanner scanner = new Scanner(new StringReader((new String(output.toByteArray()))))) {
                assertThat(scanner.nextInt(), is(3));
            }
        } finally {
            System.setOut(defaultOutput);
        }
    }

    @Test
    public void minimumBribes_tooChaotic() throws IOException {
        final PrintStream defaultOutput = System.out;

        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             PrintStream printStream = new PrintStream(output)) {

            System.setOut(printStream);

            final int[] queue = new int[]{5, 1, 2, 3, 7, 8, 6, 4};
            NewYearChaos.minimumBribes(queue);

            try (Scanner scanner = new Scanner(new StringReader((new String(output.toByteArray()))))) {
                assertThat(scanner.nextLine(), is("Too chaotic"));
            }
        } finally {
            System.setOut(defaultOutput);
        }
    }
}