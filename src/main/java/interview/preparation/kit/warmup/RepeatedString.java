package interview.preparation.kit.warmup;

public class RepeatedString {

    static long repeatedString(String source, long n) {
        if (source.length() < n) {
            long repeat = n / source.length();
            long rest = n % source.length();

            long partial = source.chars().filter(value -> value == 'a').count() * repeat;
            long tail = source.chars().limit(rest).filter(value -> value == 'a').count();

            return partial + tail;
        }

        return source.chars().limit(n).filter(value -> value == 'a').count();
    }
}
