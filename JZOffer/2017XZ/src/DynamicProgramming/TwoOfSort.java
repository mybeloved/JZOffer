package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 考拉有n个字符串字符串，任意两个字符串长度都是不同的。考拉最近学习到有两种字符串的排序方法： 1.根据字符串的字典序排序。
 * 例如：
 * "car" < "carriage" < "cats" < "doggies < "koala"
 * 2.根据字符串的长度排序。例如：
 * "car" < "cats" < "koala" < "doggies" < "carriage"
 * 考拉想知道自己的这些字符串排列顺序是否满足这两种排序方法，考拉要忙着吃树叶，所以需要你来帮忙验证。
 * <p>
 * 输入描述:
 * 输入第一行为字符串个数n(n ≤ 100)
 * 接下来的n行,每行一个字符串,字符串长度均小于100，均由小写字母组成
 * <p>
 * 输出描述:
 * 如果这些字符串是根据字典序排列而不是根据长度排列输出"lexicographically",
 * 如果根据长度排列而不是字典序排列输出"lengths",
 * 如果两种方式都符合输出"both"，否则输出"none"
 * <p>
 * 示例1
 * 输入
 * 3
 * a
 * aa
 * bbb
 * 输出
 * both
 */
public class TwoOfSort {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        if (lexico(str) && lengths(str)) {
            System.out.println("both");
        } else if (lexico(str)) {
            System.out.println("lexicographically");
        } else if (lengths(str)) {
            System.out.println("lengths");
        } else {
            System.out.println("none");
        }
    }

    public static boolean lexico(String[] str1) {
        for (int i = 0; i < str1.length - 1; i++) {
            if (str1[i + 1].compareTo(str1[i]) <= 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean lengths(String[] str2) {
        for (int i = 0; i < str2.length - 1; i++) {
            if (str2[i].length() > str2[i + 1].length()) {
                return false;
            }
        }
        return true;
    }
}
