package sortalgorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // O(n^2)
        int[] array = new int[] {32,14,25,66,78,1,12,14,5,36,2,19,69,45,3,28,7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void bubbleSort (int[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                    isSorted = false;
                }
            }
        }
    }
}
