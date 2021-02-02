package searchAlgorithms;

public class BinarySearch {
    public static void main(String[] args) {
        // O(n)
        int[] array = new int[] {1,3,5,8,9,15,25,56};// только отсортированный массив
        System.out.println(binarySearch(array,56));
    }
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (key > arr[middle]) {
                low = middle + 1;
            } else if (key < arr[middle]) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
