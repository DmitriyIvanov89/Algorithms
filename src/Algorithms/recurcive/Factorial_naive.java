package Algorithms.recurcive;

public class Factorial_naive {
    public static void main(String[] args) {
        System.out.println(Fac(8));
    }
    public static long Fac(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
