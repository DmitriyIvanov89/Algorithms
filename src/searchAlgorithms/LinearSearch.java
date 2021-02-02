package searchAlgorithms;

public class LinearSearch {
    public static void main(String[] args) {
        // O(n)
        int[] array = new int[] {1,3,8,15,25,36,98,7,4,-6};
        linearSearch(array,4);
    }
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Искомый элеменнт с индексом: " + i);
            }
        }
        return -1;
    }
}
