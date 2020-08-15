package interview.preparation.kit.warmup;

public class CountingValleys {

    static int countingValleys(int n, String steps) {
        int h = 0;
        int valleys = 0;

        for (char step : steps.toCharArray()) {
            if (step == 'U') {
                h++;
            } else if (step == 'D') {
                h--;
            }

            if (h == 0 && step == 'U') {
                valleys++;
            }
        }

        return valleys;
    }
}
