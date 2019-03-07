package DynamicProgramming;

import java.util.Scanner;

/**
 * @program: JZOffer
 * @description: 给定一个十进制的正整数number，选择从里面去掉一部分数字，希望保留下来的数字组成的正整数最大。
 * <p>
 * 输入描述:
 * 输入为两行内容，第一行是正整数number，1 ≤ length(number) ≤ 50000。
 * 第二行是希望去掉的数字数量cnt 1 ≤ cnt < length(number)。
 * <p>
 * 输出描述:
 * 输出保留下来的结果。
 * <p>
 * 示例1
 * 输入
 * 325 1
 * 输出
 * 35
 * @author: whx
 * @create: 2018-11-12 22:26
 **/
public class SaveMaxNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append(sc.next());
            int cnt = sc.nextInt();
            for (int i = 0; i < cnt; i++) {
                int j = 0;
                while (j + 1 < sb.length() && sb.charAt(j) >= sb.charAt(j + 1)) {
                    j++;
                }
                sb.deleteCharAt(j);
            }
            System.out.println(sb.toString());
        }
    }
}