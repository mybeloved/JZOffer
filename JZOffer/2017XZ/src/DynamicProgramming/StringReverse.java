package DynamicProgramming;

import java.util.Scanner;

/**
 * @program: JZOffer
 * @description: 将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
 * <p>
 * 输入描述:
 * 每个测试输入包含1个测试用例： I like beijing. 输入用例长度不超过100
 * 输出描述:
 * 依次输出倒置之后的字符串,以空格分割
 * <p>
 * 示例1
 * 输入
 * I like beijing.
 * 输出
 * beijing. like I
 * @author: whx
 * @create: 2018-09-23 11:15
 **/
public class StringReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] string = str.split(" ");
        for (int i = 0; i < string.length - 1; i++) {
            System.out.print(string[string.length - i - 1] + " ");
        }
        System.out.print(string[0]);
    }
}
