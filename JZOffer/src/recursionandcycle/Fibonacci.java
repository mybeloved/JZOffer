package recursionandcycle;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 */
public class Fibonacci {
    public int Fibonacci_(int n) {
        if (n < 0)
            return -1;
        int a = 1, b = 1, c = 0;
        if (n == 1 || n == 2) {
            return 1;
        } else {
            for (int i = 3; i <= n; i++) {
                c = a + b;
                b = a;
                a = c;
            }
        }
        return c;
    }
}

