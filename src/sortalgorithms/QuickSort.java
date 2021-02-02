package sortalgorithms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        // O(n^2)
        int[] array = new int[] {32,14,25,66,78,1,12,14,5,36,2,19,69,45,3,28,7};
        quickSort(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }
    public static void quickSort(int[] arr, int from, int to) {
        if (from < to) {
            int divideIndex = partition(arr,from,to);
            quickSort(arr,from,divideIndex - 1);
            quickSort(arr,divideIndex,to);
        }
    }

    public static int partition (int[] arr, int from, int to) {
        int leftIndex = from;
        int rightIndex = arr.length - 1;
        int pivot = arr[from];
        while (leftIndex < rightIndex) {
            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }
            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                swap(arr,rightIndex,leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static void swap (int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
