package interview.preparation.kit.warmup;

public class JumpingOnTheClouds {

    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int i = 0;

        while (i < c.length) {
            if (i < c.length - 2 && c[i + 2] == 0) {
                i += 2;
            } else {
                i += 1;
            }

            if (i < c.length) {
                jumps++;
            }
        }
        return jumps;
    }
}
