package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: JZOffer
 * @description: 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
 * 例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
 * <p>
 * 输入描述:
 * 每个测试输入包含2个字符串
 * 输出描述:
 * 输出删除后的字符串
 * <p>
 * 示例1
 * 输入
 * They are students.
 * aeiou
 * 输出
 * Thy r stdnts.
 * @author: whx
 * @create: 2018-09-24 10:28
 **/
public class PublicCharacterDeleting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = get(str1, str2);
        System.out.println(str3);
    }

    public static String get(String str1, String str2) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if ((str2.indexOf(c)) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
//    Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//                String s1 = sc.nextLine();
//                String s2 = sc.nextLine();
//                String pattern = "[" + s2 + "]";
//                String result = s1.replaceAll(pattern, "");
//                System.out.println(result);
//                }
