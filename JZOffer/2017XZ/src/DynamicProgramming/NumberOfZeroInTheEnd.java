package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: 输入一个正整数n, 求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 * <p>
 * 输入描述:
 * 输入为一行，n(1 ≤ n ≤ 1000)
 * 输出描述:
 * 输出一个整数,即题目所求
 * <p>
 * 示例1
 * 输入 10
 * 输出 2
 * @author: whx
 * @create: 2018-09-17 22:29
 **/
public class NumberOfZeroInTheEnd {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int count = 0;
        while (n / 5 != 0) {
            n = n / 5;
            count += n;
        }
        System.out.println(count);
    }
}
