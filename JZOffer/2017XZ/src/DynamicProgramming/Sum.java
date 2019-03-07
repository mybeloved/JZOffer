package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
 * 输入描述:
 * 每个测试输入包含2个整数,n和m
 * 输出描述:
 * 按每个组合的字典序排列输出,每行输出一种组合
 * <p>
 * 示例1
 * 输入
 * 5 5
 * 输出
 * 1 4
 * 2 3
 * 5
 * @author: whx
 * @create: 2018-09-25 17:10
 **/
public class Sum {
    private static int n, m;
    private static int[] is;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str = s.split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        is = new int[n + 1];
        is[1] = 1;
        add(1, 0);
        is[1] = 0;
        add(1, 0);
    }

    private static void add(int i, int sum) {
        if (i > n)
            return;
        sum += i * is[i];
        if (sum == m)
            print(i);
        else if (sum < m && i < n) {
            is[i + 1] = 1;
            add(i + 1, sum);
            is[i + 1] = 0;
            add(i + 1, sum);
        }
    }

    private static void print(int a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= a; i++) {
            if (is[i] == 1) {
                sb.append(i);
                sb.append(' ');
            }
        }
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }
}
