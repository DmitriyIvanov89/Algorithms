package searchAlgorithms;

public class binarySearch_recurcive {
    public static void main(String[] args) {
        int[] array = new int[] {1,3,5,8,9,15,25,56};
        System.out.println(binarySearch_rec(array,0,array.length - 1, 8));
    }
    public static int binarySearch_rec (int[] arr, int low, int high, int key) {
        int middle = (low + high) / 2;
        if (low > high){
            return -1;
        } else if (key < arr[middle]) {
            return binarySearch_rec(arr,low,middle - 1, key);
        } else if (key > arr[middle]) {
            return binarySearch_rec(arr,middle + 1,high,key);
        } else {
            return middle;
        }
    }
}
