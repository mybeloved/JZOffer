package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: 输入n个整数，输出出现次数大于等于数组长度一半的数。
 * <p>
 * 输入描述:
 * 每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
 * 输出描述:
 * 输出出现次数大于等于n/2的数。
 * <p>
 * 示例1
 * 输入
 * 3 9 3 2 5 6 7 3 2 3 3 3
 * 输出
 * 3
 * @author: whx
 * @create: 2018-09-22 22:17
 **/
public class NumberMoreThanHalfOfArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] temp = str.split(" ");
        int count = 0;
        int len = temp.length;
        int middle = (int) Math.floor(len / 2);
        for (int i = 0; i < len; i++) {
            if (temp[i] == temp[i++]) {
                count++;
            }
            if (count >= middle) {
                System.out.print(temp[i]);
            }
        }
    }
}
