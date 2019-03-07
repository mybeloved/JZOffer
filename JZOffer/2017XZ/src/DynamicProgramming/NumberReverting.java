package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
 * 如果 X = 123，则rev(X) = 321;
 * 如果 X = 100，则rev(X) = 1.
 * 现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？
 * <p>
 * 输入描述:
 * 输入为一行，x、y(1 ≤ x、y ≤ 1000)，以空格隔开。
 * 输出描述:
 * 输出rev(rev(x) + rev(y))的值
 * <p>
 * 示例1
 * 输入
 * 123 100
 * 输出
 * 223
 */
public class NumberReverting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int x = Integer.valueOf(line[0]);
        int y = Integer.valueOf(line[1]);
        System.out.println(rev(rev(x) + rev(y)));
    }

    private static int rev(int x) {
        int result = 0;
        while (x != 0) {
            result = x % 10 + result * 10;
            x /= 10;
        }
        return result;
    }
}
