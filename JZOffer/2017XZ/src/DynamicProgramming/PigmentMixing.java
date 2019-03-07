package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 你就是一个画家！你现在想绘制一幅画，但是你现在没有足够颜色的颜料。为了让问题简单，我们用正整数表示不同颜色的颜料。
 * 你知道这幅画需要的n种颜色的颜料，你现在可以去商店购买一些颜料，但是商店不能保证能供应所有颜色的颜料，所以你需要自己混合
 * 一些颜料。混合两种不一样的颜色A和颜色B颜料可以产生(A XOR B)这种颜色的颜料(新产生的颜料也可以用作继续混合产生新的颜色,
 * XOR表示异或操作)。本着勤俭节约的精神，你想购买更少的颜料就满足要求，所以兼职程序员的你需要编程来计算出最少需要购买几种颜色的颜料？
 * <p>
 * 输入描述:
 * 第一行为绘制这幅画需要的颜色种数n (1 ≤ n ≤ 50)
 * 第二行为n个数xi(1 ≤ xi ≤ 1,000,000,000)，表示需要的各种颜料.
 * 输出描述:
 * 输出最少需要在商店购买的颜料颜色种数，注意可能购买的颜色不一定会使用在画中，只是为了产生新的颜色。
 * <p>
 * 示例
 * 输入
 * 3
 * 1 7 3
 * 输出
 * 3
 */
public class PigmentMixing {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] fi = br.readLine().trim().split(" ");
        long[] need = new long[n];
        for (int i = 0; i < n; i++) {
            need[i] = Long.parseLong(fi[i]);
        }
        Arrays.sort(need);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (high(need[i]) == high(need[j])) {
                    need[j] = need[i] ^ need[j];
                }
            }
            Arrays.sort(need);
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (need[i] != 0) {
                num++;
            }
        }
        System.out.println(num);
    }

    public static int high(long x) {            //获得当前数字的最高二进制位
        int count = 0;
        while (x != 0) {
            x = x >> 1;
            count++;
        }
        return count;
    }
}
