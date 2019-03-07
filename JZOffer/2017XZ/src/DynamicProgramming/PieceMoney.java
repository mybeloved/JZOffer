package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: 给你六种面额1、5、10、20、50、100元的纸币，假设每种币值的数量都足够多，编写程序求组成N元
 * （N为0-10000的非负整数）的不同组合的个数。
 * <p>
 * 输入描述:
 * 输入为一个数字N，即需要拼凑的面额
 * 输出描述:
 * 输出也是一个数字，为组成N的组合个数。
 * <p>
 * 示例1
 * 输入
 * 5
 * 输出
 * 2
 * @author: whx
 * @create: 2018-11-03 14:14
 **/
public class PieceMoney {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        System.out.println(piece(n));
    }

    private static long piece(int n) {
        int[] money = {1, 5, 10, 20, 50, 100};// 保存基本面额的数组
        long[] data = new long[n + 1];// 保存计算数据的数组
        data[0] = 1;
        for (int aMoney : money) {
            for (int j = aMoney; j < data.length; j++) {
                data[j] += data[j - aMoney];
            }
        }
        return data[n];
    }
}
