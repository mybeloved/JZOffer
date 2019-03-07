package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: 给定一个英文字符串, 请写一段代码找出这个字符串中首先出现三次的那个英文字符(需要区分大小写)。
 * <p>
 * 输入描述:
 * 输入数据一个字符串，包括字母,数字等。
 * 输出描述:
 * 输出首先出现三次的那个英文字符
 * <p>
 * 示例1
 * 输入
 * Have you ever gone shopping and
 * 输出
 * e
 * @author: whx
 * @create: 2018-11-11 18:51
 **/
public class CountingCharacters {
    public static int[] count = new int[128];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        for (char aCh : ch) {
            if (aCh >= 'a' && aCh <= 'z' || aCh >= 'A' && aCh <= 'Z') {
                count[aCh]++;
                if (count[aCh] == 3) {
                    System.out.print(aCh);
                    break;
                }
            }
        }
    }
}