package fibonacci;

import java.lang.System;
import java.util.ArrayList;

public class FibonacciComparison {
    // Write code for recursive fib here
    public static int fibRecursive(int n) {
        // <your code here>
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            n = fibRecursive(n - 1) + fibRecursive(n - 2);
        }
        return n;
    }

    // Write code iterative fibonacci here
    public static int fibLinear(int n) {
        // <your code here>
        int older = 0;
        int old = 1;
        int current = 0;

        for (int i = 1; i < n; i++) {
            current = (older + old);
            older = old;
            old = current;
        }
        return current;
    }
}


