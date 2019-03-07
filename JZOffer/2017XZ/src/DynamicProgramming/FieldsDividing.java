package DynamicProgramming;

import java.util.*;

/**
 * 牛牛和 15 个朋友来玩打土豪分田地的游戏，牛牛决定让你来分田地，地主的田地可以看成是一个矩形，每个位置有一个价值。
 * 分割田地的方法是横竖各切三刀，分成 16 份，作为领导干部，牛牛总是会选择其中总价值最小的一份田地， 作为牛牛最好的朋友，
 * 你希望牛牛取得的田地的价值和尽可能大，你知道这个值最大可以是多少吗？
 * <p>
 * 输入描述:
 * 每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 75），表示田地的大小，接下来的 n 行，
 * 每行包含 m 个 0-9 之间的数字，表示每块位置的价值。
 * 输出描述:
 * 输出一行表示牛牛所能取得的最大的价值。
 * 示例
 * 输入
 * 4 4
 * 3332
 * 3233
 * 3332
 * 2323
 * 输出
 * 2
 */

public class FieldsDividing {
    /**
     * 题意是：通过横竖各三刀将一个矩阵分为16部分，每部分的value即为这一部分包含的所有数字之和。我们要做的就是想一种切法，
     * 使得这16部分中value最小的那个尽可能的大。
     * 首先很显然，每一个部分的value在0-sum之间，sum是指整个矩阵所有数字之和。这样最终的结果一定是[0, sum]中的某一个整数
     * 这里稍微逆向思考一下，既然不容易直接求结果，可不可以我猜一个值(k)，然后判断能不能通过某种切法使最小的那一块value>=k呢？
     * （也就是说，使16块的value都能大于等于k）
     * 如果可以的话，我们就可以对[0, sum]这个区间进行二分查找。这个容易理解吧，当然逻辑上你从num开始递减遍历判断a肯定也是ok的，
     * 但是会超时，所以换成二分
     * 二分的复杂度是log(sum)
     * 接下来是重点：对于一个值，怎么判断能不能横竖切三刀，使16块的value都大于等于k呢
     * 可以先横着切三刀，然后纵向贪心遍历一遍。这部分我也不用多说了，想不通的话看看代码就明白了。复杂度是n^4
     */
    private static int[][] dp;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        m = s.nextInt();
        int[][] land = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String cur = s.next();
            for (int j = 1; j <= m; j++) {
                land[i][j] = cur.charAt(j - 1) - '0';
            }
        }

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += land[i][j];
                dp[i][j] = sum + dp[i - 1][j];
            }
        }

        int l = 0;
        int r = n * m * 9;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (judge(mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(l - 1);
    }

    private static boolean judgeCol(int a, int b, int c, int x) {
        int count = 0;
        int before = 1;
        for (int i = 1; i <= m; i++) {
            int s1 = getA(1, before, a, i);
            int s2 = getA(a + 1, before, b, i);
            int s3 = getA(b + 1, before, c, i);
            int s4 = getA(c + 1, before, n, i);

            if (s1 >= x && s2 >= x && s3 >= x && s4 >= x) {
                before = i + 1;
                count++;
                if (count == 4) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean judge(int x) {
        for (int i = 1; i <= n; i++) {
            if (getA(1, 1, i, m) < (x << 2)) {
                continue;
            }
            for (int j = i + 1; j <= n; j++) {
                if (getA(i + 1, 1, j, m) < (x << 2)) {
                    continue;
                }
                for (int k = j + 1; k <= n; k++) {
                    if (getA(j + 1, 1, k, m) < (x << 2)) {
                        continue;
                    }
                    if (getA(k + 1, 1, n, m) < (x << 2)) {
                        continue;
                    }

                    if (judgeCol(i, j, k, x)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static int getA(int x1, int y1, int x2, int y2) {
        return dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
    }
}
