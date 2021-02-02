package fibonacci;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(Fibonacci(8));
    }
    public static long Fibonacci(int n) {
        if (n <= 1) return n;
        else return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
