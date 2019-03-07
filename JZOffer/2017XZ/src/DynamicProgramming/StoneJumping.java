package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
 * 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数
 * (不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好
 * 为M的石板去，小易想知道最少需要跳跃几次可以到达。
 * 例如：
 * N = 4，M = 24：
 * 4->6->8->12->18->24
 * 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
 * <p>
 * 输入描述:
 * 输入为一行，有两个整数N，M，以空格隔开。 (4 ≤ N ≤ 100000) (N ≤ M ≤ 100000)
 * 输出描述:
 * 输出小易最少需要跳跃的步数,如果不能到达输出-1
 * <p>
 * 示例1
 * 输入
 * 4 24
 * 输出
 * 5
 */
public class StoneJumping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().trim().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        System.out.println(leastJumpTime(n, m));
    }

    // 思想：动态规划
    private static int leastJumpTime(int n, int m) {
        if (m == n) {
            return 0;
        }
        int steps = m - n + 1;// 算上了起点和终点
        int[] dp = new int[steps];// 规划的量：到达每个位置需要的最小步数
        dp[0] = 0; // 起点
        for (int i = 1; i < steps; i++) {
            dp[i] = Integer.MAX_VALUE; // 初始化 表示后续位置都不能到达
        }
        for (int i = 0; i < steps; i++) {
            // 0对应n石板 ；steps - 1 = m-n对应m石板
            if (dp[i] == Integer.MAX_VALUE) { // 该位置不能向前走
                dp[i] = 0;
                continue;
            }
            ArrayList<Integer> list = getAppNums(i + n); // i+n才是石板号
            for (Integer aList : list) {
                int x = aList;
                if (i + n + x <= m) {
                    dp[i + x] = Math.min(dp[i + x], dp[i] + 1);
                }
            }
        }
        if (dp[steps - 1] == 0) {
            return -1;
        } else {
            return dp[steps - 1];
        }
    }

    // 求因数 时间复杂度较低
    private static ArrayList<Integer> getAppNums(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }
        return list;
    }
}
