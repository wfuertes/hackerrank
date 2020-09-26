package pratice.data_structures.arrays;

public class ArraysDS {

    static int[] reverseArray(int[] a) {
        final int[] reserve = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            reserve[i] = a[a.length - i - 1];
        }
        return reserve;
    }
}
