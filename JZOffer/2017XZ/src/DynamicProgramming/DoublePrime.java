package DynamicProgramming;

import java.util.Scanner;

/**
 * @program: JZOffer
 * @description: 给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
 * 如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
 * <p>
 * 输入描述:
 * 输入包括一个整数n,(3 ≤ n < 1000)
 * 输出描述:
 * 输出对数
 * <p>
 * 示例1
 * 输入
 * 10
 * 输出
 * 2
 * @author: whx
 * @create: 2018-09-28 21:21
 **/
public class DoublePrime {
    //素数对
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (isss(i) && isss(n - i)) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    //判断是否为素数
    private static boolean isss(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
