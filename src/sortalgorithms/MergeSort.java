package sortalgorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // O(nlogn)
        int[] array = new int[] {32,14,25,66,78,1,12,14,5,36,2,19,69,45,3,28,7};
        mergeSort(array,0,array.length - 1);
        System.out.println(Arrays.toString(array));
    }
    public static void mergeSort (int[] arr, int low, int high) {
        if (high <= low) return;
        int middle = (low + high) / 2;
        mergeSort(arr,low,middle);
        mergeSort(arr,middle + 1, high);
        merge(arr,low,middle,high);
    }

    public static void merge (int[] arr, int low, int mid, int high) {
        int[] leftArray = new int[mid - low + 1];
        int[] rightArray = new int[high - mid];
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[low + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = arr[i + mid + 1];
        }
        int leftIndex = 0;
        int righIndex = 0;
        for (int i = low; i < high + 1; i++) {
            if (leftIndex < leftArray.length && righIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[righIndex]) {
                    arr[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    arr[i] = rightArray[righIndex];
                    righIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                arr[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (righIndex < rightArray[righIndex]) {
                arr[i] = rightArray[righIndex];
                righIndex++;
            }
        }
    }
}
