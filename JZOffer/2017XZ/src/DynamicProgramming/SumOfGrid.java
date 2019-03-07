package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @program: JZOffer
 * @description: 有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。
 * 请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
 * <p>
 * 输入描述:
 * 输入包括一行，逗号隔开的两个正整数x和y，取值范围[1,10]。
 * 输出描述:
 * 输出包括一行，为走法的数目。
 * <p>
 * 示例1
 * 输入
 * 3 2
 * 输出
 * 10
 * @author: whx
 * @create: 2018-10-30 22:14
 **/
public class SumOfGrid {
    public static void main(String[] args) throws Exception {
        BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
        String[] str = st.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);
        int[] z = new int[y + 1];
        Arrays.fill(z, 1);
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                z[j] += z[j - 1];
            }
        }
        System.out.println(z[y]);

    }
}
