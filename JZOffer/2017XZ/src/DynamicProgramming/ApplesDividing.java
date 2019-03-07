package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，每一次，
 * 你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
 * <p>
 * 输入描述:
 * 每个输入包含一个测试用例。每个测试用例的第一行包含一个整数 n（1 <= n <= 100），接下来的一行包含 n 个整数 ai（1 <= ai <= 100）。
 * 输出描述:
 * 输出一行表示最少需要移动多少次可以平分苹果，如果方案不存在则输出 -1。
 * <p>
 * 示例
 * 输入
 * 4
 * 7 15 9 5
 * 输出
 * 3
 */
public class ApplesDividing {
    /**
     * 如果苹果总数不能整除人数，证明无论怎么分，总会有人多出一些苹果。 如果能整除，那么每个人的最终的苹果数目一定是平均数，
     * 不然不可能相等。所以只需要把低于平均数那一部分补上，把高于平均数那一部分减掉就可以了。当然如果， 补上的那一部分不能整除2，
     * 证明这个人是不能通过2个苹果的转移来达到平均数，即无论怎么分，也不可能每个人的苹果都一样。
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            int[] a = new int[n];
            line = br.readLine();
            String[] s = line.trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i];
            }
            if (sum % n != 0) {
                System.out.println(-1);
                return;
            }
            int avg = sum / n;
            for (int i = 0; i < n; i++) {
                if (Math.abs(a[i] - avg) % 2 != 0) {
                    System.out.println(-1);
                    return;
                }
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] < avg) {
                    count += (avg - a[i]) / 2;
                }
            }
            System.out.println(count);
        }
    }
}
