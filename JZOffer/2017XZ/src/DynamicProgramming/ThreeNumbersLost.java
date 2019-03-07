package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: 现在有一个数组，其值为从1到10000的连续增长的数字。出于某次偶然操作，
 * 导致这个数组中丢失了某三个元素，同时顺序被打乱，现在需要你用最快的方法找出丢失的这三个元素，
 * 并且将这三个元素根据从小到大重新拼接为一个新数字，计算其除以7的余数。 例：丢失的元素为336，10，8435，
 * 得到的新数字为103368435，除以七的余数为2。
 * <p>
 * 输入描述:
 * 输入数据为一行，包含9997个数字，空格隔开。
 * 输出描述:
 * 输出为一行，包含一个数字。
 * 示例1
 * 输入
 * 同题设例子输入
 * 输出
 * 2
 * @author: whx
 * @create: 2018-10-24 19:52
 **/
public class ThreeNumbersLost {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            String[] str = line.trim().split(" ");
            for (int i = 0; i < str.length; i++) {
                int c = Integer.parseInt(str[i]);
                if (c != i + index + 1) {
                    sb.append(c - 1);
                    index++;
                }
                if (index == 3) {
                    break;
                }

            }
            long klong = Long.valueOf(sb.toString());
            System.out.println(klong % 7);
        }
    }
}
