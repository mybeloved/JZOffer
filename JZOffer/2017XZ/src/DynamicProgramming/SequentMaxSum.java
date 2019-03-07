package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: 一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，
 * 其和为 3
 * <p>
 * 输入描述:
 * 输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，
 * 即每个元素,每个整数都在32位int范围内。以空格分隔。
 * 输出描述:
 * 所有连续子数组中和最大的值。
 * <p>
 * 示例1
 * 输入
 * 3 -1 2 1
 * 输出
 * 3
 * @author: whx
 * @create: 2018-09-11 09:02
 **/
public class SequentMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        System.out.println(getMaxSum(inputs, n));
    }

    private static int getMaxSum(String[] array, int n) {
        if (array.length == 0)
            return 0;
        int currentSum = Integer.parseInt(array[0]);
        int currentMax = Integer.parseInt(array[0]);
        for (int i = 1; i < n; i++) {
            if (currentSum < 0) {
                currentSum = Integer.parseInt(array[i]);
            } else {
                currentSum += Integer.parseInt(array[i]);
            }
            if (currentSum > currentMax) {
                currentMax = currentSum;
            }
        }
        return currentMax;
    }
}
