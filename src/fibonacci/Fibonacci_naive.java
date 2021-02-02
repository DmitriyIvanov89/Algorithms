package fibonacci;

public class Fibonacci_naive {
    public static void main(String[] args) {
        System.out.println(Fibonacci(100));
    }
    public static long Fibonacci(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
