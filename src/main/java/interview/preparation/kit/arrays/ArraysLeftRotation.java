package interview.preparation.kit.arrays;

public class ArraysLeftRotation {

    static int[] rotLeft(int[] arr, int d) {
        for (int k = 0; k < d; k++) {
            int head = arr[0];
            /*
                System.arraycopy(arr, 1, arr, 0, arr.length - 1);
                could be used here instead of the following for loop.
             */
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = head;
        }
        return arr;
    }
}
