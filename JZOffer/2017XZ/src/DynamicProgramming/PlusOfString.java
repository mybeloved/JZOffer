package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @program: JZOffer
 * @description: 请设计一个算法能够完成两个用字符串存储的整数进行相加操作，对非法的输入则返回error
 * <p>
 * 输入描述:
 * 输入为一行，包含两个字符串，字符串的长度在[1,100]。
 * 输出描述:
 * 输出为一行。合法情况输出相加结果，非法情况输出error
 * <p>
 * 示例1
 * 输入
 * 123 123
 * abd 123
 * 输出
 * 246
 * Error
 * @author: whx
 * @create: 2018-11-04 11:21
 **/
public class PlusOfString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        try {
            BigInteger m = new BigInteger(str[0]);
            BigInteger n = new BigInteger(str[1]);
            System.out.println(m.add(n));
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
