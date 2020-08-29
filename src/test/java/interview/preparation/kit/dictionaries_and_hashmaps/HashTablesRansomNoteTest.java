package interview.preparation.kit.dictionaries_and_hashmaps;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static interview.preparation.kit.dictionaries_and_hashmaps.HashTablesRansomNote.checkMagazine;
import static interview.preparation.kit.dictionaries_and_hashmaps.HashTablesRansomNote.hasEnoughWords;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HashTablesRansomNoteTest {

    private static final String BY_WHITE_SPACE = " ";
    private static final int MAGAZINE_CONTENT = 1;
    private static final int NOTE_CONTENT = 2;

    @Test
    public void sample_01_Yes() {
        final String[] magazine = "give me one grand today night".split(BY_WHITE_SPACE);
        final String[] note = "give one grand today".split(BY_WHITE_SPACE);

        assertTrue(hasEnoughWords(magazine, note));
    }

    @Test
    public void sample_02_No() {
        final String[] magazine = "ive got a lovely bunch of coconuts".split(BY_WHITE_SPACE);
        final String[] note = "ive got some coconuts".split(BY_WHITE_SPACE);

        assertFalse(hasEnoughWords(magazine, note));
    }

    @Test
    public void sample_03_No() {
        final String[] magazine = "o l x imjaw bee khmla v o v o imjaw l khmla imjaw x".split(BY_WHITE_SPACE);
        final String[] note = "imjaw l khmla x imjaw o l l o khmla v bee o o imjaw imjaw o".split(BY_WHITE_SPACE);

        assertFalse(hasEnoughWords(magazine, note));
    }

    @Test
    public void sample_04_Yes() throws URISyntaxException, IOException {
        final List<String> entries = Files.readAllLines(Paths.get(HashTablesRansomNoteTest.class.getResource("/hashmaps_13.txt").toURI()));
        final String[] magazine = entries.get(MAGAZINE_CONTENT).split(BY_WHITE_SPACE);
        final String[] note = entries.get(NOTE_CONTENT).split(BY_WHITE_SPACE);

        assertTrue(hasEnoughWords(magazine, note));
    }

    @Test
    public void checkMagazine_printYes() throws IOException {
        final PrintStream defaultSystemOut = System.out;
        final String[] magazine = "give me one grand today night".split(BY_WHITE_SPACE);
        final String[] note = "give one grand today".split(BY_WHITE_SPACE);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(outputStream));

            checkMagazine(magazine, note);

            try (Scanner scanner = new Scanner(new StringReader(new String(outputStream.toByteArray())))) {
                assertThat(scanner.nextLine(), is("Yes"));
            }
        } finally {
            System.setOut(defaultSystemOut);
        }
    }

    @Test
    public void checkMagazine_printNo() throws IOException {
        final PrintStream defaultSystemOut = System.out;
        final String[] magazine = "ive got a lovely bunch of coconuts".split(BY_WHITE_SPACE);
        final String[] note = "ive got some coconuts".split(BY_WHITE_SPACE);

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(outputStream));

            checkMagazine(magazine, note);

            try (Scanner scanner = new Scanner(new StringReader(new String(outputStream.toByteArray())))) {
                assertThat(scanner.nextLine(), is("No"));
            }
        } finally {
            System.setOut(defaultSystemOut);
        }
    }
}