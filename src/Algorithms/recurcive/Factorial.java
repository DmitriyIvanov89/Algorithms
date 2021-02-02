package Algorithms.recurcive;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(Fac(5));
    }
    public static long Fac(int n) {
        if (n <= 1) return n;
        else return n * Fac(n - 1);
    }
}
