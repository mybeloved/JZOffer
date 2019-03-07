package DynamicProgramming;

import java.util.Scanner;

/**
 * @program: JZOffer
 * @description: 一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，
 * 每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远。每个弹簧力量不同，
 * 用一个数字代表它的力量，如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，
 * 如果为0，就会陷进去无法继续跳跃。河流一共N米宽，袋鼠初始位置就在第一个弹簧上面，
 * 要跳到最后一个弹簧之后就算过河了，给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。
 * 如果无法到达输出-1
 * <p>
 * 输入描述:
 * 输入分两行，第一行是数组长度N (1 ≤ N ≤ 10000)，第二行是每一项的值，用空格分隔。
 * 输出描述:
 * 输出最少的跳数，无法到达输出-1
 * <p>
 * 示例1
 * 输入
 * 5
 * 2 0 1 1 1
 * 输出
 * 4
 * @author:whx
 * @create:2018-12-05 23:33
 **/

public class KangurooPassingTheRiver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(dtgh(n, arr));
    }

    /*
     * 在数组后增加一位，最终目的是跳到这一位置
     * 那么只要该位前面的某一位i能跳跃的距离超过最后一位，就一定能过河
     * 所以，求整体的最优变成求能跳到i的最优，以此类推
     */
    public static int dtgh(int n, int[] arr) {//动态规划
        int[] res = new int[n + 1];//用于存储跳到指定位置的最佳跳跃次数
        res[0] = 0;
        for (int k = 1; k <= n; k++) {
            int temp = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                if (arr[i] + i >= k && res[i] + 1 < temp) {
                    res[k] = res[i] + 1;
                    temp = res[k];
                }
            }
        }
        //System.out.println(Arrays.toString(res));
        for (int i = 1; i <= n; i++) {//除了第一位，其它出现0，说明掉河里了
            if (res[i] == 0)
                res[n] = -1;
        }
        return res[n];
    }
}

