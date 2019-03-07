package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Fibonacci数列是这样定义的：
 * F[0] = 0
 * F[1] = 1
 * for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 * 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，
 * 你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为
 * Fibonacci数。
 * <p>
 * 输入描述:
 * 输入为一个正整数N(1 ≤ N ≤ 1,000,000)
 * 输出描述:
 * 输出一个最小的步数变为Fibonacci数
 * <p>
 * 示例1
 * 输入
 * 15
 * 输出
 * 2
 */
public class FibonacciSeries {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = bf.readLine()) != null) {
            int n = Integer.valueOf(input);
            int a = 1, b = 1, c;
            while (true) {
                c = a + b;
                a = b;
                b = c;
                if (c > n) {
                    break;
                }
            }
            if (c - n > n - a) {
                System.out.println(n - a);
                return;
            } else {
                System.out.println(c - n);
                return;
            }
        }
    }
}
