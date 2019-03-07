package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: A, B, C三个人是好朋友, 每个人手里都有一些糖果, 我们不知道他们每个人手上具体有多少个糖果,
 * 但是我们知道以下的信息： A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的
 * 糖果数. 现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组
 * 整数A,B,C满足所有题设条件。
 * <p>
 * 输入描述: 输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。
 * 范围均在-30到30之间(闭区间)。
 * 输出描述: 输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。
 * 如果不存在这样的整数A，B，C，则输出No
 * <p>
 * 示例1
 * 输入
 * 1 -2 3 4
 * 输出
 * 2 1 3
 * @author: whx
 * @create: 2018-09-10 19:12
 **/
public class CandyCalculating {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] inputs = s.split(" ");
        int num1 = Integer.parseInt(inputs[0]);
        int num2 = Integer.parseInt(inputs[1]);
        int num3 = Integer.parseInt(inputs[2]);
        int num4 = Integer.parseInt(inputs[3]);
        int a = (num1 + num3) / 2;
        int a1 = (num1 + num3) % 2;
        int b = (num2 + num4) / 2;
        int a2 = (num1 + num3) % 2;
        int c = num4 - b;
        int a3 = (num1 + num3) % 2;

        if (a1 == 0 && a2 == 0 && a3 == 0 && a >= 0 && b >= 0 && c >= 0) {
            System.out.println(a + " " + b + " " + c);
        } else {
            System.out.println("No");
        }
    }
}
