package DynamicProgramming;

import java.util.Scanner;

/**
 * @program: JZOffer
 * @description: 给定一个有n个正整数的数组A和一个整数sum, 求选择数组A中部分数字和为sum的方案数。
 * 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 * <p>
 * 输入描述:
 * 输入为两行:  第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)  第二行为n个正整数A[i](32位整数)，以空格隔开。
 * 输出描述:
 * 输出所求的方案数
 * <p>
 * 示例1
 * 输入
 * 5 15
 * 5 5 10 2 3
 * 输出
 * 4
 * @author: whx
 * @create: 2018-09-19 22:03
 **/
public class NumberOfWayToFormSum {
    public static int n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n + 1];
        int sum = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(calculate(a, sum));
        sc.close();
    }

    private static long calculate(int[] a, int sum) {
        long dp[][] = new long[n + 1][sum + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= a[i])
                    dp[i][j] = dp[i - 1][j - a[i]] + dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }
}
