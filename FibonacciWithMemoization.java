import java.util.Arrays;

/**
 * Created by sivan on 10/17/18.
 */
public class FibonacciWithMemoization {

    public static long fibArray[] = new long[8]; //shoud be n+1

    public static long fibonacci(long n) {
        long fibValue = 0;
        System.out.println("fib n vaues "+n);
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (fibArray[(int) n] != 0) {
            return fibArray[(int) n];
        } else {
            fibValue = fibonacci(n - 1) + fibonacci(n - 2);
            fibArray[(int) n] = fibValue;
            System.out.println("fib array "+ Arrays.toString(fibArray));
            return fibValue;
        }
    }

    public static void main(String args[]) {
        fibArray[0] = 1;
        fibArray[1] = 1;
        long preTime = System.currentTimeMillis();
        System.out.println("Value of 25th number in Fibonacci series->" + fibonacci(7));
        long postTime = System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds->" + (postTime - preTime));
    }
}