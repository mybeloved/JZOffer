package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: 给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。
 * 比如： （1） “hello xiao mi”-> “mi xiao hello”
 * <p>
 * 输入描述:
 * 输入数据有多组，每组占一行，包含一个句子(句子长度小于1000个字符)
 * <p>
 * 输出描述:
 * 对于每个测试示例，要求输出句子中单词反转后形成的句子
 * <p>
 * 示例1
 * 输入
 * hello xiao mi
 * 输出
 * mi xiao hello
 * @author: whx
 * @create: 2018-12-24 21:28
 **/
public class SentenceReverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        if ((str = br.readLine()) != null) {
            String[] s = str.split(" ");
            for (int i = s.length - 1; i >= 0; i--) {
                sb.append(s[i]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
