package DynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @program: JZOffer
 * @description: 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 * <p>
 * 输入描述:
 * 输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
 * 输出描述:
 * 为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
 * <p>
 * 示例1
 * 输入
 * 7 2
 * 输出
 * 111
 * @author: whx
 * @create: 2018-09-18 09:28
 **/
public class BaseConversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String m = in.next();
        int n = in.nextInt();
        BigInteger bi = new BigInteger(m, 10);
        System.out.println(bi.toString(n).toUpperCase());
    }
}
