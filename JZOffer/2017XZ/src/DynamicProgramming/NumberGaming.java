package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 小易邀请你玩一个数字游戏，小易给你一系列的整数。你们俩使用这些整数玩游戏。每次小易会任意说一个数字出来，然后你需要
 * 从这一系列数字中选取一部分出来让它们的和等于小易所说的数字。 例如： 如果{2,1,2,7}是你有的一系列数，小易说的数字是
 * 11.你可以得到方案2+2+7 = 11.如果顽皮的小易想坑你，他说的数字是6，那么你没有办法拼凑出和为6 现在小易给你n个数，
 * 让你找出无法从n个数中选取部分求和的数字中的最小数（从1开始）。
 * <p>
 * 输入描述:
 * 输入第一行为数字个数n (n ≤ 20)
 * 第二行为n个数xi (1 ≤ xi ≤ 100000)
 * 输出描述:
 * 输出最小不能由n个数选取求和组成的数
 * <p>
 * 示例1
 * 输入
 * 3
 * 5 1 2
 * 输出
 * 4
 */
public class NumberGaming {
    private static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        sort(array);
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] > num + 1) {
                break;
            }
            num += array[i];
        }
        System.out.println(num + 1);
    }

    private static void sort(int[] a) {
        int len = a.length, key, pos;
        for (int i = 1; i < len; i++) {
            key = a[i];
            sum += key;
            pos = i - 1;
            while (pos >= 0 && a[pos] > key) {
                a[pos + 1] = a[pos];
                pos--;
            }
            a[pos + 1] = key;
        }
    }
}
